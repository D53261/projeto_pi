package objetoacesso;

import com.mycompany.pei.Login;
import com.mycompany.pei.Registro;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapbd.Confirma;

public class ConfirmaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ConfirmaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Confirma confirma) {
        String sql = "INSERT INTO registros (nome, email, senha, telefone, estado, cpf) VALUES"
                + "(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, confirma.getNome());
            stmt.setString(2, confirma.getEmail());
            stmt.setString(3, confirma.getSenha());
            stmt.setString(4, confirma.getTelefone());
            stmt.setString(5, confirma.getEstado());
            stmt.setString(6, confirma.getCpf());
            stmt.execute();
        }
        catch(Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
        
    } public ResultSet autenticar(Confirma confirma) {
        Login login = new Login();
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        
        String sql = "SELECT * FROM `pi`.`registros` WHERE `email` = ? AND `senha` = ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, confirma.getEmail());
            stmt.setString(2, confirma.getSenha());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Confirmação real");
            } else {
                JOptionPane.showMessageDialog(null, "Confirmação falsa");
            }
            return rs;
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Confirmação: "+ e);
            return null;
        }
    }
}
