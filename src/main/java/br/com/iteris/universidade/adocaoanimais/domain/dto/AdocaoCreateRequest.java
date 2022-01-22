package br.com.iteris.universidade.adocaoanimais.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Calendar;
import java.util.Date;

@Data
public class AdocaoCreateRequest {
    @NotEmpty(message = "Nome deve ser definido")
    private String nome;

    @NotEmpty(message = "Espécie deve ser definida. Pode ser: Cachorro, Gato, Coelho e Capivara")
    private String especie;


    @NotNull(message = "Nível de fofura")
    private int nivelFofura;

    @NotNull(message = "Nível de carinho")
    private int nivelCarinho;

    @Email(message = "Email com formato valido ex: fifi@gmail.com")
    private String email;

}
