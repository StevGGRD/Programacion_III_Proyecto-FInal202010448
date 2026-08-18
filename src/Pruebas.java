import java.util.ArrayList;

// Clase de pruebas del sistema
// No usa JUnit para mantenerlo simple, solo compara resultados
// y muestra si cada prueba paso o fallo

public class Pruebas {

    public static void main(String[] args) {
        int pruebasOk = 0;
        int pruebasTotal = 0;

        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();

        // Prueba 1: agregar un estudiante
        pruebasTotal++;
        lista.add(new Estudiante(1, "Juan Perez", 20, "Desarrollo de Software", "juan@correo.com"));
        if (lista.size() == 1) {
            System.out.println("Prueba 1 (agregar estudiante): PASO");
            pruebasOk++;
        } else {
            System.out.println("Prueba 1 (agregar estudiante): FALLO");
        }

        // Prueba 2: buscar un estudiante que existe
        pruebasTotal++;
        Estudiante encontrado = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == 1) {
                encontrado = lista.get(i);
            }
        }
        if (encontrado != null && encontrado.getNombre().equals("Juan Perez")) {
            System.out.println("Prueba 2 (buscar estudiante existente): PASO");
            pruebasOk++;
        } else {
            System.out.println("Prueba 2 (buscar estudiante existente): FALLO");
        }

        // Prueba 3: editar un estudiante
        pruebasTotal++;
        encontrado.setCarrera("Ingenieria de Software");
        if (encontrado.getCarrera().equals("Ingenieria de Software")) {
            System.out.println("Prueba 3 (editar estudiante): PASO");
            pruebasOk++;
        } else {
            System.out.println("Prueba 3 (editar estudiante): FALLO");
        }

        // Prueba 4: eliminar un estudiante
        pruebasTotal++;
        lista.remove(encontrado);
        if (lista.size() == 0) {
            System.out.println("Prueba 4 (eliminar estudiante): PASO");
            pruebasOk++;
        } else {
            System.out.println("Prueba 4 (eliminar estudiante): FALLO");
        }

        // Prueba 5: buscar un estudiante que no existe
        pruebasTotal++;
        Estudiante noExiste = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == 99) {
                noExiste = lista.get(i);
            }
        }
        if (noExiste == null) {
            System.out.println("Prueba 5 (buscar estudiante inexistente): PASO");
            pruebasOk++;
        } else {
            System.out.println("Prueba 5 (buscar estudiante inexistente): FALLO");
        }

        System.out.println("");
        System.out.println("Resultado final: " + pruebasOk + "/" + pruebasTotal + " pruebas pasadas");
    }
}
