public class Batalla {

    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador) {
        int dano = (int)(atacante.puntosAtaque * multiplicador);
        objetivo.recibirDano(dano);
        System.out.println("¡Golpe Crítico! " + atacante.nombre + " causó " + dano);
    }

    public static void intentarCurar(Personaje p) {
        if (p instanceof Curable) {
            ((Curable)p).curar();
        } else {
            System.out.println(p.nombre + " no puede curarse.");
        }
    }

    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2) {
        int turno = 1;
        System.out.println("--- BATALLA AUTOMÁTICA ---");

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("Turno " + turno);

            if (turno % 3 == 0) p1.habilidadEspecial(p2);
            else p1.atacar(p2);

            if (p2.estaVivo()) {
                if (turno % 3 == 0) p2.habilidadEspecial(p1);
                else p2.atacar(p1);
            }

            turno++;
        }

        Personaje ganador = p1.estaVivo() ? p1 : p2;
        System.out.println(">>> El ganador es: " + ganador.nombre + " (" + ganador.getTipo() + ")");
    }
}
