package Ventanas;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.ClasePrincipal;
import BasesDatos.Conexion;

public class FrameTabladeAnalisisClinicos extends JFrame {

	private JPanel contentPane;
	public JTable tablaAnalisisClinicos;
	public JTextField textIdPaciente;
	public JTextField textNombrePaciente;
   private int Idpaciente;
	
	public FrameTabladeAnalisisClinicos() {
		Idpaciente=FrameAntecedentesAnalisis.IdPacienteGlobal;
		
		InicioFrame();
		ActualizarTabla();
		
		
	}


	private void ActualizarTabla() {
		
		DefaultTableModel dfm = new DefaultTableModel();
		tablaAnalisisClinicos.setModel(dfm);
		tablaAnalisisClinicos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		dfm.setColumnIdentifiers(new Object[]{"Fecha", "Hematocrito", "Hemoglobina", "ColesTotal", "ColesLDL", "ColesHDL", "IndAtero"
				, "Glucemia", "Insulina", "IndHoma", "Urea", "Creatinina", "Tsh", "Otros"});
		Conexion con= new Conexion();
		ResultSet rs=null;
		rs=con.BuscaAnalisis(Idpaciente);
		
		try {
			while(rs.next()){
				dfm.addRow(new Object[]{rs.getString("FechaLab").substring(0,10),rs.getString("Hematocrito"),rs.getString("Hemoglobina"),rs.getString("ColesterolTotal"),rs.getString("ColesterolLDL"),rs.getString("ColesterolHDL"),rs.getString("IndiceAterogenico"),rs.getString("Glucemia"),rs.getString("Insulina"),rs.getString("IndiceHoma"),rs.getString("Urea"),rs.getString("Creatinina"),rs.getString("TSH"),rs.getString("Otros")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void InicioFrame() {
		setTitle("Tabla de Analisis Clinicos");
		
		setBounds(100, 100, 947, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 911, 135);
		contentPane.add(scrollPane);
		
		tablaAnalisisClinicos = new JTable();
		tablaAnalisisClinicos.setEnabled(false);
		tablaAnalisisClinicos.setBorder(new LineBorder(Color.RED, 2));
		scrollPane.setViewportView(tablaAnalisisClinicos);
		
		JLabel label = new JLabel("Historia Clinica: ");
		label.setBounds(10, 14, 111, 14);
		contentPane.add(label);
		
		textIdPaciente = new JTextField();
		textIdPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		textIdPaciente.setEditable(false);
		textIdPaciente.setColumns(10);
		textIdPaciente.setBounds(142, 11, 57, 20);
		contentPane.add(textIdPaciente);
		
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(303, 14, 57, 14);
		contentPane.add(lblPaciente);
		
		textNombrePaciente = new JTextField();
		textNombrePaciente.setHorizontalAlignment(SwingConstants.CENTER);
		textNombrePaciente.setEditable(false);
		textNombrePaciente.setColumns(10);
		textNombrePaciente.setBounds(385, 11, 212, 20);
		contentPane.add(textNombrePaciente);
		
		
	}
}
