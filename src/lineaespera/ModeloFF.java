package lineaespera;

import java.util.Scanner;

/**
 *
 * @author pzx64
 */
public class ModeloFF {
    double TasaLlegada;
    double TasaServicio;
    int TamanioPoblacion;

    public ModeloFF(double TasaLlegada, double TasaServicio, int TamanioPoblacion) {
        this.TasaLlegada = TasaLlegada;
        this.TasaServicio = TasaServicio;
        this.TamanioPoblacion = TamanioPoblacion;
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
        for (int i = 0; i <= TamanioPoblacion; i++) {
            res += (factorial(TamanioPoblacion) / factorial(TamanioPoblacion-i))*(Math.pow(TasaLlegada/TasaServicio, i));
        }
        return res;
    }
    
    public void Calcular(){
        double po = Math.pow(suma(), -1);
        System.out.println("Probabilidad de que no haya unidades en el sistema: " + po);
        
        double lq = TamanioPoblacion -(((TasaLlegada+TasaServicio)/TasaLlegada)*(1-po));
        System.out.println("Numero promedio de unidades en la linea de espera: " + lq);
        
        double l = lq + (1-po);
        System.out.println("Numero promedio de unidades en el sistema: " + l);
        
        double wq = lq/((TamanioPoblacion-l)*(TasaLlegada));
        System.out.println("Tiempo promedio que una unidad pasa en la linea de espera: " + wq);
        
        double w = wq + (1/TasaServicio);
        System.out.println("Tiempo promedio que una unidad pasa en el sistema: " + w);
        
        double pw = 1 - po;
        System.out.println("Probabilidad de que una unidad que llega tenga que esperar para que lo atiendan: " + pw);
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un numero, para calcular la probabilidad de que haya ese cantidad de unidades en el sistema:");
        int n = leer.nextInt();
        
        double pn = (factorial(TamanioPoblacion)/factorial(TamanioPoblacion-n))*(Math.pow(TasaLlegada/TasaServicio, n));
        System.out.println("Probabilidad de que haya " + n + " unidades en el sistema: " + pn);
    }
}
