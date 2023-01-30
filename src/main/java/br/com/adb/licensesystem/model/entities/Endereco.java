package br.com.adb.licensesystem.model.entities;

import lombok.*;

import javax.persistence.Embeddable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Endereco {

    private String cep;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String pais;

}
