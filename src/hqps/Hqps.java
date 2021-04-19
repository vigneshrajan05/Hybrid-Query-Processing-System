package hqps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

import hqps.parser;

public class Hqps {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	LinkedHashMap<String,String> ValueMap = new LinkedHashMap<String,String>();
	String attribute="";
	String condition="";
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hqps window = new Hqps();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hqps() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 850, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hybrid Query Processing System");
		lblNewLabel.setBounds(new Rectangle(50, 10, 400, 200));
		lblNewLabel.setBounds(188, 26, 471, 42);
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tables in MySQL:\r\n\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1.setBounds(25, 64, 138, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(78, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Staff\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(347, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Treatment History");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(562, 98, 140, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(403, 444, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 120, 80, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(188, 146, 80, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(188, 174, 80, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(422, 120, 67, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(422, 146, 67, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(635, 120, 67, 20);
		frame.getContentPane().add(textField_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(635, 146, 67, 20);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(188, 254, 67, 20);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(188, 280, 67, 20);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(188, 306, 67, 20);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(188, 332, 67, 20);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(188, 359, 67, 20);
		frame.getContentPane().add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(422, 254, 67, 20);
		frame.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(422, 280, 67, 20);
		frame.getContentPane().add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(725, 254, 77, 20);
		frame.getContentPane().add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(725, 280, 77, 20);
		frame.getContentPane().add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(725, 306, 77, 20);
		frame.getContentPane().add(textField_20);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("name");
		chckbxNewCheckBox.setToolTipText("name");
		textField_3.setVisible(false);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
                    textField_3.setVisible(true);
                    textField_3.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                    textField_3.setVisible(false);
                    textField_3.setText("");
                }
			}
		});
		chckbxNewCheckBox.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox.setBounds(57, 118, 84, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("gender");
		textField_4.setVisible(false);
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_4.setVisible(true);
					textField_4.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_4.setVisible(false);
                	textField_4.setText("");
                }
			}
		});
		chckbxNewCheckBox_1.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_1.setBounds(57, 144, 84, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("specialization");
		textField_5.setVisible(false);
		chckbxNewCheckBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_5.setVisible(true);
					textField_5.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_5.setVisible(false);
                	textField_5.setText("");
                }
			}
		});
		chckbxNewCheckBox_2.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_2.setBounds(57, 172, 106, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("s_id");
		textField_6.setVisible(false);
		chckbxNewCheckBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_6.setVisible(true);
					textField_6.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_6.setVisible(false);
                	textField_6.setText("");
                }
			}
		});
		chckbxNewCheckBox_3.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_3.setBounds(322, 119, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("staff_name");
		textField_7.setVisible(false);
		chckbxNewCheckBox_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_7.setVisible(true);
					textField_7.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_7.setVisible(false);
                	textField_7.setText("");
                }
			}
		});
		chckbxNewCheckBox_4.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_4.setBounds(322, 145, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("pid");
		textField_8.setVisible(false);
		chckbxNewCheckBox_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_8.setVisible(true);
					textField_8.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_8.setVisible(false);
                	textField_8.setText("");
                }
			}
		});
		chckbxNewCheckBox_5.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_5.setBounds(562, 119, 67, 23);
		frame.getContentPane().add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("sid");
		textField_10.setVisible(false);
		chckbxNewCheckBox_7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_10.setVisible(true);
					textField_10.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_10.setVisible(false);
                	textField_10.setText("");
                }
			}
		});
		chckbxNewCheckBox_7.setBackground(new Color(240, 230, 140));
		chckbxNewCheckBox_7.setBounds(562, 145, 72, 23);
		frame.getContentPane().add(chckbxNewCheckBox_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Collections in MongoDB:\r\n");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(25, 205, 202, 23);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		
		JCheckBox chckbxDid_1_1 = new JCheckBox("age");
		textField_11.setVisible(false);
		chckbxDid_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_11.setVisible(true);
					textField_11.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_11.setVisible(false);
                	textField_11.setText("");
                }
			}
		});
		
		JCheckBox chckbxDid_1 = new JCheckBox("pname");
		chckbxDid_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_15.setVisible(true);
					textField_15.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_15.setVisible(false);
                	textField_15.setText("");
                }
			}
		});
		chckbxDid_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1.setBounds(57, 358, 97, 23);
		frame.getContentPane().add(chckbxDid_1);
		chckbxDid_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1.setBounds(57, 253, 97, 23);
		frame.getContentPane().add(chckbxDid_1_1);
		
		JCheckBox chckbxDid_1_1_1 = new JCheckBox("bloodgroup");
		textField_12.setVisible(false);
		chckbxDid_1_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_12.setVisible(true);
					textField_12.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_12.setVisible(false);
                	textField_12.setText("");
                }
			}
		});
		chckbxDid_1_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_1.setBounds(57, 279, 119, 23);
		frame.getContentPane().add(chckbxDid_1_1_1);
		
		JCheckBox chckbxDid_1_1_1_1 = new JCheckBox("phoneno");
		textField_13.setVisible(false);
		chckbxDid_1_1_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_13.setVisible(true);
					textField_13.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_13.setVisible(false);
                	textField_13.setText("");
                }
			}
		});
		chckbxDid_1_1_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_1_1.setBounds(57, 305, 119, 23);
		frame.getContentPane().add(chckbxDid_1_1_1_1);
		
		JCheckBox chckbxDid_1_1_1_1_1 = new JCheckBox("roomno");
		textField_14.setVisible(false);
		chckbxDid_1_1_1_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_14.setVisible(true);
					textField_14.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_14.setVisible(false);
                	textField_14.setText("");
                }
			}
		});
		chckbxDid_1_1_1_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_1_1_1.setBounds(57, 331, 97, 23);
		frame.getContentPane().add(chckbxDid_1_1_1_1_1);
		textField_15.setVisible(false);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Patient");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(78, 232, 63, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Medical History");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(347, 232, 108, 14);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Treatment");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(605, 232, 97, 14);
		frame.getContentPane().add(lblNewLabel_2_1_2);
		
		JCheckBox chckbxDid_1_1_2 = new JCheckBox("disease");
		textField_16.setVisible(false);
		chckbxDid_1_1_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_16.setVisible(true);
					textField_16.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_16.setVisible(false);
                	textField_16.setText("");
                }
			}
		});
		chckbxDid_1_1_2.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_2.setBounds(322, 253, 97, 23);
		frame.getContentPane().add(chckbxDid_1_1_2);
		
		JCheckBox chckbxDid_1_1_2_1 = new JCheckBox("status");
		textField_17.setVisible(false);
		chckbxDid_1_1_2_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_17.setVisible(true);
					textField_17.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_17.setVisible(false);
                	textField_17.setText("");
                }
			}
		});
		chckbxDid_1_1_2_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_2_1.setBounds(322, 279, 97, 23);
		frame.getContentPane().add(chckbxDid_1_1_2_1);
		
		JCheckBox chckbxDid_1_1_2_1_1 = new JCheckBox("admission_date");
		textField_18.setVisible(false);
		chckbxDid_1_1_2_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_18.setVisible(true);
					textField_18.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_18.setVisible(false);
                	textField_18.setText("");
                }
			}
		});
		chckbxDid_1_1_2_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_2_1_1.setBounds(562, 253, 157, 23);
		frame.getContentPane().add(chckbxDid_1_1_2_1_1);
		
		JCheckBox chckbxDid_1_1_2_1_1_1 = new JCheckBox("discharged");
		textField_19.setVisible(false);
		chckbxDid_1_1_2_1_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_19.setVisible(true);
					textField_19.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_19.setVisible(false);
                	textField_19.setText("");
                }
			}
		});
		chckbxDid_1_1_2_1_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_2_1_1_1.setBounds(562, 279, 97, 23);
		frame.getContentPane().add(chckbxDid_1_1_2_1_1_1);
		
		JCheckBox chckbxDid_1_1_2_1_1_1_1 = new JCheckBox("treatmentname");
		textField_20.setVisible(false);
		chckbxDid_1_1_2_1_1_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_20.setVisible(true);
					textField_20.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_20.setVisible(false);
                	textField_20.setText("");
                }
			}
		});
		chckbxDid_1_1_2_1_1_1_1.setBackground(new Color(240, 230, 140));
		chckbxDid_1_1_2_1_1_1_1.setBounds(562, 305, 146, 23);
		frame.getContentPane().add(chckbxDid_1_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hybrid Query:\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(25, 414, 202, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(121, 444, 80, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxDid_1_2 = new JCheckBox("d_id");
		JCheckBox chckbxDid_1_3 = new JCheckBox("p_id");
		textField.setVisible(false);
		chckbxDid_1_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField.setVisible(true);
					textField.setText("");
					chckbxDid_1_3.setEnabled(false);
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField.setVisible(false);
                	textField.setText("");
                	chckbxDid_1_3.setEnabled(true);
                }
			}
		});
		chckbxDid_1_2.setBackground(new Color(240, 230, 140));
		chckbxDid_1_2.setBounds(25, 443, 97, 23);
		frame.getContentPane().add(chckbxDid_1_2);
		
		
		textField_1.setVisible(false);
		chckbxDid_1_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_1.setVisible(true);
					textField_1.setText("");
					chckbxDid_1_2.setEnabled(false);
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_1.setVisible(false);
                	textField_1.setText("");
                	chckbxDid_1_2.setEnabled(true);
                }
			}
		});
		chckbxDid_1_3.setBackground(new Color(240, 230, 140));
		chckbxDid_1_3.setBounds(304, 443, 97, 23);
		frame.getContentPane().add(chckbxDid_1_3);
		

		textField_2 = new JTextField();
		textField_2.setBounds(422, 306, 67, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JCheckBox chckbxDid_1_4 = new JCheckBox("BP");
		textField_2.setVisible(false);
		chckbxDid_1_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					textField_2.setVisible(true);
					textField_2.setText("");
                    
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	textField_2.setVisible(false);
                	textField_2.setText("");
                }
			}
		});
		chckbxDid_1_4.setBackground(new Color(240, 230, 140));
		chckbxDid_1_4.setBounds(322, 305, 97, 23);
		frame.getContentPane().add(chckbxDid_1_4);
		
		JButton btnNewButton = new JButton("Fire Query!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(chckbxNewCheckBox.isSelected()) {
					attribute=chckbxNewCheckBox.getText();
					condition=textField_3.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					attribute=chckbxNewCheckBox_1.getText();
					condition=textField_4.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					attribute=chckbxNewCheckBox_2.getText();
					condition=textField_5.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxNewCheckBox_3.isSelected()) {
					attribute=chckbxNewCheckBox_3.getText();
					condition=textField_6.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxNewCheckBox_4.isSelected()) {
					attribute=chckbxNewCheckBox_4.getText();
					condition=textField_7.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxNewCheckBox_5.isSelected()) {
					attribute=chckbxNewCheckBox_5.getText();
					condition=textField_8.getText();
					ValueMap.put(attribute, condition);
				}
			
				if(chckbxNewCheckBox_7.isSelected()) {
					attribute=chckbxNewCheckBox_7.getText();
					condition=textField_10.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1.isSelected()) {
					attribute=chckbxDid_1.getText();
					condition=textField_15.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1.isSelected()) {
					attribute=chckbxDid_1_1.getText();
					condition=textField_11.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_1.isSelected()) {
					attribute=chckbxDid_1_1_1.getText();
					condition=textField_12.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_1_1.isSelected()) {
					attribute=chckbxDid_1_1_1_1.getText();
					condition=textField_13.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_1_1_1.isSelected()) {
					attribute=chckbxDid_1_1_1_1_1.getText();
					condition=textField_14.getText();
					ValueMap.put(attribute, condition);
				}
				
				if(chckbxDid_1_1_2.isSelected()) {
					attribute=chckbxDid_1_1_2.getText();
					condition=textField_16.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_2_1.isSelected()) {
					attribute=chckbxDid_1_1_2_1.getText();
					condition=textField_17.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_2_1_1.isSelected()) {
					attribute=chckbxDid_1_1_2_1_1.getText();
					condition=textField_18.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_2_1_1_1.isSelected()) {
					attribute=chckbxDid_1_1_2_1_1_1.getText();
					condition=textField_19.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_1_2_1_1_1_1.isSelected()) {
					attribute=chckbxDid_1_1_2_1_1_1_1.getText();
					condition=textField_20.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_2.isSelected()) {
					attribute=chckbxDid_1_2.getText();
					condition=textField.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_3.isSelected()) {
					attribute=chckbxDid_1_3.getText();
					condition=textField_1.getText();
					ValueMap.put(attribute, condition);
				}
				if(chckbxDid_1_4.isSelected()) {
					attribute=chckbxDid_1_4.getText();
					condition=textField_2.getText();
					ValueMap.put(attribute, condition);
				}
				System.out.println(ValueMap);
				parser.parse(ValueMap);
				ValueMap.clear();
			
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(694, 443, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
			
}
}
