# Registro de Intregantes
El repositorio tiene dirección url https://github.com/Fabian143/RegistroIntregantes/edit/main/README.md

## Objetivo

Esta aplicación en Java Swing permite registrar información de estudiantes, incluyendo nombre, apellido, repositorio personal, tipo de estudiante (nuevo o antiguo) y proyecto curricular. Además, ofrece la opción de consultar los registros almacenados durante la ejecución y validar que la URL del repositorio sea válida antes de guardar la información.

La solución está organizada con una estructura basada en MVC (Modelo-Vista-Controlador), separando la lógica de la interfaz, el manejo de datos y la validación del flujo de la aplicación.

## Requisitos

Antes de ejecutar el proyecto, asegúrate de cumplir con lo siguiente:

- Java JDK 8 o superior
- Un IDE compatible con Java, como:
  - IntelliJ IDEA
  - Eclipse
  - NetBeans
- Conexión a internet (solo si deseas abrir o validar repositorios externos en la URL)
- Sistema operativo con soporte para Java Swing

## Estructura del proyecto

- `main/Main.java`: punto de entrada de la aplicación
- `view/FormularioIntregante.java`: interfaz gráfica con Swing
- `controller/IntreganteController.java`: lógica de validación y flujo de la aplicación
- `model/Intregante.java`: entidad que representa a un estudiante

## Pasos de ejecución

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Fabian143/RegistroIntregantes.git
   cd RegistroIntregantes
   ```

2. Abre el proyecto en tu IDE Java favorito.

3. Verifica que el proyecto se cargue correctamente y que no falten dependencias del JDK.

4. Ejecuta la clase principal:

   - Archivo: `main/Main.java`
   - Método principal: `main(String[] args)`

5. La aplicación abrirá una ventana con el formulario de registro.

6. Completa los datos del estudiante:
   - Nombre
   - Apellido
   - Repositorio
   - Tipo de estudiante
   - Proyecto curricular

7. Haz clic en `Registrar estudiante` para guardar el registro.

8. Si deseas consultar los estudiantes registrados, usa la opción `Consultar estudiantes`.

## Funcionamiento principal

La aplicación realiza lo siguiente:

- valida que los campos obligatorios no estén vacíos
- comprueba que la URL del repositorio tenga un formato válido (`http` o `https`)
- almacena los estudiantes en memoria durante la ejecución
- permite consultar la información registrada en pantalla
- ofrece mensajes de confirmación y validación para una mejor experiencia de usuario

## Capturas de pantalla



<img width="603" height="405" alt="image" src="https://github.com/user-attachments/assets/12eb7628-de3e-4c8d-8be3-050b916f314e" />



<img width="604" height="431" alt="image" src="https://github.com/user-attachments/assets/46756525-0b8c-4246-8020-c9da818ffd70" />



<img width="596" height="401" alt="image" src="https://github.com/user-attachments/assets/a8964cd0-dfa5-4941-b2ac-6027ff1baf82" />



<img width="602" height="406" alt="image" src="https://github.com/user-attachments/assets/83fd8ca4-d4ca-46c4-b0bb-234030b21317" />

## Nota

Este repositorio no incluye archivos compilados ni ejecutables finales; está pensado para ejecutarse directamente desde un entorno Java y desde la clase principal del proyecto.

## Autor

Proyecto desarrollado por Fabian143.
