package br.com.crud.main;

import br.com.crud.dao.*;
import br.com.crud.model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ContatoModel contato = new ContatoModel();
        ContatoDAO contatoDao = new ContatoDAO();


//        Salvar no banco
//        contato.setNome("Ariame Moanri");
//        contato.setIdade(23);
//        contato.setDataCadastro(new Date());
//        contatoDao.saveContato(contato);

        
//        Ler do banco
        for (ContatoModel c : ContatoDAO.readContato()) {
            System.out.println("Contato: "+c.getNome());
        }

    }
}
