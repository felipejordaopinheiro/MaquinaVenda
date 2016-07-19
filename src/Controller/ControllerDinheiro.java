/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionFactory;
import Model.Dinheiro;
import Model.Produto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FelipeJordao
 */
public class ControllerDinheiro {
    
    public List<Dinheiro> read(){
       
        List<Dinheiro> dinheiros = new ArrayList<>();
        
        java.sql.Connection con = null;
		try {
			con = (java.sql.Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.prepareStatement("SELECT * FROM Dinheiro1");
			rs = stmt.executeQuery();
                        while(rs.next()){
                            Dinheiro dinheiro = new Dinheiro();
                            dinheiro.setId(rs.getInt(1));
                            dinheiro.setValue(rs.getDouble(2));
                            dinheiro.setQtd(rs.getInt(3));
                            dinheiros.add(dinheiro);
                        }
                        
		}catch(SQLException ex){
			System.out.println("Execao pegar campos campos");
		}finally{
			ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
		}
        return dinheiros;
    }
    
    public void update_dinheiro(Dinheiro d){
            	Connection con = null; 
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE `Dinheiro1` SET `value`=?,`qtd`=? WHERE id = ?");
			stmt.setDouble(1,d.getValue());
			stmt.setInt(2,d.getQtd());
			stmt.setInt(3,d.get_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao atualizar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
                
    }
    
    public List<Double> calculaTroco(double totalinserido, double totalproduto, List<Dinheiro> dinheiros){
        
        double totaltroco = totalinserido - totalproduto;
        
        List<Double> troco = new ArrayList<>();
        List<Dinheiro> dinheiros1 = dinheiros;
    
        while(totaltroco >= 10 && dinheiros1.get(3).getQtd() >= 1){
            dinheiros1.get(3).setQtd(dinheiros1.get(3).getQtd() - 1);
            troco.add(10.0);
            totaltroco = totaltroco - 10;
        }
        
        while(totaltroco >= 5 && dinheiros1.get(2).getQtd() >= 1){
            dinheiros1.get(2).setQtd(dinheiros1.get(2).getQtd() - 1);
            troco.add(5.0);
            totaltroco = totaltroco - 5;
        }
        
        while(totaltroco >= 1 && dinheiros1.get(1).getQtd() >= 1){
            dinheiros1.get(1).setQtd(dinheiros1.get(1).getQtd() - 1);
            troco.add(1.0);
            totaltroco = totaltroco - 1;
        }
        
        while(totaltroco >= 0.5 && dinheiros1.get(0).getQtd() >= 1){
            dinheiros1.get(0).setQtd(dinheiros1.get(0).getQtd() - 1);
            troco.add(0.5);
            totaltroco = totaltroco - 0.5;
            
        }
         
        if(totaltroco == 0.0){ 
            this.update_dinheiro(dinheiros1.get(3));
            this.update_dinheiro(dinheiros1.get(2));
            this.update_dinheiro(dinheiros1.get(1));
            this.update_dinheiro(dinheiros1.get(0));  
        }else{
            troco.clear();
            troco.add(-1.0);
        }
        
        if(totaltroco == 0.0 && totalproduto == totalinserido){
            troco.add(0.0);
        }
        
        return troco;
    }

    public int compra(Double totaldinheiro, Produto p){
        int Status  = 0; 
        ControllerProduto cProduto = new ControllerProduto();
        
        if(totaldinheiro >= p.getPreco()){
            if(p.getQtd_atual() > 0){
                p.setQtd_vendida(p.getQtd_vendida()+1);
                p.setQtd_atual(p.getQtd_atual() - 1);   
                cProduto.update(p);
            }else{
                Status = 1;
            }    
        }else{
            Status = 2;
        }
       
       return Status;
    }

    private void ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
