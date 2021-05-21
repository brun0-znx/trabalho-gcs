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

    public void estatisticas(){
        //a) Número de médicos ###
        System.out.println("Número de médicos: " + medicos.size());
        //b) Número de pacientes ###
        System.out.println("Número de pacientes: " + pacientes.size());
        //c) Número de autorizações emitidas
        System.out.println("Número de autorizaçoes emitidas: " + att.size());
        //d) Percentual de autorizações com exames já realizados
        //-
    }
}