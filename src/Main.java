import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Sistema de Gestion de Estudiantes
// Proyecto Final - Programacion III
// Programa sencillo de consola para practicar CRUD con archivos de texto

public class Main {

    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
    static String archivo = "estudiantes.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargarDatos();

        int opcion = -1;

        while (opcion != 6) {
            System.out.println("");
            System.out.println("===== SISTEMA DE GESTION DE ESTUDIANTES =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Editar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");

            // valido que lo que escriba sea un numero
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Eso no es un numero valido.");
                sc.next();
                opcion = -1;
                continue;
            }

            if (opcion == 1) {
                registrarEstudiante();
            } else if (opcion == 2) {
                listarEstudiantes();
            } else if (opcion == 3) {
                buscarEstudiante();
            } else if (opcion == 4) {
                editarEstudiante();
            } else if (opcion == 5) {
                eliminarEstudiante();
            } else if (opcion == 6) {
                guardarDatos();
                System.out.println("Datos guardados. Hasta luego!");
            } else {
                System.out.println("Opcion invalida, intenta de nuevo.");
            }
        }
    }

    public static void registrarEstudiante() {
        sc.nextLine(); // limpiar buffer
        System.out.print("ID: ");
        int id = leerEntero();
        sc.nextLine(); // limpiar el salto de linea que deja nextInt()

        // reviso que el id no este repetido
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == id) {
                System.out.println("Ya existe un estudiante con ese ID.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().equals("")) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        System.out.print("Edad: ");
        int edad = leerEntero();
        sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        Estudiante nuevo = new Estudiante(id, nombre, edad, carrera, correo);
        listaEstudiantes.add(nuevo);
        System.out.println("Estudiante registrado correctamente.");
    }

    public static void listarEstudiantes() {
        if (listaEstudiantes.size() == 0) {
            System.out.println("No hay estudiantes registrados todavia.");
            return;
        }
        System.out.println("--- Lista de estudiantes ---");
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            System.out.println(listaEstudiantes.get(i).toString());
        }
    }

    public static void buscarEstudiante() {
        sc.nextLine();
        System.out.print("Ingresa el ID a buscar: ");
        int id = leerEntero();

        Estudiante encontrado = null;
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == id) {
                encontrado = listaEstudiantes.get(i);
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun estudiante con ese ID.");
        } else {
            System.out.println(encontrado.toString());
        }
    }

    public static void editarEstudiante() {
        sc.nextLine();
        System.out.print("Ingresa el ID del estudiante a editar: ");
        int id = leerEntero();

        Estudiante encontrado = null;
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == id) {
                encontrado = listaEstudiantes.get(i);
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun estudiante con ese ID.");
            return;
        }

        sc.nextLine();
        System.out.print("Nuevo nombre (" + encontrado.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.trim().equals("")) {
            encontrado.setNombre(nombre);
        }

        System.out.print("Nueva edad (" + encontrado.getEdad() + "): ");
        String edadTexto = sc.nextLine();
        if (!edadTexto.trim().equals("")) {
            try {
                encontrado.setEdad(Integer.parseInt(edadTexto));
            } catch (NumberFormatException e) {
                System.out.println("Edad invalida, se deja la anterior.");
            }
        }

        System.out.print("Nueva carrera (" + encontrado.getCarrera() + "): ");
        String carrera = sc.nextLine();
        if (!carrera.trim().equals("")) {
            encontrado.setCarrera(carrera);
        }

        System.out.print("Nuevo correo (" + encontrado.getCorreo() + "): ");
        String correo = sc.nextLine();
        if (!correo.trim().equals("")) {
            encontrado.setCorreo(correo);
        }

        System.out.println("Estudiante actualizado.");
    }

    public static void eliminarEstudiante() {
        sc.nextLine();
        System.out.print("Ingresa el ID del estudiante a eliminar: ");
        int id = leerEntero();
        sc.nextLine(); // limpiar el salto de linea que deja nextInt()

        Estudiante encontrado = null;
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == id) {
                encontrado = listaEstudiantes.get(i);
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun estudiante con ese ID.");
            return;
        }

        System.out.print("Estas seguro que quieres eliminarlo? (si/no): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            listaEstudiantes.remove(encontrado);
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("Se cancelo la eliminacion.");
        }
    }

    // metodo para leer un numero entero de forma segura
    public static int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Eso no es un numero, intenta otra vez: ");
            sc.next();
        }
        int valor = sc.nextInt();
        return valor;
    }

    // guarda todos los estudiantes en el archivo de texto
    public static void guardarDatos() {
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listaEstudiantes.size(); i++) {
                bw.write(listaEstudiantes.get(i).aLinea());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Hubo un error guardando el archivo.");
        }
    }

    // carga los estudiantes guardados cuando inicia el programa
    public static void cargarDatos() {
        File f = new File(archivo);
        if (!f.exists()) {
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    int edad = Integer.parseInt(partes[2]);
                    String carrera = partes[3];
                    String correo = partes[4];
                    listaEstudiantes.add(new Estudiante(id, nombre, edad, carrera, correo));
                }
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de datos.");
        }
    }
}
