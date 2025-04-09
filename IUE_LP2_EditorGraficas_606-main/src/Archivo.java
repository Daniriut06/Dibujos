import javax.swing.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

public class Archivo {

    // Metodo para mostrar una ventana que permita elegir un archivo mediante
    // exploracion
    public static String elegirArchivo() {
        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            return f.getAbsolutePath();
        } else {
            return "";
        }
    }

    // Método estático para abrir archivos planos
    public static BufferedReader abrirArchivo(String nombreArchivo) {
        File f = new File(nombreArchivo);
        // Existe el archivo?
        if (f.exists()) {
            /*
             * captura de error estructurada. Intenta realizar la instrucción de
             * apertura del archivo. Es susceptible de no poder realizarse
             */
            try {
                /*
                 * Apertura del archivo plano La clase BufferedReader permite
                 * manipular secuencia de caracteres. La clase File ofrece
                 * funcionalidad para operar con archivos
                 */
                FileReader fr = new FileReader(f);
                return new BufferedReader(fr);
            } catch (IOException e) {
                /*
                 * Sucedió un error que se captura mediante la clase IOException
                 * encargada de manipular errores de entrada y salida
                 */
                return null;
            }
        } else {
            return null;
        }
    }// abrirArchivo

    // Método estático para guardar archivos planos dado un conjunto de líneas
    public static boolean guardarArchivo(String nombreArchivo, String[] lineas) {
        if (lineas != null) {
            /*
             * captura de error estructurada. Intenta realizar la instrucción de
             * escritura del archivo. Es susceptible de no poder realizarse
             */
            try {
                // Abrir el archivo para escritura
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
                for (int i = 0; i < lineas.length; i++) {
                    // Guardar cada linea
                    bw.write(lineas[i]);
                    bw.newLine();
                }
                // Cerrar el archivo
                bw.close();
                return true;
            } catch (IOException e) {
                /*
                 * Sucedió un error que se captura mediante la clase IOException
                 * encargada de manipular errores de entrada y salida
                 */
                return false;
            }
        } else {
            return false;
        }
    }

    // Operaciones con archivos JSON
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static <T> T leerJson(String rutaArchivo, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(new File(rutaArchivo), typeReference);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return null;
    }

    // public static <T> boolean guardarJson(String rutaArchivo, T objeto) {
    public static boolean guardarJson(String rutaArchivo, Object objeto) {
        try {
            objectMapper.writeValue(new File(rutaArchivo), objeto);
            System.out.println("Datos guardados correctamente en " + rutaArchivo);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
        return false;
    }
}
