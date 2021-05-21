public class Autorizacao {

    int idSequencial;
    String data;
    Medico medico;
    Paciente paciente;
    Exame exame;

    public Autorizacao(int umIdSequencial, String umaData, Medico umMedico, Paciente umPaciente, Exame umExame){
        this.idSequencial = umIdSequencial;
        this.data = umaData;
        this.medico = umMedico;
        this.paciente = umPaciente;
        this.exame = umExame;
    }

    public String getData(){
        return data;
    }
    public Medico getMedico(){
        return medico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public Exame getExame(){
        return exame;
    }

    @Override
    public String toString(){
        String str = " ; ";
        return "ID: " + this.idSequencial + str + "Data: "  + this.data + str + "Médico: " + this.medico.toString() + str +
                "Paciente: " + this.paciente.toString() + str + "Exame: " + this.exame.toString();
    }
}