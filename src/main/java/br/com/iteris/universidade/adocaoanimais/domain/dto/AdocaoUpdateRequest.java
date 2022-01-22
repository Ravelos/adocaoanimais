package br.com.iteris.universidade.adocaoanimais.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class AdocaoUpdateRequest {
        @NotNull(message = "Nível de fofura")
        private int nivelFofura;

        @NotNull(message = "Nível de carinho")
        private int nivelCarinho;

        @Email(message = "Email com formato valido ex: fifi@gmail.com")
        private String email;

}
