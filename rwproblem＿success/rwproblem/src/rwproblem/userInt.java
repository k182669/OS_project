package rwproblem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.Label;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class userInt extends JFrame {

	ThreadGroup thrGroup = new ThreadGroup("reader");

	private int readNum;
	// private reader r = new reader(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInt frame = new userInt();
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
	public userInt() throws IOException {
		this.readNum = 0;

		ImageIcon ima = new ImageIcon("/Volumes/TOSHIBA EXT/政＿105年上學期/作業系統/rwproblem/back2.jpg");
		getContentPane().setBackground(getContentPane().getBackground());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 900);
		getContentPane().setLayout(null);

		JPanel cp = new JPanel();
		cp.setLayout(null);
		cp.setOpaque(false);

		JLabel jl = new JLabel(ima);
		jl.setBounds(0, 0, 1440, 900);

		JPanel imgp = (JPanel) this.getContentPane();
		imgp.setOpaque(false);
		this.getLayeredPane().add(jl, new Integer(Integer.MIN_VALUE));

		Color c = new Color(0, 0, 255);
		ImageIcon icon = new ImageIcon("/Volumes/TOSHIBA EXT/政＿105年上學期/作業系統/rwproblem/file5.png");

		NewReader[] rwArr = new NewReader[100];
		JButton btnNewButton = new JButton(icon);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(c);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NewReader nr = new NewReader();
				timeArr.threadArr[reader.reader_counter] = nr;
				if (!writer.writerStart || reader.hasWaiting) {
					reader.qr.add(nr);
					System.out.println("waiting reader");
				} else {
					Date s = new Date();
					int ss = s.getSeconds();
					int ms = s.getMinutes();
					timeArr.timeArr[reader.reader_counter] = ss+ms*60;
					timeArr.threadArr[reader.reader_counter].start();
				}
				System.out.println("into the reader thread");
			}
		});

		btnNewButton.setBounds(259, 229, 140, 140);

		getContentPane().add(btnNewButton);

		JButton button = new JButton();
		button.setOpaque(false);
		button.setBackground(c);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer.start = false;
					NewWriter nw = new NewWriter();
					if (!writer.writerStart || reader.reader_counter!=0) {
						writer.q.add(nw);
						System.out.println("has a waiting writer"+writer.q.size());
					} else if(writer.writerStart && reader.reader_counter==0){
						writer.nw = nw;
						writer.writerStart = false;
						System.out.println("into the writer");
						try {
							writer.countTime();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					writer.writerStart = false;
				writer.start = true;
			}
		});
		button.setBounds(47, 229, 140, 140);
		button.setIcon(icon);
		button.getIcon();
		getContentPane().add(button);

		ImageIcon icon2 = new ImageIcon("/Volumes/TOSHIBA EXT/政＿105年上學期/作業系統/rwproblem/data5.jpg");
		JButton button_1 = new JButton(icon2);
		button_1.setOpaque(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					file_window fw = new file_window();
					fw.setVisible(true);
					fw.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(47, 448, 140, 140);
		getContentPane().add(button_1);

		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setBounds(84, 370, 61, 16);
		lblWriter.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblWriter.setForeground(Color.WHITE);
		getContentPane().add(lblWriter);

		JLabel label = new JLabel("Reader");
		label.setFont(new Font("Helvetica", Font.PLAIN, 20));
		label.setForeground(Color.WHITE);
		label.setBounds(303, 370, 65, 16);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("file.txt");
		label_1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(84, 585, 70, 16);
		getContentPane().add(label_1);

		getContentPane().setVisible(true);
	}

}
