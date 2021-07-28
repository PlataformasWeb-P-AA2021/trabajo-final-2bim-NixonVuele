package paquete1;

import java.io.IOException;
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
            System.out.print("Menú de Planes de Pago Mensual\n\n"
                    + "1. Plan Postpago Minutos\n"
                    + "2. Plan Postpago Megas\n"
                    + "3. Plan Postpago Minutos Megas\n"
                    + "4. Plan Postpago Minutos Megas economico\n"
                    + "5. Mostrar Registro\n"
                    + "Escoja una opción: ");
            int option = teclado.nextInt();

            if (option != 1 & option != 2 & option != 3 & option != 4
                    & option != 5) {
                boolean verdadero = false;
                while (verdadero == false) {
                    System.out.print("Por favor seleccione una opción valida "
                            + "dentro de nuestro menú: ");
                    option = teclado.nextInt();
                    if (option == 1 || option == 2 || option == 3 || option == 4
                            || option == 5) {
                        verdadero = true;
                    }
                }
            }
            if (option < 5) {
                teclado.nextLine();
                System.out.print("Ingrese su nombre: ");
                name = teclado.nextLine();
                System.out.print("Ingrese su apellido: ");
                apellido = teclado.nextLine();
                System.out.print("Ingrese su identificación: ");
                cedula = teclado.nextLine();
                System.out.print("Ingrese su ciudad de residencia: ");
                ciudad = teclado.nextLine();
                System.out.print("Ingrese la marca de su celular: ");
                marca = teclado.nextLine();
                System.out.print("Ingrese el modelo de su celular: ");
                modelo = teclado.nextLine();
                System.out.print("Ingrese su número  de celular: ");
                numero = teclado.nextInt();
            }
            Persona p1 = new Persona(name, apellido, cedula);
            switch (option) {

                case 1: {
                    System.out.print("Ingrese la cantidad de minutos en "
                            + "llamadas nacionales: ");
                    minNacionales = teclado.nextDouble();
                    System.out.print("Ingrese el costo de minutos en llamadas"
                            + " nacionales: ");
                    double costoNacionales = teclado.nextDouble();
                    System.out.print("Ingrese la cantidad de minutos en "
                            + "llamadas internacionales: ");
                    minInternacionales = teclado.nextDouble();
                    System.out.print("Ingrese el costo de minutos en llamadas"
                            + " internacionales: ");
                    double costoInternacional = teclado.nextDouble();

                    PlanPostPagoMinutos plan1 = new PlanPostPagoMinutos(p1,
                            ciudad, marca, modelo, numero, minNacionales,
                            costoNacionales, minInternacionales,
                            costoInternacional);
                    planes.add(plan1);
                    break;
                }

                case 2: {
                    System.out.print("Ingrese su consumo de megas en este "
                            + "mes: ");
                    gigas = teclado.nextDouble();
                    System.out.print("Ingrese el costo por Giga: ");
                    double costoGigas = teclado.nextDouble();
                    System.out.print("Ingrese la tarifa base: ");
                    double tarifaBase = teclado.nextDouble();
                    PlanPostPagoMegas plan2 = new PlanPostPagoMegas(p1, ciudad,
                            marca, modelo, numero, costoGigas, tarifaBase);
                    plan2.setMegasEnGb(gigas);
                    planes.add(plan2);
                    break;
                }

                case 3: {
                    System.out.print("Ingrese la cantidad de minutos usados: ");
                    int minutos = teclado.nextInt();
                    System.out.print("Ingrese el costo por minuto: ");
                    double costoMinutos = teclado.nextDouble();
                    System.out.print("Ingrese su consumo de megas en este "
                            + "mes: ");
                    gigas = teclado.nextDouble();
                    System.out.print("Ingrese el costo por Giga: ");
                    double costoGigas = teclado.nextDouble();
                    PlanPostPagoMinutosMegas plan3
                            = new PlanPostPagoMinutosMegas(minutos,
                                    costoMinutos, gigas, costoGigas, p1, ciudad,
                                    marca, modelo, numero);
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
                    System.out.print("Ingrese el costo por Giga: ");
                    double costoGigas = teclado.nextDouble();
                    System.out.print("Ingrese el porcentaje de descuento a "
                            + "realizar: ");
                    int descuento = teclado.nextInt();

                    PlanPostPagoMinutosMegasEconomico plan4
                            = new PlanPostPagoMinutosMegasEconomico(minutos,
                                    costoMinutos, gigas, costoGigas, descuento,
                                    p1, ciudad, marca, modelo, numero);
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
