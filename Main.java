import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia del árbol AVL
        AVLTree arbol = new AVLTree();

        System.out.println("\n -- CONSTRUCCIÓN DE ÁRBOL AVL --");
        // Solicitar al usuario la cantidad de números a insertar
        System.out.print("Ingrese la cantidad de números para el árbol: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        // Instrucciones para el usuario
        System.out.println("Ingrese los números uno por uno o exit para salir:");

        int contador = 0;
        // Bucle para insertar los números solicitados
        while (contador < cantidad) {
            // Solicitar cada número individualmente
            System.out.print("Número " + (contador + 1) + ": ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("exit")) break;

            try {
                int valor = Integer.parseInt(entrada);
                if (valor == -1) break;

                arbol.raiz = arbol.insertar(arbol.raiz, valor);
                contador++;

                // Mostrar el árbol después de cada inserción
                System.out.println("\nÁrbol después de insertar " + valor + ":");
                arbol.printTree(arbol.raiz);
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número o 'exit'.");
            }
        }

        // Mostrar el árbol AVL final
        System.out.println("\nÁRBOL AVL FINAL:");
        arbol.printTree(arbol.raiz);
        scanner.close();
    }
}