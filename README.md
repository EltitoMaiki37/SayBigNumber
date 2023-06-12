# Say Big Numbers

Permite convertir números en su representación textual y realizar operaciones matemáticas con números grandes.

## Configuración del entorno local

Para configurar el entorno local, sigue los siguientes pasos:

1. Instala **Apache Tomcat 9** siguiendo las instrucciones en [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi).
2. Verifica que puedas iniciar **Apache Tomcat** localmente. Por defecto, se ejecuta en el puerto 8080. Puedes acceder a la página de administración en [http://localhost:8080/manager/html](http://localhost:8080/manager/html).

## Configuración de la webapp

1. Descarga el proyecto `SayBigNumber.zip`.
2. Descomprime el archivo ZIP y ábrelo en **IntelliJ** o tu IDE preferido.
3. En el proyecto, agrega la clase `NumbersCat` y haz que implemente la interfaz `Numbers`.
4. Agrega la clase `BigNumber` al proyecto y haz que implemente la interfaz `BigNumberOperator`.
5. Modifica la clase `SayBigNumberFactory` para utilizar tus objetos implementados.
6. Si tienes asignado un servidor en **Es Liceu**, el profesor te proporcionará un endpoint. Configura este endpoint en la clase `SayBigNumberFactory` (por defecto, está configurado para apuntar a la instancia local).

## Servicios de la webapp

La webapp ofrece los siguientes servicios:

- `say`: Convierte un número en su representación textual. Ejemplo de uso: [http://localhost:8080/SayBigNumber/say?number=71](http://localhost:8080/SayBigNumber/say?number=71)
- `operate`: Realiza una operación matemática con dos números. Ejemplo de uso: [http://localhost:8080/SayBigNumber/operate?operation=add&number1=13&number2=57](http://localhost:8080/SayBigNumber/operate?operation=add&number1=13&number2=57)
- `service`: Realiza una operación matemática con dos números y devuelve el resultado en formato JSON. Ejemplo de uso: [http://localhost:8080/SayBigNumber/service?operation=add&number1=13&number2=5](http://localhost:8080/SayBigNumber/service?operation=add&number1=13&number2=5)

## Comprobación de los logs

La salida de la aplicación se encuentra en `<TOMCAT_HOME>/logs/catalina.out`. Puedes usar la herramienta `tail` para ver los logs en la pantalla:

```bash
<TOMCAT_HOME>/logs $ tail -f catalina.out 
```

## Diagramas
A continuación, se muestran los diagramas UML necesarios para comprender el funcionamiento del proyecto:

- Diagrama de comunicación
- Diagrama de casos de uso
- Diagrama de secuencia
- Diagrama de flujo
- Diagrama de clases

## Pipeline

La construcción del proyecto debe seguir una pipeline que incluya las siguientes etapas:

1. **Build**: Compilación del código fuente y generación del artefacto.
2. **Unit tests**: Ejecución de pruebas unitarias para validar el comportamiento del código.
3. **SonarQube**: Análisis estático del código para identificar posibles problemas y mejorar la calidad del código.
4. **Deploy**: Despliegue del artefacto generado en un entorno local y en el entorno de Es Liceu.
5. **API tests**: Ejecución de pruebas automatizadas para verificar el funcionamiento de los servicios de la webapp.
6. **E2E tests**: Ejecución de pruebas de extremo a extremo para verificar la funcionalidad completa de la webapp.
