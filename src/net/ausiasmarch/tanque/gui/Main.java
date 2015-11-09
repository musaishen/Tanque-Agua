/*
 * Main.java
 */
package net.ausiasmarch.tanque.gui;

import net.ausiasmarch.tanque.modelo.*;
import net.ausiasmarch.common.Convert;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Administrador
 */
public class Main extends javax.swing.JFrame {

    private final ControlRiego controlRiego;
    String mensaje;

    public Main() {
        initComponents();

        /*Crear controlRiego y asignarle el estado del tanque */
        controlRiego = new ControlRiego(tanque.getEstado());

        setSize(580, 450);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLlenarMedio = new javax.swing.JButton();
        jButtonVaciarMedio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNivelSequia = new javax.swing.JTextField();
        jTextFieldNivelHumedad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanque = new net.ausiasmarch.tanque.modelo.Tanque();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tanque de agua");
        setResizable(false);

        jButtonLlenarMedio.setText("Llenar Medio");
        jButtonLlenarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLlenarMedioActionPerformed(evt);
            }
        });

        jButtonVaciarMedio.setText("Vaciar Medio");
        jButtonVaciarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaciarMedioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nivel de sequ�a [0-10]:");

        jTextFieldNivelSequia.setText("5");
        jTextFieldNivelSequia.setName("Sequ�a"); // NOI18N

        jTextFieldNivelHumedad.setText("5");
        jTextFieldNivelHumedad.setName("Humedad"); // NOI18N

        jLabel2.setText("Nivel de humedad del suelo [0-10]:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNivelSequia)
                            .addComponent(jTextFieldNivelHumedad))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLlenarMedio)
                            .addComponent(jButtonVaciarMedio))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNivelSequia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonLlenarMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNivelHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVaciarMedio))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonLlenarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLlenarMedioActionPerformed
        int sequia;

        if (!Convert.isValidInt(jTextFieldNivelSequia.getText())) {
            mensaje("Nivel de sequ�a no es un n�mero v�lido");
        }

        sequia = Convert.parseInt(jTextFieldNivelSequia.getText());

        controlRiego.setSequia(sequia);

        if (controlRiego.permitidoLlenar() > 0) {
            mensaje(controlRiego.getMensaje());
            return;
        }

        tanque.llenarMedio();
        controlRiego.setEstado(tanque.getEstado());


    }//GEN-LAST:event_jButtonLlenarMedioActionPerformed

    private void jButtonVaciarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVaciarMedioActionPerformed
        int humedad;

        if (!Convert.isValidInt(jTextFieldNivelHumedad.getText())) {
            mensaje("Nivel de humedad no es un n�mero v�lido");
        }

        humedad = Convert.parseInt(jTextFieldNivelHumedad.getText());

        controlRiego.setHumedad(humedad);

        if (controlRiego.permitidoVaciar() > 0) {
            mensaje(controlRiego.getMensaje());
            return;

        }

        tanque.vaciarMedio();
        controlRiego.setEstado(tanque.getEstado());

    }//GEN-LAST:event_jButtonVaciarMedioActionPerformed

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            String look = UIManager.getSystemLookAndFeelClassName();
            javax.swing.UIManager.setLookAndFeel(look);

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(("Nimbus"))) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLlenarMedio;
    private javax.swing.JButton jButtonVaciarMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNivelHumedad;
    private javax.swing.JTextField jTextFieldNivelSequia;
    private net.ausiasmarch.tanque.modelo.Tanque tanque;
    // End of variables declaration//GEN-END:variables
}
