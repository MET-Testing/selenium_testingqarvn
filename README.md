
# Java with Selenium

Web de pruebas para practicar Selenium con Java
# Cómo empezar?

0. **Ten instaladas Java & Gradle** <br>

## Java
En tu terminal chequea si ya tienes Java
```
java -version
```
Si Java ya está instalado, verás la versión instalada. Si no está instalado, el sistema te mostrará un mensaje indicando que no se encontró el comando <br>
### Windows
Ve al sitio web oficial de [Java](https://www.oracle.com/java/technologies/javase-downloads.html) y descarga la última versión de Java JDK(Java Development Kit)<br>

### Linux 
```
sudo apt install openjdk-11-jdk
```

### MacOs
1. Ve al sitio web de [AdoptOpenJDK](https://adoptopenjdk.net/).
2. En la sección "Latest release", selecciona la versión de Java que deseas instalar (por ejemplo, "OpenJDK 11 (LTS)").
3. Haz clic en el enlace de descarga para macOS.
4. Ejecuta el instalador descargado y sigue las instrucciones del asistente de instalación <br>

*Version recomendada 11.0.19*

## Gradle

Gradle ->  se encarga de compilar el código fuente, ejecutar las pruebas, generar informes de resultados y empaquetar la aplicación para su distribución.

# Para la instalación de Gradle:

### Windows

Descargan Gradle de la [página oficial](https://gradle.org/)

El archivo lo pueden descomprimir en C: o donde prefieran (les recomiendo directamente en el C). La carpeta extraída la renombran como gradle.

Abriendo el Panel de Control -> Sistema -> Configuración avanzada del sistema -> Variables de entorno … o ejecutando el comando ENV al tocar la lupa de Windows van a llegar a donde configuramos las locaciones de JAVA HOME, Gradle entre otros.

Añadimos C:\gradle\bin a la variable PATH

### MacOS

Acá el tema es más fácil. Con Homebrew instalado vamos a ejecutar, en la terminal
```
brew install gradle
```
### Linux
Instala el Software Development Kit Manager [Sdkman](https://sdkman.io/)

Instala Gradle con el siguiente comando:
```
sdk install gradle
```

1. **Configura  las variables de entorno JAVA_HOME** <br>
chequea donde se encuentra java:
```
which java
```
Esto te mostrará la ruta completa del ejecutable de Java.

Abre tu archivo .bashrc o .zshrc
```
nano ~/.zshrc   # Para zsh
```

Agrega la siguiente línea al archivo con la ruta de tu instalación de Java (reemplaza /ruta/a/java con la ubicación real que obtuviste en el paso anterior):

```
export JAVA_HOME=/ruta/a/java
```

2. **Configura la variable de entorno PATH**
- Descarga el ChromeDriver adecuado para tu sistema operativo desde el [sitio oficial](https://sites.google.com/chromium.org/driver/)
- Descomprime el archivo descargado para obtener el ejecutable del ChromeDriver.

Abre tu archivo .bashrc o .zshrc
```
nano ~/.zshrc   # Para zsh
```

```
export PATH=/ruta/del/directorio/con/chromedriver:$PATH
```

##### windows -> ```setx PATH "%PATH%;C:\ruta\del\directorio\con\chromedriver"```

Verifica que el ChromeDriver esté configurado correctamente en el PATH ejecutando el siguiente comando:
```
chromedriver --version
```
Debería mostrar la versión del ChromeDriver si está configurado correctamente.


3. **Clona el repositorio**:

#### Https:
```
git clone https://github.com/metlabtesting/selenium_testingqarvn.git
```


**Muevete al directorio**

Donde hayas clonado el repo.
   En tu terminal deberias estar dentro de
   `/selenium_testingqarvn`

 **Instala las dependencias**: (solo la primera vez)

Con comando
```
gradle clean 
```

y luego
```
gradle build
```

4. **Corre los tests**
```
gradle test
```

 5. **Crea tu rama con el gitFlow** correspondiente y empieza a codear! 🚀✨✨

# Criterios para hacer una PR

1. Perfecta nomenclatura del nombre de Archivo de prueba: <br>
   `{ID}-{ShortName}.{extensionFile} ej: T001-camposRequeridos.java`
2. Que se vea bien el codigo en general, que funcione.
3. Usar Fixtures en caso que haya datos para iterar.
4. Usar PageObjectModel.


# Menciones

Autor de la web: [ Rodrigo Igor Villanueva Nieto](https://testingqarvn.com.es/sobre-mi/)