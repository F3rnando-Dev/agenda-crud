package br.com.crud.main;

import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.ContatoModel;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContatoDAO contatoDao = new ContatoDAO();

        ContatoModel contato = new ContatoModel();
        contato.setNome("Abimaleque");
        contato.setIdade(40);
        contato.setDataCadastro(new Date());
        contatoDao.saveContato(contato);

    }
}
