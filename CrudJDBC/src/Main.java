package CrudJDBC.src;
import java.sql.*;

public class Main{
    public static void main(String[]Args){
        //Dados da conexão
        String url = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = ""; //Senha vazia

        try{
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem sucedida!");

            String sql = "SELECT * FROM produtos";
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            System.out.println("Lista de Produtos: ");
            while (resultado.next()){
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco);
            }
            resultado.close();
            stmt.close();
            conexao.close();
    } catch (SQLException e){
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}