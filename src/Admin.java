public class Admin {

    int id;
    String nome;

    public Admin(int umId, String umNome){
        this.id = umId;
        this.nome = umNome;
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