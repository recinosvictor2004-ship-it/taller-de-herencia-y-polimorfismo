public class Arquero extends Personaje {

    private int precision;

    public Arquero(String nombre, double vidaMax, double ataque, double defensa, int precision) {
        super(nombre, vidaMax, ataque, defensa);
        this.precision = precision;
    }

    public Arquero() {
        this("Arquero Novato", 90.0, 18.0, 4.0, 40);
    }

    @Override
    public void atacar(Personaje objetivo) {
        double r = Math.random() * 100;
        if (r < precision) {
            Batalla.ejecutarAtaqueCritico(this, objetivo, 1.5);
        } else {
            double dano = calcularDanoBase(objetivo);
            objetivo.recibirDano(dano);
            System.out.println(nombre + " disparó causando " + dano);
        }
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        for (int i = 0; i < 3; i++) {
            double dano = puntosAtaque * 0.6 - objetivo.puntosDefensa;
            if (dano <= 0) dano = 3.0;
            objetivo.recibirDano(dano);
            System.out.println(nombre + " impactó flecha causando " + dano);
        }
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        precision += 3;
        if (precision > 95) precision = 95;
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Precisión: " + precision);
    }

    @Override
    public String getTipo() {
        return "Arquero";
    }
}
