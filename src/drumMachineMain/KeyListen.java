package drumMachineMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener{	

	public KeyListen() {} 					//method that 'listens' to input from computer keyboard

	@Override
	public void keyTyped(KeyEvent e) {		// sets action for keyboard button pressed.
		char keyChar = e.getKeyChar();	
		
		if (keyChar == '6') { 									// runs the Click sample in a loop. 			
			UI.playClick("Click.wav");
			System.out.println("Key Press 'CLICK ON'");
		} else if(keyChar == '7'){ 								// Turns of loop of click.wav		
			UI.stopLoop("Click.wav");
			System.out.println("Key Press 'CLICK OFF'");
		} else if(keyChar == '1'){								// Plays the Kick sample 				
			UI.playSound("Kick.wav");
			System.out.println("Key Press 'KICK'");
		}else if(keyChar == '2'){								// Plays the Snare sample  				
			UI.playSound("Snare.wav");
			System.out.println("Key Press 'SNARE'");
		}else if(keyChar == '3'){								// Plays the Hihat sample  				
			UI.playSound("Hats.wav");
			System.out.println("Key Press 'HIHAT'");
		}else if(keyChar == '4'){								// Plays the Open Hihat sample  				
			UI.playSound("HatsOpen.wav");
			System.out.println("Key Press 'HIHAT OPEN'");
		}else if(keyChar == '5'){								// Plays the Cymbal sample  				
			UI.playSound("Cymb.wav");
			System.out.println("Key Press 'CYMBAL'");
		}										
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {		
		char keyChar = e.getKeyChar();
		if (keyChar == '3') { 									// runs the Click sample in a loop. 			
			UI.playLoop("Hats.wav");			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {	
		char keyChar = e.getKeyChar();
		if (keyChar == '3') { 									// runs the Click sample in a loop. 			
			UI.stopLoop("Hats.wav");			
		}
	}
}
