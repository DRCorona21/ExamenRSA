package RSAvFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {

    private int puerto;
    private String m;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }
    
    //Establecemos el servidor
    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            while (true) {
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Cliente desconectado por un error");
        }
        System.out.println("Cliente desconectado");
    }

}
