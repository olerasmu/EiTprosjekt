package EasyWasy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controller extends JFrame implements ActionListener {
	
	private TrafficLight lk;
	private javax.swing.Timer timer;
	private JButton need1;
	private JButton need2;
	private boolean whileRed;
//	private boolean noNeeds;
//	private boolean needTime;
//	private boolean needSound;
	
	public Controller() throws InterruptedException{
		super("Controller");
		
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
//		needTime = false;
//		needSound = false;
//		noNeeds = true;
		
		operate();
		
	}
	
	public void operate() throws InterruptedException{
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Dette er hva som skjer: " + e.getSource());
		System.out.println(lk.isRed);
		/*
		 * Adds extra time to the green light. Not ideal solution, because the timer is simply restarted without firing 
		 * action event. 
		 */
		if(e.getSource() == need1 && !lk.isRed){
			timer.restart();
		}
		else if(e.getSource() == need1 && lk.isRed){
			whileRed = true;
		}
		
		if(e.getSource() == timer && whileRed == false){
			if(lk.isRed){
				timer.setDelay(6000);
				lk.setSignalGreen();
			}
			else if (!lk.isRed) {
				timer.setDelay(2000);
				lk.setSignalRed();
				System.out.println("Setter timer til 6000");
			}
		}
		else if(e.getSource() == timer && whileRed == true){
		
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Controller cont = new Controller();
		cont.setVisible(true);
	}

}
