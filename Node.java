public class Node {
    int valor;
    Node izquierda;
    Node derecha;
    int altura;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}