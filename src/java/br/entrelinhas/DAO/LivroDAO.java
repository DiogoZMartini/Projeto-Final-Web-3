
package br.entrelinhas.DAO;


import br.entrelinhas.DTO.Livro;
import br.entrelinhas.conexaoBD.ConexaoBD;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

public class LivroDAO {
   private Connection conexao;
   private PreparedStatement pstm;
   private ResultSet resultado;
   private ArrayList<Livro> listaDeLivros = new ArrayList<>();
   
   public void cadastroLivro(Livro objLivro) throws ClassNotFoundException{
       String sql = "insert into tb_livro(nometblivro,autortblivro,secaotblivro,numerodepaginastblivro,isbntblivro) values(?,?,?,?,?)";
       this.conexao = new ConexaoBD().getConexao();
       try {
           pstm = conexao.prepareStatement(sql);
           pstm.setString(1, objLivro.getNome());
           pstm.setString(2, objLivro.getAutor());
           pstm.setInt(3, objLivro.getSecao());
           pstm.setInt(4, objLivro.getNumeroDePaginas());
           pstm.setLong(5, objLivro.getIsbn());
           pstm.execute();
           pstm.close();
       }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe LivroDAO no metodo cadastrarLivro()  ===> "+e);
        }
   }
   
   public ArrayList<Livro> listarTodosOsLivros() throws ClassNotFoundException {
        String sql = "SELECT * FROM tb_livro";
        this.conexao = new ConexaoBD().getConexao();
        
        try {
            this.pstm = this.conexao.prepareStatement(sql);
            this.resultado = this.pstm.executeQuery(sql);
            
            while (this.resultado.next()) {
                Livro objLivro = new Livro();
                objLivro.setId(this.resultado.getInt("pkidtblivro"));
                objLivro.setNome(this.resultado.getString("nometblivro"));
                objLivro.setAutor(this.resultado.getString("autortblivro"));
                objLivro.setSecao(this.resultado.getInt("secaotblivro"));
                objLivro.setNumeroDePaginas(this.resultado.getInt("numerodepaginastblivro"));
                objLivro.setIsbn(this.resultado.getLong("isbntblivro"));
                
                this.listaDeLivros.add(objLivro);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu Erro na classe LivroDao no metodo listarTodosOsLivros()  ===> " + e);
        }
        return this.listaDeLivros;
    }
   
   public void alterarLivro(Livro objLivro) throws ClassNotFoundException {
        String sql = "update tb_livro "
                + "set nometblivro = ?, autortblivro = ?, secaotblivro = ?, numerodepaginastblivro = ?, isbntblivro = ?"
                + " where pkidtblivro = ?";
        this.conexao = new ConexaoBD().getConexao();
        
        try {
            this.pstm = this.conexao.prepareStatement(sql);
            this.pstm.setString(1, objLivro.getNome());
            this.pstm.setString(2, objLivro.getAutor());
            this.pstm.setInt(3, objLivro.getSecao());
            this.pstm.setInt(4, objLivro.getNumeroDePaginas());
            this.pstm.setLong(5, objLivro.getIsbn());
            this.pstm.setInt(6, objLivro.getId());
            
            this.pstm.execute();
            this.pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na classe LivroDao no metodo alterarLivro()  ===> " + e);
        }
    }
    
    public void excluirLivro(Livro objLivro) throws ClassNotFoundException {
        
        String sql = "delete from tb_livro where pkidtblivro = ?";
        this.conexao = new ConexaoBD().getConexao();
        
        try {
            this.pstm = this.conexao.prepareStatement(sql);
            this.pstm.setInt(1, objLivro.getId());
            
            this.pstm.execute();
            this.pstm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na classe LivroDao no metodo excluirLivro()  ===> " + e);
        }
    }
    
    public ArrayList<Livro> pesquisarLivroPorNome(String nome) throws ClassNotFoundException {
        String sql = "SELECT * FROM tb_livro where nometblivro = ?";
        this.conexao = new ConexaoBD().getConexao();
        
        try {
            this.pstm = this.conexao.prepareStatement(sql);
            this.resultado = this.pstm.executeQuery(sql);
            
            while (this.resultado.next()) {
                
                Livro objLivro = new Livro();
                objLivro.setId(this.resultado.getInt("pkidtblivro"));
                objLivro.setNome(this.resultado.getString("nometblivro"));
                objLivro.setAutor(this.resultado.getString("autortblivro"));
                objLivro.setSecao(this.resultado.getInt("secaotblivro"));
                objLivro.setNumeroDePaginas(this.resultado.getInt(" numerodepaginastblivro"));
                objLivro.setIsbn(this.resultado.getLong("isbntblivro"));
                
                if (resultado.getString("nometblivro").equalsIgnoreCase(nome)) {
                    this.listaDeLivros.add(objLivro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na classe LivroDao no metodo pesquisarLivroPorNome()  ===> " + e);
        }
        return this.listaDeLivros;
    }
}
