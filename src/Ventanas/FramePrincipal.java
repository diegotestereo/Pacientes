package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.Current;

import BasesDatos.Conexion;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class FramePrincipal extends JFrame {

	
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textField;
	private JTable JTable1;
	private ResultSet rs;
	FramePaciente JFrameIngresarPa;

	
	public FramePrincipal() {
		
		inicializacion();//carga la pantalla con todos sus componentes
		
		ActualizarTabla();
	}

	private void inicializacion() {
		setTitle("Sistema Integral de Pacientes - Version 1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cierra toda la apliccacion
		setBounds(100, 100, 509, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar Nuevo");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String filas=String.valueOf(JTable1.getRowCount()+1);
				 java.util.Date date= new java.util.Date();
				JFrameIngresarPa = new FramePaciente();
				JFrameIngresarPa.setVisible(true);
				JFrameIngresarPa.btnEditar.setEnabled(false);
				JFrameIngresarPa.btnAnalisis.setEnabled(false);
				JFrameIngresarPa.btnControles.setEnabled(false);
				JFrameIngresarPa.textIdPaciente.setText(filas);
				JFrameIngresarPa.textFecha.setText(String.valueOf(new Timestamp(date.getTime())).substring(0,10));
				
			}
		});
		btnIngresar.setBounds(10, 143, 170, 55);
		contentPane.add(btnIngresar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 479, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setToolTipText("Ingrese el nombre y apellido del paciente");
		textNombre.setBounds(138, 46, 163, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido");
		lblNombre.setBounds(10, 49, 118, 14);
		panel.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Telefono Celular");
		lblNewLabel.setBounds(10, 87, 118, 14);
		panel.add(lblNewLabel);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setToolTipText("Ingrese Telefono");
		textTelefono.setBounds(138, 84, 98, 20);
		panel.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Historia Clinica");
		lblNewLabel_1.setBounds(10, 11, 118, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setToolTipText("Identificador \u00FAnico del paciente");
		textField.setEditable(false);
		textField.setBounds(138, 8, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarPorNombre = new JButton("Buscar por Nombre");
		btnBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre=textNombre.getText();
				
			    DefaultTableModel dfm = new DefaultTableModel();
				JTable1.setModel(dfm);
				dfm.setColumnIdentifiers(new Object[]{"Id","Nombre","Telefono","Fecha"});
				Conexion con= new Conexion();
				rs=con.BuscarNombre(Nombre);
				try {
					while(rs.next()){
						dfm.addRow(new Object[]{rs.getString("IdPaciente"),rs.getString("NomPaciente"),rs.getString("TelPaciente"),rs.getString("FechaInPaciente")});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnBuscarPorNombre.setBounds(313, 33, 146, 35);
		panel.add(btnBuscarPorNombre);
		
		JButton btnBuscarPorTelefono = new JButton("Buscar por Telefono");
		btnBuscarPorTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Telefono=textTelefono.getText();
				
			    DefaultTableModel dfm = new DefaultTableModel();
				JTable1.setModel(dfm);
				dfm.setColumnIdentifiers(new Object[]{"Id","Nombre","Telefono","Fecha"});
				Conexion con= new Conexion();
				rs=con.BuscarTelefono(Telefono);
				try {
					while(rs.next()){
						dfm.addRow(new Object[]{rs.getString("IdPaciente"),rs.getString("NomPaciente"),rs.getString("TelPaciente"),rs.getString("FechaInPaciente")});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnBuscarPorTelefono.setBounds(313, 71, 146, 35);
		panel.add(btnBuscarPorTelefono);
		
				
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int fila =JTable1.getSelectedRow();
				String IdHistClin= (String)JTable1.getValueAt(fila, 0);
				
				System.out.println(IdHistClin);
				
				Conexion con=new Conexion();
				con.Borrar(Integer.parseInt(IdHistClin));

				ActualizarTabla();
				
			}
		});
		btnBorrar.setBounds(190, 143, 129, 55);
		contentPane.add(btnBorrar);
		
		JButton btnVerPacientes = new JButton("Actualizar Vista");
		btnVerPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ActualizarTabla();
				
			}
		});
		btnVerPacientes.setBounds(329, 143, 160, 55);
		contentPane.add(btnVerPacientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 209, 479, 194);
		contentPane.add(scrollPane);
		
		JTable1 = new JTable();
		JTable1.addMouseListener(new MouseListener() {
			
		
			
			public void mouseClicked(MouseEvent arg0) {
				if( JTable1.getSelectedRows().length > 0 ) { 
					
					int fila =JTable1.getSelectedRow();
					//textField.setText(Integer.toString(fila));
					String IdHistClin= (String)JTable1.getValueAt(fila, 0);
					String NombreHistClin= (String)JTable1.getValueAt(fila, 1);
					String TelefonoHistClin= (String)JTable1.getValueAt(fila, 2);
					String FechaHistClin= (String)JTable1.getValueAt(fila, 3);
					
					FramePaciente JFramePaciente= new FramePaciente();
					JFramePaciente.textIdPaciente.setText(IdHistClin);
					JFramePaciente.textNomPaciente.setText(NombreHistClin);
					JFramePaciente.textTelPAciente.setText(TelefonoHistClin);
					JFramePaciente.textFecha.setText(FechaHistClin.substring(0,10));
					JFramePaciente.btnGuardar.setEnabled(false);
					
					JFramePaciente.setVisible(true);
					//   JOptionPane.showMessageDialog( JTable1 ,"No son molestos los popups?");
			         }
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		scrollPane.setViewportView(JTable1);
		}

	public void ActualizarTabla() {
		// TODO Auto-generated method stub
		DefaultTableModel dfm = new DefaultTableModel();
		JTable1.setModel(dfm);
		JTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dfm.setColumnIdentifiers(new Object[]{"Id","Nombre","Telefono","Fecha"});
		Conexion con= new Conexion();
		rs=con.BuscarTodos();
		try {
			while(rs.next()){
				dfm.addRow(new Object[]{rs.getString("IdPaciente"),rs.getString("NomPaciente"),rs.getString("TelPaciente"),rs.getString("FechaInPaciente")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
