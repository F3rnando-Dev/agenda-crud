package br.com.crud.dao;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.ContatoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    /*
     * C: CREATE  -  OK
     * R: READ    -
     * U: UPDATE  -
     * D: DELETE  -
     */

    public void saveContato(ContatoModel contato){

        String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criamos uma preparedStatment pra executarmos uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //Executar a query
            pstm.execute();




        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //Fechar as conexoes
            try{
                if(pstm != null){
                    pstm.close();
                } if(conn != null){
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<ContatoModel> readContatos(){
        String sql = "SELECT * FROM contatos";
        List<ContatoModel> contatos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai consultar os dados do banco (SELECT)
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()) {

                ContatoModel contato = new ContatoModel();

                //Recuperar o ID
                contato.setId(rset.getInt("id"));

                //Recuperar o nome
                contato.setNome(rset.getString("nome"));

                //Recuperar a idade
                contato.setIdade(rset.getInt("idade"));

                //Recuperar a datade cadastro
                contato.setDataCadastro(rset.getDate("dataCadastro"));

                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null){
                    rset.close();
                }

                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return contatos;
    }
}
