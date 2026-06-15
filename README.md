# MiTienda

# MiTienda - Sistema de Ventas 🛒

###Descripción del Proyecto
Módulo funcional de autenticación y gestión de inventario desarrollado en **JavaFX** y estructurado con **Maven** para la materia de Programación Orientada a Objetos (EPN). ]El sistema implementa un control de acceso por roles y un módulo CRUD completo conectado a una interfaz gráfica limpia y moderna utilizando estilos CSS personalizados

#### 1. Pantalla de Login
<img width="602" height="651" alt="image" src="https://github.com/user-attachments/assets/a5bdc63e-31e2-4513-b26c-8f19e4be619a" />



### 🛠️ Tecnologías Utilizadas
* **Java 17** (o tu versión actual de JDK) 
* **JavaFX 17** (Controles, FXML para diseño desacoplado) 
* **Maven** (Gestor de dependencias y construcción del proyecto)
* **CSS Custom Styling** (Estilos visuales para componentes) 

---

### 🚀 Funcionalidades Implementadas

1. **Acceso Seguro (Login):** Validación de credenciales del sistema según el rol seleccionado (`Administrador`, `Vendedor`, `Cajero`). Acceso directo con `admin / 1234 / Administrador`.
2. **Módulo de Productos (CRUD Completo):**
   * **Nuevo / Limpiar:** Vacía los campos del formulario para un nuevo registro
   * **Guardar:** Registra un producto de forma dinámica en la tabl
   ***Actualizar:** Modifica los valores del ítem seleccionado
   ***Eliminar:** Da de baja productos del inventario de forma lógica/física
3. **Tabla Dinámica (TableView):** Renderizado de columnas observables para Código, Nombre, Categoría, Precio, Stock y Estado[

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
