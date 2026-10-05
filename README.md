# ⚔️ Simulador de Combate RPG con Herencia y Polimorfismo en Java

Este proyecto implementa un sistema de combate RPG utilizando **herencia**, **polimorfismo**, **interfaces**, **clases abstractas**, **métodos sobrescritos**, **super(...)**, **this(...)**, y **métodos estáticos**, cumpliendo todas las restricciones del taller:

✔ Sin arreglos  
✔ Sin listas  
✔ Sin colecciones  
✔ Sin instanceof para decidir ataques (solo permitido en intentarCurar)  
✔ Uso obligatorio de herencia, polimorfismo, interfaces y clase abstracta  
✔ Uso de super(...) y this(...)  
✔ Uso de super.método()  
✔ Todos los métodos sobrescritos llevan @Override  

---

## 📌 Estructura del Proyecto (8 archivos .java)

### 1. **Curable.java** (Interface)
Define la capacidad de curarse.  
Incluye una constante y un método abstracto.

### 2. **Mejorable.java** (Interface)
Define la capacidad de subir nivel.  
Incluye un método default para mostrar mensajes de nivel.

### 3. **Personaje.java** (Clase abstracta)
Clase base de todos los personajes.  
Implementa Mejorable.  
Contiene atributos protegidos, constructor base, métodos concretos y métodos abstractos:

- `atacar(Personaje objetivo)`  
- `habilidadEspecial(Personaje objetivo)`  
- `getTipo()`  

También incluye:

- `recibirDano(...)`  
- `estaVivo()`  
- `calcularDanoBase(...)`  
- `subirNivel()` con super.método()  
- `mostrarEstado()`  
- Contador estático `totalPersonajesCreados`

---

## 🛡️ Clases Hijas

### 4. **Guerrero.java**
Extiende Personaje e implementa Curable.  
Atributo propio: `escudo`.  
Sobrescribe:

- atacar  
- habilidadEspecial  
- recibirDano  
- curar  
- subirNivel  
- mostrarEstado  

Incluye constructor predeterminado y parametrizado.

---

### 5. **Mago.java**
Extiende Personaje e implementa Curable.  
Atributo propio: `mana`.  
Sobrescribe:

- atacar (Rayo Arcano)  
- habilidadEspecial (Bola de Fuego)  
- curar  
- getTipo  

Incluye constructor predeterminado y parametrizado.

---

### 6. **Arquero.java**
Extiende Personaje.  
Atributo propio: `precision`.  
Sobrescribe:

- atacar (con probabilidad de crítico)  
- habilidadEspecial (Lluvia de Flechas)  
- subirNivel  
- mostrarEstado  
- getTipo  

Incluye constructor predeterminado y parametrizado.

---

## ⚔️ Clase de Utilidad

### 7. **Batalla.java**
Contiene métodos estáticos:

- `ejecutarAtaqueCritico(...)`  
- `intentarCurar(Personaje p)` → único uso permitido de instanceof  
- `iniciarPeleaAutomatica(...)`  
  - Turnos automáticos  
  - Cada 3 turnos se usa habilidadEspecial  
  - Al final imprime el ganador con su tipo

---

## 🎮 Menú Interactivo

### 8. **Main.java**
Controla toda la interacción con el usuario mediante Scanner.

Opciones del menú:

1. Crear Personaje 1  
2. Crear Personaje 2  
3. Ver ficha técnica  
4. Subir nivel  
5. Curar personaje  
6. Ataque básico  
7. Habilidad especial  
8. Batalla automática  
9. Ver total de personajes creados  
10. Salir  

El menú:

- Usa polimorfismo para ejecutar ataques y habilidades  
- No pregunta por el tipo del personaje  
- Valida personajes nulos  
- Valida personajes derrotados  
- Usa super(...) y this(...) en constructores  
- Usa super.método() en métodos sobrescritos  

---

## 🧪 Ejemplo de Ejecución (Opción 8)

--- BATALLA AUTOMÁTICA ---
Turno 1
Mago Aprendiz lanza Rayo Arcano contra Guerrero Novato y causa 19.0 de daño.
Guerrero Novato ataca a Mago Aprendiz y causa 13.0 de daño.
Turno 3
Mago Aprendiz lanza Bola de Fuego causando 40.0 de daño.
Guerrero Novato usa Golpe Furioso causando 20.5 de daño.

El ganador es: Mago Aprendiz (Mago)


---

## 🎯 Objetivo Académico

Este proyecto demuestra dominio de:

- Herencia  
- Polimorfismo por sobrescritura y por referencia  
- Interfaces con constantes y métodos default  
- Clases abstractas  
- Encadenamiento de constructores  
- Métodos estáticos  
- Control de estado interno  
- Diseño orientado a objetos sin colecciones  

---

## ✔️ Entregable

- Proyecto completo con los 8 archivos .java  
- Captura de ejecución mostrando:  
  - Creación de dos personajes distintos  
  - Una curación  
  - Una habilidad especial  
  - Una batalla automática completa  
- README profesional (este archivo)  
- Código con comentarios breves donde se aplica cada concepto  

---

## 🏁 Conclusión

Este simulador RPG está construido con una arquitectura sólida, profesional y completamente alineada con los requerimientos del taller.  
Demuestra un uso correcto de herencia, polimorfismo, interfaces, clases abstractas y diseño orientado a objetos sin colecciones.

