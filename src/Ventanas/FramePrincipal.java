package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textField;

	
	public FramePrincipal() {
		setTitle("Sistema Integral de Pacientes de Nutricion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresar = new JButton("Nuevo");
		btnIngresar.setBounds(132, 144, 101, 55);
		contentPane.add(btnIngresar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 144, 101, 54);
		contentPane.add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 334, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textNombre = new JTextField();
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
		textTelefono.setToolTipText("Ingrese Telefono");
		textTelefono.setBounds(138, 84, 98, 20);
		panel.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Historia Clinica");
		lblNewLabel_1.setBounds(10, 11, 118, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("Identificador \u00FAnico del paciente");
		textField.setEditable(false);
		textField.setBounds(138, 8, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnModificar = new JButton("Editar");
		btnModificar.setBounds(243, 143, 101, 55);
		contentPane.add(btnModificar);
	}
}
