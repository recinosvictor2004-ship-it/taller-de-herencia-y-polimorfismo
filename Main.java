import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Personaje p1 = null, p2 = null;
        int opcion;

        do {
            System.out.println("====================================");
            System.out.println("SIMULADOR DE COMBATE RPG");
            System.out.println("====================================");
            System.out.println("1. Crear Personaje 1");
            System.out.println("2. Crear Personaje 2");
            System.out.println("3. Ver ficha técnica");
            System.out.println("4. Subir de nivel");
            System.out.println("5. Curar personaje");
            System.out.println("6. Ataque básico");
            System.out.println("7. Habilidad especial");
            System.out.println("8. Batalla automática");
            System.out.println("9. Total personajes creados");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                case 2:
                    Personaje nuevo = crearPersonaje(sc);
                    if (opcion == 1) p1 = nuevo;
                    else p2 = nuevo;
                    break;

                case 3:
                    if (p1 != null) p1.mostrarEstado();
                    else System.out.println("P1 no existe.");
                    if (p2 != null) p2.mostrarEstado();
                    else System.out.println("P2 no existe.");
                    break;

                case 4:
                    Personaje s = elegir(sc, p1, p2);
                    if (s != null) s.subirNivel();
                    break;

                case 5:
                    Personaje c = elegir(sc, p1, p2);
                    if (c != null) Batalla.intentarCurar(c);
                    break;

                case 6:
                    atacar(sc, p1, p2);
                    break;

                case 7:
                    habilidad(sc, p1, p2);
                    break;

                case 8:
                    if (p1 != null && p2 != null && p1.estaVivo() && p2.estaVivo())
                        Batalla.iniciarPeleaAutomatica(p1, p2);
                    else
                        System.out.println("Ambos deben existir y estar vivos.");
                    break;

                case 9:
                    System.out.println("Total creados: " + Personaje.getTotalPersonajesCreados());
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 10);

        sc.close();
    }

    private static Personaje crearPersonaje(Scanner sc) {
        System.out.println("Tipo: 1.Guerrero  2.Mago  3.Arquero");
        int tipo = sc.nextInt();

        System.out.println("Constructor: 1.Predeterminado  2.Parametrizado");
        int cons = sc.nextInt();

        if (cons == 1) {
            if (tipo == 1) return new Guerrero();
            if (tipo == 2) return new Mago();
            return new Arquero();
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Vida Max: ");
        double vida = sc.nextDouble();
        System.out.print("Ataque: ");
        double ataque = sc.nextDouble();
        System.out.print("Defensa: ");
        double defensa = sc.nextDouble();

        if (tipo == 1) {
            System.out.print("Escudo: ");
            double escudo = sc.nextDouble();
            return new Guerrero(nombre, vida, ataque, defensa, escudo);
        }

        if (tipo == 2) {
            System.out.print("Maná: ");
            double mana = sc.nextDouble();
            return new Mago(nombre, vida, ataque, defensa, mana);
        }

        System.out.print("Precisión: ");
        int precision = sc.nextInt();
        return new Arquero(nombre, vida, ataque, defensa, precision);
    }

    private static Personaje elegir(Scanner sc, Personaje p1, Personaje p2) {
        System.out.print("¿Personaje (1 o 2)? ");
        int x = sc.nextInt();
        if (x == 1 && p1 != null) return p1;
        if (x == 2 && p2 != null) return p2;
        System.out.println("No existe.");
        return null;
    }

    private static void atacar(Scanner sc, Personaje p1, Personaje p2) {
        System.out.print("¿Quién ataca? (1 o 2): ");
        int a = sc.nextInt();
        System.out.print("¿A quién? (1 o 2): ");
        int b = sc.nextInt();

        Personaje atacante = (a == 1 ? p1 : p2);
        Personaje objetivo = (b == 1 ? p1 : p2);

        if (atacante == null || objetivo == null) {
            System.out.println("Personajes no creados.");
            return;
        }

        if (!atacante.estaVivo()) {
            System.out.println("Ese personaje está derrotado.");
            return;
        }

        atacante.atacar(objetivo);
    }

    private static void habilidad(Scanner sc, Personaje p1, Personaje p2) {
        System.out.print("¿Quién usa habilidad? (1 o 2): ");
        int a = sc.nextInt();
        System.out.print("¿A quién? (1 o 2): ");
        int b = sc.nextInt();

        Personaje atacante = (a == 1 ? p1 : p2);
        Personaje objetivo = (b == 1 ? p1 : p2);

        if (atacante == null || objetivo == null) {
            System.out.println("Personajes no creados.");
            return;
        }

        if (!atacante.estaVivo()) {
            System.out.println("Ese personaje está derrotado.");
            return;
        }

        atacante.habilidadEspecial(objetivo);
    }
}
