package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private String codigo;
    private ArrayList<Estudiante> listaEstudiantes;



    public Curso(String nombre, String codigo){

        this.nombre = nombre;
        this.codigo = codigo;

        listaEstudiantes=new ArrayList<>();


    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public void setCodigo(String codigo){
        this.nombre = codigo;
    }

    public String getCodigo(){
        return codigo;
    }
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes){
        this.listaEstudiantes=listaEstudiantes;
    }
    public ArrayList<Estudiante> getListaEstudiantes(){
        return listaEstudiantes;
    }

    @Override
    public String toString() {
        return "curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    public String registrarEstudiante(String nombre, String apellidos, String identificación, byte edad,
                                      String correo, String telefono, Curso ownedByCurso, Nota[] listaNotas){
        String msg="";
        Estudiante buscado=buscarEstudiante(identificación);

        if(buscado !=null){
            msg+="Error el estudiante que usted desea registrar ya se encuentra registrado";
        }else{
            Estudiante estudianteNuevo=new Estudiante(nombre, apellidos, identificación, edad, correo, telefono,this);
                                                        listaEstudiantes.add(estudianteNuevo);
            msg+="Estudiante registrado con exito";
        }
        return msg;
    }

    public Estudiante buscarEstudiante(String identificacion){
        for(Estudiante aux : listaEstudiantes){

            if(aux.getIdentificación().equals(identificacion)){
                return aux;
            }
        }
        return null;
    }

    public boolean eliminarEstudiante(String identificacion) {
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if(estudianteEncontrado != null){
            listaEstudiantes.remove(estudianteEncontrado);
            return true;
        }
        return false;
    }

    public boolean actualizarEstudiante(String identificacionAntigua, String identificacionNueva,
                                        String nombresNuevos, String apellidosNuevos,
                                        byte edadEstudianteNueva, String correoNuevo, String telefonoNuevo) {
        Estudiante estudianteEncontrado = buscarEstudiante(identificacionAntigua);
        if(estudianteEncontrado != null){
            estudianteEncontrado.setApellidos(apellidosNuevos);
            estudianteEncontrado.setNombre(nombresNuevos);
            estudianteEncontrado.setIdentificacion(identificacionNueva);
            estudianteEncontrado.setEdad(edadEstudianteNueva);
            estudianteEncontrado.setCorreo(correoNuevo);
            estudianteEncontrado.setTelefono(telefonoNuevo);
            return true;
        }else return false;
    }

    public String registrarNotaEstudiante(String identificacion, String nombreNota, float valorNota) {

        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if(estudianteEncontrado != null){
            return estudianteEncontrado.registrarNota(nombreNota,valorNota);
        }else{
            return "El estudiante no esta registrado";
        }
    }

    public boolean verificarEstudianteNotaD5(){
        for (Estudiante aux : listaEstudiantes){
            if (aux.calcularNotaDefinitiva()==5){
                return true;
            }

        }
        return false;
    }

    public boolean verSiHayDosMariana(){
        for (Estudiante aux : listaEstudiantes){
            if (aux.getNombre().equalsIgnoreCase("Mariana")){
                return true;
            }
        }
        return false;
    }

    public double calcularNotaMayor(){
        double mayor=0;

        for (Estudiante aux : listaEstudiantes) {
            for (Nota notaAux : aux.getListaNotas()){
                if (notaAux!=null && notaAux.getValor()>mayor){
                    mayor=notaAux.getValor();
                }
            }
        }
        return mayor;
    }

    public double calcularNotaMenor(){
        double menor=5;

        for (Estudiante aux : listaEstudiantes){
            for (Nota notaAux : aux.getListaNotas()){
                if (notaAux!=null && notaAux.getValor()<menor){
                    menor=notaAux.getValor();
                }
            }
        }
        return menor;
    }

    public double promedioGrupal(){
        double suma=0;
        int cantidad=0;

        for (Estudiante aux:listaEstudiantes){
            for (Nota notaAux : aux.getListaNotas()){
                if (notaAux!=null){
                    suma+=notaAux.getValor();
                    cantidad++;
                }
            }
        }
        if (cantidad==0){
            return 0;
        }
        return suma/cantidad;
    }
    
    public void ordenarEstudiantesPorNombre(){
        for (int i = 0; i < listaEstudiantes.size() ; i++) {
            for (int j = 0; j < listaEstudiantes.size() ; j++) {
                Estudiante actual=listaEstudiantes.get(j);
                Estudiante siguiente=listaEstudiantes.get(j+1);

                if (actual.getNombre().compareToIgnoreCase(siguiente.getNombre())>0){
                    listaEstudiantes.set(j, siguiente);
                    listaEstudiantes.set(j+1, actual);
                }
            }
        }
    }

    public String estudianteConSyPromedioSuperiorA(){
        String msg="";

        for (Estudiante aux:listaEstudiantes){
            if (aux.getNombre()!=null && aux.getNombre().charAt(0)=='S' && aux.calcularNotaDefinitiva()>3.5){
                msg+=aux.getNombre()+" "+aux.getApellidos()+"\n"+"Con promedio: "+aux.calcularNotaDefinitiva()+"\n";
            }
        }
        return msg;
    }
}


