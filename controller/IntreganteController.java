package controller;

import java.util.ArrayList;

import model.Intregante;
import view.FormularioIntregante;

/**Controlador que valida las acciones de la vista y administra los intregantes registrados*/
public class IntreganteController {
    private final FormularioIntregante vista;
    private final ArrayList<Intregante> intregantes;

    /**Crea el controlador y la lista que almacenara los intregantes durante la ejecucion*/
    public IntreganteController(FormularioIntregante vista) {
        this.vista = vista;
        this.intregantes = new ArrayList<>();
    }

    /**Prepara el menu inicial y muestra la ventana principal*/
    public void iniciar() {
        vista.formulariollenar(this::confirmarRegistro,this::confirmarConsulta,this::confirmarCierre);
        vista.mostrarVentana();
    }

    /**Solicita confirmacion antes de validar y registrar los datos del formulario*/
    private void confirmarRegistro() {
        vista.mostrarConfirmacion("¿Desea registrar este estudiante?", this::registrarIntregante);
    }

    /**Solicita confirmacion antes de mostrar los registros guardados*/
    private void confirmarConsulta() {
        vista.mostrarConfirmacion("¿Desea consultar los estudiantes registrados?", this::consultarIntregantes);
    }

    /**Solicita confirmacion antes de cerrar la aplicacion*/
    private void confirmarCierre() {
        vista.mostrarConfirmacion("¿Está seguro de que desea cerrar la aplicación?", vista::cerrarVentana);
    }

    
    
    /**Valida los campos y agrega el nuevo intregante a la lista*/
    public void registrarIntregante() {
        if (vista.getNombre().isEmpty()|| vista.getApellido().isEmpty()|| vista.getRepositorio().isEmpty()) {
            vista.mostrarError("Alguno de estos campos(nombre, apellido y repositorio) esta vacio por favor completar.");
            return;
        }


        int indiceProyecto = vista.getIndiceProyectoCurricular();
        if (indiceProyecto < 0) {
            vista.mostrarError("Seleccione un proyecto curricular.");
            return;
        }

        try {
            Intregante intregante = new Intregante(vista.getNombre(),vista.getApellido(),vista.getRepositorio(),vista.isEstudianteNuevo(),(byte) (indiceProyecto + 1));
            intregantes.add(intregante);
            vista.mostrarMensaje("El estudiante se registró correctamente.");
        } catch (IllegalArgumentException error) {
            vista.mostrarError("No fue posible registrar al estudiante: " + error.getMessage());
        }
    }

    /**Muestra los datos de todos los intregantes registrados*/
    private void consultarIntregantes() {
        if (intregantes.isEmpty()) {
            vista.mostrarMensaje("Todavía no hay estudiantes registrados.");
            return;
        }

        StringBuilder informacion = new StringBuilder();
        for (int i = 0; i < intregantes.size(); i++) {
            Intregante intregante = intregantes.get(i);
            informacion.append("Estudiante ").append(i + 1).append(" :\n")
            			.append("Nombre: ").append(intregante.getNombre()).append(' ')
            			.append(intregante.getApellido()).append('\n')
            			.append("Repositorio: ").append(intregante.getRepositorio()).append('\n')
            			.append("Tipo: ").append(intregante.getTipoEstudiante()).append('\n')
            			.append("Proyecto curricular: ").append(intregante.getProyectoCurricular())
            			.append("\n\n");
        }

        vista.mostrarInfoIntregante(informacion.toString(), this::volverAlMenu, this::confirmarCierre);
    }

    /**Regresa desde la consulta al formulario de registro*/
    private void volverAlMenu() {
        vista.mostrarFormulario();
    }
}
