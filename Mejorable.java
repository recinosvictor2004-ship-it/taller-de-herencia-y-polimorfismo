public interface Mejorable {

    void subirNivel();

    default void mostrarMensajeNivel(int nivel) {
        System.out.println("**** ¡Alcanzó el nivel " + nivel + "! ****");
    }
}
