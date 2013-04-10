package EasyWasy;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TrafficLight extends JFrame {

	Signal green = new Signal(Color.green);
	Signal red = new Signal(Color.red);
	Controller cont;
	boolean isRed;

	public TrafficLight(){
		super("Traffic Light");
		getContentPane().setLayout(new GridLayout(2,1));
		green.turnOn(false);
		red.turnOn(true);
		isRed = true;

		JPanel p1 = new JPanel(new GridLayout(2,1));
		p1.add(red);
		p1.add(green);
		getContentPane().add(p1);

		pack();
	}


	public void setSignalRed(){
		red.turnOn(true);
		green.turnOn(false);
		isRed = true;
	}

	public void setSignalGreen(){
		red.turnOn(false);
		green.turnOn(true);
		isRed = false;
	}

	public Signal getRedSignal(){
		return this.red;
	}

	public Signal getGreenSignal(){
		return this.green;
	}
	
	public boolean getSignal(){
		return isRed;
	}
}  

class Signal extends JPanel{

	Color on;
	int radius = 40;
	int border = 10;
	boolean change;

	Signal(Color color){
		on = color;
		change = true;
	}

	public void turnOn(boolean a){
		change = a;
		repaint();        
	}

	public Dimension getPreferredSize(){
		int size = (radius+border)*2;
		return new Dimension( size, size );
	}

	public void paintComponent(Graphics g){
		g.setColor( Color.black );
		g.fillRect(0,0,getWidth(),getHeight());

		if (change){
			g.setColor( on );
		} else {
			g.setColor( on.darker().darker().darker() );
		}
		g.fillOval( border,border,2*radius,2*radius );
	}
	
	public Color getStatus(){
		return this.on;
	}
}
