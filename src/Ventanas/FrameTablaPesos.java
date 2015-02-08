package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameTablaPesos extends JFrame {

	private JPanel contentPane;
	public JTable tablaPesos;
	public JTextArea textAreaObservacion;
	private JTextField textPeso;
	private JTextField textDiferencia;
	private JTextField textFecha;
	private JLabel lblDiferencia;

	
	public FrameTablaPesos() {
		InicioFrame();
		
	}


	private void InicioFrame() {
		setTitle("Tabla Control de Peso");
		setBounds(100, 100, 450, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 162);
		contentPane.add(scrollPane);
		
		tablaPesos = new JTable();
		tablaPesos.addMouseListener(new MouseListener() {
			
				
			public void mouseClicked(MouseEvent arg0) {

				
					int fila =tablaPesos.getSelectedRow();
					String Observacion =(String) tablaPesos.getValueAt(fila, 3);
					String Fecha=(String) tablaPesos.getValueAt(fila, 0);
					String Peso=(String) tablaPesos.getValueAt(fila, 1);
					String Diferencia=(String) tablaPesos.getValueAt(fila, 2);
					float dif=Float.parseFloat(Diferencia);
					textAreaObservacion.setText(Observacion);
					textPeso.setText(Peso);
					textFecha.setText(Fecha);
					
					if(dif<0){
						lblDiferencia.setText("Bajó:");
						textDiferencia.setText(Diferencia.substring(1,Diferencia.length()) +" Kgs.");
						textDiferencia.setBackground(Color.green);
						textDiferencia.setForeground(Color.black);
						
					}else if(dif==0){
						lblDiferencia.setText("Se mantuvo:");
						textDiferencia.setText(Diferencia +" Kgs.");
						textDiferencia.setBackground(Color.gray);
						textDiferencia.setForeground(Color.black);
					}else{
						
						lblDiferencia.setText("Aumentó:");
						textDiferencia.setText(Diferencia +" Kgs.");
						textDiferencia.setBackground(Color.RED);
						textDiferencia.setForeground(Color.white);
						
						
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
		scrollPane.setViewportView(tablaPesos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 247, 414, 89);
		contentPane.add(scrollPane_1);
		
		textAreaObservacion = new JTextArea();
		textAreaObservacion.setEditable(false);
		scrollPane_1.setViewportView(textAreaObservacion);
		
		JLabel lblObservacionDelControl = new JLabel("Observacion del Control de Peso:");
		lblObservacionDelControl.setBounds(10, 222, 203, 14);
		contentPane.add(lblObservacionDelControl);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(10, 197, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setEditable(false);
		textFecha.setBounds(63, 194, 86, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Peso Actual:");
		lblNewLabel_1.setBounds(237, 197, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		textPeso = new JTextField();
		textPeso.setHorizontalAlignment(SwingConstants.CENTER);
		textPeso.setEditable(false);
		textPeso.setBounds(338, 191, 86, 20);
		contentPane.add(textPeso);
		textPeso.setColumns(10);
		
		lblDiferencia = new JLabel("Diferencia");
		lblDiferencia.setBounds(237, 222, 91, 14);
		contentPane.add(lblDiferencia);
		
		textDiferencia = new JTextField();
		textDiferencia.setHorizontalAlignment(SwingConstants.CENTER);
		textDiferencia.setEditable(false);
		textDiferencia.setBounds(338, 216, 86, 20);
		contentPane.add(textDiferencia);
		textDiferencia.setColumns(10);
	}
}
