public class Paciente {

    int id;
    String nome;

    public Paciente(int umId, String umNome){
        this.id = umId;
        this.nome = umNome;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
    @Override
    public String toString(){
        String str = " ; ";
        return "ID: " + this.id + str + "Nome: "  + this.nome;
    }
}