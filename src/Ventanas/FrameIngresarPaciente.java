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

public class FrameIngresarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textIdPaciente;
	private JTextField textNomPaciente;
	private JTextField textTelPAciente;
	JButton btnAnalisisClinicos = new JButton("Analisis Clinicos");
	JButton btnControles = new JButton("Controles");
	JButton btnGuardar = new JButton("Guardar");
	FrameAnalisiClinicos JFrameAnalClini;
	FrameControles JFrameControl;
	FramePrincipal JFramePrincipal;
	
	public FrameIngresarPaciente() {
		
		InicializarPantalla();
		}


	private void InicializarPantalla() {
		setTitle("Ingreso de Nuevo Paciente");
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
		lblNewLabel.setBounds(10, 24, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y Apellido");
		lblNewLabel_1.setBounds(10, 63, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono");
		lblNewLabel_2.setBounds(10, 100, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_3.setBounds(10, 139, 123, 14);
		panel.add(lblNewLabel_3);
		
		textIdPaciente = new JTextField();
		textIdPaciente.setEditable(false);
		textIdPaciente.setBounds(140, 21, 86, 20);
		panel.add(textIdPaciente);
		textIdPaciente.setColumns(10);
		
		textNomPaciente = new JTextField();
		textNomPaciente.setBounds(140, 57, 158, 20);
		panel.add(textNomPaciente);
		textNomPaciente.setColumns(30);
		
		textTelPAciente = new JTextField();
		textTelPAciente.setBounds(140, 94, 86, 20);
		panel.add(textTelPAciente);
		textTelPAciente.setColumns(20);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nombre=textNomPaciente.getText();
				String TelefonoS=textTelPAciente.getText();
				int Telefono = 0;
				try {
					 Telefono=Integer.parseInt(TelefonoS);

					
				} catch (NumberFormatException ex){ // handle your exception e) {
					System.out.println("Error :" +ex);
				}
				
				System.out.println(Telefono);
				Conexion con = new Conexion();
				con.Insertar(Nombre, Telefono);
				JOptionPane.showMessageDialog(rootPane, "Paciente "+Nombre+" Ingresado !!!");
				
								
			btnAnalisisClinicos.setEnabled(true);	
			btnControles.setEnabled(true);
			}
		});
		btnGuardar.setBounds(10, 191, 93, 31);
		panel.add(btnGuardar);
		
		btnControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFrameControl=new FrameControles();
			JFrameControl.setVisible(true);
			}
		});
		btnControles.setEnabled(false);
		btnControles.setBounds(116, 191, 110, 31);
		panel.add(btnControles);
		
		btnAnalisisClinicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameAnalClini=new FrameAnalisiClinicos();
				JFrameAnalClini.setVisible(true);
			}
		});
		btnAnalisisClinicos.setEnabled(false);
		btnAnalisisClinicos.setBounds(236, 191, 110, 31);
		panel.add(btnAnalisisClinicos);
	
	}
}
