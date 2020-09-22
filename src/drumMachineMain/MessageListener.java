package drumMachineMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MessageListener implements ActionListener {
	
	
	private String sampleName = null; // string that is the name of the audio sample being called. 

	public MessageListener(JButton hit, String sampleName) { //Method called from UI class containing the button pressed and a string representing the audio sample to be played
		this.sampleName = sampleName;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (sampleName == "Click.wav") { 		// runs the click.wav in a loop. 
			System.out.println("Button click " + sampleName);
			UI.playLoop(sampleName);
		} else if(sampleName == "ClickStop"){ 	// Turns of loop of click.wav
			System.out.println("Button click " + sampleName);
			UI.stopLoop(sampleName);
		} else {								// Plays the sample represented by the button pressed. 	
			System.out.println("Button click " + sampleName);
			UI.playSound(sampleName);
		}
	}
	
	
	
	
	
	
}