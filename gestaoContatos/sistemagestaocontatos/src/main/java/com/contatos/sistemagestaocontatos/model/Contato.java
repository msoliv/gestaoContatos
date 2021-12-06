package com.contatos.sistemagestaocontatos.model;

/**
 *
 * @author Mayara
 */
public class Contato {
    private String nome;
    private String telefone;


    public Contato(String nome, String telefone){
	this.nome = nome;
	this.telefone = telefone;
    }

    public void setNome(String nome){
	this.nome = nome;
    }

    public void setTelefone(String telefone){
	this.telefone = telefone;
    }

    public String getNome(){
	return this.nome;
    }	

    public String getTelefone(){
	return this.telefone;
    }

}
