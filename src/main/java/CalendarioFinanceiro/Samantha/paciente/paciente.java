package CalendarioFinanceiro.Samantha.paciente;

import CalendarioFinanceiro.Samantha.endereco.endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class paciente {

    @Transient
    public static final String SEQUENCE_NAME="paciente_sequence";

    @Id
    private String id;
    private String nome;
    private String email;

    private String telefone;
    private String idade;
    private String dataAniversario;
    private String estadoCivil;

    private endereco endereco;

    private Boolean ativo;

    public paciente(dadosCadastroPaciente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.idade = dados.idade();
        this.dataAniversario = dados.dataAniversario();
        this.estadoCivil = dados.estadoCivil();
        this.endereco = new endereco(dados.endereco());
    }

    public static void setId(int sequenceNumber) {
    }

    public dadosAtualizacaoPaciente atualizarInformacoes(dadosAtualizacaoPaciente dados){
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.estadoCivil() != null) {
            this.estadoCivil = dados.estadoCivil();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        return dados;
        }

    public void desabilitar() {
        this.ativo = false;
    }
}
