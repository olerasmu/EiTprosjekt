package EasyWasy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Controller extends JFrame implements ActionListener {

	private TrafficLight lk;
	private Sound sound;
	private javax.swing.Timer timer;
	private JButton need1;
	private JButton need2;
	private boolean whileRed;
	//	private boolean noNeeds;
	//	private boolean needTime;
	//	private boolean needSound;
	// open the sound file as a Java input stream
	
	String gongFile = "C:\\Users\\Ole\\Downloads\\car-beeping-1.wav";
	InputStream in = new FileInputStream(gongFile);
	

	public Controller() throws InterruptedException, IOException{
		super("Controller");
		sound = new Sound();
		timer = new javax.swing.Timer(6000, this);
		getContentPane().setLayout(new GridLayout(1,2));
		JPanel panel = new JPanel(new GridLayout(1,2));
		need1 = new JButton("Need 1");
		need2 = new JButton("Need 2");
		need1.addActionListener(this);
		need2.addActionListener(this);
		panel.add(need1);
		panel.add(need2);
		getContentPane().add(panel);
		pack();

		lk = new TrafficLight();
		lk.setVisible(true);
		whileRed = false;
		operate();

	}

	public void operate() throws InterruptedException{
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(lk.isRed);
		/*
		 * Adds extra time to the green light. Not ideal solution, because the timer is simply restarted without firing 
		 * action event. 
		 */
		
		
		if(e.getSource() == need1 && !lk.isRed){
			timer.restart();
			System.out.println("Need is registered while light was green, 6 extra seconds is given");
		}
		else if(e.getSource() == need1 && lk.isRed){
			whileRed = true;
			System.out.println("Need was registered while light was red, 6 extra seconds is given with the next green light");
		}

		if(e.getSource() == timer && whileRed == false){
			if(lk.isRed){
				timer.setDelay(6000);
				lk.setSignalGreen();
				try {
					sound.fireSound();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			else if (!lk.isRed) {
				timer.setDelay(2000);
				lk.setSignalRed();
				
			}
		}
		else if(e.getSource() == timer && whileRed == true){
			if (lk.isRed) {
				timer.setDelay(6000);
				whileRed = false;
				System.out.println("6 extra seconds is given");
			}
		}

	}
	
	public TrafficLight getTrafficLight(){
		return this.lk;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Controller cont = new Controller();
		cont.setVisible(true);
	}

}
