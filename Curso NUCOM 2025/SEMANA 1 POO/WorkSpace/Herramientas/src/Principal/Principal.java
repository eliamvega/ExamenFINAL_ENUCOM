package Principal;

import com.mx.Implementacion.ImpHerramienta;
import com.mx.Implementacion.ImpRopa;

import Entidad.Herramienta;
import Entidad.Ropa;

public class Principal {

    public static void main(String[] args) {

        Ropa r1 = new Ropa("CAMIZA", "AMARILLO", 20, 355.54);
        Ropa r2 = new Ropa("SHORTS", "ROJA", 50, 15.75);
        Ropa r3 = new Ropa("PANTALON", "AMARILLO", 50, 15.75);

        // ImpRopa
        ImpRopa impR = new ImpRopa();

        // Guardar ropa con clave nombre
        impR.guardar(r1.getNombre(), r1);
        impR.guardar(r2.getNombre(), r2);
        impR.guardar(r3.getNombre(), r3);

        // Mostrar ropa
        impR.mostrar();

        // Buscar prenda
        Ropa auxR = (Ropa) impR.buscar("CAMIZA");
        System.out.println("PRENDA LOCALIZADA : " + auxR);

        // Eliminar prenda
        auxR = (Ropa) impR.buscar("PANTALON");
        if(auxR != null){
            impR.eliminar(auxR.getNombre());
            System.out.println("LA PRENDA HA SIDO ELIMINADA : " + auxR.getNombre());
        } else {
            System.out.println("Prenda no encontrada para eliminar.");
        }

        impR.contar();

        Herramienta h1 = new Herramienta(15, "MARTILLO", "TRUPPER", "CLAVAR CLAVOS", 15, 749.99);
        Herramienta h2 = new Herramienta(35, "MARTILLO ELECTRICO", "TRUPPER", "ROMPER CONCRETO", 15, 749.99);
        Herramienta h3 = new Herramienta(25, "PALA", "TRUPPER", "HACER HOYOS", 15, 749.99);

        // ImpHerramienta
        ImpHerramienta impH = new ImpHerramienta();

        // Guardar herramienta con clave código
        impH.guardar(h1.getCodigo(), h1);
        impH.guardar(h2.getCodigo(), h2);
        impH.guardar(h3.getCodigo(), h3);

        // Mostrar herramientas
        impH.mostrar();

        // Buscar herramienta por código
        Herramienta auxH = (Herramienta) impH.buscar(15);
        System.out.println("HERRAMIENTA LOCALIZADA : " + auxH);

        // Eliminar herramienta por código
        auxH = (Herramienta) impH.buscar(35);
        if(auxH != null){
            impH.eliminar(auxH.getCodigo());
            System.out.println("LA HERRAMIENTA HA SIDO ELIMINADA : " + auxH.getCodigo());
        } else {
            System.out.println("Herramienta no encontrada para eliminar.");
        }

        impH.contar();
        
        
        //editar
        
        auxH = (Herramienta) impH.buscar(15);
        auxH.setPrecio(450.25);
        System.out.println("se edito : " + auxH.getNombre());
        impH.mostrar();
    }
}
