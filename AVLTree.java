import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    Node raiz; // Raíz del árbol AVL

    // Obtiene la altura de un nodo (0 si es nulo)
    int getAltura(Node nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Calcula el factor de balance de un nodo (diferencia de alturas entre subárboles)
    int getFactorBalance(Node nodo) {
        return nodo == null ? 0 : getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    // Actualiza la altura de un nodo basado en sus subárboles
    void actualizarAltura(Node nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        }
    }

    // Rotación simple a la derecha para balancear el árbol
    Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Rotación simple a la izquierda para balancear el árbol
    Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // Inserta un nuevo valor en el árbol y lo balancea si es necesario
    Node insertar(Node nodo, int valor) {
        if (nodo == null) return new Node(valor);

        // Inserción estándar en árbol binario
        if (valor < nodo.valor) {
            nodo.izquierda = insertar(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertar(nodo.derecha, valor);
        } else {
            return nodo; // No se permiten valores duplicados
        }

        actualizarAltura(nodo);
        int factorBalance = getFactorBalance(nodo);

        // Casos de rotación para balancear el árbol:
        // 1. Rotación simple derecha
        if (factorBalance > 1 && valor < nodo.izquierda.valor) {
            return rotarDerecha(nodo);
        }
        // 2. Rotación simple izquierda
        if (factorBalance < -1 && valor > nodo.derecha.valor) {
            return rotarIzquierda(nodo);
        }
        // 3. Rotación doble izquierda-derecha
        if (factorBalance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        // 4. Rotación doble derecha-izquierda
        if (factorBalance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Imprime el árbol de forma jerárquica en la consola
    void printTree(Node root) {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean hasNodes = false;
            
            // Imprimir valores del nivel actual
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current != null) {
                    System.out.print(current.valor);
                    queue.add(current.izquierda);
                    queue.add(current.derecha);
                    if (current.izquierda != null || current.derecha != null) {
                        hasNodes = true;
                    }
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }
                System.out.print(" ");
            }
            System.out.println();
            
            if (!hasNodes) break;
            
            // Imprimir las conexiones entre nodos
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.peek();
                if (current != null && current.izquierda != null) {
                    System.out.print("/ ");
                } else {
                    System.out.print("  ");
                }
                if (current != null && current.derecha != null) {
                    System.out.print("\\ ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}