package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //Nome do user do mysql
    private static final String USERNAME= "root";

    //senha do user do mysql
    private static final String USERPASSWORD= "123456";

    //Caminho do banco, porta, nome do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda?characterEncoding=utf8";

    /*
     * Conexão com o bancoo
     */

    public static Connection createConnectionToMySQL() throws Exception{
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Cria a conexão
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, USERPASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        //Recuperar conexão com banco se houver
        Connection con = createConnectionToMySQL();

        if (con != null){
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }





    }





}
