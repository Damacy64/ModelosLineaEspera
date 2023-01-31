package lineaespera;

/**
 *
 * @author pzx64
 */
public class ModeloTA {
    double TasaLlegadas;
    double TasaServicios;
    double DesviacionE;
    
    public ModeloTA(double TLlegadas, double TServicios, double DE){
        this.TasaLlegadas = TLlegadas;
        this.TasaServicios = TServicios;
        this.DesviacionE = DE;
    }
    
    public void Calcular(){
        double po = 1-(TasaLlegadas/TasaServicios);
        System.out.println("Probabilidad de que no haya unidades en el sistema: " + po);
        
        double PLlegada = Math.pow(TasaLlegadas, 2);
        double PDE = Math.pow(DesviacionE, 2);
        double potencia = Math.pow(TasaLlegadas/TasaServicios, 2);
        
        double lq = ((PLlegada*PDE)+potencia)/(2*(1-(TasaLlegadas/TasaServicios)));
        System.out.println("Numero promedio de unidades en la linea de espera: " + lq);
        
        double l = lq + (TasaLlegadas/TasaServicios);
        System.out.println("Numero promedio de unidades en el sistema: " + l);
        
        double wq = lq/TasaLlegadas;
        System.out.println("Tiempo promedio que una unidad pasa en la linea de espera: " + wq);
        
        double w = wq + (1/TasaServicios);
        System.out.println("Tiempo promedio que una unidad pasa en el sistema: " + w);
        
        double pw = (TasaLlegadas/TasaServicios);
        System.out.println("Probabilidad de que una unidad que llega tenga que esperar a que la atiendan: " + pw);
    }
}
