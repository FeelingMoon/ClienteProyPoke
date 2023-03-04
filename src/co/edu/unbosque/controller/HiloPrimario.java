package co.edu.unbosque.controller;

public class HiloPrimario extends Thread {
	@SuppressWarnings("unused")
	private Controller controller;

	public HiloPrimario() {
	}

	@Override
	public void run() {
		controller = new Controller();
		super.run();
	}

}
