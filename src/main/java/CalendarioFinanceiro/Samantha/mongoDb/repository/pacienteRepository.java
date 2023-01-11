package CalendarioFinanceiro.Samantha.mongoDb.repository;

import CalendarioFinanceiro.Samantha.paciente.dadosListagemPaciente;
import CalendarioFinanceiro.Samantha.paciente.paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface pacienteRepository extends MongoRepository<paciente, String> {

    Page<paciente> findAllByAtivoTrue(Pageable paginacao);

    Page<paciente> findAllByAtivoFalse(Pageable paginacao);
}