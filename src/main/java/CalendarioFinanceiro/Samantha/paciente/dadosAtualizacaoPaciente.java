package CalendarioFinanceiro.Samantha.paciente;

import CalendarioFinanceiro.Samantha.endereco.dadosEndereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record dadosAtualizacaoPaciente(

        @NotNull
        String id,
        String telefone,
        String email,
        String estadoCivil,
        dadosEndereco endereco) {




}
