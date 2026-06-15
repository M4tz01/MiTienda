# MiTienda

# MiTienda - Sistema de Ventas 🛒

###Descripción del Proyecto
[cite_start]Módulo funcional de autenticación y gestión de inventario desarrollado en **JavaFX** y estructurado con **Maven** para la materia de Programación Orientada a Objetos (EPN)[cite: 1, 37]. [cite_start]El sistema implementa un control de acceso por roles y un módulo CRUD completo conectado a una interfaz gráfica limpia y moderna utilizando estilos CSS personalizados[cite: 5, 37].

#### 1. Pantalla de Login
<img width="602" height="651" alt="image" src="https://github.com/user-attachments/assets/a5bdc63e-31e2-4513-b26c-8f19e4be619a" />



### 🛠️ Tecnologías Utilizadas
* [cite_start]**Java 17** (o tu versión actual de JDK) [cite: 151]
* [cite_start]**JavaFX 17** (Controles, FXML para diseño desacoplado) [cite: 72, 151]
* **Maven** (Gestor de dependencias y construcción del proyecto)
* [cite_start]**CSS Custom Styling** (Estilos visuales para componentes) [cite: 72, 151]

---

### 🚀 Funcionalidades Implementadas

1. [cite_start]**Acceso Seguro (Login):** Validación de credenciales del sistema según el rol seleccionado (`Administrador`, `Vendedor`, `Cajero`)[cite: 6, 9, 30, 32, 34]. [cite_start]Acceso directo con `admin / 1234 / Administrador`.
2. **Módulo de Productos (CRUD Completo):**
   * [cite_start]**Nuevo / Limpiar:** Vacía los campos del formulario para un nuevo registro[cite: 57, 61].
   * [cite_start]**Guardar:** Registra un producto de forma dinámica en la tabla[cite: 58, 62].
   * [cite_start]**Actualizar:** Modifica los valores del ítem seleccionado[cite: 59].
   * [cite_start]**Eliminar:** Da de baja productos del inventario de forma lógica/física[cite: 60].
3. [cite_start]**Tabla Dinámica (TableView):** Renderizado de columnas observables para Código, Nombre, Categoría, Precio, Stock y Estado[cite: 62, 64, 65, 66, 67, 68, 69].

---

### 📁 Estructura de Carpetas del Proyecto

```text
MiTienda/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── com.example.mitienda/
│       │   │   ├── DashboardController.java  # Controlador de la vista principal
│       │   │   ├── HelloApplication.java     # Clase principal (Start/Main)
│       │   │   ├── LoginController.java     # Controlador del login
│       │   │   └── Producto.java            # Modelo de datos de Producto
│       │   └── module-info.java             # Configuración modular de Java
│       │
│       └── resources/
│           └── com.example.mitienda/
│               ├── dashboard.fxml           # Diseño del módulo de productos
│               ├── login.fxml               # Diseño del formulario de acceso
│               └── styles.css               # Hoja de estilos de la interfaz
│
├── pom.xml                                  # Dependencias de Maven y compilador
└── README.md                                # Documentación del proyecto
