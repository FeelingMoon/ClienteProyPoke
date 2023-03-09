package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Class in charge of the window to login the user.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 * 
 */
@SuppressWarnings("serial")
public class VentanaUsuario extends JFrame {
	private JPanel ventana;
	private JLabel salir, fantasma, continuar, fondo, nuevo;
	private JTextField usuario;
	private Color sc, pr;
	private Font fuente;
	private ArrayList<JLabel> botones;
	private JTextPane text;

	/**
	 * Window constructor where you initialize what is going to be used.
	 * 
	 * @param mouse Mouse Action Listener
	 * @param momo  Mouse Motion Listener
	 */
	public VentanaUsuario(MouseListener mouse, MouseMotionListener momo) {
		fuente = Fuente.oFuente();
		ventana = new JPanel();
		salir = new JLabel("Exit", SwingConstants.CENTER);
		fantasma = new JLabel();
		continuar = new JLabel("Go on", SwingConstants.CENTER);
		fondo = new JLabel();
		nuevo = new JLabel("New User", SwingConstants.CENTER);
		usuario = new JTextField();
		pr = new Color(56, 56, 56);
		sc = new Color(72, 72, 72);
		botones = new ArrayList<>();
		text = new JTextPane();
		//
		botones.add(salir);
		botones.add(fantasma);
		botones.add(continuar);
		botones.add(nuevo);
		//
		salir.setForeground(Color.WHITE);
		salir.setFont(fuente.deriveFont(Font.BOLD, 30));
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setBounds(0, 150, 133, 50);
		salir.addMouseListener(mouse);
		salir.setBackground(Color.RED);
		salir.setOpaque(true);
		fantasma.setBounds(0, 0, 400, 100);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(momo);
		continuar.setForeground(Color.WHITE);
		continuar.setFont(fuente.deriveFont(Font.BOLD, 30));
		continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		continuar.setBounds(266, 150, 140, 50);
		continuar.addMouseListener(mouse);
		continuar.setBackground(pr);
		continuar.setOpaque(true);
		nuevo.setForeground(Color.WHITE);
		nuevo.setFont(fuente.deriveFont(Font.BOLD, 30));
		nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nuevo.setBounds(133, 150, 133, 50);
		nuevo.addMouseListener(mouse);
		nuevo.setBackground(pr);
		nuevo.setOpaque(true);
		usuario.setForeground(Color.BLACK);
		usuario.setFont(fuente.deriveFont(Font.BOLD, 30));
		usuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		usuario.setBounds(25, 75, 350, 50);
		usuario.addMouseListener(mouse);
		usuario.setBackground(Color.WHITE);
		usuario.setOpaque(true);
		usuario.setBorder(new MatteBorder(2, 2, 2, 2, pr));
		text.setForeground(Color.BLACK);
		text.setFont(fuente.deriveFont(Font.BOLD, 30));
		text.setBounds(25, 40, 350, 30);
		text.setEditable(false);
		text.setOpaque(false);
		text.setText("User: ");
		//
		this.setSize(400, 200);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventana.setSize(this.getSize());
		ventana.setLayout(null);
		ventana.add(text);
		ventana.add(usuario);
		ventana.add(nuevo);
		ventana.add(continuar);
		ventana.add(salir);
		ventana.add(fantasma);
		ventana.add(fondo);
		//
		this.add(ventana);
		fondo.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/fondo.png").getImage()
				.getScaledInstance((int) (this.getWidth()), (int) (this.getHeight()), Image.SCALE_DEFAULT)));
		fondo.setSize(((int) (this.getWidth())), (int) (this.getHeight()));
	}

	/**
	 * Method in charge of giving the labels (buttons) to give them their use.
	 * 
	 * @param x The label to give.
	 * @return The requested label.
	 */
	public JLabel obtenerLB(int x) {
		return botones.get(x);
	}

	/**
	 * Method that changes the color of the label when the mouse pointer passes over
	 * it.
	 * 
	 * @param x The label to change the color.
	 */
	public void interiorColor(int x) {
		if (x == 0) {
			salir.setBackground(Color.BLACK);
		} else {
			botones.get(x).setBackground(sc);
		}
	}

	/**
	 * Method that changes the color of the label when the mouse pointer leaves the
	 * label.
	 * 
	 * @param x The label to change the color.
	 */
	public void exteriorColor(int x) {
		if (x == 0) {
			salir.setBackground(Color.RED);
		} else {
			botones.get(x).setBackground(pr);
		}
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
	 * Method that obtains the information written in the user's box
	 * 
	 * @return User entered
	 */
	public String getUsuario() {
		return usuario.getText();
	}

	/**
	 * Method in charge of cleaning the user's box.
	 */
	public void limpiar() {
		usuario.setText("");
	}
}
