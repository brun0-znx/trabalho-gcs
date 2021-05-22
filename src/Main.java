import java.lang.reflect.AnnotatedArrayType;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Sistema s = new Sistema();
        Scanner teclado = new Scanner(System.in);
        int op = -1;

        Admin a1 = new Admin(1,"Bruno Chanan");
        s.setAdmins(a1);
        Admin a2 = new Admin(2,"Matheus Chong");
        s.setAdmins(a2);

        Medico dr1 = new Medico(3,"Drauzio Varella");
        s.setMedicos(dr1);
        Medico dr2 = new Medico(4,"Pedro Tramontini");
        s.setMedicos(dr2);

        Paciente p1 = new Paciente(5,"Daniel Callegari");
        s.setPacientes(p1);
        Paciente p2 = new Paciente(6,"Marcelo Yamaguti");
        s.setPacientes(p2);

        Exame exame1 = new Exame(1,"RadioX");
        s.setExame(exame1);
        Exame exame2 = new Exame(2,"Mamografia");
        s.setExame(exame2);
        Exame exame3 = new Exame(3,"Tomografia");
        s.setExame(exame3);
        Exame exame4 = new Exame(4,"Resonancia Magnetica");
        s.setExame(exame4);
        Exame exame5 = new Exame(5,"Ultrassom");
        s.setExame(exame5);
        Exame exame6 = new Exame(6,"Ecografia");
        s.setExame(exame6);
        Exame exame7 = new Exame(7,"Endoscopia");
        s.setExame(exame7);
        Exame exame8 = new Exame(8,"Colesterol");
        s.setExame(exame8);
        Exame exame9 = new Exame(9,"Tireóide");
        s.setExame(exame9);
        Exame exame10 = new Exame(10,"Urina");
        s.setExame(exame10);

        Autorizacao auto1 = new Autorizacao(0,"21/05/2021","",dr1,p1,exame4);
        s.setAutorizacao(auto1);

        do {
            System.out.println("\n                                         ### Trabalho de GCS ###");
            System.out.println("\n                                               ## Login ##");
            System.out.println("\n                                            [0] Sair do Sistema)");
            System.out.println("\n                                     ##Informe o ID do usuário desejado##");


            s.mostraAdmins();
            s.mostraMedicos();
            s.mostraPacientes();

            op = teclado.nextInt();
            Map input = s.validaUsuario(op);
            if(input.containsKey("0"))   {
                op=2;
                //medico
            }

            if(input.containsKey("1"))   {
                op=1;
                //admin
            }
            if(input.containsKey("2"))   {
                op=3;
                //paciente
            }

            switch (op){
                case 1:
                    int opAdmin = -1;
                    do {
                        System.out.println("\n[1]Criar um novo usuario");
                        System.out.println("[2]Buscar");
                        System.out.println("[3]Estatísticas");
                        System.out.println("[4]Voltar");
                        opAdmin = teclado.nextInt();

                        switch (opAdmin){
                            case 1:
                                s.menuCadastro();
                                break;
                            case 2:
                                s.busca();
                                break;
                            case 3:
                                s.estatisticas();
                                break;
                            case 4:
                                System.out.println("\n");
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("\n");
                                System.out.println("Opção inválida");
                                break;
                        }
                    }while(opAdmin!=4);
                    break;
                case 2:
                    int opMedico = -1;
                    do{
                        System.out.println("\n[1]Nova autorização");
                        System.out.println("[2]Buscar");
                        System.out.println("[3]Voltar");
                        opMedico = teclado.nextInt();

                        switch (opMedico){
                            case 1:
                                s.novaAutorizacao();
                                break;
                            case 2:
                                s.busca2();
                                break;
                            case 3:
                                System.out.println("\n");
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("\n");
                                System.out.println("Opção inválida");
                                break;
                        }

                    }while(opMedico!=3);
                    break;
                case 3:
                    int opPaciente = -1;
                    String idS = (String) input.get("2");
                    int id = Integer.parseInt(idS);

                    do{
                        System.out.println("\n[1]Confirmar autorização");
                        System.out.println("[2]Listar");
                        System.out.println("[3]Voltar");
                        opPaciente = teclado.nextInt();

                        switch (opPaciente){
                            case 1:
                                s.realizaExame(id);
                                break;
                            case 2:
                                s.listaAtt(id);
                                break;
                            case 3:
                                System.out.println("\n");
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("\n");
                                System.out.println("Opção inválida");
                                break;
                        }
                    }while(opPaciente!=3);
                    break;
            }
        }while(op != 0);
    }
}