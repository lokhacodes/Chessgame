

package com.chess.gui;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

// *************************************************
public class Stopwatch extends JPanel implements ActionListener{
	
	//JLabel counterLabel;
        private static final Dimension CHAT_PANEL_DIMENSION = new Dimension(600, 80);
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds =0;
	int minutes =0;
	int hours =0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime=elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
		
	});
	
	
	Stopwatch(){
		super(new BorderLayout());
		this.timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		this.timeLabel.setBounds(100,100,100,100);
		this.timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		this.timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		this.timeLabel.setOpaque(true);
		this.timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		this.startButton.setBounds(20,20,100,50);
		this.startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		this.startButton.setFocusable(false);
		this.startButton.addActionListener(this);
		
		this.resetButton.setBounds(660,20,100,50);
		this.resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		this.resetButton.setFocusable(false);
		this.resetButton.addActionListener(this);
		        setPreferredSize(CHAT_PANEL_DIMENSION);
        validate();
		add(this.startButton);
		add(this.resetButton);
		add(this.timeLabel);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			
			if(started==false) {
				started=true;
				startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				startButton.setText("START");
				stop();
			}
			
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("START");
			reset();
		}
		
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime=0;
		seconds =0;
		minutes=0;
		hours=0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}

}// *************************************************

































