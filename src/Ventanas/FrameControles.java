package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BasesDatos.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class FrameControles extends JFrame {

	private JPanel contentPane;
	private JTextField textPesoC;
	private JTextField textAlturaC;
	public JTextField textNomPacienteC;
	private JTextField textCalculoIMC;
	public JTextField textFechaC;
	
		public FrameControles() {
			setResizable(false);
			setTitle("Control Paciente");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 1, true));
		panel.setBounds(10, 11, 361, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
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
		lblNewLabel_4.setBounds(10, 182, 102, 20);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 341, 111);
		panel.add(scrollPane);
		
		final JTextArea textAreaObs = new JTextArea();
		scrollPane.setViewportView(textAreaObs);
		textPesoC = new JTextField();
		textPesoC.setBounds(109, 69, 46, 19);
		panel.add(textPesoC);
		textPesoC.setColumns(10);
		
		JButton btnTablaPeso = new JButton("Tabla Peso");
		btnTablaPeso.setBounds(239, 66, 99, 23);
		panel.add(btnTablaPeso);
		
		JButton btnGuardarControl = new JButton("Guardar Control");
		btnGuardarControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int Id=Integer.parseInt(Jfp.getText());
				double Peso = Double.parseDouble(textPesoC.getText());
				double Altura = Double.parseDouble(textAlturaC.getText());
				double IMC = Double.parseDouble(textCalculoIMC.getText());
				String Obs=textAreaObs.getText();
				
				Conexion con=new Conexion();
				con.InsertarControl(Id, Peso,IMC,Altura,Obs);
			
				JOptionPane.showMessageDialog(rootPane, "Control Ingresado !!!");
			
			}
		});
		btnGuardarControl.setBounds(10, 330, 341, 35);
		panel.add(btnGuardarControl);
		
		JLabel lblNewLabel_7 = new JLabel("Altura");
		lblNewLabel_7.setBounds(10, 98, 46, 14);
		panel.add(lblNewLabel_7);
		
		textAlturaC = new JTextField();
		textAlturaC.setBounds(109, 95, 46, 20);
		panel.add(textAlturaC);
		textAlturaC.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Kg.");
		lblNewLabel_8.setBounds(165, 72, 26, 14);
		panel.add(lblNewLabel_8);
		
		textNomPacienteC = new JTextField();
		textNomPacienteC.setEditable(false);
		textNomPacienteC.setBounds(109, 10, 169, 20);
		panel.add(textNomPacienteC);
		textNomPacienteC.setColumns(10);
		
		textCalculoIMC = new JTextField();
		textCalculoIMC.setEditable(false);
		textCalculoIMC.setBounds(109, 123, 46, 20);
		panel.add(textCalculoIMC);
		textCalculoIMC.setColumns(10);
		
		JLabel lblKgm = new JLabel("Kg/(m)^2");
		lblKgm.setBounds(165, 126, 46, 14);
		panel.add(lblKgm);
		
		JLabel lblNewLabel_5 = new JLabel("cm.");
		lblNewLabel_5.setBounds(165, 98, 46, 14);
		panel.add(lblNewLabel_5);
		
		textFechaC = new JTextField();
		textFechaC.setEditable(false);
		textFechaC.setBounds(109, 41, 106, 20);
		panel.add(textFechaC);
		textFechaC.setColumns(10);
		
		JButton btnCalcIMC = new JButton("Calcular IMC");
		btnCalcIMC.setBounds(239, 120, 99, 23);
		panel.add(btnCalcIMC);
		
		JLabel lblDisgnostico = new JLabel("Disgnostico");
		lblDisgnostico.setBounds(8, 154, 66, 14);
		panel.add(lblDisgnostico);
		
		JLabel lblBn = new JLabel("diagnostico");
		lblBn.setBounds(109, 154, 102, 14);
		panel.add(lblBn);
	}
}
