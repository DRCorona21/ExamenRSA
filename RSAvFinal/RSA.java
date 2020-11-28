//Se utulizara la clase big integer para el calculo de los primos grandes
package RSAvFinal;

import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class RSA {

    //Se crean las varaibles para el algoritmo
    int tamPrimo;
    BigInteger p, q, n;
    BigInteger phi;
    BigInteger e, d;

    String mensajeDescifrado;

    public String getMensajeDescifrado() {
        return mensajeDescifrado;
    }

    public void setMensajeDescifrado(String mensajeDescifrado) {
        this.mensajeDescifrado = mensajeDescifrado;
    }

    //Constructor
    public RSA(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    //Metodo que genera primos
    public void GenerarPrimos() {
        p = new BigInteger(tamPrimo, 10, new Random());
        do {
            q = new BigInteger(tamPrimo, 10, new Random());
        } while (q.compareTo(p) == 0);
    }

    //generamos las claves
    public void GenerarClaves() {
        //n  = p*q
        n = p.multiply(q);
        //phi = (p-1) * (q-1)
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));

        //Calcular el primo relativo o coprimo de e y menor que n
        do {
            e = new BigInteger(2 * tamPrimo, new Random());
        } //Calcular el MCD de e
        while ((e.compareTo(phi) != -1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));
        //calcular d
        d = e.modInverse(phi);
    }

    //Cifrar
    public BigInteger[] encritpar(String mensaje) {
        //Variables
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        //primero es recorrer el tamaño de bigdigitos para asignarlos al temp
        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        //necesito un biinteger para el cifrado
        BigInteger[] cifrado = new BigInteger[bigdigitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            //modulo de cifrados
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }

        return cifrado;
    }

    //descifrar
    public String descifrar(BigInteger[] cifrado) {
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        //dcescifrar
        for (int i = 0; i < descifrado.length; i++) {
            //aplico descifrado 
            descifrado[i] = cifrado[i].modPow(d, n);
        }

        //Lo tengo que colocar en un arreglo de caracteres para despues parsarlo a una cadena
        char[] charArray = new char[descifrado.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (descifrado[i].intValue());
        }

        return (new String(charArray));
    }

    //Pedir valores desde los formularios
    public RSA(BigInteger p, BigInteger q, BigInteger phi, BigInteger n, BigInteger e) {
        this.p = p;
        this.q = q;
        this.phi = phi;
        this.n = n;
        this.e = e;
    }

    public int getTamPrimo() {
        return tamPrimo;
    }

    public void setTamPrimo(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getPhi() {
        return phi;
    }

    public void setPhi(BigInteger phi) {
        this.phi = phi;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        d = e.modInverse(phi);
        return d;

    }

    public void setD(BigInteger d) {
        this.d = d;
    }

}
