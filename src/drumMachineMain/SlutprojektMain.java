package drumMachineMain;

import javax.swing.SwingUtilities;

public class SlutprojektMain {

	public static void main(String[] args) {
		// playing welcome sound when starting the application. 
		UI.playSound("Cymb.wav");
		UI.playSound("Snare.wav");
		UI.playSound("Kick.wav");
		UI.playSound("Hats.wav");
		UI.playSound("HatsOpen.wav");
	
		UI ui = new UI();		// Loads Class UI, user interface. 
		SwingUtilities.invokeLater(ui);
		
	}

}
