package main;

import controller.IntreganteController;
import view.FormularioIntregante;

/**Punto de entrada de la aplicacion de registro de intregantes*/
public class Main {

	/**Inicia la interfaz grafica en el hilo de eventos de Swing*/
	public static void main(String[] args) {
		FormularioIntregante vista = new FormularioIntregante("Registro de intregantes");
		IntreganteController controlador = new IntreganteController(vista);
		controlador.iniciar();
	
}
}