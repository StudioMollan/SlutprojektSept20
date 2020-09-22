package drumMachineMain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UI implements Runnable, ActionListener {

	private JFrame frame;

	public UI() {
	}

	@Override
	public void run() { // Sets the main window of the application
		frame = new JFrame("DrumMachine Player Window");
		frame.setPreferredSize(new Dimension(800, 450));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createButtons(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	private void createButtons(Container container) {
		// Loads all buttons displayed on the applications main window.
		GridLayout layout = new GridLayout(4, 3);
		container.setLayout(layout);
		JButton jButtonKick = new JButton("KICK");
		JButton jButtonSnare = new JButton("SNARE");
		JButton jButtonHihat = new JButton("HIHAT");
		JButton jButtonHihatOpen = new JButton("OPEN HIHAT");
		JButton jButtonCymbal = new JButton("CYMBAL");
		JButton jButtonClickON = new JButton("CLICK ON");
		JButton jButtonClickOFF = new JButton("CLICK OFF");
		// ArrayList containing all buttons. Ordered as intended by the programmer.
		ArrayList<JButton> jButtonList = new ArrayList<JButton>();
		jButtonList.add(jButtonKick);
		jButtonList.add(jButtonHihat);
		jButtonList.add(jButtonSnare);
		jButtonList.add(jButtonHihatOpen);
		jButtonList.add(jButtonCymbal);
		jButtonList.add(jButtonClickON);
		jButtonList.add(jButtonClickOFF);

		// Loads all buttons into method MessageListener and adds an actionListener
		// object.
		MessageListener kickPlayer = new MessageListener(jButtonKick, "Kick.wav");
		jButtonKick.addActionListener(kickPlayer);
		MessageListener SnarePlayer = new MessageListener(jButtonSnare, "Snare.wav");
		jButtonSnare.addActionListener(SnarePlayer);
		MessageListener HihatPlayer = new MessageListener(jButtonHihat, "Hats.wav");
		jButtonHihat.addActionListener(HihatPlayer);
		MessageListener HihatOpenPlayer = new MessageListener(jButtonHihatOpen, "HatsOpen.wav");
		jButtonHihatOpen.addActionListener(HihatOpenPlayer);
		MessageListener CymbalPlayer = new MessageListener(jButtonCymbal, "Cymb.wav");
		jButtonCymbal.addActionListener(CymbalPlayer);
		MessageListener ClickPlayerON = new MessageListener(jButtonClickON, "Click.wav");
		jButtonClickON.addActionListener(ClickPlayerON);
		MessageListener ClickPlayerOFF = new MessageListener(jButtonClickOFF, "ClickStop");
		jButtonClickOFF.addActionListener(ClickPlayerOFF);

		// Loads all buttons into method KeyListen and adds an actionListener object.
		KeyListen keyListener = new KeyListen();
		jButtonKick.addKeyListener(keyListener);
		jButtonSnare.addKeyListener(keyListener);
		jButtonHihat.addKeyListener(keyListener);
		jButtonHihatOpen.addKeyListener(keyListener);
		jButtonCymbal.addKeyListener(keyListener);
		jButtonClickON.addKeyListener(keyListener);
		jButtonClickOFF.addKeyListener(keyListener);		

		// Sets two fonts used in the main window.
		Font font = new Font("Helvetica", Font.BOLD, 30);
		Font ItalicFont = new Font("Helvetica", Font.ITALIC, 30);
		// Sets above fonts to relevant buttons.
		for (JButton i : jButtonList) {
			i.setFont(font);
			i.setForeground(Color.BLACK);
			container.add(i);
		}
		jButtonClickON.setFont(ItalicFont);
		jButtonClickON.setForeground(Color.GREEN);
		jButtonClickOFF.setFont(ItalicFont);
		jButtonClickOFF.setForeground(Color.RED);
	}

	public static void playSound(String soundName) { // Plays Clip representing the button pressed.
		try {
			AudioInputStream inStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(inStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error playing sound.");
			ex.printStackTrace();
		}
	}

	private static Clip activeClip; // Instantiates a static Clip used to stop playback of Click loop.

	public static void playLoop(String soundName) { // Separate player method for playing the audio sample 'Click.wav'
													// as an continuous loop.
		try {
			activeClip.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			AudioInputStream inStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(inStream);
			activeClip = clip;
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			System.out.println("Error playing sound.");
			ex.printStackTrace();
		}
	}

	public static void stopLoop(String soundName) { // Separate player method for
		activeClip.stop();
	}

	public JFrame getFrame() { // Method for calling the main window from the Main Class.
		return frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
