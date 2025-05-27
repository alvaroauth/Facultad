
package Parciales.Parcial13;

public class PARCIAL13 {
    public static void main(String[] args) {
        Agenda age = new Agenda(5,6);
        
        Paciente pa1 = new Paciente("Alvaro",true,2500.00);
        Paciente pa2 = new Paciente("Lucía",false,2000.00);
        Paciente pa3 = new Paciente("Alvaro",true,2500.00);
        Paciente pa4 = new Paciente("Martina",false,3000.00);
        Paciente pa5 = new Paciente("Alvaro",true,1500.00);
        
        age.agregarPaciente(pa1, 1, 1);
        age.agregarPaciente(pa2, 2, 1);
        age.agregarPaciente(pa3, 3, 6);
        age.agregarPaciente(pa4, 2, 3);
        age.agregarPaciente(pa5, 5, 2);
        
        System.out.println(age.toString());
        
        if (age.pacienteAgendado(1, "Matias"))
            System.out.println("Alvaro esta agendado");
    }
}
