// Fornecedor.java
package com.loja_moveis.modelos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Fornecedor {

   @XmlElement(required = true)
   private String cnpj;
   private String nomeFantasia;
   private String razaoSocial;

   public Fornecedor(String cnpj, String nomeFantasia, String razaoSocial) {
      this.cnpj = cnpj;
      this.nomeFantasia = nomeFantasia;
      this.razaoSocial = razaoSocial;
   }

   public Fornecedor() {
   }

   public String getCnpj() {
      return cnpj;
   }

   public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
   }

   public String getNomeFantasia() {
      return nomeFantasia;
   }

   public void setNomeFantasia(String nomeFantasia) {
      this.nomeFantasia = nomeFantasia;
   }

   public String getRazaoSocial() {
      return razaoSocial;
   }

   public void setRazaoSocial(String razaoSocial) {
      this.razaoSocial = razaoSocial;
   }
}