package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
@ViewScoped
public class ExemploController implements Serializable {

    private Pessoa pessoa;
    private Pessoa selecionada;
    private List<Pessoa> pessoas = new ArrayList<>();

    public ExemploController() {
        System.out.println("construtor.");
        this.pessoa = new Pessoa();
    }

    public void teste() {
        System.out.println("Executou o método teste.");
        System.out.println("Nome: " + this.pessoa.getNome());
    }

    public void adicionar() {
        System.out.println("adicionou pessoa na lista.");
        this.pessoas.add(pessoa);
        this.pessoa = new Pessoa();
        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro realizado.");

    }

    public void excluir() {
        System.out.println("Removeu pessoa da lista.");
        this.pessoas.remove(selecionada);
        this.selecionada = null;
        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Exclusão realizado.");
    }

    public Pessoa getSelecionada() {
        return selecionada;
    }

    public void setSelecionada(Pessoa selecionada) {
        this.selecionada = selecionada;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

}
