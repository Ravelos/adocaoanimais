package br.com.iteris.universidade.adocaoanimais.service;

import br.com.iteris.universidade.adocaoanimais.domain.dto.AdocaoCreateRequest;
import br.com.iteris.universidade.adocaoanimais.domain.dto.AdocaoUpdateRequest;
import br.com.iteris.universidade.adocaoanimais.domain.dto.entity.Adocao;
import br.com.iteris.universidade.adocaoanimais.exception.AdocaoInvalidaException;
import br.com.iteris.universidade.adocaoanimais.exception.AdocaoNaoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdocoesService {
    private static List<Adocao> ListaDeAdocoes;
    private static int proximoId = 1;

    public AdocoesService() {
        if (ListaDeAdocoes == null) {
            ListaDeAdocoes = new ArrayList<>();
            ListaDeAdocoes.add(new Adocao(proximoId++, "Gringo", "Capivara", 3, 4, "gringo@gmail.com"));
            ListaDeAdocoes.add(new Adocao(proximoId++, "Rufus", "Gato", 2, 1, "rufus@gmail.com"));
            ListaDeAdocoes.add(new Adocao(proximoId++, "Dido", "Cachorro", 3, 5, "dido@gmail.com"));
        }
    }

    public Adocao criarCadastro(AdocaoCreateRequest adocaoCreateRequest) {
        if (adocaoCreateRequest.getEspecie() != "Cachorro" || adocaoCreateRequest.getEspecie() != "Capivara" || adocaoCreateRequest.getEspecie() != "Gato") {
            throw new AdocaoInvalidaException("418 I am a teapot");
        }
        var novaAdocao = new Adocao(proximoId++, adocaoCreateRequest.getNome(), adocaoCreateRequest.getEspecie(), adocaoCreateRequest.getNivelFofura(), adocaoCreateRequest.getNivelCarinho(), adocaoCreateRequest.getEmail());
        ListaDeAdocoes.add(novaAdocao);

        return novaAdocao;
    }
    public List<Adocao> listar() {
        return ListaDeAdocoes;
    }

    public Adocao buscarPorId(Integer idAdocao) {
        var adocaoEncontrado = ListaDeAdocoes.stream()
                .filter(adocao -> adocao.getIdAdocao() == idAdocao)
                .findFirst();

        if (adocaoEncontrado.isEmpty()) {
            throw new AdocaoNaoEncontradaException();
        }

        return adocaoEncontrado.get();
    }

    public Adocao buscarPorNome(String nome) {
        var adocaoEncontrada = ListaDeAdocoes.stream()
                .filter(album -> album.getNome().equals(nome))
                .findFirst();

        if (adocaoEncontrada.isEmpty()) {
            throw new AdocaoNaoEncontradaException();
        }

        return adocaoEncontrada.get();
    }
    public Adocao atualizarAdocao(Integer idAdocao, AdocaoUpdateRequest adocaoUpdateRequest) {
        var adocaoEncontrada = ListaDeAdocoes.stream()
                .filter(adocao -> adocao.getIdAdocao() == idAdocao)
                .findFirst();

        if (adocaoEncontrada.isEmpty()) {
            throw new AdocaoNaoEncontradaException();
        }

        var  adocao = adocaoEncontrada.get();
        adocao.setNivelFofura(adocaoUpdateRequest.getNivelFofura());
        adocao.setNivelCarinho(adocaoUpdateRequest.getNivelCarinho());
        adocao.setEmail(adocaoUpdateRequest.getEmail());


        return adocaoEncontrada.get();
    }

    public Adocao deletarAdocao(Integer idAdocao) {
        var adocaoEncontrada = ListaDeAdocoes.stream()
                .filter(adocao -> adocao.getIdAdocao() == idAdocao)
                .findFirst();

        if (adocaoEncontrada.isEmpty()) {
            throw new AdocaoNaoEncontradaException();
        }

        var adocao = adocaoEncontrada.get();
        ListaDeAdocoes.remove(adocao);

        return adocao;
    }
}
