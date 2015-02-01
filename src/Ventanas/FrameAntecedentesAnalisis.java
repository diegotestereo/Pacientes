package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import BasesDatos.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import javax.swing.JTextArea;

public class FrameAntecedentesAnalisis extends JFrame {

	private JPanel contentPane;
	private JTextField textHematocrito;
	private JTextField textHemoglobina;
	private JTextField textColesterolTotal;
	private JTextField textColesterolLDL;
	private JTextField textColesterolHDL;
	private JTextField textIndiceAterogenico;
	private JTextField textGlucemia;
	private JTextField textInsulina;
	private JTextField textIndiceHoma;
	private JTextField textUrea;
	private JTextField textCreatinina;
	private JTextField textTSH;
	private JTextField textOtros;
	public JTextField textIdPaciente;
	public JTextField textNombre;
	JTextArea textOtrasEnfermedades;
	JButton btnEditar ;
	JButton btnGuardarAntyAnalisisClin ;
	JButton btnTablaAnalisis;
	ResultSet rs;
	JCheckBox chckbxDiabetes,chckbxColesterol,chckbxEnfCardio,chckbxInsulinoResistente,chckbxHipotiroidismo,chckbxHipertiroidismo;
	
	
	
	public FrameAntecedentesAnalisis() {
		
		
		
		setTitle("Antecedentes y Analisis Clinicos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Antecedentes");
		panel.setBorder(new LineBorder(new Color(240, 230, 140)));
		panel.setBounds(10, 11, 448, 472);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(240, 230, 140));
		panel_1.setBorder(new LineBorder(new Color(240, 230, 140)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("los datos numericos utilizan el \".\" para decimales");
		panel_2.setBorder(new LineBorder(new Color(240, 230, 140)));
		panel_2.setForeground(new Color(240, 230, 140));
		panel_1.setLayout(null);
		
		
		btnEditar = new JButton("Editar");
		btnGuardarAntyAnalisisClin = new JButton("Guardar");
		btnTablaAnalisis = new JButton("Tabla Analisis de Clinicos");
		
		chckbxDiabetes = new JCheckBox("Diabetes");
		chckbxDiabetes.setBounds(6, 7, 140, 23);
		panel_1.add(chckbxDiabetes);
		
		chckbxEnfCardio = new JCheckBox("Enf. Cardiovascular");
		chckbxEnfCardio.setBounds(6, 33, 140, 23);
		panel_1.add(chckbxEnfCardio);
		
		chckbxColesterol = new JCheckBox("Colesterol");
		chckbxColesterol.setBounds(6, 59, 97, 23);
		panel_1.add(chckbxColesterol);
		
		chckbxInsulinoResistente = new JCheckBox("Insulino Resistente");
		chckbxInsulinoResistente.setBounds(6, 85, 140, 23);
		panel_1.add(chckbxInsulinoResistente);
		
		chckbxHipotiroidismo = new JCheckBox("Hipotiroidismo");
		chckbxHipotiroidismo.setBounds(6, 111, 140, 23);
		panel_1.add(chckbxHipotiroidismo);
		
		chckbxHipertiroidismo = new JCheckBox("Hipertiroidismo");
		chckbxHipertiroidismo.setBounds(6, 137, 140, 23);
		panel_1.add(chckbxHipertiroidismo);
	
		
		btnGuardarAntyAnalisisClin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int IdNombre,diabetes,enfcard,colest,insulino,hipo,hiper;
				float Hematocrito=0, Hemoglobina=0, ColesTotal=0, ColesLDL=0, ColesHDL=0, IndAtero=0, Glucemia=0, Insulina=0, IndHoma=0
						, Urea=0, Creatinina=0, Tsh=0;
				String Otros;
				
				IdNombre=Integer.parseInt(textIdPaciente.getText());
				if(chckbxDiabetes.isSelected()){diabetes=1;} else{ diabetes=0;}
				if(chckbxEnfCardio.isSelected()){enfcard=1;} else{enfcard=0;}
				if(chckbxColesterol.isSelected()){colest=1;} else{colest=0;}
				if(chckbxInsulinoResistente.isSelected()){insulino=1;} else{insulino=0;}
				if(chckbxHipotiroidismo.isSelected()){hipo=1;} else{hipo=0;}
				if(chckbxHipertiroidismo.isSelected()){hiper=1;} else{hiper=0;}
				String otros=textOtrasEnfermedades.getText();
		
				Hematocrito=Float.parseFloat(textHematocrito.getText());
				Hemoglobina=Float.parseFloat(textHemoglobina.getText());
				ColesTotal=Float.parseFloat(textColesterolTotal.getText());
				ColesLDL=Float.parseFloat(textColesterolLDL.getText());
				ColesHDL=Float.parseFloat(textColesterolHDL.getText());
				IndAtero=Float.parseFloat(textIndiceAterogenico.getText());
				Glucemia=Float.parseFloat(textGlucemia.getText());
				Insulina=Float.parseFloat(textInsulina.getText());
				IndHoma=Float.parseFloat(textIndiceHoma.getText());
				Urea=Float.parseFloat(textUrea.getText());
				Creatinina=Float.parseFloat(textCreatinina.getText());
				Tsh=Float.parseFloat(textTSH.getText());
				Otros=textOtros.getText();
				
				
				Conexion con= new Conexion();
				int cantidadAntecedentes=0;
				ResultSet rsAntecedentes=con.BuscarAntecedentes(IdNombre);
				
				try {
					rsAntecedentes.last();
					cantidadAntecedentes=rsAntecedentes.getRow();
					rsAntecedentes.beforeFirst();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cantidadAntecedentes!=0){
					JOptionPane.showMessageDialog(rootPane, "Existen antecedentes");
					con.InsertarAnalisis(IdNombre, Hematocrito, Hemoglobina, ColesTotal, ColesLDL, ColesHDL, IndAtero, Glucemia, Insulina, IndHoma, Urea, Creatinina, Tsh, Otros);
					
				}else{JOptionPane.showMessageDialog(rootPane, "No existen antecedentes  Almacenados");
				
				con.InsertarAntecedentes(IdNombre, diabetes, enfcard, colest, insulino, hipo, hiper, otros);
				con.InsertarAnalisis(IdNombre, Hematocrito, Hemoglobina, ColesTotal, ColesLDL, ColesHDL, IndAtero, Glucemia, Insulina, IndHoma, Urea, Creatinina, Tsh, Otros);
			
				
				}
				
				try {
					while(rsAntecedentes.next()){
						chckbxDiabetes.setSelected(rsAntecedentes.getBoolean("Diabetes"));
						chckbxColesterol.setSelected(rsAntecedentes.getBoolean("Colesterol"));
						chckbxEnfCardio.setSelected(rsAntecedentes.getBoolean("EnfermedadCardio"));
						chckbxHipertiroidismo.setSelected(rsAntecedentes.getBoolean("Hipertiroidismo"));
						chckbxHipotiroidismo.setSelected(rsAntecedentes.getBoolean("Hipotiroidismo"));
						chckbxInsulinoResistente.setSelected(rsAntecedentes.getBoolean("InsulinoResistente"));
						textOtrasEnfermedades.setText(rsAntecedentes.getString("Otros"));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				JOptionPane.showMessageDialog(rootPane, "Datos Ingresados");
				btnEditar.setEnabled(true);
			
			}
		});
		
		
		
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int IdNombre,diabetes,enfcard,colest,insulino,hipo,hiper;
				IdNombre=Integer.parseInt(textIdPaciente.getText());
			if(chckbxDiabetes.isSelected()){diabetes=1;} else{ diabetes=0;}
			if(chckbxEnfCardio.isSelected()){enfcard=1;} else{enfcard=0;}
			if(chckbxColesterol.isSelected()){colest=1;} else{colest=0;}
			if(chckbxInsulinoResistente.isSelected()){insulino=1;} else{insulino=0;}
			if(chckbxHipotiroidismo.isSelected()){hipo=1;} else{hipo=0;}
			if(chckbxHipertiroidismo.isSelected()){hiper=1;} else{hiper=0;}
		
				String otros=textOtrasEnfermedades.getText();
				
				Conexion con=new Conexion();
				con.EditarAntecendentes(IdNombre,diabetes,enfcard,colest,insulino,hipo,hiper,otros);//
				JOptionPane.showMessageDialog(rootPane, "Los cambios fueron Efectuados.");
				
			}
		});
		
		btnTablaAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int cantidadAntecedentes=0;
				
				Conexion con=new Conexion();
				ResultSet rsAntededentes=null;
				ResultSet rsAnalisis=null;
				
				rsAntededentes=con.BuscarAntecedentes(Integer.parseInt(textIdPaciente.getText()));
				
				try {
					rsAntededentes.last();
					cantidadAntecedentes=rsAntededentes.getRow();
					rsAntededentes.beforeFirst();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cantidadAntecedentes!=0){
			//		JOptionPane.showMessageDialog(rootPane, "Existen antecedentes");
					try {
						while(rsAntededentes.next()){
							chckbxDiabetes.setSelected(rsAntededentes.getBoolean("Diabetes"));
							chckbxColesterol.setSelected(rsAntededentes.getBoolean("Colesterol"));
							chckbxEnfCardio.setSelected(rsAntededentes.getBoolean("EnfermedadCardio"));
							chckbxHipertiroidismo.setSelected(rsAntededentes.getBoolean("Hipertiroidismo"));
							chckbxHipotiroidismo.setSelected(rsAntededentes.getBoolean("Hipotiroidismo"));
							chckbxInsulinoResistente.setSelected(rsAntededentes.getBoolean("InsulinoResistente"));
							textOtrasEnfermedades.setText(rsAntededentes.getString("Otros"));
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{JOptionPane.showMessageDialog(rootPane, "No existen antecedentes  Almacenados");
				}
				
				
				
				
				FrameTabladeAnalisisClinicos frameTablaAnalisis = new FrameTabladeAnalisisClinicos();
				frameTablaAnalisis.textIdPaciente.setText(textIdPaciente.getText());
				frameTablaAnalisis.textNombrePaciente.setText(textNombre.getText());
				
				frameTablaAnalisis.setVisible(true);
				
				
				
			}
		});
		
		JLabel lblHistoriaClinica = new JLabel("Historia Clinica: ");
		
		JLabel lblPaciente = new JLabel("Paciente");
		
		textIdPaciente = new JTextField();
		textIdPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		textIdPaciente.setEditable(false);
		textIdPaciente.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHistoriaClinica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textIdPaciente, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPaciente)
							.addGap(18)
							.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGuardarAntyAnalisisClin, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTablaAnalisis, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHistoriaClinica)
						.addComponent(textIdPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaciente)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTablaAnalisis, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGuardarAntyAnalisisClin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hematocrito");
		lblNewLabel.setBounds(10, 11, 123, 24);
		panel_2.add(lblNewLabel);
		
		textHematocrito = new JTextField();
		textHematocrito.setText("0");
		textHematocrito.setHorizontalAlignment(SwingConstants.CENTER);
		textHematocrito.setBounds(143, 13, 86, 20);
		panel_2.add(textHematocrito);
		textHematocrito.setColumns(10);
		
		textHemoglobina = new JTextField();
		textHemoglobina.setText("0");
		textHemoglobina.setHorizontalAlignment(SwingConstants.CENTER);
		textHemoglobina.setColumns(10);
		textHemoglobina.setBounds(143, 43, 86, 20);
		panel_2.add(textHemoglobina);
		
		JLabel lblHemoglobina = new JLabel("Hemoglobina");
		lblHemoglobina.setBounds(10, 41, 123, 24);
		panel_2.add(lblHemoglobina);
		
		textColesterolTotal = new JTextField();
		textColesterolTotal.setText("0");
		textColesterolTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textColesterolTotal.setColumns(10);
		textColesterolTotal.setBounds(143, 74, 86, 20);
		panel_2.add(textColesterolTotal);
		
		JLabel lblColesteroltotal = new JLabel("Colesterol Total");
		lblColesteroltotal.setBounds(10, 72, 123, 24);
		panel_2.add(lblColesteroltotal);
		
		textColesterolLDL = new JTextField();
		textColesterolLDL.setText("0");
		textColesterolLDL.setHorizontalAlignment(SwingConstants.CENTER);
		textColesterolLDL.setColumns(10);
		textColesterolLDL.setBounds(143, 105, 86, 20);
		panel_2.add(textColesterolLDL);
		
		JLabel lblColesterolldl = new JLabel("Colesterol LDL");
		lblColesterolldl.setBounds(10, 103, 123, 24);
		panel_2.add(lblColesterolldl);
		
		textColesterolHDL = new JTextField();
		textColesterolHDL.setText("0");
		textColesterolHDL.setHorizontalAlignment(SwingConstants.CENTER);
		textColesterolHDL.setColumns(10);
		textColesterolHDL.setBounds(143, 136, 86, 20);
		panel_2.add(textColesterolHDL);
		
		JLabel lblColesterolhdl = new JLabel("Colesterol HDL");
		lblColesterolhdl.setBounds(10, 134, 123, 24);
		panel_2.add(lblColesterolhdl);
		
		textIndiceAterogenico = new JTextField();
		textIndiceAterogenico.setText("0");
		textIndiceAterogenico.setHorizontalAlignment(SwingConstants.CENTER);
		textIndiceAterogenico.setColumns(10);
		textIndiceAterogenico.setBounds(143, 166, 86, 20);
		panel_2.add(textIndiceAterogenico);
		
		JLabel lblIndiceAterognico = new JLabel("Indice Aterog\u00E9nico");
		lblIndiceAterognico.setBounds(10, 164, 123, 24);
		panel_2.add(lblIndiceAterognico);
		
		textGlucemia = new JTextField();
		textGlucemia.setText("0");
		textGlucemia.setHorizontalAlignment(SwingConstants.CENTER);
		textGlucemia.setColumns(10);
		textGlucemia.setBounds(143, 194, 86, 20);
		panel_2.add(textGlucemia);
		
		JLabel lblGlucemia = new JLabel("Glucemia");
		lblGlucemia.setBounds(10, 192, 123, 24);
		panel_2.add(lblGlucemia);
		
		textInsulina = new JTextField();
		textInsulina.setText("0");
		textInsulina.setHorizontalAlignment(SwingConstants.CENTER);
		textInsulina.setColumns(10);
		textInsulina.setBounds(143, 222, 86, 20);
		panel_2.add(textInsulina);
		
		JLabel lblInsulina = new JLabel("Insulina");
		lblInsulina.setBounds(10, 220, 123, 24);
		panel_2.add(lblInsulina);
		
		textIndiceHoma = new JTextField();
		textIndiceHoma.setText("0");
		textIndiceHoma.setHorizontalAlignment(SwingConstants.CENTER);
		textIndiceHoma.setColumns(10);
		textIndiceHoma.setBounds(143, 249, 86, 20);
		panel_2.add(textIndiceHoma);
		
		JLabel lblIndiceHoma = new JLabel("Indice Homa");
		lblIndiceHoma.setBounds(10, 247, 123, 24);
		panel_2.add(lblIndiceHoma);
		
		textUrea = new JTextField();
		textUrea.setText("0");
		textUrea.setHorizontalAlignment(SwingConstants.CENTER);
		textUrea.setColumns(10);
		textUrea.setBounds(143, 277, 86, 20);
		panel_2.add(textUrea);
		
		JLabel lblUrea = new JLabel("Urea");
		lblUrea.setBounds(10, 275, 123, 24);
		panel_2.add(lblUrea);
		
		textCreatinina = new JTextField();
		textCreatinina.setText("0");
		textCreatinina.setHorizontalAlignment(SwingConstants.CENTER);
		textCreatinina.setColumns(10);
		textCreatinina.setBounds(143, 308, 86, 20);
		panel_2.add(textCreatinina);
		
		JLabel lblCreatinina = new JLabel("Creatinina");
		lblCreatinina.setBounds(10, 306, 123, 24);
		panel_2.add(lblCreatinina);
		
		textTSH = new JTextField();
		textTSH.setText("0");
		textTSH.setHorizontalAlignment(SwingConstants.CENTER);
		textTSH.setColumns(10);
		textTSH.setBounds(143, 340, 86, 20);
		panel_2.add(textTSH);
		
		JLabel lblTsh = new JLabel("TSH");
		lblTsh.setBounds(10, 338, 123, 24);
		panel_2.add(lblTsh);
		
		textOtros = new JTextField();
		textOtros.setHorizontalAlignment(SwingConstants.CENTER);
		textOtros.setColumns(10);
		textOtros.setBounds(51, 371, 207, 20);
		panel_2.add(textOtros);
		
		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setBounds(10, 369, 123, 24);
		panel_2.add(lblOtros);
		
		JLabel lblOtros_1 = new JLabel("Otros");
		lblOtros_1.setBounds(16, 167, 46, 14);
		panel_1.add(lblOtros_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 179, 136, 76);
		panel_1.add(scrollPane);
		
		textOtrasEnfermedades = new JTextArea();
		scrollPane.setViewportView(textOtrasEnfermedades);
		

		panel.setLayout(gl_panel);
	}
	
	public void InicioFrame(){
		
		
	};
	
	public void CheckarAnalisis(){
		
		
		
		
	};
	
	public ResultSet BuscarAntecedentes(){
		ResultSet respuesta=null;
		int id=Integer.parseInt(textIdPaciente.getText());
		Conexion con=new Conexion();
		con.BuscarAntecedentes(id);
	return respuesta;
	}
	
	public ResultSet BuscarAnalisisClinicos(){
		ResultSet respuesta=null;
		int id=Integer.parseInt(textIdPaciente.getText());
		Conexion con=new Conexion();
		respuesta=con.BuscaAnalisis(id);
		
	return respuesta;
	}
	
	
	public boolean CheckearCheckBox(int check){
		boolean salida=false;
		
		if(check==1){salida=true;}else{salida=false;}
		
		return salida;
	}
}
