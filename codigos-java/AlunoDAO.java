import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection conn;

    public AlunoDAO() {
        try {
        
            String url = "jdbc:postgresql://localhost:5432/suabase";
            String user = "seuusuario";
            String password = "suasenha";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao PostgreSQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, idade, curso) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public List<Aluno> listar() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("curso")
                );
                lista.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

  
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome=?, idade=?, curso=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Aluno excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
