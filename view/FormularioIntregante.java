package view;

//organización visual
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
import java.awt.GridLayout;

// Componentes visibles de Swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class FormularioIntregante {
    
     
    private final JFrame ventana;
    private final JPanel contenedor;
    private final CardLayout tarjetas;
    private JLabel lblTitulo;
    private JTextField campoTexto;

    public FormularioIntregante(String titulo) {
         
        ventana = new JFrame(titulo);
        
        ventana.setUndecorated(true);//Esto lo que hace es ocultar la barra donde esta la x
        ventana.setSize(600, 400);//ventana de 600*400 pixeles
        ventana.setLocationRelativeTo(null);//la ventana aparecera centrada

        tarjetas = new CardLayout();
        contenedor = new JPanel(tarjetas);
        campoTexto = new JTextField();
        lblTitulo = new JLabel(titulo, JLabel.CENTER);

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
         JTextField camponombre=new JTextField(10);
         panelCampos.add(lblNombre);
         panelCampos.add(camponombre);
         
         //Appellido y donde se llenara
         JLabel lblApellido =new JLabel("Apellido: ");
         JTextField campoApellido=new JTextField(10);
         panelCampos.add(lblApellido);
         panelCampos.add(campoApellido);
         
         //Repositorio y donde se llenara
         JLabel lblRepo =new JLabel("Repositorio: ");
         JTextField campoRepo=new JTextField(10);
         panelCampos.add(lblRepo);
         panelCampos.add(campoRepo);
         
         //luego este comentario se borrara pero necesito primero algo para que en la interfaz salga como Tipo estudiante: y 2 radio button con unica respuesta uno de nuevo y otro de antiguo
         //tambien necesito una de proyecto curricular: y que al lado este su lista que es definida en otra clase especificamente en Intregante pero si se puede evitar importar la clase de modelo estaria mejor aun
         
         JButton btnCerrar=agregarBoton(panel,"Cerrar ventana");
         JButton btnRegistrar=agregarBoton(panel,"Registrar estudiante");
         JButton btnConsultar=agregarBoton(panel,"Consultar estudiantes");
         
         //acciones de los botones
         btnCerrar.addActionListener(e -> cerrar.run());
         btnRegistrar.addActionListener(e -> registrar.run());
         btnConsultar.addActionListener(e -> consultar.run());
         
         panelBotones.add(btnRegistrar);
         panelBotones.add(btnConsultar);
         panelBotones.add(btnCerrar);
        
         panel.add(panelCampos, BorderLayout.CENTER);
         panel.add(panelBotones, BorderLayout.CENTER);
         
         agregarPanel("panel inicial", panel);
         mostrarPanel("panel inicial");
    }
    /**Metodo */
    public void mostrarInfoIntregante(String informacion,Runnable volver,Runnable cerrar) {

   	 	JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelBotones =new JPanel(new GridLayout(1, 2, 50, 5));
    	
    }
    
    private JButton agregarBoton(JPanel panel, String textoBoton) {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        return boton;
    }

    private JTextField agregarCampoTexto(JPanel panel, int columnas) {
        campoTexto = new JTextField(columnas);
        panel.add(campoTexto);
        return campoTexto;
    }

    private String obtenerTexto() {
        return campoTexto.getText();
    }

    private void limpiarCampoTexto() {
        campoTexto.setText("");
    }

    private void agregarPanel(String nombre, JPanel panel) {
        panel.setName(nombre);
        contenedor.add(panel, nombre);
    }

    private void mostrarPanel(String nombre) {
        tarjetas.show(contenedor, nombre);
    }

    private JTextArea agregarAreaMensajes(JPanel panel, int filas, int columnas) {
        JTextArea area = new JTextArea(filas, columnas);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        panel.add(area);
        return area;
    }

    private JScrollPane agregarScrollMensajes(JPanel panel, JTextArea area) {
        JScrollPane scroll = new JScrollPane(area);
        panel.add(scroll);
        return scroll;
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

    public JTextField getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(JTextField campoTexto) {
        this.campoTexto = campoTexto;
    }

    public Component getVentana() {
        return ventana;
    }

}
