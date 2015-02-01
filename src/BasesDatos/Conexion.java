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
	
	public void EditarAntecendentes(int IdNombre,int diabet,int enfcar,int colest,int insulino,int hipo,int hiper,String otros){
		Connection con=Conectar();
		
		PreparedStatement pst;
		
		try {
			pst = con.prepareStatement("UPDATE antecedentesclinicos SET Diabetes=?,EnfermedadCardio=?,Colesterol=?,InsulinoResistente=?,Hipotiroidismo=?,Hipertiroidismo=?,Otros=?  WHERE  IdPaciente='"+IdNombre+"'");
			pst.setInt(1,diabet);
			pst.setInt(2,enfcar);
			pst.setInt(3,colest);
			pst.setInt(4,insulino);
			pst.setInt(5,hiper);
			pst.setInt(6,hipo);
			pst.setString(7,otros);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ResultSet BuscarAntecedentes(int IdPaciente){
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs=null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM antecedentesclinicos WHERE idPaciente='"+IdPaciente+"' ");
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return rs;
	
	}
	
	
public ResultSet BuscaAnalisis(int IdPaciente){
		
		Connection con=Conectar();
		Statement st;
		ResultSet rs=null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM tablalaboratorio WHERE idPaciente='"+IdPaciente+"' ");
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return rs;
	
	}
	

	public void InsertarAntecedentes(int Nombre,int diabet,int enfcar,int colest,int insulino,int hipo,int hiper,String otros){
		
		Connection con=Conectar();
		
			PreparedStatement pst;
			try {
				pst = con.prepareStatement("INSERT INTO antecedentesclinicos (IdPaciente,Diabetes,EnfermedadCardio,Colesterol,InsulinoResistente,Hipotiroidismo,Hipertiroidismo,Otros) VALUES (?,?,?,?,?,?,?,?)");
			
				pst.setInt(1,Nombre);
				pst.setInt(2,diabet);
				pst.setInt(3,enfcar);
				pst.setInt(4,colest);
				pst.setInt(5,insulino);
				pst.setInt(6,hiper);
				pst.setInt(7,hipo);
				pst.setString(8,otros);
				pst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
	}
	
	public void InsertarPacientes(String Nombre,String Telefono){
		Connection con =Conectar();
		try {
			PreparedStatement pst =con.prepareStatement("INSERT INTO tablapacientes (NomPaciente,TelPaciente) VALUES (?,?)");
			pst.setString(1,Nombre);
			pst.setString(2,Telefono);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void InsertarAnalisis(int IdPaciente,float Hematocrito,float Hemoglobina,float ColesTotal,float ColesLDL,float ColesHDL,
			float IndAtero,float Glucemia,float Insulina,float IndHoma,float Urea,float Creatinina,float Tsh,String Otros){
		
		Connection con= Conectar();
		PreparedStatement pst;
		
		try {
			pst=con.prepareStatement("INSERT INTO tablalaboratorio (IdPaciente,Hematocrito,Hemoglobina,ColesterolTotal,ColesterolLDL,ColesterolHDL,IndiceAterogenico,Glucemia,Insulina,IndiceHoma,Urea,Creatinina,TSH,Otros) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,IdPaciente);
			pst.setFloat(2,Hematocrito);
			pst.setFloat(3,Hemoglobina);
			pst.setFloat(4,ColesTotal);
			pst.setFloat(5,ColesLDL);
			pst.setFloat(6,ColesHDL);
			pst.setFloat(7,IndAtero);
			pst.setFloat(8,Glucemia);
			pst.setFloat(9,Insulina);
			pst.setFloat(10,IndHoma);
			pst.setFloat(11,Urea);
			pst.setFloat(12,Creatinina);
			pst.setFloat(13,Tsh);
			pst.setString(14,Otros);
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
