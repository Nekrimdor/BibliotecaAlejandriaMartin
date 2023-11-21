import java.util.Scanner;

public class bibliotecaAlejandria {

    static String[][] inventario = new String[15][6];
    static String[][] usuarios = {
            { "admin", "admin", "admin" },
            { "usuario1", "usu1", "cliente" },
            { "usuario2", "usu2", "cliente" },
            { "usuario3", "usu3", "cliente" },
            { "usuario4", "usu4", "cliente" },
            { "usuario5", "usu5", "cliente" }
    };

    static boolean contParAct = true;

    public static void main(String[] args) {
        iniciarSesion();
        cargarDatos();
        ejecMenu();
    }

    static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Usuario: ");
        String usuarioA = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasenaA = sc.nextLine();

        // Verificar usuario
        boolean correcto = false;
        for (int i = 0; i < usuarios.length; i++) {
            String[] usuario = usuarios[i];
            if (usuario[0].equals(usuarioA) && usuario[1].equals(contrasenaA)) {
                System.out.println("Saludos " + usuarioA + ".");
                correcto = true;
                break;
            }
        }

        if (!correcto) {
            System.out.println("Credenciales incorrectas.");
            System.exit(0);
        }
    }

    static void ejecMenu() {
        Scanner sc = new Scanner(System.in);
        int opcionM;
        do {
            System.out.println("########################################");
            System.out.println("# Menú Principal                       #");
            System.out.println("# 1. Consultar documento               #");
            System.out.println("# 2. Visualizar todos los documentos   #");
            System.out.println("# 3. Reservar documento                #");
            System.out.println("# 4. Devolver documento                #");
            System.out.println("# 5. Salir                             #");
            System.out.println("########################################");
            opcionM = sc.nextInt();
            sc.nextLine();

            switch (opcionM) {
                case 1:
                    consultarDoc();
                    break;
                case 2:
                    visualizarDoc();
                    break;
                case 3:
                    reservarDoc();
                    break;
                case 4:
                    devolverDoc();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcionM != 5);
    }

    static void consultarDoc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué documento quiere consultar?");
        String nombreDoc = sc.nextLine();

        for (int i = 0; i < inventario.length; i++) {
            String[] doc = inventario[i];
            if (doc != null && doc[0] != null && doc[0].equalsIgnoreCase(nombreDoc)) {
                // consultar el documento
                System.out.println("Información del documento: ");
                for (int l = 0; l < doc.length; l++) {
                    String atributo = doc[l];
                    System.out.println(atributo);
                }
                return;
            }
        }
        System.out.println("Documento no encontrado.");
    }

    static void visualizarDoc() {
        System.out.println("Todos los Documentos:");
        for (int j = 0; j < inventario.length; j++) {
            String[] doc = inventario[j];
            if (doc != null && doc[0] != null) {
                // Imprime información del doc
                for (int i = 0; i < doc.length; i++) {
                    String atributo = doc[i];
                    System.out.print(atributo + "\t");
                }
                System.out.println();
            }
        }
    }

    static void reservarDoc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué documento quiere  reservar?");
        String nombreDoc = sc.nextLine();

        for (int i = 0; i < inventario.length; i++) {
            String[] doc = inventario[i];
            if (doc != null && doc[0] != null && doc[0].equalsIgnoreCase(nombreDoc)) {
                //reservar el documento
                if (doc[3].equalsIgnoreCase("disponible")) {
                    doc[3] = "reservado";
                    System.out.println("Ha reservvvado el documento.");
                } else {
                    System.out.println("No disponible.");
                }
                return;
            }
        }

        System.out.println("No encontrado.");
    }

    static void devolverDoc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué documento quiere devolver?");
        String nombreDoc = sc.nextLine();

        for (int i = 0; i < inventario.length; i++) {
            String[] doc = inventario[i];
            if (doc != null && doc[0] != null && doc[0].equalsIgnoreCase(nombreDoc)) {
                //devolver el documento
                if (doc[3].equalsIgnoreCase("reservado")) {
                    doc[3] = "disponible";
                    System.out.println("Documento devuelto con éxito.");
                } else {
                    System.out.println("El documento no está reservado.");
                }
                return;
            }
        }

        System.out.println("Documento no encontrado.");
    }

    static void configuracion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("###########################################");
        System.out.println("# Configuración                           #");
        System.out.println("# 1. Activar/Desactivar control parental  #");
        System.out.println("# 2. Volver al Menú Principal             #");
        System.out.print ("# Seleccione una opción:                   # ");
        System.out.println("###########################################");
        int opcionCP = sc.nextInt();
        sc.nextLine();

        switch (opcionCP) {
            case 1:
                contParAct = !contParAct;
                System.out.println("Control parental " + (contParAct ? "activado." : "desactivado."));
                break;
            case 2:
                System.out.println("Volviendo al Menú Principal.");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    static void cargarDatos() {
        //libros
        inventario[0] = new String[] {"The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "disponible", "1", "180"};
        inventario[1] = new String[] {"To Kill a Mockingbird", "Harper Lee", "Harper Perennial", "disponible", "2", "336"};
        inventario[2] = new String[] {"The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company","disponible", "3", "224"};
        inventario[3] = new String[] {"1984", "George Orwell", "Penguin Books", "disponible", "1", "328"};
        inventario[4] = new String[] {"The Hobbit", "J.R.R. Tolkien", "Houghton Mifflin Harcourt", "disponible", "2", "310"};
    
        //revistas
        inventario[5] = new String[] {"National Geographic", "National Geographic Society", "123", "disponible"};
        inventario[6] = new String[] {"Time", "Time Inc.", "124", "disponible"};
        inventario[7] = new String[] {"Scientific American", "Springer Nature", "125", "disponible"};
        inventario[8] = new String[] {"Vogue", "Condé Nast", "126", "disponible"};
        inventario[9] = new String[] {"The Economist", "The Economist Group", "127", "disponible"};
    
        //doc
        inventario[10] = new String[] {"2023-11-20", "Research Report", "Researcher 1", "disponible", "Author 1"};
        inventario[11] = new String[] {"2023-11-21", "User Manual", "Company XYZ", "Author 2","disponible" };
        inventario[12] = new String[] {"2023-11-22", "Service Agreement", "Client ABC", "Author 3", "disponible"};
        inventario[13] = new String[] {"2023-11-23", "Presentation", "Sales Team", "Author 4"};
        inventario[14] = new String[] {"2023-11-24", "Privacy Policy", "Company DEF", "disponible", "Author 5"};
    }
}