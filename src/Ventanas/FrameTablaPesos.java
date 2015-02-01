package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrameTablaPesos extends JFrame {

	private JPanel contentPane;
	public JTable tablaPesos;

	
	public FrameTablaPesos() {
		InicioFrame();
		
	}


	private void InicioFrame() {
		setTitle("Tabla Control de Peso");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 240);
		contentPane.add(scrollPane);
		
		tablaPesos = new JTable();
		scrollPane.setViewportView(tablaPesos);
	}
}
