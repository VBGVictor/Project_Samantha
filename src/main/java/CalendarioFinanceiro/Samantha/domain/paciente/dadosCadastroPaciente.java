package CalendarioFinanceiro.Samantha.domain.paciente;

import CalendarioFinanceiro.Samantha.domain.endereco.dadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record dadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank
        String idade,
        @NotBlank
        String dataAniversario,
        @NotBlank
        String estadoCivil,
        @NotNull @Valid dadosEndereco endereco) {
}
