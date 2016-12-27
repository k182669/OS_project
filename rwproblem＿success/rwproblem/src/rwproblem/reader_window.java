package rwproblem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class reader_window extends JFrame {

	public Date s = new Date();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reader_window frame = new reader_window();
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
	public reader_window() throws IOException {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TextArea textArea = new TextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		FileReader fr = new FileReader("/Volumes/TOSHIBA EXT/政＿105年上學期/作業系統/rwproblem/rwFile.txt");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			textArea.append(br.readLine() + "\n");
		}
		textArea.setEditable(false);
		
		textField = new JTextField("This is the reader");
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		textField.setFont(new Font("PilGi", Font.BOLD, 32));
		textField.setEditable(false);
		fr.close();
	}

}
