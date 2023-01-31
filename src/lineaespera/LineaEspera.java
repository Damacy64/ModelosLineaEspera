package lineaespera;

import java.util.Scanner;

/**
 *
 * @author pzx64
 */
public class LineaEspera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("Elija una opcion:\n1.Modelo Exponencial\n2.Modelo Tiempos Arbitrarios\n3.Modelo Exponencial de Multiples Canales"
                + "\n4.Modelo M/G/K con clientes bloqueados\n5.Modelo con fuentes finitas\n6.Salir");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese Tasa de llegadas:");
                double llegadas = leer.nextDouble();
                System.out.println("Ingrese Tasa de servicios:");
                double servicio = leer.nextDouble();
                ModeloExponencial me = new ModeloExponencial(llegadas, servicio);
                me.Calcular();
                break;
            case 2:
                System.out.println("Ingrese Tasa de llegadas:");
                llegadas = leer.nextDouble();
                System.out.println("Ingrese Tasa de servicios:");
                servicio = leer.nextDouble();
                System.out.println("Ingrese la Desviacion Estandar:");
                double desviacion = leer.nextDouble();
                ModeloTA modelo = new ModeloTA(llegadas, servicio, desviacion);
                modelo.Calcular();
                break;
            case 3:
                System.out.println("Ingrese Tasa de llegadas: ");
                llegadas = leer.nextDouble();
                System.out.println("Ingrese Tasa de servicios: ");
                servicio = leer.nextDouble();
                System.out.println("Ingrese Cantidad de canales: ");
                int canales = leer.nextInt();
                ModeloMC mc = new ModeloMC(llegadas, servicio, canales);
                mc.Calcular();
                break;
            case 4:
                System.out.println("Ingrese Tasa de llegadas; ");
                llegadas = leer.nextDouble();
                System.out.println("Ingrese Tasa de servicios: ");
                servicio = leer.nextDouble();
                System.out.println("Ingrese Cantidad de canales: ");
                canales = leer.nextInt();
                System.out.println("Ingrese el canal al que quiere sacar la probabilidad: ");
                int canal = leer.nextInt();
                ModeloCB mcb = new ModeloCB(llegadas, servicio, canales, canal);
                mcb.Calcular();
                break;
            case 5:
                System.out.println("Ingrese Tasa de llegadas; ");
                llegadas = leer.nextDouble();
                System.out.println("Ingrese Tasa de servicios: ");
                servicio = leer.nextDouble();
                System.out.println("Ingrese Tamaño de la poblacion: ");
                int tamanio = leer.nextInt();
                ModeloFF mff = new ModeloFF(llegadas, servicio, tamanio);
                mff.Calcular();
                break;
            default:
                System.out.println("Error en la opcion");
                opcion = 6;
                break;
        }
    }
}
