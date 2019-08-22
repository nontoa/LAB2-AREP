package edu.escuelaing.arep.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Esta clase se encarga de las operaciones logicas.
 *
 * @author Nicolas Nontoa.
 */
public class App {

    public static void main(String[] args) {
    }

    /**
     * Este metodo se encarga de leer los datos y crear el linkedList
     * correspondiente.
     *
     * @param path Es la ruta para los archivos de prueba.
     * @return Retorna un LinkedList con las respuestas.
     * @throws FileNotFoundException Error al encontrar el archivo.
     * @throws IOException Error en Input/Output.
     */
    public static LinkedList<Double> read(String path) throws FileNotFoundException, IOException {
        /*String linea;
        LinkedList<Double> c1 = new LinkedList<Double>();
        while ((linea = br.readLine()) != null) {
            c1.add(Double.parseDouble(linea));
        }*/      
        LinkedList<Double> c1 = new LinkedList<Double>();
        String[] parts = path.split(" ");
        for(int x=0;x<parts.length;x++){
            c1.add(Double.parseDouble(parts[x]));
        }       
        ArrayList<Double> op = new ArrayList<Double>();
        op = operation(c1);
        LinkedList<Double> respuesta = new LinkedList<Double>();
        respuesta.add(op.get(0));
        respuesta.add(op.get(1));
        return respuesta;

    }

    /**
     * Este metodo se encarga de realizar las operaciones para hayar la media y
     * la desviacion estandar.
     *
     * @param c1 Es el LinkedList con los datos.
     * @return Retorna Un ArrayList con las respuestas.
     */
    public static ArrayList<Double> operation(LinkedList<Double> c1) {
        double promedio = 0;
        for (int x = 0; x < c1.size(); x++) {
            promedio += (c1.get(x));
        }
        double numerador1 = 0;
        double result1 = 0;
        for (int x = 0; x < c1.size(); x++) {
            numerador1 += Math.pow((c1.get(x) - (promedio / c1.size())), 2);

        }
        result1 = numerador1 / (c1.size() - 1);

        ArrayList<Double> ret = new ArrayList<Double>();
        ret.add(promedio / c1.size());
        ret.add(Math.sqrt(result1));
        return ret;

    }
}
