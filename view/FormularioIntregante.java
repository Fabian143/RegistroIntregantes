package view;

//organización visual
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// Componentes visibles de Swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class FormularioIntregante extends JFrame {
    
     
    private final JFrame ventana;
    private final JPanel contenedor;
    private final CardLayout tarjetas;
    private JLabel lblTitulo;
    private JTextField campoTexto;

    public FormularioIntregante() {
         
        ventana = new JFrame(titulo);//titulo de la ventana no tengo idea de cuando se cambia
        
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

}
