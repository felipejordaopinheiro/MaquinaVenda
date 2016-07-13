/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;
import java.sql.*;
import com.mysql.jdbc.Connection;

public class ConnectionFactory {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/maquina_vendas";
	private static final String USER = "root";
	private static final String PASS =  "";
	
	public static java.sql.Connection getConnection() throws SQLException{
		
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USER,PASS);
			
		} catch(ClassNotFoundException ex){
			throw new RuntimeException ("Erro na conexao: ", ex);
		}
		
	}
	
	public static void closeConnection(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt){
		
		closeConnection(con);
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
		
		closeConnection(con,stmt);
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
