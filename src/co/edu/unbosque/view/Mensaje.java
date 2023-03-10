package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * Class used for sending status messages to the user.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 *
 */
public class Mensaje {
	/**
	 * Empty Constrcutor.
	 */
	public Mensaje() {

	}

	/**
	 * Method in charge of sending the message.
	 * 
	 * @param msg Message to display.
	 */
	public static void mensaje(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
