
import com.saojudas.sistemalavanderia.Conexao.ConexaoBanco;
import com.saojudas.sistemalavanderia.Service.LoginService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Gabriel
 */
public class LoginTest {

    @Test
    public void testLoginValido() throws Exception {
        LoginService mockService = mock(LoginService.class);

        when(mockService.autenticar("admin", "1234")).thenReturn(true);

        boolean resultado = mockService.autenticar("admin", "1234");

        assertTrue(resultado);
    }
}

