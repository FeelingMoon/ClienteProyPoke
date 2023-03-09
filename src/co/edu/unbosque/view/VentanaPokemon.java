package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class in charge of the window to information of pokemon.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 * 
 */
@SuppressWarnings("serial")
public class VentanaPokemon extends JFrame {
	private JLabel fantasma;
	private JPanel panel;

	/**
	 * This Constructor method sets its attributes and adds the JPanels to the
	 * JFrame
	 * 
	 * @param panelArriba Top of the window
	 * @param panelAbajo  Bottom of the window
	 * @param mouse       Mouse Action Listener
	 * @param momo        Mouse Motion Listener
	 */
	public VentanaPokemon(JPanel panelArriba, JPanel panelAbajo, MouseListener mouse, MouseMotionListener momo) {
		fantasma = new JLabel();
		panel = new JPanel();
		fantasma.setBounds(0, 0, 600, 100);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(momo);
		//
		this.setLayout(null);
		this.setSize(600, 800);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.add(fantasma);
		panel.setSize(this.getSize());
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelArriba);
		panel.add(panelAbajo);
		this.add(panel);
	}

	/**
	 * Method that takes care of changing the location of the window.
	 * 
	 * @param x Location on the x-axis.
	 * @param y Location on the y-axis.
	 */
	public void ubicacion(int x, int y) {
		this.setLocation(x, y);

	}

	/**
	 * Method that returns the ghost of the window.
	 * 
	 * @return Label ghost
	 */
	public JLabel getFantasma() {
		return fantasma;
	}
}
