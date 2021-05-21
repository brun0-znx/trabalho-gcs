public class Medico {

    private int id;
    private String nome;

    public Medico(int umId, String umNome){
        this.id = umId;
        this.nome = umNome;
    }
    public String getNome(){
        return nome;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        String str = " ; ";
        return "ID: " + this.id + str + "Nome: "  + this.nome;
    }
}