package paquete4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import paquete2.PlanCelular;

public class LecturaArchivoSecuencial {

    private ObjectInputStream entrada;
    private ArrayList<PlanCelular> planes;
    private String nombreArchivo;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String n) {
        this.nombreArchivo = n;
    }

    public ArrayList<PlanCelular> getListaPlanes() {
        return planes;
    }

    public void setListaPlanes() {
        planes = new ArrayList<>();
        File f = new File(getNombreArchivo());

        while (true) {
            try {

                Object registro = entrada.readObject();
                planes.add((PlanCelular)registro);
            } catch (EOFException endOfFileException) {
                return; // se llegó al fin del archivo

            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto: " + ex);
            } catch (Exception ex) {
                // System.err.println("No hay datos en el archivo: " + ex);
                break;
            }
        }
    }

    @Override
    public String toString() {

        String cadena = "Lista de Planes Moviles\n";
        for (int i = 0; i < getListaPlanes().size(); i++) {
            PlanCelular p = getListaPlanes().get(i);
            cadena = String.format("\n%s%d) %s  %s\n", cadena,
                    i + 1, p.getClass().getSimpleName(), p);
        }

        return cadena;
    }

    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    }
}
