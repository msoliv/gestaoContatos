package com.contatos.sistemagestaocontatos.presenter;

import com.contatos.sistemagestaocontatos.collection.ContatoCollection;
import com.contatos.sistemagestaocontatos.model.Contato;
import com.contatos.sistemagestaocontatos.view.ListarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.Action;
import javax.swing.JOptionPane;
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
    
    atualizarTabela();

    view.getBtnFechar().addActionListener (new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            fechar();
        }            
    });
    
    view.getBtnVisualizar().addActionListener (new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           visualizar();
        }            
    });    
    
    view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
    });
    
    view.setVisible(true);
    
    }
 
    private void fechar() {
        view.dispose();
    }
    
    private void excluir() {
        int l = view.getTblContatos().getSelectedRow();
        
        if(l != -1){
            String nome = view.getTblContatos().getValueAt(l, 0).toString();
            String telefone = view.getTblContatos().getValueAt(l, 1).toString();

            Contato contato = new Contato(nome, telefone);
            
            String[] options = {"Sim", "Não"};

            String mensagem = "Deseja realmente excluir o contato " + nome + "?";
            int a = JOptionPane.showOptionDialog(null, mensagem, "Exclusão de Contato", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            if(a == JOptionPane.YES_OPTION) {
                contatos.getContatos().remove(contato);
                atualizarTabela();
            }
        } else JOptionPane.showMessageDialog(view, "Selecione uma linha");
    }
    
    private void visualizar(){
        int l = view.getTblContatos().getSelectedRow();
        
        if(l != -1){
            String nome = view.getTblContatos().getValueAt(l, 0).toString();
            String telefone = view.getTblContatos().getValueAt(l, 1).toString();

            Contato contato = new Contato(nome, telefone);

            new ManterContatoPresenter(contatos, contato);
        } else JOptionPane.showMessageDialog(view, "Selecione uma linha");
    }
    
    private void atualizarTabela() {
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();

        while (it.hasNext()){
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(),contato.getTelefone()});
        }
        
        view.getTblContatos().setModel(tmContatos);
    }
}