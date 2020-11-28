package RSAvFinal;

import java.math.BigInteger;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class Form1 extends javax.swing.JFrame {

    public Form1() {
        initComponents();
        this.getRootPane().setDefaultButton(this.btnEnviar);
        Servidor s = new Servidor(5000);
        Thread t = new Thread(s);
        t.start();

        this.mensaje.setLineWrap(true);
        
        this.p.setEditable(false);
        this.q.setEditable(false);
        this.phi.setEditable(false);
        this.n.setEditable(false);
        this.e.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        tamPrimo = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        e = new javax.swing.JTextField();
        phi = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA DIEGO");
        setMinimumSize(new java.awt.Dimension(800, 575));
        setResizable(false);
        getContentPane().setLayout(null);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar);
        btnEnviar.setBounds(595, 29, 124, 32);

        tamPrimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamPrimoActionPerformed(evt);
            }
        });
        getContentPane().add(tamPrimo);
        tamPrimo.setBounds(18, 30, 280, 40);

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        getContentPane().add(p);
        p.setBounds(18, 257, 748, 40);
        getContentPane().add(q);
        q.setBounds(18, 324, 748, 40);
        getContentPane().add(e);
        e.setBounds(20, 500, 748, 20);
        getContentPane().add(phi);
        phi.setBounds(18, 382, 748, 30);

        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });
        getContentPane().add(n);
        n.setBounds(18, 438, 748, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tamaño del primo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(18, 12, 154, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mensaje:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(18, 77, 272, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor p:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(18, 237, 124, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor q:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(18, 304, 102, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor e:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(18, 476, 103, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor Phi:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(18, 362, 143, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor n:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(18, 418, 108, 16);

        mensaje.setColumns(20);
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(18, 97, 748, 113);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RSAvFinal/ZeroTwo.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-50, 0, 980, 920);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        int tamPrimito;
        String tamPrimo = this.tamPrimo.getText();
        try {
            tamPrimito = Integer.parseInt(tamPrimo);
        } catch (Exception e) {
            tamPrimito = 0;
        }

        if (tamPrimo != null && tamPrimito > 10 /*&& tamPrimito < 100*/) {
            RSA rsa = new RSA(tamPrimito);
            rsa.GenerarPrimos();
            rsa.GenerarClaves();

            String mensajeClaro = this.mensaje.getText();
            if (mensajeClaro != null && mensajeClaro.length() > 0) {
                BigInteger[] cifrado = rsa.encritpar(mensajeClaro);
                String CifradoStrin = bigIntegerArrayToString(cifrado);
                System.out.println("Biginteger: " + CifradoStrin);

                String msjClaro = rsa.descifrar(cifrado);
                rsa.setMensajeDescifrado(msjClaro);

                String p = rsa.getP().toString();
                String q = rsa.getQ().toString();
                String phi = rsa.getPhi().toString();
                String n = rsa.getN().toString();
                String e = rsa.getE().toString();
                String d = rsa.getD().toString();

                this.p.setText(p);
                this.q.setText(q);
                this.phi.setText(phi);
                this.n.setText(n);
                this.e.setText(e);

                String superCadena = CifradoStrin + "-" + p + "-" + q + "-" + phi + "-" + n + "-" + e;
                System.out.println("Etiqueta cifrado = " + cifrado);

                Cliente c = new Cliente(6000, superCadena);
                Thread t = new Thread(c);

                t.start();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un mensaje para poder enviarlo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el tamaño del primo numerico valido.");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    //Metodo para convertir de arreglo de BigInteger to String
    public static String bigIntegerArrayToString(BigInteger[] arregloBigInt) {
        StringBuilder strBigInteger = new StringBuilder("");
        if (arregloBigInt != null && arregloBigInt.length > 0) {
            for (int i = 0; i < arregloBigInt.length; i++) {
                strBigInteger.append(arregloBigInt[i].toString());
                if (i != arregloBigInt.length - 1) {
                    strBigInteger.append(",");
                }
            }
        }
        return strBigInteger.toString();
    }

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pActionPerformed

    private void tamPrimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamPrimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamPrimoActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTextField e;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextField n;
    private javax.swing.JTextField p;
    private javax.swing.JTextField phi;
    private javax.swing.JTextField q;
    private javax.swing.JTextField tamPrimo;
    // End of variables declaration//GEN-END:variables

}
