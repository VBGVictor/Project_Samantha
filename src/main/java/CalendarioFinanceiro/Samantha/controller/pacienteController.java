package CalendarioFinanceiro.Samantha.controller;


import CalendarioFinanceiro.Samantha.mongoDb.repository.pacienteRepository;
import CalendarioFinanceiro.Samantha.paciente.dadosAtualizacaoPaciente;
import CalendarioFinanceiro.Samantha.paciente.dadosCadastroPaciente;
import CalendarioFinanceiro.Samantha.paciente.dadosListagemPaciente;
import CalendarioFinanceiro.Samantha.paciente.paciente;
import CalendarioFinanceiro.Samantha.service.sequenceGeneratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("paciente")
public class pacienteController {

    @Autowired
    private pacienteRepository repository;
    @Autowired
    private sequenceGeneratorService service;


    @PostMapping
    @Transactional
    public paciente save(@RequestBody @Valid dadosCadastroPaciente dados){
        paciente.setId(service.getSequenceNumber(paciente.SEQUENCE_NAME));
        return repository.save(new paciente(dados));
    }

    @GetMapping("/pacientes")
    public Page<dadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(dadosListagemPaciente::new);
    }

    @GetMapping("/ativos")
    public Page<dadosListagemPaciente> listarAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(dadosListagemPaciente::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable("id") String id, @RequestBody @Valid dadosAtualizacaoPaciente dados){
        var paciente = repository.findById(id);
        if (paciente.isPresent()) {
           paciente.get().atualizarInformacoes(dados);
        }
        repository.save(paciente.get());
    }

    @DeleteMapping("/DT/{id}")
    @Transactional
    public void excluir(@PathVariable String id){
        repository.deleteById(id);
    }

    @DeleteMapping("/D/{id}")
    @Transactional
    public void desativar(@PathVariable String id){
        var paciente = repository.findById(id);
        paciente.get().desabilitar();
        repository.save(paciente.get());
    }

}
