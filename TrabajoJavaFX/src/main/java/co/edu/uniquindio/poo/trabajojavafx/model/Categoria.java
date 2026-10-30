package co.edu.uniquindio.poo.trabajojavafx.model;

public enum Categoria {
    NOVELA("Novela"),CIENCIA("Ciencia"),TECNOLOGIA("Tecnología"),HISTORIA("Historia"),INFANTIL("Infantil");

    private final String etiqueta;

    Categoria(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "etiqueta='" + etiqueta + '\'' +
                '}';
    }
}
