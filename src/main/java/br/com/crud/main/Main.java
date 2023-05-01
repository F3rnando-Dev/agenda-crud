package br.com.crud.main;

import br.com.crud.dao.*;
import br.com.crud.model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ContatoModel contato = new ContatoModel();
        ContatoDAO contatoDao = new ContatoDAO();



        contato.setNome("Abimaleque");
        contato.setIdade(40);
        contato.setDataCadastro(new Date());
        contatoDao.saveContato(contato);

    }
}
