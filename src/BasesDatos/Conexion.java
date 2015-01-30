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
	
	public void InsertarControl(int Id,double peso,double imc,double altura,String Observaciones){
		
		Connection con =Conectar();
		//Statement st=null;
		try {
			//st=con.createStatement();
			PreparedStatement pst =con.prepareStatement("INSERT INTO tablacontrol (IdPaciente,PesoControl,IMCControl,AlturaControl,ObsControl) VALUES (?,?,?,?,?)");
			pst.setInt(1,Id);
			pst.setDouble(2,peso);
			pst.setDouble(3,imc);
			pst.setDouble(4,altura);
			pst.setString(5,Observaciones);
			pst.execute();
			
		//	st.execute("INSERT INTO tablacontrol (IdPaciente,PesoControl,AlturaControl,IMCControl,ObsControl) VALUES ('"+Id+"','"+peso+"','"+imc+"','"+altura+"','"+Observaciones+"')");
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
			int Consulta=st.executeUpdate("UPDATE tablaPacientes SET NomPaciente ='"+Nombre+"', TelPaciente ='"+Telefono+"' WHERE IdPaciente='"+id+"'");
			if (Consulta==1){
				System.out.println("ACtualizado");
			}else{
				System.out.println("error");
				
			}
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
	
	public ResultSet BuscarControles(int Id){
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs = null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM tablacontrol WHERE IdPaciente = '"+Id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
