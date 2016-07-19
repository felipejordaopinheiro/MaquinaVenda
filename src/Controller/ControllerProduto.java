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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
public class ControllerProduto {
    public boolean create(Produto p){
		
		Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO produto (nome, qtd, preco, validade, bloqueado) VALUES(?,?,?,?,?)");
			stmt.setString(1,p.getNome());
			stmt.setInt(2,p.getQtd_atual());
			stmt.setDouble(3,p.getPreco());
			stmt.setNString(4,p.getValidade());
                        stmt.setInt(5,p.isBloqueado());
			stmt.executeUpdate();
                        
			JOptionPane.showMessageDialog(null, "salvo com sucesso!");
                        return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao salvar: " + e);
                        return false;
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
                                produto.setBloqueado(rs.getInt("bloqueado"));
				produtos.add(produto);
			}
		}catch(SQLException ex){
			System.out.println("Execao Jtable");
		}finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return produtos;
	}
    public boolean update(Produto p){
		
		Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE produto SET nome = ?, qtd = ?, preco= ?, validade = ?, bloqueado = ? WHERE id = ?");
			stmt.setString(1,p.getNome());
			stmt.setInt(2,p.getQtd_atual());
			stmt.setDouble(3,p.getPreco());
			stmt.setNString(4,p.getValidade());
                        stmt.setInt(5,p.getCod());
                        stmt.setInt(6,p.isBloqueado());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                        return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao atualizar: " + e);
                        return false;
                        
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
    
    
    public boolean delete(Produto p){
		
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
                        return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + e);
                        return false;
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
    
    
     public List<Produto> checkVencido() {
        
        String day = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String month = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        String year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        
        int Day = Integer.parseInt(day);
        int Month = Integer.parseInt(month);
        int Year = Integer.parseInt(year);        
        
        List<Produto> produtos = read();
        Produto temp;
        String val;
        List<Produto> vencidos = new ArrayList<Produto>();
        
        for (int i = 0; i < produtos.size(); i++) {
            temp = produtos.get(i);
            val = temp.getValidade();
            
            if(Year >= Integer.parseInt(val.substring(6,10))){
                if(Month >= Integer.parseInt(val.substring(3,5))){
                    if(Day > Integer.parseInt(val.substring(0,2))){
                            vencidos.add(temp);
                            JOptionPane.showMessageDialog(null, "Vencido encontrado!");
                    }
                }
            }
        }
        return vencidos;        
    }
           
    
    public void removeVencido() {
        List<Produto> vencidos = new ArrayList<Produto>();
        vencidos = checkVencido();

        Produto temp;
        for (int i = 0; i < vencidos.size(); i++) {
           temp = vencidos.get(i);
           delete(temp);
           JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        }
    }
    
    public int blockVencido() {
        List<Produto> vencidos = new ArrayList<Produto>();
        vencidos = checkVencido();
        
        if(!vencidos.isEmpty()){
            Produto p = new Produto();
            for (int i = 0; i < vencidos.size(); i++) {
               p=vencidos.get(i);
               p.setBloqueado(1);
               
               Connection con = null;
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE produto SET nome = ?, qtd = ?, preco= ?, validade = ?, bloqueado = ? WHERE id = ?");
			stmt.setString(1,p.getNome());
			stmt.setInt(2,p.getQtd_atual());
			stmt.setDouble(3,p.getPreco());
			stmt.setNString(4,p.getValidade());
                        stmt.setInt(5,p.isBloqueado());
                        stmt.setInt(6,p.getCod());
                        
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao atualizar: " + e);
                        
                        
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
           }
            return vencidos.size();
        }else{
            return 0;
        }
    }
}
