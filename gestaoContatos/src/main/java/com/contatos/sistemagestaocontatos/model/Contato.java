package com.contatos.sistemagestaocontatos.model;

import java.util.Objects;

/**
 *
 * @author Mayara
 */
public class Contato {
    private String nome;
    private String telefone;


    public Contato(String nome, String telefone){
	this.setNome(nome);
	this.setTelefone(telefone);
    }

    public void setNome(String nome){
        if(!nome.isBlank())
            this.nome = nome;
        else 
            throw new IllegalArgumentException("Nome vazio!");
    }

    public void setTelefone(String telefone){
        String p1 = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";;
        String p2 = "^\\([1-9]{2}\\)[0-9]{4}\\-[0-9]{4}$";
        
        if(telefone.matches(p1) || telefone.matches(p2))
            this.telefone = telefone;
        else 
            throw new IllegalArgumentException("Telefone inválido");
    }

    public String getNome(){
	return this.nome;
    }	

    public String getTelefone(){
	return this.telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.nome);
        hash = 31 * hash + Objects.hashCode(this.telefone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return true;
    }

}
