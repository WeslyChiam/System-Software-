package sync;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Final {

	private JFrame frame;
	static JLabel label, label_1; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final window = new Final();
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
	public Final() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 201);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clockWithoutSync = "2400";
				String clockWithSync = "0000"; 
				label.setText(clockWithoutSync);
				label_1.setText(clockWithSync);
			}
		});
		btnStart.setBounds(67, 102, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JLabel lblClock = new JLabel("Clock Without Sync");
		lblClock.setBounds(10, 5, 120, 14);
		frame.getContentPane().add(lblClock);
		
		JLabel lblClockWithSync = new JLabel("Clock With Sync");
		lblClockWithSync.setBounds(10, 60, 120, 14);
		frame.getContentPane().add(lblClockWithSync);
		
		label = new JLabel("Please Press Start");
		label.setBounds(141, 5, 110, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Please Press Start");
		label_1.setBounds(141, 60, 110, 14);
		frame.getContentPane().add(label_1);
	}

}
