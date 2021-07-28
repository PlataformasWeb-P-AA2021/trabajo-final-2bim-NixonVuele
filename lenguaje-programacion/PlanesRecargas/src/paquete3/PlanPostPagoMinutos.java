package paquete3;

import java.io.Serializable;
import paquete2.Persona;
import paquete2.PlanCelular;

public class PlanPostPagoMinutos extends PlanCelular implements Serializable {

    private double minNacionales;
    private double costoMinNacional;
    private double minInternacional;
    private double costoMinInternacional;

    public PlanPostPagoMinutos(Persona n, String c, String m, String md,
            int nc, double mn, double cmn, double mi, double cmi) {
        super(n, c, m, md, nc);
        minNacionales = mn;
        costoMinNacional = cmn;
        minInternacional = mi;
        costoMinInternacional = cmi;

    }

    @Override
    public void setPagoMensual() {
        pagoMensual = (costoMinInternacional * minInternacional)
                + (costoMinNacional * minNacionales);
    }

    public double getMinNacionales() {
        return minNacionales;
    }

    public void setMinNacionales(double m) {
        this.minNacionales = m;
    }

    public double getCostoMinNacional() {
        return costoMinNacional;
    }

    public void setCostoMinNacional(double c) {
        this.costoMinNacional = c;
    }

    public double getMinInternacional() {
        return minInternacional;
    }

    public void setMinInternacional(double m) {
        this.minInternacional = m;
    }

    public double getCostoMinInternacional() {
        return costoMinInternacional;
    }

    public void setCostoMinInternacional(double c) {
        this.costoMinInternacional = c;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s"
                + "Minutos nacionales: %.2f minutos\n"
                + "Costo Minuto Nacional: %.2f$\n"
                + "Minutos internacionales: %.2f minutos\n"
                + "Costo Minuto Internacional: %.2f$\n"
                + "Pago mensual: %.2f$\n",
                super.toString(),
                minNacionales,
                costoMinNacional,
                minInternacional,
                costoMinInternacional,
                getPagoMensual());
        return cadena;
    }

}
