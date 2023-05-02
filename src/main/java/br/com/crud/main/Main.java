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

//        Atualizar no banco
        ContatoModel c1 = new ContatoModel();
        c1.setNome("Ariane Monari Campos");
        c1.setIdade(23);
        c1.setDataCadastro(new Date());
        c1.setId(2);

        contatoDao.updateContato(c1);

        
//        Ler do banco
//        for (ContatoModel c : ContatoDAO.readContato()) {
//            System.out.println("Contato: "+c.getNome());
//        }

    }
}
