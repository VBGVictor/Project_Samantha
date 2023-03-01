package CalendarioFinanceiro.Samantha.controller;


import CalendarioFinanceiro.Samantha.domain.paciente.*;
import CalendarioFinanceiro.Samantha.mongoDb.repository.pacienteRepository;
import CalendarioFinanceiro.Samantha.domain.paciente.*;
import CalendarioFinanceiro.Samantha.service.sequenceGeneratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("paciente")
public class pacienteController {

    @Autowired
    private pacienteRepository repository;
    @Autowired
    private sequenceGeneratorService service;


    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid dadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        paciente.setId(service.getSequenceNumber(paciente.SEQUENCE_NAME));
        var paciente = new paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new dadosDetalhamentoPaciente(Optional.of(paciente)));
    }

    @GetMapping("/listar")
    public ResponseEntity <Page<dadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
         var page = repository.findAll(paginacao).map(dadosListagemPaciente::new);
         return ResponseEntity.ok(page);
    }

    @GetMapping("/pacientes")
    public ResponseEntity <Page<dadosDetalhamentoPaciente>> listarGeral(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(dadosDetalhamentoPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/ativos")
    public ResponseEntity <Page<dadosListagemPaciente>> listarAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(dadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/desativados")
    public ResponseEntity <Page<dadosListagemPaciente>> listarDesativados(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoFalse(paginacao).map(dadosListagemPaciente::new);
        System.out.println(page); //Ainda não esta trazendo a lista de desativados.
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable String id){
        var paciente = repository.findById(id);
        return ResponseEntity.ok(new dadosDetalhamentoPaciente(paciente));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody @Valid dadosAtualizacaoPaciente dados){
        var paciente = repository.findById(id);
        if (paciente.isPresent()) {
           paciente.get().atualizarInformacoes(dados);
        }
        repository.save(paciente.get());
        return ResponseEntity.ok(new dadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/DT/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/D/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable String id){
        var paciente = repository.findById(id);
        paciente.get().desabilitar();
        repository.save(paciente.get());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/A/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable String id){
        var paciente = repository.findById(id);
        paciente.get().habilitar();
        repository.save(paciente.get());
        return ResponseEntity.ok().build();
    }

}
