package controller;

import model.Intregante;
import view.FormularioIntregante;

public class IntreganteController {
    private final FormularioIntregante vista;

    public IntreganteController(FormularioIntregante vista) {
        this.vista = vista;
    }

    public void registrarIntregante() {
        Intregante integrante = vista.obtenerDatos();
        System.out.println("Intregante registrado: " + integrante);
    }
}
