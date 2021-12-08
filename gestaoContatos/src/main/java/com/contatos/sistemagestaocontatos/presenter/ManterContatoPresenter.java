package com.contatos.sistemagestaocontatos.presenter;

import com.contatos.sistemagestaocontatos.collection.ContatoCollection;
import com.contatos.sistemagestaocontatos.model.Contato;
import com.contatos.sistemagestaocontatos.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Mayara
 */
public class ManterContatoPresenter {
    
    
    private ManterContatoView view;
    private ContatoCollection contatos;
    
    public ManterContatoPresenter(ContatoCollection contatos){
        this.contatos = contatos;
        view = new ManterContatoView();
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        
        });
        
        view.getBtnSalvar().addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }            
        });
        
        view.getjButtonEditar().setVisible(false);
        view.setLocationRelativeTo(view.getParent());
        view.setVisible(true);
    }
    
    public ManterContatoPresenter(ContatoCollection contatos, Contato contato){
        this.contatos = contatos;
        view = new ManterContatoView();
        
        view.setTitle("Visualizar contato");
        view.getTxtNome().setText(contato.getNome());
        view.getTxtTelefone().setText(contato.getTelefone());
        view.getTxtNome().setEditable(false);
        view.getTxtTelefone().setEditable(false);
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        
        });
        
        view.getBtnSalvar().addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }            
        });
        
        view.getjButtonEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar(contato);
            }
        });
        
        view.getBtnSalvar().setEnabled(false);
        view.getjButtonEditar().setVisible(true);
        view.setLocationRelativeTo(view.getParent());
        view.setVisible(true);
    }
    
    private void fechar(){
        view.dispose();
    }
    
    private void editar(Contato contato) {
        view.setTitle("Editar contato");
        view.getjButtonEditar().setEnabled(false);
        view.getBtnSalvar().setEnabled(true);
        view.getTxtNome().setEditable(true);
        view.getTxtTelefone().setEditable(true);
        
        view.getBtnSalvar().removeActionListener(view.getBtnSalvar().getActionListeners()[0]);
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update(contato);
            }
        });
    }
    
    private void salvar(){
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        
        try {
            Contato contato = new Contato(nome, telefone);
            contatos.add(contato);
            
            JOptionPane.showMessageDialog(view, "Contato " + contato.getNome() + " salvo com sucesso!", "Salvo com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch(IllegalArgumentException  exc) {
            JOptionPane.showMessageDialog(view, "Dados inválidos\n" + exc.getMessage());
        } catch(RuntimeException exc) {
            JOptionPane.showMessageDialog(view, "Dados inválidos\n" + exc.getMessage());
        }
    }
    
    private void update(Contato antigo){
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        
        try {
            Contato novo = new Contato(nome, telefone);
            contatos.update(antigo, novo);
            
            JOptionPane.showMessageDialog(view, "Contato " + novo.getNome() + " salvo com sucesso!", "Salvo com sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            view.setTitle("Visualizar contato");
            view.getjButtonEditar().setEnabled(true);
            view.getBtnSalvar().setEnabled(false);
            view.getTxtNome().setEditable(false);
            view.getTxtTelefone().setEditable(false);
        } catch(IllegalArgumentException exc) {
            JOptionPane.showMessageDialog(view, "Dados inválidos\n" + exc.getMessage());
        }
    }
    
}
