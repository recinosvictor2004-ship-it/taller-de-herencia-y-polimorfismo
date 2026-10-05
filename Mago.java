public class Mago extends Personaje implements Curable {

    private double mana;

    public Mago(String nombre, double vidaMax, double ataque, double defensa, double mana) {
        super(nombre, vidaMax, ataque, defensa);
        this.mana = mana;
    }

    public Mago() {
        this("Mago Aprendiz", 80.0, 20.0, 2.0, 100.0);
    }

    @Override
    public void atacar(Personaje objetivo) {
        double dano;
        if (mana >= 5.0) {
            mana -= 5.0;
            dano = puntosAtaque - objetivo.puntosDefensa / 2;
        } else {
            dano = 3.0;
        }
        if (dano <= 0) dano = 3.0;
        objetivo.recibirDano(dano);
        System.out.println(nombre + " lanzó Rayo Arcano causando " + dano);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        if (mana < 30.0) {
            System.out.println("No hay maná suficiente. Se usa ataque básico.");
            atacar(objetivo);
            return;
        }
        mana -= 30.0;
        double dano = puntosAtaque * 2;
        objetivo.recibirDano(dano);
        System.out.println(nombre + " lanzó Bola de Fuego causando " + dano);
    }

    @Override
    public void curar() {
        if (mana < 20.0) {
            System.out.println(nombre + " no tiene maná para curarse.");
            return;
        }
        mana -= 20.0;
        double antes = puntosVida;
        puntosVida += CURACION_BASE + 5.0;
        if (puntosVida > puntosVidaMax) puntosVida = puntosVidaMax;
        System.out.println(nombre + " recuperó " + (puntosVida - antes));
    }

    @Override
    public String getTipo() {
        return "Mago";
    }
}
