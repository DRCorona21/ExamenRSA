package RSAvFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;

    }
    
    //Se establece la conexion con la otra computadora
    @Override
    public void run() {
        
        //Se establece la conexion a travez de la ip publica
        final String HOST = "x.x.x.x";
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, puerto);

            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

            sc.close();

        } catch (Exception e) {
        }
    }
}
