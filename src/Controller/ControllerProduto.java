/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Connection.ConnectionFactory;
import java.util.*;
import Model.Produto;
import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
public class ControllerProduto {
    public void create(Produto p){
		
		Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO produto (nome, qtd, preco, validade) VALUES(?,?,?,?)");
			stmt.setString(1,p.getNome());
			stmt.setInt(2,p.getQtd_atual());
			stmt.setDouble(3,p.getPreco());
			stmt.setNString(4,p.getValidade());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "salvo com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao salvar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public List<Produto> read() {
		Connection con = null;
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.prepareStatement("SELECT * FROM produto");
			rs = stmt.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
                                produto.setCod(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQtd_atual(rs.getInt("qtd"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setValidade(rs.getString("validade"));
				produtos.add(produto);
			}
		}catch(SQLException ex){
			System.out.println("Execao Jtable");
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return produtos;
	}
    public void update(Produto p){
		
		Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE produto SET nome = ?, qtd = ?, preco= ?, validade = ? WHERE id = ?");
			stmt.setString(1,p.getNome());
			stmt.setInt(2,p.getQtd_atual());
			stmt.setDouble(3,p.getPreco());
			stmt.setNString(4,p.getValidade());
                        stmt.setInt(5,p.getCod());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao atualizar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
    
    
    public void delete(Produto p){
		
		Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
                        stmt.setInt(1,p.getCod());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
}
