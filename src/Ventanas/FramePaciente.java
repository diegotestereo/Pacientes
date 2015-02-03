package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BasesDatos.Conexion;

import javax.swing.SwingConstants;

public class FramePaciente extends JFrame {

	private JPanel contentPane;
	public JTextField textIdPaciente;
	public JTextField textNomPaciente;
	public JTextField textTelPAciente;
	JButton btnAnalisis = new JButton("Antecedentes Clinicos y Lab.");
	JButton btnControles = new JButton("Controles");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnEditar = new JButton("Editar");
	FrameAntecedentesAnalisis JFrameAnalClini;
	FrameControles JFrameControl;
	FramePrincipal JFramePrincipal;
	public JTextField textFecha;
	static public int IdPacienteGlobal;
	
	public FramePaciente() {
		setResizable(false);
		
		InicializarPantalla();
		//IdPacienteGlobal=Integer.parseInt(textIdPaciente.getText());
		}


	private void InicializarPantalla() {
		setTitle("Paciente");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(238, 232, 170));
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 1, true));
		panel.setBounds(10, 11, 357, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historia Clinica");
		lblNewLabel.setBounds(10, 24, 123, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y Apellido");
		lblNewLabel_1.setBounds(10, 63, 123, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono");
		lblNewLabel_2.setBounds(10, 100, 123, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Primera visita");
		lblNewLabel_3.setBounds(10, 139, 123, 14);
		panel.add(lblNewLabel_3);
		
		textIdPaciente = new JTextField();
		textIdPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		textIdPaciente.setEditable(false);
		textIdPaciente.setBounds(248, 18, 93, 20);
		panel.add(textIdPaciente);
		textIdPaciente.setColumns(10);
		
		textNomPaciente = new JTextField();
		textNomPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		textNomPaciente.setBounds(166, 54, 175, 20);
		panel.add(textNomPaciente);
		textNomPaciente.setColumns(30);
		textNomPaciente.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent arg0) {
				btnEditar.setEnabled(true);
			}
			
			public void insertUpdate(DocumentEvent arg0) {
	//			btnEditar.setEnabled(true);
				
			}
			
			public void changedUpdate(DocumentEvent arg0) {
				btnEditar.setEnabled(true);
				
			}
		});
		
		textTelPAciente = new JTextField();
		textTelPAciente.setHorizontalAlignment(SwingConstants.CENTER);
		textTelPAciente.setBounds(195, 91, 146, 20);
		panel.add(textTelPAciente);
		textTelPAciente.setColumns(20);
		textTelPAciente.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent arg0) {
				btnEditar.setEnabled(true);
			}
			
			public void insertUpdate(DocumentEvent arg0) {
		//		btnEditar.setEnabled(true);
			}
			
			public void changedUpdate(DocumentEvent arg0) {
			//	btnEditar.setEnabled(true);
				
			}
		});
		btnGuardar.setToolTipText("Almacena el Paciente en la base de datos");
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre=textNomPaciente.getText();
				String Telefono=textTelPAciente.getText();
				
				
				boolean r = textNomPaciente.getText().isEmpty();
				r|=textTelPAciente.getText().isEmpty();
				System.out.println(r);
				
				
				
			if (!(r)){
				System.out.println(Telefono);
				Conexion con = new Conexion();
				con.InsertarPacientes(Nombre, Telefono);
				JOptionPane.showMessageDialog(rootPane, "Paciente "+Nombre+" Ingresado !!!");
									
			btnAnalisis.setEnabled(true);	
			btnControles.setEnabled(true);
			btnEditar.setEnabled(true);
			btnGuardar.setEnabled(false);
			textNomPaciente.setEditable(false);
			textTelPAciente.setEditable(false);
			}
			else{
				JOptionPane.showMessageDialog(rootPane, "Ingrese Nombre y Telefono !!!");
				
			}
			}
		});
		btnGuardar.setBounds(10, 228, 331, 42);
		panel.add(btnGuardar);
		btnControles.setToolTipText("Muestra los Controles");
		
		btnControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 java.util.Date date= new java.util.Date();
			JFrameControl=new FrameControles();
			JFrameControl.textIdPaciente.setText(textIdPaciente.getText());
			IdPacienteGlobal=Integer.parseInt(textIdPaciente.getText());
			JFrameControl.textNomPacienteC.setText(textNomPaciente.getText());
			JFrameControl.textFechaC.setText(textFecha.getText().substring(0,10));
			JFrameControl.textFechaC.setText(String.valueOf(new Timestamp(date.getTime())).substring(0,10));
			JFrameControl.btnGuardarControl.setEnabled(false);
			JFrameControl.setVisible(true);
			}
		});
		btnControles.setBounds(10, 164, 107, 53);
		panel.add(btnControles);
		btnAnalisis.setToolTipText("Muestra los Analisis Clinicos");
		
		btnAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IdPacienteGlobal=Integer.parseInt(textIdPaciente.getText());
				
				JFrameAnalClini=new FrameAntecedentesAnalisis();
				JFrameAnalClini.textIdPaciente.setText(textIdPaciente.getText());
				JFrameAnalClini.textNombre.setText(textNomPaciente.getText());
				JFrameAnalClini.setVisible(true);
				
			}
		});
		btnAnalisis.setBounds(127, 164, 214, 53);
		panel.add(btnAnalisis);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setEditable(false);
		textFecha.setBounds(169, 133, 172, 20);
		panel.add(textFecha);
		textFecha.setColumns(10);
		btnEditar.setEnabled(false);
		btnEditar.setToolTipText("Almacenar Cambios");
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcionEditar=JOptionPane.showConfirmDialog(null, "Desea Guardar Cambios?","Elija ", JOptionPane.YES_NO_OPTION);
				if(opcionEditar==0){
				Conexion con= new Conexion();
				con.Editar(Integer.parseInt(textIdPaciente.getText()),textNomPaciente.getText(),textTelPAciente.getText());
				btnEditar.setEnabled(false);
				}else{}
				}
		});
		btnEditar.setBounds(10, 281, 331, 37);
		panel.add(btnEditar);
	
	}
}
