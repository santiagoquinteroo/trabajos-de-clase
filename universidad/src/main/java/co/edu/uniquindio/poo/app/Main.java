package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Curso;

import javax.swing.*;

public class Main {

    static void main(){

        JOptionPane.showMessageDialog(null,"Bienvenidos el sistema de gestión academica");
        String nombreCurso = JOptionPane.showInputDialog(null,"Por favor ingresar el nombre del curso");
        String codigoCurso = JOptionPane.showInputDialog(null,"Por favor ingresar el código del curso");

        Curso curso= new Curso("Programación 1","001");

        int opcion;
        do {

            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"------MENÚ------ \n"+
                                                                "1. Agregar un estudiante \n"+
                                                                "2. \n"+
                                                                "3. \n"+
                                                                "4. \n"));

            switch (opcion){
                case 1:
                    crearEstudiante(curso);
                    break;

                default:JOptionPane.showMessageDialog(null,"Opción invalida");
            }

        }while (opcion!=5);{

        }

    }
    static void crearEstudiante(Curso curso){

        String nombres= JOptionPane.showInputDialog(null,"Por favor ingresar los nombres del estudiante");
        String apellidos= JOptionPane.showInputDialog(null, "Ingrese los apellidos del estudiante");
        String identificacion= JOptionPane.showInputDialog(null,"Ingrese la indentificación del estudiante");
        String edad = JOptionPane.showInputDialog(null, "Ingrese la edad del estudiante");
        byte edadEstudiante=Byte.parseByte(edad);
        String correo = JOptionPane.showInputDialog(null,"Ingrese el correo del estudiante");
        String telefono = JOptionPane.showInputDialog(null, "Ingrese el telefono del estudiante");

        String resultado=curso.registrarEstudiante(nombres,  apellidos,  identificacion,  edad,  correo,  telefono, curso);
    }


}
