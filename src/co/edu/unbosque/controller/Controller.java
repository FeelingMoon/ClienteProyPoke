package co.edu.unbosque.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import co.edu.unbosque.view.Fuente;
import co.edu.unbosque.view.Mensaje;
import co.edu.unbosque.view.PanelAbajo;
import co.edu.unbosque.view.PanelArriba;
import co.edu.unbosque.view.VentanaCreacionUsuario;
import co.edu.unbosque.view.VentanaLiberar;
import co.edu.unbosque.view.VentanaMovimiento;
import co.edu.unbosque.view.VentanaPokemon;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaUsuario;

public class Controller implements MouseListener, MouseMotionListener {
	@SuppressWarnings("unused")
	private Fuente fuente;
	private VentanaUsuario user;
	private VentanaPrincipal principal;
	private VentanaPokemon poke;
	private VentanaLiberar free;
	private VentanaMovimiento mov;
	private PanelArriba arriba;
	private PanelAbajo abajo;
	private int xmouse, ymouse;
	private HiloPrimario primario;
	private VentanaCreacionUsuario createUs;
	private String userActual;
	private Mensaje mensaje;

	public Controller() {
		fuente = new Fuente();
		user = new VentanaUsuario(this, this);
		mov = new VentanaMovimiento(this, this);
		free = new VentanaLiberar(this, this);
		principal = new VentanaPrincipal(this, this);
		arriba = new PanelArriba();
		abajo = new PanelAbajo(this);
		poke = new VentanaPokemon(arriba, abajo, this, this);
		createUs = new VentanaCreacionUsuario(this, this);
		user.setVisible(true);
		userActual = "";
		try {
			primario = new HiloPrimario(7250);
			primario.start();
		} catch (Exception e) {
			try {
				primario = new HiloPrimario(7500);
				primario.start();
			} catch (Exception e2) {
				try {
					primario = new HiloPrimario(7750);
					primario.start();
				} catch (Exception e3) {
					try {
						primario = new HiloPrimario(8000);
						primario.start();
					} catch (Exception e4) {
					}
				}
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			principal.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(poke.getFantasma())) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			poke.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(user.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			user.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(mov.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			mov.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(free.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			free.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(createUs.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			createUs.ubicacion((x - xmouse), (y - ymouse));
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			System.exit(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			// liberar
			free.cambiarTextoPoke("Pikachu");
			principal.setVisible(false);
			free.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			// mover
			principal.setVisible(false);
			mov.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			// sumar
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			// datos
			principal.setVisible(false);
			poke.setVisible(true);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			// Pokemon Bolsillo 1
		} else if (e.getSource().equals(principal.obtenerLB(7))) {
			// Pokemon Bolsillo 2
		} else if (e.getSource().equals(principal.obtenerLB(8))) {
			// Pokemon Bolsillo 3
		} else if (e.getSource().equals(principal.obtenerLB(9))) {
			// Pokemon Bolsillo 4
		} else if (e.getSource().equals(principal.obtenerLB(10))) {
			// Pokemon Bolsillo 5
		} else if (e.getSource().equals(principal.obtenerLB(11))) {
			// Pokemon Bolsillo 6
		} else if (e.getSource().equals(principal.obtenerLB(12))) {
			// Izquierda

			if (principal.getCajaActual() == 3) {
				principal.cambioCaja(2);
			} else if (principal.getCajaActual() == 2) {
				principal.cambioCaja(1);
			}

		} else if (e.getSource().equals(principal.obtenerLB(13))) {
			// Derecha
			if (principal.getCajaActual() == 1) {
				principal.cambioCaja(2);
			} else if (principal.getCajaActual() == 2) {
				principal.cambioCaja(3);
			}
		} else if (e.getSource().equals(abajo.obtenerLB(0))) {
			// Grito
		} else if (e.getSource().equals(abajo.obtenerLB(1))) {
			// Detalles
			if (arriba.panelPrincipalActivo()) {
				arriba.panelEstadisActivo();
			} else {
				arriba.panelPrincipalActivo();
			}
		} else if (e.getSource().equals(abajo.obtenerLB(2))) {
			// Volver
			poke.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(user.obtenerLB(0))) {
			System.exit(0);
		} else if (e.getSource().equals(user.obtenerLB(2))) {
			if (user.getUsuario().equals(null) || user.getUsuario().equals("")) {
				mensaje.mensaje("User no exist");
			}
			user.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(user.obtenerLB(3))) {
			user.setVisible(false);
			createUs.setVisible(true);
		} else if (e.getSource().equals(mov.obtenerLB(0))) {
			// Volver
			mov.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(mov.obtenerLB(2))) {
			// Mover
			System.out.println(mov.getBox());
			mov.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(free.obtenerLB(0))) {
			// Volver
			free.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(free.obtenerLB(2))) {
			// Liberar
			System.out.println(free.isLiberated());
			free.setVisible(false);
			principal.setVisible(true);
		} else if (e.getSource().equals(createUs.obtenerLB(0))) {
			createUs.setVisible(false);
			user.setVisible(true);
		} else if (e.getSource().equals(createUs.obtenerLB(2))) {
			// Liberar
			System.out.println(createUs.getUsuario());
			createUs.setVisible(false);
			user.setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(poke.getFantasma())) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(user.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(mov.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(free.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(createUs.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			principal.interiorColor(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			principal.interiorColor(2);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			principal.interiorColor(3);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			principal.interiorColor(4);
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			principal.interiorColor(5);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			principal.interiorColor(6);
		} else if (e.getSource().equals(principal.obtenerLB(7))) {
			principal.interiorColor(7);
		} else if (e.getSource().equals(principal.obtenerLB(8))) {
			principal.interiorColor(8);
		} else if (e.getSource().equals(principal.obtenerLB(9))) {
			principal.interiorColor(9);
		} else if (e.getSource().equals(principal.obtenerLB(10))) {
			principal.interiorColor(10);
		} else if (e.getSource().equals(principal.obtenerLB(11))) {
			principal.interiorColor(11);
		} else if (e.getSource().equals(principal.obtenerLB(12))) {
			principal.interiorColor(12);
		} else if (e.getSource().equals(principal.obtenerLB(13))) {
			principal.interiorColor(13);
		} else if (e.getSource().equals(abajo.obtenerLB(0))) {
			abajo.interiorColor(0);
		} else if (e.getSource().equals(abajo.obtenerLB(1))) {
			abajo.interiorColor(1);
		} else if (e.getSource().equals(abajo.obtenerLB(2))) {
			abajo.interiorColor(2);
		} else if (e.getSource().equals(user.obtenerLB(0))) {
			user.interiorColor(0);
		} else if (e.getSource().equals(user.obtenerLB(2))) {
			user.interiorColor(2);
		} else if (e.getSource().equals(user.obtenerLB(3))) {
			user.interiorColor(3);
		} else if (e.getSource().equals(mov.obtenerLB(0))) {
			mov.interiorColor(0);
		} else if (e.getSource().equals(mov.obtenerLB(2))) {
			mov.interiorColor(2);
		} else if (e.getSource().equals(free.obtenerLB(0))) {
			free.interiorColor(0);
		} else if (e.getSource().equals(free.obtenerLB(2))) {
			free.interiorColor(2);
		} else if (e.getSource().equals(createUs.obtenerLB(0))) {
			createUs.interiorColor(0);
		} else if (e.getSource().equals(createUs.obtenerLB(2))) {
			createUs.interiorColor(2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(principal.obtenerLB(0))) {
			principal.exteriorColor(0);
		} else if (e.getSource().equals(principal.obtenerLB(2))) {
			principal.exteriorColor(2);
		} else if (e.getSource().equals(principal.obtenerLB(3))) {
			principal.exteriorColor(3);
		} else if (e.getSource().equals(principal.obtenerLB(4))) {
			principal.exteriorColor(4);
		} else if (e.getSource().equals(principal.obtenerLB(5))) {
			principal.exteriorColor(5);
		} else if (e.getSource().equals(principal.obtenerLB(6))) {
			principal.exteriorColor(6);
		} else if (e.getSource().equals(principal.obtenerLB(7))) {
			principal.exteriorColor(7);
		} else if (e.getSource().equals(principal.obtenerLB(8))) {
			principal.exteriorColor(8);
		} else if (e.getSource().equals(principal.obtenerLB(9))) {
			principal.exteriorColor(9);
		} else if (e.getSource().equals(principal.obtenerLB(10))) {
			principal.exteriorColor(10);
		} else if (e.getSource().equals(principal.obtenerLB(11))) {
			principal.exteriorColor(11);
		} else if (e.getSource().equals(principal.obtenerLB(12))) {
			principal.exteriorColor(12);
		} else if (e.getSource().equals(principal.obtenerLB(13))) {
			principal.exteriorColor(13);
		} else if (e.getSource().equals(abajo.obtenerLB(0))) {
			abajo.exteriorColor(0);
		} else if (e.getSource().equals(abajo.obtenerLB(1))) {
			abajo.exteriorColor(1);
		} else if (e.getSource().equals(abajo.obtenerLB(2))) {
			abajo.exteriorColor(2);
		} else if (e.getSource().equals(user.obtenerLB(0))) {
			user.exteriorColor(0);
		} else if (e.getSource().equals(user.obtenerLB(2))) {
			user.exteriorColor(2);
		} else if (e.getSource().equals(user.obtenerLB(3))) {
			user.exteriorColor(3);
		} else if (e.getSource().equals(mov.obtenerLB(0))) {
			mov.exteriorColor(0);
		} else if (e.getSource().equals(mov.obtenerLB(2))) {
			mov.exteriorColor(2);
		} else if (e.getSource().equals(free.obtenerLB(0))) {
			free.exteriorColor(0);
		} else if (e.getSource().equals(free.obtenerLB(2))) {
			free.exteriorColor(2);
		} else if (e.getSource().equals(createUs.obtenerLB(0))) {
			createUs.exteriorColor(0);
		} else if (e.getSource().equals(createUs.obtenerLB(2))) {
			createUs.exteriorColor(2);
		}

	}
}
