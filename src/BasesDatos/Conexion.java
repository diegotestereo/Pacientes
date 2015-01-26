package BasesDatos;

import java.sql.*;

import com.sun.istack.internal.logging.Logger;


public class Conexion {

	public Conexion() {
		
	}
	
	
	public  Connection Conectar(){
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/pacientes","root","");		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
		
	}
	
	public void Insertar(String Nombre,int Telefono){
		
		Connection con=Conectar();
		try {
			PreparedStatement pst =con.prepareStatement("INSERT INTO tablapacientes (NomPaciente,TelPaciente) VALUES (?,?)");
			pst.setString(1,Nombre);
			pst.setInt(2, Telefono);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	
	}
	
	public void Buscar(String Nombre){
		
		
		
	}
	
	public void Editar(){
		
		
		
		
	}
	
	

}
