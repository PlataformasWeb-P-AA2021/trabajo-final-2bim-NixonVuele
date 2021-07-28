package paquete3;

import java.io.Serializable;
import paquete2.Persona;
import paquete2.PlanCelular;

public class PlanPostPagoMegas extends PlanCelular implements Serializable{

    private double megasEnGb;
    private double costoGb;
    private double tarifaBase;

    public PlanPostPagoMegas(Persona p, String c, String m, String md, int nc,
            double cgb, double tb) {
        super(p, c, m, md, nc);
        costoGb = cgb;
        tarifaBase = tb;
    }

    @Override
    public void setPagoMensual() {
        pagoMensual = tarifaBase + (megasEnGb * costoGb);
    }

    public double getMegasEnGb() {
        return megasEnGb;
    }

    public void setMegasEnGb(double m) {
        this.megasEnGb = m / 1024;
    }

    public double getCostoGb() {
        return costoGb;
    }

    public void setCostoGb(double c) {
        this.costoGb = c;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double t) {
        this.tarifaBase = t;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s"
                + "Megas en Gigas: %.2f\n"
                + "Costo por giga: %.2f\n"
                + "Tarifa Base: %.2f\n"
                + "Pago Mensual: %.2f\n",
                super.toString(),
                megasEnGb,
                costoGb,
                tarifaBase,
                getPagoMensual());
        return cadena;
    }

}
