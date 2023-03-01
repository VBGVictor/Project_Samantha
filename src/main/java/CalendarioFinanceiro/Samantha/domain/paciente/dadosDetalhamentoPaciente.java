package CalendarioFinanceiro.Samantha.domain.paciente;

import CalendarioFinanceiro.Samantha.domain.endereco.endereco;

import java.util.Optional;

public record dadosDetalhamentoPaciente(String id, String nome, String email, String telefone,
                                        String idade, String dataAniversario, String estadoCivil, endereco endereco) {

    public dadosDetalhamentoPaciente(Optional<paciente> paciente){
        this(paciente.get().getId(), paciente.get().getNome(), paciente.get().getEmail(), paciente.get().getTelefone(), paciente.get().getIdade(),
                paciente.get().getDataAniversario(), paciente.get().getEstadoCivil(), paciente.get().getEndereco());
    }

    public dadosDetalhamentoPaciente(paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getIdade(), paciente.getDataAniversario(), paciente.getEstadoCivil(), paciente.getEndereco());
    }
}
