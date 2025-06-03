
import com.saojudas.sistemalavanderia.TelaClientes;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.saojudas.sistemalavanderia.Conexao.ConexaoBanco;
import com.saojudas.sistemalavanderia.Model.Cliente;
import com.saojudas.sistemalavanderia.Service.ClientService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 *
 * @author Gabriel
 */
public class ClientTest {
    
    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet resultSet;

    @BeforeEach
    public void setup() throws Exception {
        connection = mock(Connection.class);
        stmt = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);

        when(connection.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(resultSet);

        when(resultSet.next()).thenReturn(true, false); 
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("nome")).thenReturn("João");
        when(resultSet.getString("telefone")).thenReturn("123456789");
        when(resultSet.getString("endereco")).thenReturn("Rua A");

        mockStaticConnection();
    }

    private void mockStaticConnection() throws SQLException {
        ConexaoBanco mockConexaoBanco = mock(ConexaoBanco.class);
        ConexaoBanco.conexao = connection;
    }

    @Test
    public void testListarClientes() throws SQLException {
        ClientService service = new ClientService();
        List<Cliente> clientes = service.listarClientes();

        assertEquals(1, clientes.size());

        Cliente c = clientes.get(0);
        assertEquals(1, c.getId());
        assertEquals("João", c.getNome());
        assertEquals("123456789", c.getTelefone());
        assertEquals("Rua A", c.getEndereco());
    }
}
