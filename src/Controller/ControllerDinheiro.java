/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionFactory;
import Model.Dinheiro;
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
    
    public int[] fetch_db(){
        int bq_cinquenta = 0,bq_um =0,bq_cinco = 0,bq_dez=0;
        final int[] bq = new int[4];
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
                            bq_cinquenta = rs.getInt(2);
                            bq[0] = bq_cinquenta;
                            bq_um = rs.getInt(3);
                            bq[1] = bq_um;
                            bq_cinco = rs.getInt(4);
                            bq[2] = bq_cinco;
                            bq_dez = rs.getInt(5);
                            bq[3] = bq_dez;
                        }
                        
		}catch(SQLException ex){
			System.out.println("Execao pegar campos campos");
		}finally{
			ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
		}
        return bq;
    }
    
    public void update_dinheiro(Dinheiro d, int qtd_cinquenta, int qtd_um, int qtd_cinco, int qtd_dez){
            int[] bq = fetch_db();
		Connection con = null; 
		try {
			con = (Connection) ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE `Dinheiro1` SET `id`=?,`0.50`=?,`1.00`=?,`5.00`=?,`10.00`=? WHERE 1");
                        stmt.setInt(1,1);
			stmt.setInt(2,d.getCinquenta_centavos()+bq[0]);
			stmt.setInt(3,d.getUm_real()+bq[1]);
			stmt.setInt(4,d.getCinco_reais()+bq[2]);
			stmt.setInt(5,d.getDez_reais()+bq[3]);
                        
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao atualizar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
                
    }

}
