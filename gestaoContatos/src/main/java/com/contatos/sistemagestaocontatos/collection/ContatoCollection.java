package com.contatos.sistemagestaocontatos.collection;

import com.contatos.sistemagestaocontatos.model.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mayara
 */
public class ContatoCollection {
    
    private ArrayList<Contato> contatos;
    
    public ContatoCollection(){
        contatos = new ArrayList<>();
    }
    
    public void add(Contato contato) {
        if (contatos.contains(contato)){
            throw new RuntimeException("Contato já existente!");
        }
        if (contato != null){
            contatos.add(contato);
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato!");
        }
    }
    
    public List<Contato> getContatos(){
        return this.contatos;
    }

    public void update(Contato c1, Contato c2) {
        if(contatos.contains(c1)){
            contatos.stream().filter(c -> (c.equals(c1))).map(c -> {
                c.setNome(c2.getNome());
                return c;
            }).forEachOrdered(c -> {
                c.setTelefone(c2.getTelefone());
            });
        }
    }
    
}
