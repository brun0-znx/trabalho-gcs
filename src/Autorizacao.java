public class Autorizacao {

    int idSequencial;
    String data,dataRealizacao;
    Medico medico;
    Paciente paciente;
    Exame exame;

    public Autorizacao(int umIdSequencial, String umaData, String umaDataRealizacao, Medico umMedico, Paciente umPaciente, Exame umExame){
        this.idSequencial = umIdSequencial;
        this.data = umaData;
        this.medico = umMedico;
        this.paciente = umPaciente;
        this.exame = umExame;
        this.dataRealizacao = umaDataRealizacao;
    }

    public String getDataRealizacao(){
        return getDataRealizacao();
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

    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    @Override
    public String toString(){
        String str = " ; ";
        return "ID: " + this.idSequencial + str + "Data: "  + this.data + str + "Médico: " + this.medico.toString() + str +
                "Paciente: " + this.paciente.toString() + str + "Exame: " + this.exame.toString();
    }
}