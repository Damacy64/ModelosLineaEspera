package lineaespera;

/**
 *
 * @author pzx64
 */
public class ModeloCB {
    double TasaLlegadas;
    double TasaServicios;
    int NumeroCanales;
    double aux;
    int c;
    
    public ModeloCB(double llegadas, double servicios, int canales, int canal){
        this.TasaLlegadas = llegadas;
        this.TasaServicios = servicios;
        this.NumeroCanales = canales;
        this.aux = TasaLlegadas/TasaServicios;
        this.c = canal;
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
        for (int i = 0; i <= NumeroCanales; i++) {
            res += Math.pow(aux, i) / factorial(i);
        }
        return res;
    }
    
    public void Calcular(){
        double pj = (Math.pow(aux, c)/factorial(c))/suma();
        System.out.println("La probabilidad de que " + c + " de los " + NumeroCanales + " esten en uso y los usuaros sean bloqueados es de: " + pj);
    }
}
