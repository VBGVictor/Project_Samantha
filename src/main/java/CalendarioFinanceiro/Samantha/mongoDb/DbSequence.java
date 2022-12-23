package CalendarioFinanceiro.Samantha.mongoDb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "id_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DbSequence {

    @Id
    private String id;
    private int seq;

}
