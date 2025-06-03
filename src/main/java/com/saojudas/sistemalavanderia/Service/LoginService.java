/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saojudas.sistemalavanderia.Service;

import com.saojudas.sistemalavanderia.Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class LoginService {
     public boolean autenticar(String usuario, String senha) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se encontrou o usuário
        }
    }
}
