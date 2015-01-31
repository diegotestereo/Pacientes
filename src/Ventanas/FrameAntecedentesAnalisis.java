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

import javax.swing.JScrollPane;

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
	private JTextField textOtrasEnfermedades;

	
	public FrameAntecedentesAnalisis() {
		setTitle("Antecedentes y Analisis Clinicos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Antecedentes");
		panel.setBorder(new LineBorder(new Color(240, 230, 140)));
		panel.setBounds(10, 11, 451, 430);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(240, 230, 140));
		panel_1.setBorder(new LineBorder(new Color(240, 230, 140)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(240, 230, 140)));
		panel_2.setForeground(new Color(240, 230, 140));
		panel_1.setLayout(null);
		
		final JCheckBox chckbxDiabetes = new JCheckBox("Diabetes");
		chckbxDiabetes.setBounds(6, 7, 140, 23);
		panel_1.add(chckbxDiabetes);
		
		final JCheckBox chckbxEnfCardio = new JCheckBox("Enf. Cardiovascular");
		chckbxEnfCardio.setBounds(6, 33, 140, 23);
		panel_1.add(chckbxEnfCardio);
		
		final JCheckBox chckbxColesterol = new JCheckBox("Colesterol");
		chckbxColesterol.setBounds(6, 59, 97, 23);
		panel_1.add(chckbxColesterol);
		
		final JCheckBox chckbxInsulinoResistente = new JCheckBox("Insulino Resistente");
		chckbxInsulinoResistente.setBounds(6, 85, 140, 23);
		panel_1.add(chckbxInsulinoResistente);
		
		final JCheckBox chckbxHipotiroidismo = new JCheckBox("Hipotiroidismo");
		chckbxHipotiroidismo.setBounds(6, 111, 140, 23);
		panel_1.add(chckbxHipotiroidismo);
		
		final JCheckBox chckbxHipertiroidismo = new JCheckBox("Hipertiroidismo");
		chckbxHipertiroidismo.setBounds(6, 137, 140, 23);
		panel_1.add(chckbxHipertiroidismo);
		
		JButton btnGuardarAntyAnalisisClin = new JButton("Guardar");
		btnGuardarAntyAnalisisClin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				boolean diabetes=chckbxDiabetes.isSelected();
				boolean enfcard=chckbxDiabetes.isSelected();
				boolean colest=chckbxDiabetes.isSelected();
				boolean insulino=chckbxDiabetes.isSelected();
				boolean hipo=chckbxDiabetes.isSelected();
				boolean hiper=chckbxDiabetes.isSelected();
				String otros=textOtrasEnfermedades.getText();
				
				System.out.println(" "+diabetes+" "+enfcard+" "+colest+" "+insulino+" "+hipo+" "+hiper+" "+otros);
			//	if(ControlarFormularioLleno()){
				
				Conexion con= new Conexion();
					con.InsertarAntecedentes(1,diabetes,enfcard,colest,insulino,hipo,hiper,otros);
					JOptionPane.showMessageDialog(rootPane, "Analisis y Antecedentes Ingresados");
								
			//	}else{
			//		JOptionPane.showMessageDialog(rootPane, "Ingrese Los analisis antes de Guardar");
					
			//	}
				
				
				
			}
		});
		
		
		
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnTablaAnalisis = new JButton("Ver Tabla");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGuardarAntyAnalisisClin, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTablaAnalisis, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTablaAnalisis, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGuardarAntyAnalisisClin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hematocrito");
		lblNewLabel.setBounds(10, 11, 123, 24);
		panel_2.add(lblNewLabel);
		
		textHematocrito = new JTextField();
		textHematocrito.setBounds(143, 13, 86, 20);
		panel_2.add(textHematocrito);
		textHematocrito.setColumns(10);
		
		textHemoglobina = new JTextField();
		textHemoglobina.setColumns(10);
		textHemoglobina.setBounds(143, 43, 86, 20);
		panel_2.add(textHemoglobina);
		
		JLabel lblHemoglobina = new JLabel("Hemoglobina");
		lblHemoglobina.setBounds(10, 41, 123, 24);
		panel_2.add(lblHemoglobina);
		
		textColesterolTotal = new JTextField();
		textColesterolTotal.setColumns(10);
		textColesterolTotal.setBounds(143, 74, 86, 20);
		panel_2.add(textColesterolTotal);
		
		JLabel lblColesteroltotal = new JLabel("Colesterol Total");
		lblColesteroltotal.setBounds(10, 72, 123, 24);
		panel_2.add(lblColesteroltotal);
		
		textColesterolLDL = new JTextField();
		textColesterolLDL.setColumns(10);
		textColesterolLDL.setBounds(143, 105, 86, 20);
		panel_2.add(textColesterolLDL);
		
		JLabel lblColesterolldl = new JLabel("Colesterol LDL");
		lblColesterolldl.setBounds(10, 103, 123, 24);
		panel_2.add(lblColesterolldl);
		
		textColesterolHDL = new JTextField();
		textColesterolHDL.setColumns(10);
		textColesterolHDL.setBounds(143, 136, 86, 20);
		panel_2.add(textColesterolHDL);
		
		JLabel lblColesterolhdl = new JLabel("Colesterol HDL");
		lblColesterolhdl.setBounds(10, 134, 123, 24);
		panel_2.add(lblColesterolhdl);
		
		textIndiceAterogenico = new JTextField();
		textIndiceAterogenico.setColumns(10);
		textIndiceAterogenico.setBounds(143, 166, 86, 20);
		panel_2.add(textIndiceAterogenico);
		
		JLabel lblIndiceAterognico = new JLabel("Indice Aterog\u00E9nico");
		lblIndiceAterognico.setBounds(10, 164, 123, 24);
		panel_2.add(lblIndiceAterognico);
		
		textGlucemia = new JTextField();
		textGlucemia.setColumns(10);
		textGlucemia.setBounds(143, 194, 86, 20);
		panel_2.add(textGlucemia);
		
		JLabel lblGlucemia = new JLabel("Glucemia");
		lblGlucemia.setBounds(10, 192, 123, 24);
		panel_2.add(lblGlucemia);
		
		textInsulina = new JTextField();
		textInsulina.setColumns(10);
		textInsulina.setBounds(143, 222, 86, 20);
		panel_2.add(textInsulina);
		
		JLabel lblInsulina = new JLabel("Insulina");
		lblInsulina.setBounds(10, 220, 123, 24);
		panel_2.add(lblInsulina);
		
		textIndiceHoma = new JTextField();
		textIndiceHoma.setColumns(10);
		textIndiceHoma.setBounds(143, 249, 86, 20);
		panel_2.add(textIndiceHoma);
		
		JLabel lblIndiceHoma = new JLabel("Indice Homa");
		lblIndiceHoma.setBounds(10, 247, 123, 24);
		panel_2.add(lblIndiceHoma);
		
		textUrea = new JTextField();
		textUrea.setColumns(10);
		textUrea.setBounds(143, 277, 86, 20);
		panel_2.add(textUrea);
		
		JLabel lblUrea = new JLabel("Urea");
		lblUrea.setBounds(10, 275, 123, 24);
		panel_2.add(lblUrea);
		
		textCreatinina = new JTextField();
		textCreatinina.setColumns(10);
		textCreatinina.setBounds(143, 308, 86, 20);
		panel_2.add(textCreatinina);
		
		JLabel lblCreatinina = new JLabel("Creatinina");
		lblCreatinina.setBounds(10, 306, 123, 24);
		panel_2.add(lblCreatinina);
		
		textTSH = new JTextField();
		textTSH.setColumns(10);
		textTSH.setBounds(143, 340, 86, 20);
		panel_2.add(textTSH);
		
		JLabel lblTsh = new JLabel("TSH");
		lblTsh.setBounds(10, 338, 123, 24);
		panel_2.add(lblTsh);
		
		textOtros = new JTextField();
		textOtros.setColumns(10);
		textOtros.setBounds(143, 371, 86, 20);
		panel_2.add(textOtros);
		
		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setBounds(10, 369, 123, 24);
		panel_2.add(lblOtros);
		
		JLabel lblOtros_1 = new JLabel("Otros");
		lblOtros_1.setBounds(46, 167, 46, 14);
		panel_1.add(lblOtros_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 179, 136, 76);
		panel_1.add(scrollPane);
		
		textOtrasEnfermedades = new JTextField();
		scrollPane.setViewportView(textOtrasEnfermedades);
		textOtrasEnfermedades.setColumns(10);
		

		panel.setLayout(gl_panel);
	}
	
	public boolean ControlarFormularioLleno(){
		boolean lleno =textColesterolHDL.getText().isEmpty();
		lleno |=textColesterolLDL.getText().isEmpty();
		lleno |=textColesterolTotal.getText().isEmpty();
		lleno |=textCreatinina.getText().isEmpty();
		lleno |=textGlucemia.getText().isEmpty();
		lleno |=textHematocrito.getText().isEmpty();
		lleno |=textHemoglobina.getText().isEmpty();
		lleno |=textIndiceAterogenico.getText().isEmpty();
		lleno |=textIndiceHoma.getText().isEmpty();
		lleno |=textInsulina.getText().isEmpty();
		lleno |=textOtros.getText().isEmpty();
	return  !lleno;
	}
}
