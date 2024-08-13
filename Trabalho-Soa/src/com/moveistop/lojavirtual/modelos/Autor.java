package com.moveistop.lojavirtual.modelos;

import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;


@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Autor {

   private String nome;
//   Por que não usar o localDate
   @XmlTransient
   private Date dataNascimento;

   public Autor() {
   }

   public Autor(String nome, Date dataNascimento) {
      super();
      this.nome = nome;
      this.dataNascimento = dataNascimento;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Autor autor = (Autor) o;
      return Objects.equals(nome, autor.nome);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(nome);
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Date getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
   }

}
