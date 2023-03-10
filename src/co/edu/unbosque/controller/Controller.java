package co.edu.unbosque.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import co.edu.unbosque.view.Fuente;
import co.edu.unbosque.view.Mensaje;

/**
 * 
 * Controller class that links all program packages.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 *
 */
public class Controller implements MouseListener, MouseMotionListener, ItemListener {
	@SuppressWarnings("unused")
	private Fuente fuente;
	private int xmouse, ymouse;
	HiloPrimario primario;

	/**
	 * Controller construction method.
	 */
	public Controller() {
		fuente = new Fuente();

		try {
			primario = new HiloPrimario("127.0.0.1", 7250, this, this, this);
			primario.start();
		} catch (Exception e) {
			try {
				primario = new HiloPrimario("127.0.0.1", 7500, this, this, this);
				primario.start();
			} catch (Exception e2) {
				try {
					primario = new HiloPrimario("127.0.0.1", 7750, this, this, this);
					primario.start();
				} catch (Exception e3) {
					try {
						primario = new HiloPrimario("127.0.0.1", 8000, this, this, this);
						primario.start();
					} catch (Exception e4) {
					}
				}
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource().equals(primario.principal.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.principal.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.poke.getFantasma())) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.poke.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.user.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.user.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.mov.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.mov.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.free.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.free.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.createUs.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.createUs.ubicacion((x - xmouse), (y - ymouse));
		} else if (e.getSource().equals(primario.captura.obtenerLB(1))) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			primario.captura.ubicacion((x - xmouse), (y - ymouse));
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(primario.principal.obtenerLB(0))) {
			primario.enviarInfo("Over");
			System.exit(0);
		} else if (e.getSource().equals(primario.principal.obtenerLB(2))) {
			// liberar
			primario.free.cambiarTextoPoke(primario.principal.getActual());
			primario.principal.setVisible(false);
			primario.free.setVisible(true);
		} else if (e.getSource().equals(primario.principal.obtenerLB(3))) {
			// mover
			primario.principal.setVisible(false);
			primario.mov.setVisible(true);
		} else if (e.getSource().equals(primario.principal.obtenerLB(4))) {
			// sumar
			primario.enviarInfo(primario.userActual + "-getAll@true");
		} else if (e.getSource().equals(primario.principal.obtenerLB(5))) {
			// datos
			primario.principal.setVisible(false);
			primario.poke.setVisible(true);
		} else if (e.getSource().equals(primario.principal.obtenerLB(6))) {
			// Pokemon Bolsillo 1
		} else if (e.getSource().equals(primario.principal.obtenerLB(7))) {
			// Pokemon Bolsillo 2
		} else if (e.getSource().equals(primario.principal.obtenerLB(8))) {
			// Pokemon Bolsillo 3
		} else if (e.getSource().equals(primario.principal.obtenerLB(9))) {
			// Pokemon Bolsillo 4
		} else if (e.getSource().equals(primario.principal.obtenerLB(10))) {
			// Pokemon Bolsillo 5
		} else if (e.getSource().equals(primario.principal.obtenerLB(11))) {
			// Pokemon Bolsillo 6
		} else if (e.getSource().equals(primario.principal.obtenerLB(12))) {
			// Izquierda

			if (primario.principal.getCajaActual() == 3) {
				primario.principal.eliminarComboBox();
				primario.principal.cambioImagen(null);
				primario.principal.cambioCaja(2);
				primario.enviarInfo(primario.userActual + "-getCB@" + 2);
			} else if (primario.principal.getCajaActual() == 2) {
				primario.principal.eliminarComboBox();
				primario.principal.cambioImagen(null);
				primario.principal.cambioCaja(1);
				primario.enviarInfo(primario.userActual + "-getCB@" + 1);
			}

		} else if (e.getSource().equals(primario.principal.obtenerLB(13))) {
			// Derecha
			if (primario.principal.getCajaActual() == 1) {
				primario.principal.eliminarComboBox();
				primario.principal.cambioImagen(null);
				primario.principal.cambioCaja(2);
				primario.enviarInfo(primario.userActual + "-getCB@" + 2);
				System.err.println(primario.principal.getCajaActual());
			} else if (primario.principal.getCajaActual() == 2) {
				primario.principal.eliminarComboBox();
				primario.principal.cambioImagen(null);
				primario.principal.cambioCaja(3);
				primario.enviarInfo(primario.userActual + "-getCB@" + 3);
				System.err.println(primario.principal.getCajaActual());
			}
		} else if (e.getSource().equals(primario.principal.obtenerLB(14))) {
			// Actualizar
			primario.enviarInfo(primario.userActual + "-getCB@" + primario.principal.getCajaActual());
			primario.enviarInfo(primario.userActual + "-getCB@" + primario.principal.getCajaActual());
			if (!primario.bolsillo.equals("")) {
				primario.principal.agregarBolsilloImg(primario.bolsillo);
				primario.enviarInfo(primario.userActual + "-getMote@" + primario.principal.getCajaActual() + "-"
						+ primario.principal.getActual());
			}

		} else if (e.getSource().equals(primario.abajo.obtenerLB(0))) {
			// Grito
		} else if (e.getSource().equals(primario.abajo.obtenerLB(1))) {
			// Detalles
			if (primario.arriba.panelPrincipalActivo()) {
				primario.arriba.panelEstadisActivo();
			} else {
				primario.arriba.panelPrincipalActivo();
			}
		} else if (e.getSource().equals(primario.abajo.obtenerLB(2))) {
			// Volver
			primario.poke.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.user.obtenerLB(0))) {
			primario.enviarInfo("Over");
			System.exit(0);
		} else if (e.getSource().equals(primario.user.obtenerLB(2))) {
			if (primario.user.getUsuario().equals(null) || primario.user.getUsuario().equals("")) {
				Mensaje.mensaje("Enter the user");
			} else {
				primario.enviarInfo(primario.user.getUsuario() + "-iniciar@true");

			}

		} else if (e.getSource().equals(primario.user.obtenerLB(3))) {
			primario.user.setVisible(false);
			primario.createUs.setVisible(true);
		} else if (e.getSource().equals(primario.mov.obtenerLB(0))) {
			// Volver
			primario.mov.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.mov.obtenerLB(2))) {
			// Mover
			System.out.println(primario.userActual + "-mover@" + primario.principal.getCajaActual() + "-"
					+ primario.mov.getBoxSelected() + "-" + primario.principal.getActual());
			primario.enviarInfo(primario.userActual + "-mover@" + primario.principal.getCajaActual() + "-"
					+ primario.mov.getBoxSelected() + "-" + primario.principal.getActual());
			primario.mov.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.free.obtenerLB(0))) {
			// Volver
			primario.free.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.free.obtenerLB(2))) {
			// liberar
			primario.enviarInfo(primario.userActual + "-liberar@" + primario.principal.getCajaActual() + "-"
					+ primario.principal.getActual());
			primario.free.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(0))) {
			primario.createUs.setVisible(false);
			primario.user.setVisible(true);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(2))) {
			// crear
			if (primario.createUs.getUsuario().equals(null) || primario.createUs.getUsuario().equals("")) {
				Mensaje.mensaje("Enter the user");
			} else {
				primario.enviarInfo("true-nuevo@" + primario.createUs.getUsuario());
			}
		} else if (e.getSource().equals(primario.captura.obtenerLB(0))) {
			// Volver
			primario.captura.setVisible(false);
			primario.principal.setVisible(true);
		} else if (e.getSource().equals(primario.captura.obtenerLB(2))) {
			String tmp = primario.captura.getPokemon();
			System.out.println(tmp);
			if (primario.captura.getNombre().equals("") || primario.captura.getNombre().equals(null)) {
				primario.enviarInfo(
						primario.userActual + "-capturar@" + tmp + "-Nothing-" + primario.captura.getCaja());
				primario.captura.limpiar();
			} else {
				primario.enviarInfo(primario.userActual + "-capturar@" + tmp + "-" + primario.captura.getNombre() + "-"
						+ primario.captura.getCaja());
				primario.captura.limpiar();
			}
			primario.captura.setVisible(false);
			primario.principal.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(primario.principal.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.poke.getFantasma())) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.user.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.mov.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.free.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.createUs.obtenerLB(1))) {
			xmouse = e.getX();
			ymouse = e.getY();
		} else if (e.getSource().equals(primario.captura.obtenerLB(1))) {
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
		if (e.getSource().equals(primario.principal.obtenerLB(0))) {
			primario.principal.interiorColor(0);
		} else if (e.getSource().equals(primario.principal.obtenerLB(2))) {
			primario.principal.interiorColor(2);
		} else if (e.getSource().equals(primario.principal.obtenerLB(3))) {
			primario.principal.interiorColor(3);
		} else if (e.getSource().equals(primario.principal.obtenerLB(4))) {
			primario.principal.interiorColor(4);
		} else if (e.getSource().equals(primario.principal.obtenerLB(5))) {
			primario.principal.interiorColor(5);
		} else if (e.getSource().equals(primario.principal.obtenerLB(6))) {
			primario.principal.interiorColor(6);
		} else if (e.getSource().equals(primario.principal.obtenerLB(7))) {
			primario.principal.interiorColor(7);
		} else if (e.getSource().equals(primario.principal.obtenerLB(8))) {
			primario.principal.interiorColor(8);
		} else if (e.getSource().equals(primario.principal.obtenerLB(9))) {
			primario.principal.interiorColor(9);
		} else if (e.getSource().equals(primario.principal.obtenerLB(10))) {
			primario.principal.interiorColor(10);
		} else if (e.getSource().equals(primario.principal.obtenerLB(11))) {
			primario.principal.interiorColor(11);
		} else if (e.getSource().equals(primario.principal.obtenerLB(12))) {
			primario.principal.interiorColor(12);
		} else if (e.getSource().equals(primario.principal.obtenerLB(13))) {
			primario.principal.interiorColor(13);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(0))) {
			primario.abajo.interiorColor(0);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(1))) {
			primario.abajo.interiorColor(1);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(2))) {
			primario.abajo.interiorColor(2);
		} else if (e.getSource().equals(primario.user.obtenerLB(0))) {
			primario.user.interiorColor(0);
		} else if (e.getSource().equals(primario.user.obtenerLB(2))) {
			primario.user.interiorColor(2);
		} else if (e.getSource().equals(primario.user.obtenerLB(3))) {
			primario.user.interiorColor(3);
		} else if (e.getSource().equals(primario.mov.obtenerLB(0))) {
			primario.mov.interiorColor(0);
		} else if (e.getSource().equals(primario.mov.obtenerLB(2))) {
			primario.mov.interiorColor(2);
		} else if (e.getSource().equals(primario.free.obtenerLB(0))) {
			primario.free.interiorColor(0);
		} else if (e.getSource().equals(primario.free.obtenerLB(2))) {
			primario.free.interiorColor(2);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(0))) {
			primario.createUs.interiorColor(0);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(2))) {
			primario.createUs.interiorColor(2);
		} else if (e.getSource().equals(primario.captura.obtenerLB(0))) {
			primario.captura.interiorColor(0);
		} else if (e.getSource().equals(primario.captura.obtenerLB(2))) {
			primario.captura.interiorColor(2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(primario.principal.obtenerLB(0))) {
			primario.principal.exteriorColor(0);
		} else if (e.getSource().equals(primario.principal.obtenerLB(2))) {
			primario.principal.exteriorColor(2);
		} else if (e.getSource().equals(primario.principal.obtenerLB(3))) {
			primario.principal.exteriorColor(3);
		} else if (e.getSource().equals(primario.principal.obtenerLB(4))) {
			primario.principal.exteriorColor(4);
		} else if (e.getSource().equals(primario.principal.obtenerLB(5))) {
			primario.principal.exteriorColor(5);
		} else if (e.getSource().equals(primario.principal.obtenerLB(6))) {
			primario.principal.exteriorColor(6);
		} else if (e.getSource().equals(primario.principal.obtenerLB(7))) {
			primario.principal.exteriorColor(7);
		} else if (e.getSource().equals(primario.principal.obtenerLB(8))) {
			primario.principal.exteriorColor(8);
		} else if (e.getSource().equals(primario.principal.obtenerLB(9))) {
			primario.principal.exteriorColor(9);
		} else if (e.getSource().equals(primario.principal.obtenerLB(10))) {
			primario.principal.exteriorColor(10);
		} else if (e.getSource().equals(primario.principal.obtenerLB(11))) {
			primario.principal.exteriorColor(11);
		} else if (e.getSource().equals(primario.principal.obtenerLB(12))) {
			primario.principal.exteriorColor(12);
		} else if (e.getSource().equals(primario.principal.obtenerLB(13))) {
			primario.principal.exteriorColor(13);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(0))) {
			primario.abajo.exteriorColor(0);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(1))) {
			primario.abajo.exteriorColor(1);
		} else if (e.getSource().equals(primario.abajo.obtenerLB(2))) {
			primario.abajo.exteriorColor(2);
		} else if (e.getSource().equals(primario.user.obtenerLB(0))) {
			primario.user.exteriorColor(0);
		} else if (e.getSource().equals(primario.user.obtenerLB(2))) {
			primario.user.exteriorColor(2);
		} else if (e.getSource().equals(primario.user.obtenerLB(3))) {
			primario.user.exteriorColor(3);
		} else if (e.getSource().equals(primario.mov.obtenerLB(0))) {
			primario.mov.exteriorColor(0);
		} else if (e.getSource().equals(primario.mov.obtenerLB(2))) {
			primario.mov.exteriorColor(2);
		} else if (e.getSource().equals(primario.free.obtenerLB(0))) {
			primario.free.exteriorColor(0);
		} else if (e.getSource().equals(primario.free.obtenerLB(2))) {
			primario.free.exteriorColor(2);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(0))) {
			primario.createUs.exteriorColor(0);
		} else if (e.getSource().equals(primario.createUs.obtenerLB(2))) {
			primario.createUs.exteriorColor(2);
		} else if (e.getSource().equals(primario.captura.obtenerLB(0))) {
			primario.captura.exteriorColor(0);
		} else if (e.getSource().equals(primario.captura.obtenerLB(2))) {
			primario.captura.exteriorColor(2);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(primario.principal.getCombo())) {
			primario.enviarInfo(primario.userActual + "-getMote@" + primario.principal.getCajaActual() + "-"
					+ primario.principal.getActual());
		}

	}

}
