package lineaespera;

/**
 *
 * @author pzx64
 */
public class ModeloMC {

    double TasaLlegadas;
    double TasaServicios;
    int NumeroCanales;
    double aux;

    public ModeloMC(double llegadas, double servicios, int canales) {
        this.TasaLlegadas = llegadas;
        this.TasaServicios = servicios;
        this.NumeroCanales = canales;
        this.aux = TasaLlegadas / TasaServicios;
    }

    public int factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

    public double suma() {
        double res = 0;
        for (int i = 0; i <= NumeroCanales - 1; i++) {
            res += Math.pow(aux, i) / factorial(i);
        }
        return res;
    }

    public void Calcular() {
        double a = (Math.pow(aux, NumeroCanales) * (NumeroCanales * TasaServicios)) / ((factorial(NumeroCanales)) * (NumeroCanales * TasaServicios - TasaLlegadas));
        double b = suma() + a;
        double po = Math.pow(b, -1);
        System.out.println("Probabilidad de que no haya unidades en el sistema: " + po);

        double lq = ((Math.pow(aux, NumeroCanales) * (TasaLlegadas * TasaServicios)) / (factorial(NumeroCanales - 1) * Math.pow((NumeroCanales * TasaServicios) - TasaLlegadas, 2))) * po;
        System.out.println("Numero promedio de unidades en la linea de espera: " + lq);

        double l = lq + aux;
        System.out.println("Numero promedio de unidades en el sistema: " + l);

        double wq = lq / TasaLlegadas;
        System.out.println("Tiempo promedio que una unidad pasa en la linea de espera: " + wq);

        double w = wq + (1 / TasaServicios);
        System.out.println("Tiempo promedio que una unidad pasa en el sistema: " + w);

        double aux1 =  (double)1 / (double)(factorial(NumeroCanales));
        double aux2 = Math.pow(aux, NumeroCanales);
        double aux3 = (NumeroCanales * TasaServicios) / ((NumeroCanales * TasaServicios) - TasaLlegadas);
        double pw = aux1 * aux2 * aux3 * po;
        System.out.println("Probabilidad de que una unidad que llega tenga que esperar a que la atiendan: " + pw);

    }
}
