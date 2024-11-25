/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package microprotecto_1;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
//import net.sourceforge.jFuzzyLogic.rule.Rule;
//import net.sourceforge.jFuzzyLogic.rule.Variable;
public class Microprotecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Carga el archivo de lenguaje de control difuso 'FCL'
        String fileName = "src/microprotecto_1/Asignacion_recursos.fcl";
        FIS fis = FIS.load(fileName, true);

        if (fis == null) {
            System.err.println("No se puede cargar el archivo: '" + fileName + "'");
            return;
        }

        fis.setVariable("Precipitacion", 100);
        fis.setVariable("Temperatura", 24);
        fis.setVariable("DemandaAgua", 10);
        fis.setVariable("NivelReservas", 50);

        fis.evaluate();

        JFuzzyChart.get().chart(fis.getFunctionBlock("AsignacionRecursos"));

        double asignacion = fis.getVariable("Asignacion").getLatestDefuzzifiedValue();
        System.out.println("Para los valores de entrada, la Asignación sugerida es: " + asignacion + "%");

        double costo = fis.getVariable("Costo").getLatestDefuzzifiedValue();
        System.out.println("Para los valores de entrada, el Costo sugerido es: " + costo + " kWh");
        
        /*
        // Muestra las reglas y el valor de salida de cada una despues de aplicar las operaciones lógicas
        fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules().forEach(r -> {
            System.out.println(r);
        });
        System.out.println();
        */
        
        /*
        // Muestra el grado de pertenencia de la variable de salida a cada CD
        double pertenenciaBaja = fis.getVariable("propina").getMembership("baja");
        double pertenenciaPromedio = fis.getVariable("propina").getMembership("promedio");
        double pertenenciaGenerosa = fis.getVariable("propina").getMembership("generosa");
        
        System.out.println("La propina es baja con grado de pertenencia " + pertenenciaBaja);
        System.out.println("La propina es promedio con grado de pertenencia " + pertenenciaPromedio);
        System.out.println("La propina es generosa con grado de pertenencia " + pertenenciaGenerosa);
        */

    }
    
}
