package co.edu.uniquindio.poo.empresa.model;

public class Empleado {
    private String user;
    private String password;
    private String nombre;
    private String apellido;
    private String idenficicacion;

    public Empleado(String user, String password, String nombre, String apellido, String idenficicacion) {
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idenficicacion = idenficicacion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdenficicacion() {
        return idenficicacion;
    }

    public void setIdenficicacion(String idenficicacion) {
        this.idenficicacion = idenficicacion;
    }
}
