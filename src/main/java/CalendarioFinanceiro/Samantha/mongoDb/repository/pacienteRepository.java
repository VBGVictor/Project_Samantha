package CalendarioFinanceiro.Samantha.mongoDb.repository;

import CalendarioFinanceiro.Samantha.domain.paciente.paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface pacienteRepository extends MongoRepository<paciente, String> {

    Page<paciente> findAllByAtivoTrue(Pageable paginacao);

    Page<paciente> findAllByAtivoFalse(Pageable paginacao);
}