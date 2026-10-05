public abstract class Personaje implements Mejorable {

    protected String nombre;
    protected double puntosVida;
    protected double puntosVidaMax;
    protected double puntosAtaque;
    protected double puntosDefensa;
    protected int nivel;

    private static int totalPersonajesCreados = 0;

    public Personaje(String nombre, double vidaMax, double ataque, double defensa) {
        this.nombre = nombre;
        this.puntosVidaMax = vidaMax;
        this.puntosVida = vidaMax;
        this.puntosAtaque = ataque;
        this.puntosDefensa = defensa;
        this.nivel = 1;
        totalPersonajesCreados++;
    }

    public void recibirDano(double cantidad) {
        puntosVida -= cantidad;
        if (puntosVida < 0) puntosVida = 0.0;
    }

    public boolean estaVivo() {
        return puntosVida > 0.0;
    }

    protected double calcularDanoBase(Personaje objetivo) {
        double dano = puntosAtaque - objetivo.puntosDefensa;
        return dano <= 0 ? 3.0 : dano;
    }

    @Override
    public void subirNivel() {
        nivel++;
        puntosVidaMax += 20.0;
        puntosAtaque += 5.0;
        puntosDefensa += 2.0;
        puntosVida = puntosVidaMax;
        mostrarMensajeNivel(nivel);
    }

    public void mostrarEstado() {
        System.out.println("====================================");
        System.out.println("Tipo: " + getTipo());
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + puntosVida + " / " + puntosVidaMax);
        System.out.println("Ataque: " + puntosAtaque);
        System.out.println("Defensa: " + puntosDefensa);
        System.out.println("====================================");
    }

    public static int getTotalPersonajesCreados() {
        return totalPersonajesCreados;
    }

    public abstract void atacar(Personaje objetivo);
    public abstract void habilidadEspecial(Personaje objetivo);
    public abstract String getTipo();
}
