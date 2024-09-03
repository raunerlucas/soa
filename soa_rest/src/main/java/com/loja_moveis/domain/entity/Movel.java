package com.loja_moveis.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movel extends Produto implements Serializable {
    private String tipoMadeira;

    private String dimensoes;
}
