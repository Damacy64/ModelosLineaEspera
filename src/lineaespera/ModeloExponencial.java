package lineaespera;

/**
 *
 * @author pzx64
 */
public class ModeloExponencial {
    double TasaLlegadas;
    double TasaServicios;
    
    public ModeloExponencial(double TLlegadas, double TServicios){
        this.TasaLlegadas = TLlegadas;
        this.TasaServicios = TServicios;
    }
    
    public void Calcular(){
        double po = 1-(TasaLlegadas/TasaServicios);
        System.out.println("Probabilidad de que no haya unidades en el sistema: " + po);
        
        double potencia = Math.pow(TasaLlegadas, 2);
        double lq = potencia/(TasaServicios*(TasaServicios-TasaLlegadas));
        System.out.println("Numero promedio de clientes en la linea de espera: " + lq);
        
        double l = lq + (TasaLlegadas/TasaServicios);
        System.out.println("Numero promedio de clientes en el sistema: " + l);
        
        double wq = lq/TasaLlegadas;
        System.out.println("Tiempo promedio que un cliente pasa en la linea de espera: " + wq);
        
        double w = wq + (1/TasaServicios);
        System.out.println("Tiempo promedio que un cliente pasa en el sistema: " + w);
        
        double pw = TasaLlegadas/TasaServicios;
        System.out.println("Probabilidad de que un cliente que llega tenga que esperar: " + pw);
    }
}
