/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete3;

import paquete2.Persona;
import paquete2.PlanCelular;

/**
 *
 * @author nixon
 */
public class PlanPostPagoMinutosMegas extends PlanCelular {

    private int minutos;
    private double costoMinutos;
    private double megasEnGigas;
    private double costoGiga;

    public PlanPostPagoMinutosMegas(int minutos, double costoMinutos,
            double megasEnGigas, double costoGiga, Persona p, String c,
            String m, String md, int nc) {
        super(p, c, m, md, nc);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasEnGigas = megasEnGigas;
        this.costoGiga = costoGiga;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setCostoMinutos(double costoMinutos) {
        this.costoMinutos = costoMinutos;
    }

    public void setMegasEnGigas(double megasEnGigas) {
        this.megasEnGigas = megasEnGigas / 1024;
    }

    public void setCostoGiga(double costoGiga) {
        this.costoGiga = costoGiga;
    }

    public int getMinutos() {
        return minutos;
    }

    public double getCostoMinutos() {
        return costoMinutos;
    }

    public double getMegasEnGigas() {
        return megasEnGigas;
    }

    public double getCostoGiga() {
        return costoGiga;
    }

    @Override
    public void setPagoMensual() {
        pagoMensual = (minutos * costoMinutos) * (megasEnGigas * costoGiga);
    }

    @Override
    public String toString() {
        String cadena = String.format("%s"
                + "Megas en Gigas: %.2f\n"
                + "Costo por giga: %.2f\n"
                + "Minutos: %d\n"
                + "Costo por minuto: %.2f\n"
                + "Pago Mensual: %.2f\n",
                super.toString(),
                megasEnGigas,
                costoGiga,
                minutos,
                costoMinutos,
                getPagoMensual());
        return cadena;
    }
}
