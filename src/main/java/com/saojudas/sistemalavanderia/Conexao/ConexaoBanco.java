/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saojudas.sistemalavanderia.Conexao;

/**
 *
 * @author Gabriel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/lavanderia";
                String usuario = "root";
                String senha = "root";
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
            }
        }
        return conexao;
    }
}
