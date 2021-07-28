package paquete1;

import paquete4.EscrituraArchivoSecuencial;
import paquete4.LecturaArchivoSecuencial;
import java.util.ArrayList;
import paquete2.PlanCelular;
import paquete2.Persona;
import paquete3.PlanPostPagoMinutos;
import paquete3.*;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreArchivo = "planes.data";
        ArrayList<PlanCelular> planes = new ArrayList<>();

        String name = "";
        String apellido = "";
        String cedula = "";
        String ciudad = "";
        String marca = "";
        String modelo = "";
        double minNacionales = 0;
        double minInternacionales = 0;
        double gigas = 0;
        String seguir = "Si";
        int numero = 0;
        do {
            System.out.print("Menu de Planes de Pago Mensual\n\n"
                    + "1. Plan Postpago Minutos\n"
                    + "2. Plan Postpago Megas\n"
                    + "3. Plan Postpago MinutosMegas\n"
                    + "4. Plan Postpago MinutosMegas economico\n"
                    + "5. Mostrar Registro\n"
                    + "Escoja una opcion: ");
            int option = teclado.nextInt();
            if (option < 5) {
                teclado.nextLine();
                System.out.print("Ingrese su nombre: ");
                name = teclado.nextLine();
                System.out.print("Ingrese su apellido: ");
                apellido = teclado.nextLine();
                System.out.print("Ingrese su identificacion: ");
                cedula = teclado.nextLine();
                System.out.print("Ingrese su ciudad de residencia: ");
                ciudad = teclado.nextLine();
                System.out.print("Ingrese la marca de su celular: ");
                marca = teclado.nextLine();
                System.out.print("Ingrese el modelo de su celular: ");
                modelo = teclado.nextLine();
                System.out.print("Ingrese su numero de celular: ");
                numero = teclado.nextInt();
                teclado.nextLine();

            }
            Persona p1 = new Persona(name, apellido, cedula);
            switch (option) {

                case 1: {
                    System.out.print("Ingrese la cantidad de minutos en llamadas"
                            + " nacionales: ");
                    minNacionales = teclado.nextDouble();
                    System.out.print("Ingrese la cantidad de minutos en llamadas"
                            + " internacionacionales: ");
                    minInternacionales = teclado.nextDouble();
                    PlanPostPagoMinutos plan1 = new PlanPostPagoMinutos(p1, ciudad,
                            marca, modelo, numero, minNacionales, 0.15,
                            minInternacionales, 0.40);
                    planes.add(plan1);
                    break;
                }

                case 2: {
                    System.out.print("Ingrese su consumo de megas en este "
                            + "mes: ");
                    gigas = teclado.nextDouble();
                    PlanPostPagoMegas plan2 = new PlanPostPagoMegas(p1, ciudad,
                            marca, modelo, numero, 2.50, 6.00);
                    plan2.setMegasEnGb(gigas);
                    planes.add(plan2);
                    break;
                }

                case 3: {
                    System.out.print("Ingrese la cantidad de minutos usados:");
                    int minutos = teclado.nextInt();
                    System.out.print("Ingrese el costo por minuto:");
                    double costoMinutos = teclado.nextDouble();
                    System.out.print("Ingrese su consumo de megas en este "
                            + "mes: ");
                    gigas = teclado.nextDouble();
                    PlanPostPagoMinutosMegas plan3
                            = new PlanPostPagoMinutosMegas(minutos, costoMinutos,
                                    gigas, 0.20, p1, ciudad, marca, modelo, numero);
                    plan3.setMegasEnGigas(gigas);
                    planes.add(plan3);
                    break;
                }

                case 4: {
                    System.out.print("Ingrese la cantidad de minutos usados: ");
                    int minutos = teclado.nextInt();
                    System.out.print("Ingrese el costo por minuto: ");
                    double costoMinutos = teclado.nextDouble();
                    System.out.print("Ingrese su consumo de megas en este "
                            + "mes: ");
                    gigas = teclado.nextDouble();
                    PlanPostPagoMinutosMegasEconomico plan4
                            = new PlanPostPagoMinutosMegasEconomico(minutos,
                                    costoMinutos, gigas, 0.20, 12, p1, ciudad,
                                    marca, modelo, numero);
                    plan4.setMegasEnGigas(gigas);
                    planes.add(plan4);
                    break;

                }
                case 5: {
                    LecturaArchivoSecuencial lectura
                            = new LecturaArchivoSecuencial(nombreArchivo);
                    lectura.setListaPlanes();
                    System.out.println(lectura);

                    break;
                }

            }
            EscrituraArchivoSecuencial archivo
                    = new EscrituraArchivoSecuencial(nombreArchivo);
            for (int i = 0; i < planes.size(); i++) {
                planes.get(i).setPagoMensual();
                // establecer el valor del atributo registro
                archivo.setRegistro(planes.get(i));
                // establecer en el archivo el atributo del registro
                archivo.setSalida();
            }
            archivo.cerrarArchivo();
            teclado.nextLine();
            System.out.println("\nSi desea continuar presione Si caso contrario"
                    + " No");
            seguir = teclado.nextLine();
        } while (seguir.equals("Si"));

    }//Fin del Metodo Main

}
