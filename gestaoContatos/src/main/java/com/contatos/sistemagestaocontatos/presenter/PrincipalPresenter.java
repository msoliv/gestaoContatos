package com.contatos.sistemagestaocontatos.presenter;

import com.contatos.sistemagestaocontatos.collection.ContatoCollection;
import com.contatos.sistemagestaocontatos.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mayara
 */
public class PrincipalPresenter {
    
    public static void main(String[] args){
        PrincipalView view = new PrincipalView();
        
        ContatoCollection contatos = new ContatoCollection();
        
        view.getjMenuItemNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterContatoPresenter(contatos);
            }
        });
        
        view.getjMenuItemListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarContatosPresenter(contatos);
            }
        });
        
        view.getjMenuItemFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }
    
    
}
