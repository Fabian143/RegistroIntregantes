package view;

import model.Intregante;

import javax.swing.*;
import java.awt.*;

public class FormularioIntregante extends JFrame {
    private final JTextField txtNombre;
    private final JTextField txtApellido;
    private final JTextField txtEdad;
    private final JTextField txtEmail;
    private final JButton btnGuardar;

    public FormularioIntregante() {
        super("Registro de Intregante");

        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        add(new JLabel());
    }

    public Intregante obtenerDatos() {
        Intregante integrante = new Intregante();
        integrante.setNombre(txtNombre.getText());
        integrante.setApellido(txtApellido.getText());
        integrante.setEdad(Integer.parseInt(txtEdad.getText().trim()));
        integrante.setEmail(txtEmail.getText());
        return integrante;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
}
