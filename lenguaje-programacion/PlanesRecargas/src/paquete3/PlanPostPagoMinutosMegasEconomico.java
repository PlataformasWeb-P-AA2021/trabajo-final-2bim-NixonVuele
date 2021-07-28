/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete3;

import java.io.Serializable;
import paquete2.Persona;
import paquete2.PlanCelular;

/**
 *
 * @author nixon
 */
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular implements 
        Serializable {

    private int minutos;
    private double costoMinutos;
    private double megasEnGigas;
    private double costoGiga;
    private int porcentajeDescuento;

    public PlanPostPagoMinutosMegasEconomico(int mi, double cM,
            double mG, double cG, int pD,
            Persona p, String c, String m, String md, int nc) {
        super(p, c, m, md, nc);
        this.minutos = mi;
        this.costoMinutos = cM;
        this.megasEnGigas = mG;
        this.costoGiga = cG;
        this.porcentajeDescuento = pD;
    }

    public void setMinutos(int m) {
        this.minutos = m;
    }

    public void setCostoMinutos(double c) {
        this.costoMinutos = c;
    }

    public void setMegasEnGigas() {
        this.megasEnGigas = megasEnGigas / 1024;
    }

    public void setCostoGiga(double c) {
        this.costoGiga = c;
    }

    public void setPorcentajeDescuento(int p) {
        this.porcentajeDescuento = p;
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

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public void setPagoMensual() {
        double pago = ((minutos * costoMinutos) + (megasEnGigas * costoGiga));
        pagoMensual = pago - ((pago * porcentajeDescuento) / 100);
    }

    @Override
    public String toString() {
        String cadena = String.format("%s"
                + "Megas en Gigas: %.2f Gigas\n"
                + "Costo por giga: %.2f$\n"
                + "Minutos: %d\n"
                + "Costo por minuto: %.2f$\n"
                + "Porcentaje de descuento: %d\n%s"
                + "Pago Mensual: %.2f$\n",
                super.toString(),
                megasEnGigas,
                costoGiga,
                minutos,
                costoMinutos,
                porcentajeDescuento,
                "%",
                getPagoMensual());
        return cadena;
    }

    public void setMegasEnGigas(double gigas) {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
}
