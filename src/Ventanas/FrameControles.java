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
	private JTextField textField_1;

		public FrameControles() {
			setTitle("Control");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 1, true));
		panel.setBounds(10, 11, 311, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historia Clinica:");
		lblNewLabel.setBounds(10, 10, 84, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso:");
		lblNewLabel_1.setBounds(10, 42, 64, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IMC:");
		lblNewLabel_2.setBounds(10, 67, 44, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Control:");
		lblNewLabel_3.setBounds(10, 98, 102, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observaciones");
		lblNewLabel_4.setBounds(10, 125, 102, 20);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 285, 78);
		panel.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(104, 10, 102, 20);
		panel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 37, 77, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnTablaPeso = new JButton("Tabla Peso");
		btnTablaPeso.setBounds(206, 10, 89, 66);
		panel.add(btnTablaPeso);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(206, 80, 89, 60);
		panel.add(btnNewButton);
	}
}
