package rwproblem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class file_window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					file_window frame = new file_window();
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
	public file_window() throws IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		FileReader fr = new FileReader("/Volumes/TOSHIBA EXT/政＿105年上學期/作業系統/rwproblem/rwFile.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			textArea.append(br.readLine()+"\n");
		}
		textArea.setEditable(false);
		
		JLabel lblRwfiletxt = new JLabel("this is the rwfile.txt");
		contentPane.add(lblRwfiletxt, BorderLayout.NORTH);
		lblRwfiletxt.setFont(new Font("PilGi",Font.BOLD,32));
		fr.close();
	}

}
