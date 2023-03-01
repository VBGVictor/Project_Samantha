package CalendarioFinanceiro.Samantha.domain.paciente;

import CalendarioFinanceiro.Samantha.domain.endereco.dadosEndereco;
import jakarta.validation.constraints.NotNull;

public record dadosAtualizacaoPaciente(

        @NotNull
        String id,
        String telefone,
        String email,
        String estadoCivil,
        dadosEndereco endereco) {




}
