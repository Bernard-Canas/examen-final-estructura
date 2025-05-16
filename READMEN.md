# Árbol AVL - Implementación en Java

## Descripción del Proyecto
Este proyecto y/o examen implementa un árbol AVL (árbol binario de búsqueda auto-balanceable) en Java. Este programa permite al usuario construir un árbol AVL insertando valores numéricos y muestra visualmente la estructura del árbol después de cada inserción.

## Características Principales
- Inserción de nodos con auto-balanceo (rotaciones simples y dobles)
- Visualización clara del árbol en consola
- Interfaz interactiva para construir el árbol paso a paso
- Validación de entrada de datos

## Requisitos
- Java JDK 8 o superior
- Terminal o línea de comandos

## Instrucciones de Ejecución
## Enlace de video: https://youtu.be/8qgeR2KFFTU

### Compilación
1. Asegúrate de tener los 3 archivos en el mismo directorio(carpeta):
   - `Node.java`
   - `AVLTree.java`
   - `Main.java`

2. Compila el programa con:
   ```bash
   javac Main.java

CONSTRUCCIÓN DE ÁRBOL AVL
Ingrese la cantidad de números para el árbol: 5
Ingrese los números uno por uno o exit para salir:
Número 1: 10

Árbol después de insertar 10:
10 

Número 2: 20

Árbol después de insertar 20:
10 
  \ 
20 

Número 3: 30

Árbol después de insertar 30:
20 
/ \ 
10 30 

ÁRBOL AVL FINAL:
20 
/ \ 
10 30 
   / \ 
   
[...dependiendo de que tan largo sea el arbol solicitado....]

