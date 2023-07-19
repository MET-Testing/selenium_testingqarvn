
# Java with Selenium

Web de pruebas para practicar Selenium con Java
# Cómo empezar?

0. **Ten instaladas extensiones **<br>
Instala extensiones de Gradle 
```
Instala pack de extensiones de Java
```
# Para la instalación de Gradle:

**Windows** 

Descargan Gradle de la página oficial que no puedo linkearles acá.

El archivo lo pueden descomprimir en C: o donde prefieran (les recomiendo directamente en el C). La carpeta extraída la renombran como gradle.

Abriendo el Panel de Control -> Sistema -> Configuración avanzada del sistema -> Variables de entorno … o ejecutando el comando ENV al tocar la lupa de Windows van a llegar a donde configuramos las locaciones de JAVA HOME, Gradle entre otros.

Añadimos C:\gradle\bin a la variable PATH

**MacOS**

Acá el tema es más fácil. Con Homebrew instalado vamos a ejecutar, en la terminal: brew install gradle

**Clona el repositorio**:

#### Https:

     ```
    git clone https://github.com/metlabtesting/selenium_testingqarvn.git
    ```


**Muevete al directorio**

donde hayas clonado el repo.
   En tu terminal deberias estar dentro de
   `/selenium_testingqarvn`

 **Instala las dependencias**: (solo la primera vez)

Con comando  gradle clean y luego gradle build
```

 **Crea tu rama** y empieza a codear! 🚀✨✨

# Criterios para hacer una PR

1. Perfecta nomenclatura del nombre de Archivo de prueba: <br>
   `{ID}-{ShortName}.{extensionFile} ej: T001-camposRequeridos.cy.js`
2. Archivo de Prueba dentro del directorio del Componente correspondiente:<br>
   ``
3. Que se vea bien el codigo en general, que funcione.
4. Usar Fixtures en caso que haya datos para iterar.
5. Usar PageObjectModel: Chequear que el "Page.js" esté dentro de la carpeta "pages" en la de "support", ejemplo: <br>
6. En caso de usar Commands: Asegurarse de aplicarlo para crear pasos de Precondiciones o Scripts de Algoritmos globales. (No para pasos de accion)

# Menciones

Autor de la web: [ Rodrigo Igor Villanueva Nieto](https://testingqarvn.com.es/sobre-mi/)