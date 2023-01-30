package br.com.adb.licensesystem.model.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Contato {

    private String telefoneResidencial;
    private String celular;
    private String nomeContato;
    private String email;
}
