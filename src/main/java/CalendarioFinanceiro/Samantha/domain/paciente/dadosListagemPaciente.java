package CalendarioFinanceiro.Samantha.domain.paciente;

public record dadosListagemPaciente(String id, String nome, String email, String idade, String dataAniversario, String estadoCivil) {

    public dadosListagemPaciente(paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getIdade(), paciente.getDataAniversario(), paciente.getEstadoCivil());
    }

}
