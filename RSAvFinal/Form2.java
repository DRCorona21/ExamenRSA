package RSAvFinal;

import java.util.Observable;
import java.util.Observer;
import java.lang.String;
import java.math.BigInteger;

public class Form2 extends javax.swing.JFrame implements Observer {

    String descifrado = null;
    String StrD = null;

    public Form2() {
        initComponents();
        this.getRootPane().setDefaultButton(this.Descifrar);
        Servidor s = new Servidor(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();

        //Set los txtfields
        this.mensajeCifrado.setLineWrap(true);
        this.mensajeDescifrado.setLineWrap(true);
        this.mensajeCifrado.setEditable(false);
        this.mensajeDescifrado.setEditable(false);
        this.p.setEditable(false);
        this.q.setEditable(false);
        this.phi.setEditable(false);
        this.n.setEditable(false);
        this.d.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Descifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensajeDescifrado = new javax.swing.JTextArea();
        p = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        phi = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajeCifrado = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA KARLA");
        setMinimumSize(new java.awt.Dimension(790, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        Descifrar.setText("Descifrar");
        Descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescifrarActionPerformed(evt);
            }
        });
        getContentPane().add(Descifrar);
        Descifrar.setBounds(673, 433, 100, 32);

        mensajeDescifrado.setColumns(20);
        mensajeDescifrado.setRows(5);
        jScrollPane1.setViewportView(mensajeDescifrado);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 159, 738, 41);

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        getContentPane().add(p);
        p.setBounds(10, 238, 607, 30);
        getContentPane().add(q);
        q.setBounds(10, 288, 607, 30);
        getContentPane().add(d);
        d.setBounds(10, 436, 607, 30);
        getContentPane().add(phi);
        phi.setBounds(10, 334, 607, 30);
        getContentPane().add(n);
        n.setBounds(10, 385, 607, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mensaje Cifrado:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 24, 170, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mensaje Descifrado:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 139, 160, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor q:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 218, 150, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor p:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 270, 140, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor Phi:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 320, 210, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor d:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 416, 250, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor n:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 365, 180, 16);

        mensajeCifrado.setColumns(20);
        mensajeCifrado.setRows(5);
        jScrollPane2.setViewportView(mensajeCifrado);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 44, 738, 77);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RSAvFinal/ZeroTwo.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 860, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescifrarActionPerformed

        //Datos de rsa.descifrar
        this.mensajeDescifrado.setText(descifrado);
        this.d.setText(StrD);

    }//GEN-LAST:event_DescifrarActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed

    }//GEN-LAST:event_pActionPerformed

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
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Descifrar;
    private javax.swing.JTextField d;
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
    private javax.swing.JTextArea mensajeCifrado;
    private javax.swing.JTextArea mensajeDescifrado;
    private javax.swing.JTextField n;
    private javax.swing.JTextField p;
    private javax.swing.JTextField phi;
    private javax.swing.JTextField q;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Las variables son:" + (String) arg);
        String t = (String) arg;
        
        //Metodo para separar las variables necesarias para descifrar
        String[] parts = t.split("-");
        String msjCifrado = parts[0];
        String pp = parts[1];
        String qq = parts[2];
        String phip = parts[3];
        String nn = parts[4];
        String ee = parts[5];
        
        //Se ocupa el metodo de stringToBigIntegerArray  
        BigInteger[] BigCifrados = stringToBigIntegerArray(msjCifrado);
        System.out.println("Etiqueta usada para el cifrado (Funcion de java) = " + BigCifrados);
        
        //Set los BigInteger de la cadena String
        BigInteger p = new BigInteger(pp);
        BigInteger q = new BigInteger(qq);
        BigInteger phi = new BigInteger(phip);
        BigInteger n = new BigInteger(nn);
        BigInteger e = new BigInteger(ee);
        
        //Las variables necesesarias para descifrar se mandan a la clase RSA
        try {
            RSA rsa = new RSA(p, q, phi, n, e);
            System.out.println("D: " + rsa.getD());
            System.out.println("Mensaje descifrado: " + rsa.descifrar(BigCifrados));
            this.descifrado = rsa.descifrar(BigCifrados);
            this.StrD = rsa.getD().toString();
        } catch (Exception er) {
            System.out.println("Error: " + er.getMessage());
        }

        //Set de txtfields
        this.mensajeCifrado.setText(msjCifrado);
        System.out.println(msjCifrado);
        this.p.setText(pp);
        this.q.setText(qq);
        this.phi.setText(phip);
        this.n.setText(nn);
        this.mensajeDescifrado.setText("");

    }
    
    //Metodo para convertir una cadena String a un arreglo de BigInteger (beta 1.2)
    public static BigInteger[] stringToBigIntegerArray(String cadena) {
        String[] partes = cadena.split(",");
        BigInteger[] coleccion = new BigInteger[partes.length];
        if (partes != null && partes.length > 0) {
            for (int i = 0; i < partes.length; i++) {
                coleccion[i] = new BigInteger(partes[i]);
            }
        }
        return coleccion;
    }
}
