package paquete4;

import paquete4.LecturaArchivoSecuencial;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete2.PlanCelular;

public class EscrituraArchivoSecuencial {

    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private PlanCelular registro;
    private ArrayList<PlanCelular> lista;

    public EscrituraArchivoSecuencial(String nombreArc) {
        nombreArchivo = nombreArc;
        setLista(); // obtener los valores (objetos)
        // que tiene el archivo.
        // System.out.println(obtenerListaProfesores().size());
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (getLista().size() > 0) {
                for (int i = 0; i < getLista().size(); i++) {
                    setRegistro(getLista().get(i));
                    setSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo." + ioException);
        } // fin de catch
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String n) {
        this.nombreArchivo = n;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            System.err.println(ex);
        }
    }

    public PlanCelular getRegistro() {
        return registro;
    }

    public void setRegistro(PlanCelular r) {
        this.registro = r;
    }

    public ArrayList<PlanCelular> getLista() {
        return lista;
    }

    public void setLista() {
        LecturaArchivoSecuencial l
                = new LecturaArchivoSecuencial(getNombreArchivo());
        l.setListaPlanes();
        lista = l.getListaPlanes();
    }

    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        } // fin de catch
    }

}
