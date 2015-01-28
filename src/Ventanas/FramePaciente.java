package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import BasesDatos.Conexion;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePaciente extends JFrame {

	private JPanel contentPane;
	public JTextField textIdPaciente;
	public JTextField textNomPaciente;
	public JTextField textTelPAciente;
	JButton btnAnalisis = new JButton("Analisis");
	JButton btnControles = new JButton("Control");
	JButton btnGuardar = new JButton("Guardar");
	FrameAnalisiClinicos JFrameAnalClini;
	FrameControles JFrameControl;
	FramePrincipal JFramePrincipal;
	public JTextField textFecha;
	
	public FramePaciente() {
		
		InicializarPantalla();
		}


	private void InicializarPantalla() {
		setTitle("Paciente");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(238, 232, 170));
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 1, true));
		panel.setBounds(10, 11, 367, 239);
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
		textIdPaciente.setEditable(false);
		textIdPaciente.setBounds(222, 21, 76, 20);
		panel.add(textIdPaciente);
		textIdPaciente.setColumns(10);
		
		textNomPaciente = new JTextField();
		textNomPaciente.setBounds(140, 57, 158, 20);
		panel.add(textNomPaciente);
		textNomPaciente.setColumns(30);
		
		textTelPAciente = new JTextField();
		textTelPAciente.setBounds(169, 94, 129, 20);
		panel.add(textTelPAciente);
		textTelPAciente.setColumns(20);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre=textNomPaciente.getText();
				String Telefono=textTelPAciente.getText();
				
				System.out.println(Telefono);
				Conexion con = new Conexion();
				con.Insertar(Nombre, Telefono);
				JOptionPane.showMessageDialog(rootPane, "Paciente "+Nombre+" Ingresado !!!");
				
								
			btnAnalisis.setEnabled(true);	
			btnControles.setEnabled(true);
			}
		});
		btnGuardar.setBounds(10, 164, 76, 58);
		panel.add(btnGuardar);
		
		btnControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFrameControl=new FrameControles();
			JFrameControl.setVisible(true);
			}
		});
		btnControles.setBounds(100, 164, 76, 58);
		panel.add(btnControles);
		
		btnAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameAnalClini=new FrameAnalisiClinicos();
				JFrameAnalClini.setVisible(true);
			}
		});
		btnAnalisis.setBounds(192, 164, 79, 58);
		panel.add(btnAnalisis);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(143, 136, 155, 20);
		panel.add(textFecha);
		textFecha.setColumns(10);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion con= new Conexion();
				con.Editar(Integer.parseInt(textIdPaciente.getText()),textNomPaciente.getText(),textTelPAciente.getText());
				System.out.println(Integer.parseInt(textIdPaciente.getText())+" "+textNomPaciente.getText()+" "+textTelPAciente.getText());
								
			}
		});
		btnNewButton.setBounds(290, 164, 67, 58);
		panel.add(btnNewButton);
	
	}
}