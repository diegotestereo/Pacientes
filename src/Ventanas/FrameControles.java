package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import jdk.nashorn.internal.scripts.JO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.JCommon;

import javax.swing.SwingConstants;

import BasesDatos.Conexion;

public class FrameControles extends JFrame {

	private JPanel contentPane;
	private JTextField textPesoC;
	private JTextField textAlturaC;
	public JTextField textNomPacienteC;
	private JTextField textCalculoIMC;
	public JTextField textFechaC;
	public JTextField textIdPaciente;
	JButton btnGuardarControl;
	String DiagnosticoBool;
	private JTextField textDiagnostico;
	private ResultSet rs;
	public FrameControles() {
		Inicializa();
		
		
	}
	
	
	private String DiagnosticarIMC(float IMC) {
	
		float Normal=(float) 25.0;
		float Sobrepeso=(float) 30.0;
		float Obesidad1=(float) 35.0;
		float Obesidad2=(float) 40.0;
		//float Obesidad3=(float) 40.0;
		
		int ResultadoN=Float.compare(IMC,Normal);
		int ResultadoS=Float.compare(IMC,Sobrepeso);
		int ResultadoO1=Float.compare(IMC,Obesidad1);
		int ResultadoO2=Float.compare(IMC,Obesidad2);
		//int ResultadoO3=Float.compare(IMC,Obesidad3);
		
		if(ResultadoN<0){
			DiagnosticoBool="Normal";
			textDiagnostico.setBackground(Color.GREEN);
		}else if(ResultadoS<0){
			DiagnosticoBool="Sobrepeso";
			textDiagnostico.setBackground(Color.yellow);
		}else{
			if(ResultadoO1<0){
				
				
				DiagnosticoBool="Obesidad Grado 1";
				textDiagnostico.setBackground(Color.orange);
			}else if(ResultadoO2<0){
				
				DiagnosticoBool="Obesidad Grado 2";
				textDiagnostico.setBackground(Color.red);
				
			}else{
				DiagnosticoBool="Obesidad Grado 3";
				textDiagnostico.setBackground(Color.red);
			}
		}
		
		return  DiagnosticoBool;


		
	}


	private void Inicializa(){
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
	lblNewLabel.setBounds(10, 56, 84, 20);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Peso:");
	lblNewLabel_1.setBounds(10, 118, 64, 14);
	panel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("IMC:");
	lblNewLabel_2.setBounds(10, 169, 44, 20);
	panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Fecha Control:");
	lblNewLabel_3.setBounds(10, 87, 84, 20);
	panel.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Observaciones");
	lblNewLabel_4.setBounds(10, 228, 102, 20);
	panel.add(lblNewLabel_4);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 259, 341, 57);
	panel.add(scrollPane);
	
	final JTextArea textAreaObs = new JTextArea();
	textAreaObs.setToolTipText("Ingrese Alguna observaci\u00F3n para guardar el control");
	scrollPane.setViewportView(textAreaObs);
	textPesoC = new JTextField();
	textPesoC.setToolTipText("utilice el punto \".\" para los decimales");
	textPesoC.setHorizontalAlignment(SwingConstants.CENTER);
	textPesoC.setBounds(109, 115, 46, 19);
	panel.add(textPesoC);
	textPesoC.setColumns(10);
	
	JButton btnTablaPeso = new JButton("Tabla Peso");
	btnTablaPeso.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int id =Integer.parseInt(textIdPaciente.getText());
			Conexion con= new Conexion();
			
			rs=con.BuscarControles(id);
			int c=0;
			XYSeries xygrafico=new XYSeries("Control Peso de:"+textNomPacienteC.getText());
			
			try {
				while(rs.next()){
					System.out.println("Peso: "+rs.getString("PesoControl")+" - Altura: "+rs.getString("AlturaControl")+" - IMC: "+rs.getString("IMCControl")+" - Obs: "+rs.getString("ObsControl")+" - Fecha: "+rs.getString("FechaControl"));
					float peso=Float.parseFloat(rs.getString("PesoControl"));
					System.out.println(c+" "+peso);
					xygrafico.add(c, peso);
					c++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	XYSeriesCollection dataset=new XYSeriesCollection();
			dataset.addSeries(xygrafico);
			JFreeChart chart=ChartFactory.createXYLineChart(textNomPacienteC.getText(), "Fecha Control", "Peso (Kg)", dataset);
			ChartFrame frame = new ChartFrame("Control de Peso", chart);
			frame.pack();
			frame.setVisible(true);
		}
	});
	btnTablaPeso.setBounds(239, 112, 112, 46);
	panel.add(btnTablaPeso);
	
	btnGuardarControl = new JButton("Guardar Control");
	btnGuardarControl.setEnabled(false);
	btnGuardarControl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(!(textAreaObs.getText().equals(""))){
			int Id=Integer.parseInt(textIdPaciente.getText());
			double Peso = Double.parseDouble(textPesoC.getText());
			double Altura = Double.parseDouble(textAlturaC.getText());
			double IMC = Double.parseDouble(textCalculoIMC.getText());
			String Obs=textAreaObs.getText();
			
			Conexion con=new Conexion();
			con.InsertarControl(Id, Peso,IMC,Altura,Obs);
		
			JOptionPane.showMessageDialog(rootPane, "Control Ingresado !!!");
			textPesoC.setText("");
			textAreaObs.setText("");
		
			}else{
				
				JOptionPane.showMessageDialog(rootPane, "Ingrese una Observacion para grabar");
				
			}
		
		}
	});
	btnGuardarControl.setBounds(10, 330, 341, 35);
	panel.add(btnGuardarControl);
	
	JLabel lblNewLabel_7 = new JLabel("Altura");
	lblNewLabel_7.setBounds(10, 144, 46, 14);
	panel.add(lblNewLabel_7);
	
	textAlturaC = new JTextField();
	textAlturaC.setToolTipText("utilice el punto \".\" para los decimales");
	textAlturaC.setHorizontalAlignment(SwingConstants.CENTER);
	textAlturaC.setBounds(109, 141, 46, 20);
	panel.add(textAlturaC);
	textAlturaC.setColumns(10);
	
	JLabel lblNewLabel_8 = new JLabel("Kg");
	lblNewLabel_8.setBounds(165, 118, 26, 14);
	panel.add(lblNewLabel_8);
	
	textNomPacienteC = new JTextField();
	textNomPacienteC.setHorizontalAlignment(SwingConstants.CENTER);
	textNomPacienteC.setEditable(false);
	textNomPacienteC.setBounds(109, 56, 131, 20);
	panel.add(textNomPacienteC);
	textNomPacienteC.setColumns(10);
	
	textCalculoIMC = new JTextField();
	textCalculoIMC.setHorizontalAlignment(SwingConstants.CENTER);
	textCalculoIMC.setText("0");
	textCalculoIMC.setEditable(false);
	textCalculoIMC.setBounds(109, 169, 46, 20);
	panel.add(textCalculoIMC);
	textCalculoIMC.setColumns(10);
	
	JLabel lblKgm = new JLabel("Kg/(m)^2");
	lblKgm.setBounds(165, 172, 46, 14);
	panel.add(lblKgm);
	
	JLabel lblNewLabel_5 = new JLabel("m");
	lblNewLabel_5.setBounds(165, 144, 46, 14);
	panel.add(lblNewLabel_5);
	
	textFechaC = new JTextField();
	textFechaC.setHorizontalAlignment(SwingConstants.CENTER);
	textFechaC.setEditable(false);
	textFechaC.setBounds(109, 87, 106, 20);
	panel.add(textFechaC);
	textFechaC.setColumns(10);

	JButton btnCalcIMC = new JButton("Calcular IMC");
	btnCalcIMC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		if((!(textPesoC.getText().equals("")))&&(!(textAlturaC.getText().equals("")))){
			float peso= Float.parseFloat(String.valueOf(textPesoC.getText()));
			float altura= Float.parseFloat(String.valueOf(textAlturaC.getText()));
			float IMC=(peso)/((altura)*(altura));
			
			textCalculoIMC.setText((String.valueOf(IMC)).substring(0,5));
			btnGuardarControl.setEnabled(true);
		
			textDiagnostico.setText(DiagnosticarIMC(IMC));
		btnGuardarControl.setEnabled(true);
			
			}else{
				
				JOptionPane.showMessageDialog(rootPane, "Ingrese Peso en kg y Altura en metros...");
				
			}
			
		}
	});
	
	
	btnCalcIMC.setBounds(239, 166, 112, 51);
	panel.add(btnCalcIMC);
	
	JLabel lblDisgnostico = new JLabel("Disgnostico");
	lblDisgnostico.setBounds(8, 200, 66, 14);
	panel.add(lblDisgnostico);
	
	JLabel lblHitoriaClinica = new JLabel("Hitoria Clinica");
	lblHitoriaClinica.setBounds(8, 22, 91, 14);
	panel.add(lblHitoriaClinica);
	
	textIdPaciente = new JTextField();
	textIdPaciente.setHorizontalAlignment(SwingConstants.CENTER);
	textIdPaciente.setEditable(false);
	textIdPaciente.setBounds(109, 19, 50, 20);
	panel.add(textIdPaciente);
	textIdPaciente.setColumns(10);
	
	textDiagnostico = new JTextField();
	textDiagnostico.setHorizontalAlignment(SwingConstants.CENTER);
	textDiagnostico.setEditable(false);
	textDiagnostico.setBounds(109, 197, 117, 20);
	panel.add(textDiagnostico);
	textDiagnostico.setColumns(10);
		
		
		
		
	};
}
