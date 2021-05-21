import java.util.*;

public class Sistema {

    private ArrayList<Medico> medicos = new ArrayList();
    private ArrayList<Paciente> pacientes = new ArrayList();
    private ArrayList<Admin> admins = new ArrayList();
    private ArrayList<Autorizacao> att = new ArrayList();
    private ArrayList<Exame> exames = new ArrayList();

    public Sistema() {

    }
    /*
    Funções de administrador
     */
    public void cadastraMédico(){
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;

        System.out.println("Informe o ID do médico: \n");
        id = teclado.nextInt();

        System.out.println("Informe o nome do médico: \n");
        nome = teclado.next();

        Medico medico1 = new Medico(id,nome);
        setMedicos(medico1);
    }

    public void setMedicos(Medico umMedico) {
        medicos.add(umMedico);
        System.out.println("Médico cadastrado!");
    }

    public void cadastraPaciente(){
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;

        System.out.println("Informe o ID do paciente: \n");
        id = teclado.nextInt();
        System.out.println("Informe o nome do paciente: \n");
        nome = teclado.next();

        Paciente paciente1 = new Paciente(id,nome);
        setPacientes(paciente1);
    }

    public void setPacientes(Paciente umPaciente){
        pacientes.add(umPaciente);
        System.out.println(("Paciente cadastrado!"));
    }

    public void cadastraAdmin(){
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;

        System.out.println("Informe o ID do Administrador:");
        id = teclado.nextInt();
        System.out.println("Informe o nome do Administrador");
        nome = teclado.next();

        Admin admin1 = new Admin(id,nome);
        setAdmins(admin1);
    }

    public void setAdmins(Admin umAdmin){
        admins.add(umAdmin);
        System.out.println("Administrador cadastrado!");
    }

    public void novaAutorizacao(){
        contSequencial++;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a data de cadastro:");
        String data = teclado.next();
        System.out.println("Informe o ID do médico: ");
        mostraMedicos();
        int idMedico = teclado.nextInt();
        System.out.println("Informe o ID do paciente: ");
        mostraPacientes();
        int idPaciente = teclado.nextInt();
        System.out.println("Informe o ID do exame: ");
        mostraExames();
        int idExame = teclado.nextInt();

        for(Medico medico1 : medicos){
            if(idMedico==medico1.getId()){
                for(Paciente paciente1 : pacientes){
                    if(idPaciente==paciente1.getId()){
                        for(Exame exame1 : exames){
                            if(idExame==exame1.getId()){
                                Autorizacao att1 = new Autorizacao(contSequencial,data,medico1,paciente1,exame1);
                                setAutorizacao(att1);
                            }
                            else{
                                System.out.println("Exame não encontrado!");
                            }
                        }
                    }
                    else{
                        System.out.println("Paciente não encontrado!");
                    }
                }
            }
            else{
                System.out.println("Médico não encontrado!");
            }
        }

    }

    public void busca2(){
        Scanner teclado = new Scanner(System.in);
        String search;
        int search2;

        System.out.println("[1] Busca por nome do paciente");
        System.out.println("[2] Busca por tipo de exame");
        int op = teclado.nextInt();

        switch (op){
            case 1:
                System.out.println("Informe o nome do paciente");
                search = teclado.next();
                for(Autorizacao att1 : att){
                    if(search.equals(att1.getPaciente().getNome())){
                        organizaAtt();
                        System.out.println(att1.toString());
                    }
                    else{
                        System.out.println("Nenhum paciente encontrado com este nome!");
                        break;
                    }
                }
            case 2:
                mostraExames();
                System.out.println("Informe o id do exame:");
                search2 = teclado.nextInt();
                for(Autorizacao att1 : att){
                    if(search2==att1.getExame().getId()){
                        organizaAtt();
                        System.out.println(att1.toString());
                    }
                }
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}