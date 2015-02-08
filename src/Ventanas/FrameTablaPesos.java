package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FrameTablaPesos extends JFrame {

	private JPanel contentPane;
	public JTable tablaPesos;
	public JTextArea textAreaObservacion;

	
	public FrameTablaPesos() {
		InicioFrame();
		
	}


	private void InicioFrame() {
		setTitle("Tabla Control de Peso");
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 162);
		contentPane.add(scrollPane);
		
		tablaPesos = new JTable();
		scrollPane.setViewportView(tablaPesos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 253, 414, 174);
		contentPane.add(scrollPane_1);
		
		textAreaObservacion = new JTextArea();
		scrollPane_1.setViewportView(textAreaObservacion);
		
		JLabel lblObservacionDelControl = new JLabel("Observacion del Control de Peso:");
		lblObservacionDelControl.setBounds(10, 228, 203, 14);
		contentPane.add(lblObservacionDelControl);
	}
}
