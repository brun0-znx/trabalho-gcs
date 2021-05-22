public class Exame {
    int id;
    String nome;

    public Exame(int umId, String umNome){
        this.id = umId;
        this.nome = umNome;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString(){
        String str = " ; ";
        return "ID: " + this.id + str + "Exame: "  + this.nome;
    }
}