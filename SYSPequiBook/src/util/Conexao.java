package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;

    private static Connection Conectar() {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection("jdbc:postgresql://localhost/pequibook", "postgres", "sap@123");
            //return DriverManager.getConnection("jdbc:postgresql://localhost/pequibook", "postgres", "123456");
        } catch (ClassNotFoundException e){
            System.out.println("Driver não encontrado no CLASSPATH");
            return null;
        } catch (SQLException e){
            System.out.println("Erro na conexao com o banco verifique a url, o usuário e a senha");
            return null;
        }

    }

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = Conectar();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return conexao;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        // testo se a conexão já foi criada
        if (conexao == null) {
            // cria a conexão
            conexao = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return conexao.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: "
                    + e.getMessage());
        }
        return null;
    }

}
