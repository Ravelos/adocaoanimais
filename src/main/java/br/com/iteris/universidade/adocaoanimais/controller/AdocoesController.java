package br.com.iteris.universidade.adocaoanimais.controller;

import br.com.iteris.universidade.adocaoanimais.domain.dto.AdocaoCreateRequest;
import br.com.iteris.universidade.adocaoanimais.domain.dto.AdocaoUpdateRequest;
import br.com.iteris.universidade.adocaoanimais.domain.dto.entity.Adocao;
import br.com.iteris.universidade.adocaoanimais.service.AdocoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
public class AdocoesController {

    private final AdocoesService service;

    public AdocoesController(final AdocoesService service) {
        this.service = service;
    }
    // Lista todas as adoções
    @GetMapping(value = "api/adocoes")
    public ResponseEntity<List<Adocao>> listar() {
        var ListaDeAdocoes = service.listar();
        return ResponseEntity.ok(ListaDeAdocoes);
    }
    // Consulta adocão por id
    @GetMapping(value = "api/adocoes/{id}")
    public ResponseEntity<Adocao> buscarPorId(@PathVariable Integer id) {
        var adocaoResponse = service.buscarPorId(id);
        return ResponseEntity.ok(adocaoResponse);
    }

    @GetMapping(value = "api/albuns/nome/{nomeParam}")
    public ResponseEntity<Adocao> buscarPorNome(@PathVariable String nomeParam) {
        var adocaoResponse = service.buscarPorNome(nomeParam);
        return ResponseEntity.ok(adocaoResponse);
    }


    @PostMapping(value = "api/adocoes")
    public ResponseEntity<Adocao> criarCadastro(@RequestBody @Valid AdocaoCreateRequest adocao) {
        var adocaoResponse = service.criarCadastro(adocao);
        return ResponseEntity.ok(adocaoResponse);
    }

    @PutMapping(value = "api/adocoes/{idAdocao}")
    public ResponseEntity<Adocao> atualizarAdocao(
            @PathVariable Integer idAdocao,
            @RequestBody @Valid AdocaoUpdateRequest adocaoUpdateRequest) {
        var adocao = service.atualizarAdocao(idAdocao, adocaoUpdateRequest);
        return ResponseEntity.ok(adocao);
    }

    @DeleteMapping(value = "api/adocoes/{idAdocao}")
    public ResponseEntity<Adocao> deletarAdocao(@PathVariable Integer idAdocao) {
        var adocao = service.deletarAdocao(idAdocao);
        return ResponseEntity.ok(adocao);
    }
}
