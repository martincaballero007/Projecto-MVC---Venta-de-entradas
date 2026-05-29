package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame {

    private JComboBox<String> comboZonas;
    private JTextField txtCantidad;
    private JTextField txtNumTarjeta;
    private JTextField txtTitular;
    private JTextField txtVencimiento;
    private JPasswordField txtCvv; 
    
    private JButton btnComprar;
    private JButton btnSalir;

    public VistaPrincipal() {
        super("Sistema de Venta de Entradas");
        configurarLookAndFeel();
        inicializarComponentes();
    }

    private void configurarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("No se pudo establecer el Look and Feel del sistema: " + e.getMessage());
        }
    }

    private void inicializarComponentes() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(480, 380);
        this.setLocationRelativeTo(null); 
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel lblTitulo = new JLabel("COMPRA DE ENTRADAS", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 6, 6, 6); 

        comboZonas = new JComboBox<>(new String[]{"VIP", "General", "Preferencial"}); 
        txtCantidad = new JTextField();
        txtNumTarjeta = new JTextField();
        txtTitular = new JTextField();
        txtVencimiento = new JTextField();
        txtCvv = new JPasswordField();

        colocarComponente(panelFormulario, new JLabel("Zona del Concierto:"), comboZonas, gbc, 0);
        colocarComponente(panelFormulario, new JLabel("Cantidad (Máx. 4):"), txtCantidad, gbc, 1);
        colocarComponente(panelFormulario, new JLabel("Número de Tarjeta (16 dígitos):"), txtNumTarjeta, gbc, 2);
        colocarComponente(panelFormulario, new JLabel("Nombre del Titular:"), txtTitular, gbc, 3);
        colocarComponente(panelFormulario, new JLabel("Vencimiento (MM/AA):"), txtVencimiento, gbc, 4);
        colocarComponente(panelFormulario, new JLabel("CVV (3 dígitos):"), txtCvv, gbc, 5);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        btnComprar = new JButton("Comprar Entradas");
        btnSalir = new JButton("Salir");
        
        btnComprar.setPreferredSize(new Dimension(140, 30));
        btnSalir.setPreferredSize(new Dimension(90, 30));

        panelBotones.add(btnComprar);
        panelBotones.add(btnSalir);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        this.add(panelPrincipal);
    }

    private void colocarComponente(JPanel panel, JLabel label, JComponent componente, GridBagConstraints gbc, int fila) {
        gbc.gridy = fila;
        gbc.gridx = 0;
        gbc.weightx = 0.3;
        panel.add(label, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(componente, gbc);
    }

    // Métodos de interacción expuestos al controlador
    public void addComprarListener(ActionListener listener) {
        btnComprar.addActionListener(listener);
    }

    public void addSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }

    public String getNombreZona() {
        return (String) comboZonas.getSelectedItem();
    }

    public String getCantidadInput() {
        return txtCantidad.getText().trim();
    }

    public String getNumTarjetaInput() {
        return txtNumTarjeta.getText().trim();
    }

    public String getTitularInput() {
        return txtTitular.getText().trim();
    }

    public String getVencimientoInput() {
        return txtVencimiento.getText().trim();
    }

    public String getCvvInput() {
        return new String(txtCvv.getPassword()).trim();
    }

    public void mostrarMensajeExitoso(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error en el Proceso", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiarFormulario() {
        comboZonas.setSelectedIndex(0);
        txtCantidad.setText("");
        txtNumTarjeta.setText("");
        txtTitular.setText("");
        txtVencimiento.setText("");
        txtCvv.setText("");
    }
}