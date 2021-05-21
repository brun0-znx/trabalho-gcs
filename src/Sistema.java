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
}