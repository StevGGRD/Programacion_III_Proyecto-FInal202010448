// Clase que representa un estudiante
// Aqui guardamos los datos basicos que pide el sistema

public class Estudiante {
    private int id;
    private String nombre;
    private int edad;
    private String carrera;
    private String correo;

    public Estudiante(int id, String nombre, int edad, String carrera, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // esto lo uso para guardar la info en el archivo de texto
    public String aLinea() {
        return id + ";" + nombre + ";" + edad + ";" + carrera + ";" + correo;
    }

    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad + " | Carrera: " + carrera + " | Correo: " + correo;
    }
}
