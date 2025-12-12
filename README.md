# Sistema de Gestión de Criaturas Elementales

> **Proyecto de Backend en Java** que modela un ecosistema complejo de entidades con distintas afinidades, evoluciones y mecánicas de interacción.

## 📋 Descripción del Proyecto
Este sistema fue desarrollado para gestionar el "Mundo de Elandria", administrando el ciclo de vida, entrenamiento y combate de criaturas elementales (Agua, Fuego, Tierra, Aire). El objetivo principal fue aplicar **Programación Orientada a Objetos Avanzada** y metodologías ágiles de desarrollo.

El sistema permite a los "Maestros" capturar, entrenar y transformar criaturas, gestionando reglas de negocio complejas sobre niveles de energía y estados emocionales.

## ⚙️ Características Técnicas y Desafíos
El proyecto resuelve los siguientes requerimientos técnicos:

* **Arquitectura POO Robusta:** Uso de **Herencia y Polimorfismo** para diferenciar comportamientos entre criaturas *Salvajes*, *Domesticadas* y *Ancestrales*.
* **Patrones de Diseño:** Implementación del **Patrón Decorator** para manejar las "Transformaciones Elementales" (Bendición del Río, Llama Interna, etc.) de manera dinámica y acumulativa.
* **Manejo de Excepciones:** Control de flujos alternativos mediante Excepciones Checked (ej: `MaestriaInsuficienteException`) y Unchecked para estados inválidos.
* **Estructuras de Datos:** Uso intensivo de `HashMap` y `Collections` para la generación de reportes estratégicos y búsquedas optimizadas.
* **Calidad de Código:** Desarrollo guiado por pruebas (**TDD**) utilizando **JUnit 4** para validar la lógica de negocio y asegurar el principio de responsabilidad única (SRP).

## 🚀 Funcionalidades Principales
1.  **Gestión de Entidades:** Registro de criaturas con atributos dinámicos (energía, afinidad, estado emocional).
2.  **Mecánicas de Juego:**
    * **Entrenamiento:** Lógica variable según el tipo de criatura (las salvajes pueden volverse inestables).
    * **Interacciones:** Sistema de "combate" donde la afinidad elemental determina bonificaciones o penalizaciones de energía.
3.  **Reportes Administrativos:**
    * Ranking de criaturas con mayor poder.
    * Estadísticas de maestros y transformaciones.
    * Mapa de población por afinidad elemental.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java (JDK 20)
* **Testing:** JUnit 4
* **Herramientas:** Eclipse IDE, Git/GitHub

---
*Este proyecto fue realizado como trabajo final de la cátedra de Programación Básica 2 en la Universidad Nacional de La Matanza (UNLaM), obteniendo la calificación máxima (10).*
