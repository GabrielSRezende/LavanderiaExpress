
import com.saojudas.sistemalavanderia.Service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabriel
 */
public class UserTest {
    private Connection connection;
    private PreparedStatement stmt;

    @BeforeEach
    public void setup() throws Exception {
        connection = mock(Connection.class);
        stmt = mock(PreparedStatement.class);

        when(connection.prepareStatement(anyString())).thenReturn(stmt);
    }

    @Test
    public void testAdicionarUsuario() throws SQLException {
        UserService service = new UserService(connection);

        service.adicionarUsuario("admin", "1234");

        verify(connection).prepareStatement("INSERT INTO usuarios (nome_usuario, senha) VALUES (?, ?)");
        verify(stmt).setString(1, "admin");
        verify(stmt).setString(2, "1234");
        verify(stmt).executeUpdate();
    }
}
