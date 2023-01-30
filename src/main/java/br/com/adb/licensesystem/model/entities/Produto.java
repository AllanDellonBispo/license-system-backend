package br.com.adb.licensesystem.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@ToString
@Getter
@Setter
@EqualsAndHashCode

@Entity(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }
    public  Produto(){
    }
}
