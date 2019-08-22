package edu.escuelaing.arep;

/**
 * Hello world!
 *
 */
import static spark.Spark.*;
import edu.escuelaing.arep.ASE.app.*;
import java.io.IOException;
import spark.Request;
import spark.Response;

public class SparkWebApp {

    public LinkedList<Double> lista = new LinkedList<Double>();
    public static Double media = 0.0;
    public static Double desviacion = 0.0;    

    public static void main(String[] args) {
        port(getPort());
        //get("/hello", (req, res) -> "Hello Heroku");
        get("/index", (req, res) -> indexPage(req, res));
        get("/calculos", (req, res) -> calculosPage(req, res));
        get("/respuesta", (req, res) -> logicaPage(req, res));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e.on localhost)
    }

    private static String indexPage(Request req, Response res) {
        String indexHTML = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "   \n"
                + "   <head>\n"
                + "      <title>Calculadora Estadistica</title>\n"
                + "   </head>\n"
                + "	\n"
                + "   <body>\n"
                + "<center>"
                + "      <h2>Calculadora de media y desviación estandar</h2>\n"
                + "      <p>Aplicación Web para calcular la media y la desviacion estandar de un conjunto de datos dados por el usuario.\n\n</p>\n"
                + "      <p>\n\nClick en el link para ir a la calculadora</p>\n"
                + "      <a href = \"/calculos\" target = \"_self\">Calculadora</a>\n"
                + "</center>"
                + "   </body>\n"
                + "	\n"
                + "</html>";
        return indexHTML;
    }

    private static String calculosPage(Request req, Response res) throws IOException {

        String calculosHtml = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "   \n"
                + "   <head>\n"
                + "      <title>Calculadora</title>\n"
                + "   </head>\n"
                + "	\n"
                + "<body>"
                + "<center>"
                + "      <h2>Ingrese los datos</h2>\n"
                + "      <p>Ingrese los numeros separados por espacios en blanco.</p>\n"
                + "       <form>"
                + "           Conjunto de numeros:<br>\n"
                + "           <input type=\"text\" placeholder=\"Numeros\" name=\"inputData\" ><br>\n"
                //+ "           <input type=\"submit\" value=\"Calcular\">\n"
                + "      <a href = \"/respuesta\" target = \"_self\">Ver Respuesta</a>\n"
                + "       </form>\n"
                + "</center>\n"
                + "</body>\n"
                + "</html>";        
        return calculosHtml;
    }

    private static String logicaPage(Request req, Response res) throws IOException {        
        String num = req.queryParams("inputData");
        System.out.println(num);
        LinkedList<Double> respuesta = new LinkedList<Double>();
        App aplicacion = new App();
        respuesta = aplicacion.read(num);
        media = respuesta.get(0);
        desviacion = respuesta.get(1);
        System.out.println(media);
        System.out.println(desviacion);
        String c = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<title> Resultados </title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<center>\n"
                + "<h1> Resultados </h1>\n"
                + "<p> Los resultados son:</p> <br>\n"
                + "<p> Media: " + media + "</p>\n"
                + "<p> Desviacion: " + desviacion + "</p> <br>\n"
                + "<a href = \"/calculos\" target = \"_self\">Volver a la calculadora</a>\n"
                + "</center>\n"
                + "</body>\n"
                + "</html>";
        return c;
    }
}
