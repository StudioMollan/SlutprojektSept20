package drumMachineMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener{
	

	public KeyListen() {} 					//method that 'listens' to input from computer keyboard

	@Override
	public void keyTyped(KeyEvent e) {		// sets action for keyboard button pressed.
		char keyChar = e.getKeyChar();	
		
		if (keyChar == '6') { 									// runs the Click sample in a loop. 			
			UI.playLoop("Click.wav");
		} else if(keyChar == '7'){ 								// Turns of loop of click.wav		
			UI.stopLoop("Kick.wav");
		} else if(keyChar == '1'){								// Plays the Kick sample 				
			UI.playSound("Kick.wav");
		}else if(keyChar == '2'){								// Plays the Snare sample  				
			UI.playSound("Snare.wav");
		}else if(keyChar == '3'){								// Plays the Hihat sample  				
			UI.playSound("Hats.wav");
		}else if(keyChar == '4'){								// Plays the Open Hihat sample  				
			UI.playSound("HatsOpen.wav");
		}else if(keyChar == '5'){								// Plays the Cymbal sample  				
			UI.playSound("Cymb.wav");
		}										
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
