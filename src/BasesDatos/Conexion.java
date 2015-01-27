package BasesDatos;

import java.sql.*;




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
	
	
	
	public void Insertar(String Nombre,String telefono){
		
		Connection con=Conectar();
		try {
			PreparedStatement pst =con.prepareStatement("INSERT INTO tablapacientes (NomPaciente,TelPaciente) VALUES (?,?)");
			pst.setString(1,Nombre);
			pst.setString(2,telefono);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	
	}
	
	public void Editar(int id,String Nombre,String Telefono){
		Connection con=Conectar();
		Statement st;
		
		try {
			st=con.createStatement();
			st.executeUpdate("UPDATE tablaPacientes NomPaciente ='"+Nombre+"', TelPaciente ='"+Telefono+"' WHERE IdPaciente='"+id+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	
	public void Borrar(int id){
		Connection con=  Conectar();
		Statement st;
		try {
			st=con.createStatement();
			st.execute("DELETE FROM tablaPacientes WHERE idPaciente='"+id+"'");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public ResultSet BuscarTodos(){
		Connection con=Conectar();
		Statement st;
		ResultSet rs=null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM tablapacientes");
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet BuscarNombre(String NombreBusqueda){
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs = null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM tablapacientes WHERE NomPaciente LIKE '%"+NombreBusqueda+"%'");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return rs;
	
	}
	
public ResultSet BuscarTelefono(String Telefono){
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs = null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM tablapacientes WHERE TelPaciente LIKE '%"+Telefono+"%'");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return rs;
	
	}


	
	


}
