package view;

//organización visual
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;

// Componentes visibles de Swing
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class FormularioIntregante {
    
     
    private final JFrame ventana;
    private final JPanel contenedor;
    private final CardLayout tarjetas;
    private final JLabel lblTitulo;
    private final JTextField campoNombre;
    private final JTextField campoApellido;
    private final JTextField campoRepositorio;
    private final JRadioButton radioEstudianteNuevo;
    private final JRadioButton radioEstudianteAntiguo;
    private final JComboBox<String> listaProyectos;

    private static final String[] PROYECTOS_CURRICULARES = {
        "Ingeniería de sistemas",
        "Ingeniería industrial",
        "Ingeniería electrica",
        "Ingenieria electronica",
        "Ingenieria civil"
    };

    public FormularioIntregante(String titulo) {
         
        ventana = new JFrame(titulo);
        
        ventana.setUndecorated(true);//Esto lo que hace es ocultar la barra donde esta la x
        ventana.setSize(600, 400);//ventana de 600*400 pixeles
        ventana.setLocationRelativeTo(null);//la ventana aparecera centrada
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//necesario para cerrar por completo la aplicacion

        tarjetas = new CardLayout();
        contenedor = new JPanel(tarjetas);
        lblTitulo = new JLabel(titulo, JLabel.CENTER);
        campoNombre = new JTextField(10);
        campoApellido = new JTextField(10);
        campoRepositorio = new JTextField(10);
        radioEstudianteNuevo = new JRadioButton("Nuevo", true);//es true para que al principo se muestre activado
        radioEstudianteAntiguo = new JRadioButton("Antiguo");
        listaProyectos = new JComboBox<>(PROYECTOS_CURRICULARES);//este es el que permite la lista desplieglable

        ButtonGroup tipoEstudiante = new ButtonGroup();
        tipoEstudiante.add(radioEstudianteNuevo);
        tipoEstudiante.add(radioEstudianteAntiguo);

        ventana.setLayout(new BorderLayout(5, 5));//5 px de separación horizontal y 5 px de separación vertical
        ventana.add(lblTitulo, BorderLayout.NORTH);
        ventana.add(contenedor, BorderLayout.CENTER);
    }
    
    
    
    /**Metodo que define junto con el constructor como se vera la primera ventana*/
    public void formulariollenar(Runnable registrar,Runnable consultar,Runnable cerrar){
    	
    	 JPanel panel = new JPanel(new BorderLayout(10, 10));
         JPanel panelCampos = new JPanel(new GridLayout(5, 2, 5, 5));
         JPanel panelBotones =new JPanel(new GridLayout(1, 3, 30, 5));
         
         // nombre y donde se llenara 
         JLabel lblNombre =new JLabel("Nombre: ");
         panelCampos.add(lblNombre);
         panelCampos.add(campoNombre);
         
         //Appellido y donde se llenara
         JLabel lblApellido =new JLabel("Apellido: ");
         panelCampos.add(lblApellido);
         panelCampos.add(campoApellido);
         
         //Repositorio y donde se llenara
         JLabel lblRepo =new JLabel("Repositorio: ");
         panelCampos.add(lblRepo);
         panelCampos.add(campoRepositorio);
         
         //label y 2 radio buttons de TipoEstudiante
         JLabel lblTipoEstudiante = new JLabel("Tipo de estudiante: ");
         JPanel panelTipoEstudiante = new JPanel(new GridLayout(1, 2, 5, 0));
         panelTipoEstudiante.add(radioEstudianteNuevo);
         panelTipoEstudiante.add(radioEstudianteAntiguo);
         panelCampos.add(lblTipoEstudiante);
         panelCampos.add(panelTipoEstudiante);

         //label y lista desplegable
         JLabel lblProyecto = new JLabel("Proyecto curricular: ");
         panelCampos.add(lblProyecto);
         panelCampos.add(listaProyectos);
         
         JButton btnCerrar=agregarBoton(panelBotones,"Cerrar ventana");
         JButton btnRegistrar=agregarBoton(panelBotones,"Registrar estudiante");
         JButton btnConsultar=agregarBoton(panelBotones,"Consultar estudiantes");
         
         //acciones de los botones
         btnCerrar.addActionListener(e -> cerrar.run());
         btnRegistrar.addActionListener(e -> registrar.run());
         btnConsultar.addActionListener(e -> consultar.run());
         
         panel.add(panelCampos, BorderLayout.CENTER);
         panel.add(panelBotones, BorderLayout.SOUTH);
         
         agregarPanel("panel inicial", panel);
         mostrarPanel("panel inicial");
    }
    
    
    
    /**Metodo para mostrar la información en un panel usando un jtextarea y el scroll esto va estar en el centro mientras que los botones abajo */
    public void mostrarInfoIntregante(String informacion,Runnable volver,Runnable cerrar) {

   	 	JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelBotones =new JPanel(new GridLayout(1, 2, 10, 5));
        JTextArea areaInformacion = new JTextArea(informacion, 12, 45);
        
        areaInformacion.setEditable(false);//area de texto no editable
        areaInformacion.setLineWrap(true);//ajuste automatico de lineas por si el texto es muy largo se pasa a la siguiente
        areaInformacion.setWrapStyleWord(true);//se hace esto para no cortar palabras

        JButton btnVolver = agregarBoton(panelBotones, "Volver");
        JButton btnCerrar = agregarBoton(panelBotones, "Cerrar ventana");
        btnVolver.addActionListener(e -> volver.run());
        btnCerrar.addActionListener(e -> cerrar.run());

        panel.add(new JScrollPane(areaInformacion), BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        for (Component componente : contenedor.getComponents()) {
            if ("panel informacion".equals(componente.getName())) {
                contenedor.remove(componente);
                break;
            }
        }
        agregarPanel("panel informacion", panel);
        mostrarPanel("panel informacion");
    }
    
    /**Muestra una ventana emergente de error*/
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,"Error",JOptionPane.ERROR_MESSAGE);
    }

    /**Muestra una ventana emergente con un mensaje informativo*/
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(ventana,mensaje,"Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Muestra una ventana emergente de confirmación*/
    public void mostrarConfirmacion(String mensaje, Runnable accionAceptar) {
        int respuesta = JOptionPane.showConfirmDialog(null,mensaje,"Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            accionAceptar.run();
        }
    }
    private JButton agregarBoton(JPanel panel, String textoBoton) {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        return boton;
    }

    private void agregarPanel(String nombre, JPanel panel) {
        panel.setName(nombre);//se le asigna un identificador al panel
        contenedor.add(panel, nombre);//se añade al panel al panel general que es un atributo de la clase
        //no añadir más cosas aqui esto es lo que entiendo y ya lo provee en otro proyecto y asi es funcional no tocar
    }

    private void mostrarPanel(String nombre) {
        tarjetas.show(contenedor, nombre);
    }
    
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    public String getNombre() {
        return campoNombre.getText().trim();
    }

    public String getApellido() {
        return campoApellido.getText().trim();
    }

    public String getRepositorio() {
        return campoRepositorio.getText().trim();
    }

    public boolean isEstudianteNuevo() {
        return radioEstudianteNuevo.isSelected();
    }

    public String getProyectoCurricular() {
        return (String) listaProyectos.getSelectedItem();
    }

    /**Indica si se selecciono alguno de los dos tipos de estudiante*/
    public boolean hayTipoEstudianteSeleccionado() {
        return radioEstudianteNuevo.isSelected() || radioEstudianteAntiguo.isSelected();
    }

    /**Devuelve la posicion del proyecto seleccionado en la lista*/
    public int getIndiceProyectoCurricular() {
        return listaProyectos.getSelectedIndex();
    }

    /**Vuelve a mostrar el formulario de registro*/
    public void mostrarFormulario() {
        mostrarPanel("panel inicial");
    }

    public Component getVentana() {
        return ventana;
    }

}
