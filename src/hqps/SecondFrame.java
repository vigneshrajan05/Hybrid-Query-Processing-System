package hqps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class SecondFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame frame = new SecondFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 1000, 600);
		contentPane.setBackground(new Color(240, 230, 140));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.BOLD, 13));
		textArea.setBounds(0, 0, 1000,600);
		contentPane.add(textArea);
//		TextAreaLogProgram t=new TextAreaLogProgram(textArea);
	}
	public SecondFrame(String s1,String s2) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 1000, 600);
		contentPane.setBackground(new Color(240, 230, 140));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 1000,600);
		contentPane.add(textArea);
		String s=s1+"\n"+s2;
		textArea.setText(s);
//		TextAreaLogProgram t=new TextAreaLogProgram(textArea);
	}
	public SecondFrame(String s1) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 1000, 600);
		contentPane.setBackground(new Color(240, 230, 140));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 1000,600);
		contentPane.add(textArea);
		textArea.setText(s1);
//		TextAreaLogProgram t=new TextAreaLogProgram(textArea);
	}


}
