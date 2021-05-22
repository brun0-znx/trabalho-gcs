
import java.sql.Date;
import java.util.*;

public class Sistema {
    int contSequencial = 0;
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
    public void cadastraMédico() {
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;
        Boolean valida = false;

        do{
            System.out.println("Informe o ID do médico: ");
            id = teclado.nextInt();
            valida = validaId(id);

        }while(valida==false);

        System.out.println("Informe o nome do médico: ");
        nome = teclado.next();

        Medico medico1 = new Medico(id,nome);
        setMedicos(medico1);
    }


    public void cadastraPaciente(){
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;
        Boolean valida=false;

        do{
            System.out.println("Informe o ID do paciente: ");
            id = teclado.nextInt();
            valida = validaId(id);

        }while(valida==false);

        System.out.println("Informe o nome do paciente: ");
        nome = teclado.next();

        Paciente paciente1 = new Paciente(id,nome);
        setPacientes(paciente1);
    }

    public void cadastraAdmin(){
        Scanner teclado = new Scanner(System.in);
        int id;
        String nome;
        Boolean valida = false;

        do{
            System.out.println("Informe o ID do Administrador:");
            id = teclado.nextInt();
            valida = validaId(id);
        }while(valida==false);

        System.out.println("Informe o nome do Administrador");
        nome = teclado.next();

        Admin admin1 = new Admin(id,nome);
        setAdmins(admin1);
    }

    public void estatisticas(){
        //a) Número de médicos ###
        System.out.println("Número de médicos: " + medicos.size());
        //b) Número de pacientes ###
        System.out.println("Número de pacientes: " + pacientes.size());
        //c) Número de autorizações emitidas
        System.out.println("Número de autorizaçoes emitidas: " + att.size());
        //d) Percentual de autorizações com exames já realizados
        String compare = "";
        int total = 0;
        int cont = 0;
        for(Autorizacao att1 : att){
            if(compare.equals(att1.getDataRealizacao())){
                total++;
            }
            else{
                total++;
                cont++;
            }
        }
        int result = cont/total;
        result = result*100;
        System.out.println("Taxa de exames realizados: " + result + "%");

    }

    public void busca(){
        Scanner teclado = new Scanner(System.in);
        String search;

        System.out.println("[1] Busca por nome do paciente");
        System.out.println("[2] Busca por nome do médico");
        int op = teclado.nextInt();

        switch (op){
            case 1:
                System.out.println("Informe o nome do paciente");
                search = teclado.next();
                for(Autorizacao att1 : att){
                    if(search.equals(att1.getPaciente().getNome())){
                        System.out.println(att1.toString());
                    }
                    else{
                        System.out.println("Nenhum paciente encontrado com este nome!");
                        break;
                    }
                }
            case 2:
                System.out.println("Informe o nome do médico");
                search = teclado.next();
                for(Autorizacao att1 : att){
                    if(search.equals(att1.getMedico().getNome())){
                        System.out.println(att1.toString());
                    }
                    else{
                        System.out.println("Nenhum médico encontrado com este nome!");
                        break;
                    }
                }
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void setMedicos(Medico umMedico) {
        medicos.add(umMedico);
        System.out.println("Médico cadastrado!");
    }

    public void setPacientes(Paciente umPaciente){
        pacientes.add(umPaciente);
        System.out.println(("Paciente cadastrado!"));
    }

    public void setAdmins(Admin umAdmin){
        admins.add(umAdmin);
        System.out.println("Administrador cadastrado!");
    }

    public void setExame(Exame umExame){
        exames.add(umExame);
        System.out.println("Exame cadastrado!");
    }


    /*
    Funções de médico
     */
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
        String dataRealizacao = "";

        for(Medico medico1 : medicos){
            if(idMedico==medico1.getId()){
                for(Paciente paciente1 : pacientes){
                    if(idPaciente==paciente1.getId()){
                        for(Exame exame1 : exames){
                            if(idExame==exame1.getId()){
                                Autorizacao att1 = new Autorizacao(contSequencial,data,dataRealizacao,medico1,paciente1,exame1);
                                setAutorizacao(att1);
                                break;
                            }

                        }

                    }

                }

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
                }
                break;
            case 2:
                mostraExames();
                System.out.println("Informe o ID do exame:");
                search2 = teclado.nextInt();
                for(Autorizacao att1 : att){
                    if(search2==att1.getExame().getId()){
                        organizaAtt();
                        System.out.println(att1.toString());
                    }
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void setAutorizacao(Autorizacao umaAutorizacao){
        att.add(umaAutorizacao);
        System.out.println("Autorização cadastrada!");

    }

    /*
    Funções de paciente
     */
    public void listaAtt(int id){
        organizaAtt();
        for(Autorizacao att1 : att){
            if(id==att1.getPaciente().getId()){
                System.out.println(att1.toString());
            }
            else{
                System.out.println("Não foi encontrada nenhuma autorização de exame em seu nome!");
            }
        }
    }

    public void realizaExame(int id){
        Scanner teclado = new Scanner(System.in);
        for(Autorizacao att1 : att){
            if(id==att1.getPaciente().getId()){
                System.out.println(att1.toString());
                System.out.println("Deseja confirmar a realização desse exame? [1] SIM - [0] NÃO");
                int op = teclado.nextInt();
                switch (op){
                    case 1:
                        System.out.println("Informe a data de realização:");
                        String dataRealizacao = teclado.next();
                        att1.setDataRealizacao(dataRealizacao);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        }
    }

    /*
    Funçoes do sistema
     */


    public void mostraAdmins(){
        for(Admin admin : admins){
            System.out.println(admin.toString());
        }
    }
    public void mostraMedicos(){
        for(Medico medico : medicos){
            System.out.println(medico.toString());
        }
    }
    public void mostraPacientes(){
        for(Paciente paciente : pacientes){
            System.out.println(paciente.toString());
        }
    }
    public void mostraExames(){
        for(Exame exame : exames){
            System.out.println(exame.toString());
        }
    }


    public Map<String,String> validaUsuario(int umId){
        String id = "" + umId;
        String op = "-1";
        Map<String,String> input = new HashMap<String,String>();
        for(Medico medico1 : medicos){
            if(umId==medico1.getId()){
                op = "0";
                input.put(op,id);
            }
        }
        for(Admin admin1 : admins){
            if(umId==admin1.getId()){
                op = "1";
                input.put(op,id);
            }
        }
        for(Paciente paciente1 : pacientes){
            if(umId==paciente1.getId()){
                op = "2";
                input.put(op,id);
            }
        }
        return input;
    }

    public void organizaAtt(){
        Collections.sort(att, new Comparator<Autorizacao>() {
            public int compare(Autorizacao a1, Autorizacao a2) {
                return a1.getData().compareTo(a2.getData());
            }
        });
    }

    public void menuCadastro(){
        int op = -1;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nInforme qual tipo de usuário deseja cadastrar: ");
        System.out.println("[1] Administrador ");
        System.out.println("[2] Médico");
        System.out.println("[3] Paciente");
        op = teclado.nextInt();

        switch (op){
            case 1:
                cadastraAdmin();
                break;
            case 2:
                cadastraMédico();
                break;
            case 3:
                cadastraPaciente();
                break;
            default:
                System.out.println("\n");
                System.out.println("Opção inválida");
                break;
        }
    }

    public Boolean validaId(int id){
        Boolean valida = true;
        for(Medico medico1 : medicos){
            if(id==medico1.getId()){
                System.out.println("Já existe um usuário com este ID!");
                valida=false;
                return valida;
            }
        }
        for(Admin admin1 : admins){
            if(id==admin1.getId()){
                System.out.println("Já existe um usuário com este ID!");
                valida=false;
                return valida;
            }
        }
        for(Paciente paciente1 : pacientes){
            if(id==paciente1.getId()){
                System.out.println("Já existe um usuário com este ID!");
                valida=false;
                return valida;
            }
        }
        return valida;
    }
}
