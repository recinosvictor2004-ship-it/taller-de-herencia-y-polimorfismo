public class Guerrero extends Personaje implements Curable {

    private double escudo;

    public Guerrero(String nombre, double vidaMax, double ataque, double defensa, double escudo) {
        super(nombre, vidaMax, ataque, defensa);
        this.escudo = escudo;
    }

    public Guerrero() {
        this("Guerrero Novato", 120.0, 15.0, 8.0, 20.0);
    }

    @Override
    public void atacar(Personaje objetivo) {
        double dano = calcularDanoBase(objetivo);
        objetivo.recibirDano(dano);
        System.out.println(nombre + " atacó a " + objetivo.nombre + " causando " + dano);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        double dano = puntosAtaque * 1.5 - objetivo.puntosDefensa;
        if (dano <= 0) dano = 3.0;
        objetivo.recibirDano(dano);

        puntosVida -= 10.0;
        if (puntosVida < 1.0) puntosVida = 1.0;

        System.out.println(nombre + " usó Golpe Furioso causando " + dano);
    }

    @Override
    public void recibirDano(double cantidad) {
        double restante = cantidad - escudo;
        if (restante > 0) super.recibirDano(restante);
        escudo -= cantidad;
        if (escudo < 0) escudo = 0;
    }

    @Override
    public void curar() {
        double antes = puntosVida;
        puntosVida += CURACION_BASE;
        if (puntosVida > puntosVidaMax) puntosVida = puntosVidaMax;
        System.out.println(nombre + " recuperó " + (puntosVida - antes));
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        escudo += 10.0;
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Escudo: " + escudo);
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }
}
