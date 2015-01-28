package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrameControles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

		public FrameControles() {
			setTitle("Control Paciente");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 1, true));
		panel.setBounds(10, 11, 311, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historia Clinica:");
		lblNewLabel.setBounds(10, 10, 84, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso:");
		lblNewLabel_1.setBounds(10, 72, 64, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IMC:");
		lblNewLabel_2.setBounds(10, 123, 44, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Control:");
		lblNewLabel_3.setBounds(10, 41, 84, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observaciones");
		lblNewLabel_4.setBounds(10, 154, 102, 20);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 285, 78);
		panel.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(90, 69, 46, 19);
		panel.add(textPeso);
		textPeso.setColumns(10);
		
		JButton btnTablaPeso = new JButton("Tabla Peso");
		btnTablaPeso.setBounds(202, 68, 99, 23);
		panel.add(btnTablaPeso);
		
		JButton btnNewButton = new JButton("Guardar Control");
		btnNewButton.setBounds(10, 269, 285, 47);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Altura");
		lblNewLabel_7.setBounds(10, 98, 46, 14);
		panel.add(lblNewLabel_7);
		
		textAltura = new JTextField();
		textAltura.setBounds(90, 95, 46, 20);
		panel.add(textAltura);
		textAltura.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Kg");
		lblNewLabel_8.setBounds(146, 72, 26, 14);
		panel.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(90, 10, 46, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(90, 123, 44, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblKgm = new JLabel("Kg/(m)^2");
		lblKgm.setBounds(146, 126, 46, 14);
		panel.add(lblKgm);
		
		JLabel lblNewLabel_5 = new JLabel("m");
		lblNewLabel_5.setBounds(146, 98, 46, 14);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(90, 41, 106, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCalcIMC = new JButton("Calcular IMC");
		btnCalcIMC.setBounds(202, 122, 99, 23);
		panel.add(btnCalcIMC);
	}
}
