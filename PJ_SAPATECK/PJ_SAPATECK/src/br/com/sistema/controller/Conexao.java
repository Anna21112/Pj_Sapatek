package br.com.sistema.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/sapatek";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public Conexao(){
        conectar();
    }

    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
        return conexao;
    }
    
    
}



