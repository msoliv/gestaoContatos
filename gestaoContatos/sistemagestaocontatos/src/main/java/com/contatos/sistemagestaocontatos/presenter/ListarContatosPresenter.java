package com.contatos.sistemagestaocontatos.presenter;

import com.contatos.sistemagestaocontatos.collection.ContatoCollection;
import com.contatos.sistemagestaocontatos.model.Contato;
import com.contatos.sistemagestaocontatos.view.ListarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mayara
 */
public class ListarContatosPresenter {
    
    
    private ListarContatosView view;
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;
    
    public ListarContatosPresenter(ContatoCollection contatos){
        this.contatos = contatos;    
        
    view = new ListarContatosView();
    
    tmContatos = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Nome", "Telefone"});
    
    view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    tmContatos.setNumRows(0);
    ListIterator<Contato> it = contatos.getContatos().listIterator();
    
    while (it.hasNext()){
        Contato contato = it.next();
        tmContatos.addRow(new Object[]{contato.getNome(),contato.getTelefone()});
    }
    
    view.getTblContatos().setModel(tmContatos);

    view.getBtnFechar().addActionListener (new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            fechar();
        }            
     });
    
    
    view.setVisible(true);
    
    
    view.getBtnVisualizar().addActionListener (new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           // visualizar(tmContatos.getSelectedRow() );
        }            
     });    
    
    }
 
    private void fechar() {
        view.dispose();
    }
    
    private void visualizar(){
        
    }
}