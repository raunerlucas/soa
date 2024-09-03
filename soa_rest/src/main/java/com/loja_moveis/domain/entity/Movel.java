package com.loja_moveis.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Movel extends Produto implements Serializable {
    private String tipoMadeira;

    private String dimensoes;
}
