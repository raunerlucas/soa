package br.edu.ifto.soa_rest.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "Movel")
public class Movel extends Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_madeira")
    private String tipoMadeira;

    @Column(name = "dimensoes")
    private String dimensoes;

}
