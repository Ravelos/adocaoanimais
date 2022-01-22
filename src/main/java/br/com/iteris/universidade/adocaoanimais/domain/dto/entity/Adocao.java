package br.com.iteris.universidade.adocaoanimais.domain.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;


@Data
@AllArgsConstructor

public class Adocao {
    private int idAdocao;
    private String nome;
    private String especie;
    private int nivelFofura;
    private int nivelCarinho;
    private String email;
}
