package tree;

import estrut.Tree;


public class BinarySearchTree implements Tree{

    private class Node {
        int valor;
        Node left, right;
        int altura; //balanceamento da AVL

        Node(int valor) {
            this.valor = valor;
            altura = 1;
        }
    }

    private Node root;

    @Override
    public boolean buscaElemento(int valor) {
        return buscaRecursiva(root, valor);
    }

    private boolean buscaRecursiva(Node node, int valor) {
        if (node == null) {
            return false; 
        }
        if (valor == node.valor) {
            return true; // Valor encontrado
        } else if (valor < node.valor) {
            return buscaRecursiva(node.left, valor); // Buscar na subárvore esquerda
        } else {
            return buscaRecursiva(node.right, valor); // Buscar na subárvore direita
        }
    }

    @Override
    public int minimo() {
        if (root == null) {
            throw new IllegalStateException("Árvore está vazia");
        }
        return encontrarMinimo(root).valor;
    }

    private Node encontrarMinimo(Node node) {
        if (node.left == null) {
            return node; // Nó mais à esquerda encontrado
        }
        return encontrarMinimo(node.left); // Continuar buscando na subárvore esquerda
    }

    @Override
    public int maximo() {
        return 0;
    }

    @Override
    public void insereElemento(int valor) {
        root = inserirRec(root, valor);
    }

    private Node inserirRec(Node node, int valor){
        if (node == null) {
            return new Node(valor);
        }

        if(valor < node.valor) {
            node.left = inserirRec(node.left, valor);
        } else if (valor > node.valor) {
            node.right = inserirRec(node.right, valor);
        } else {
            return node;
        }

        node.altura = 1 + Math.max(getAltura(node.left), getAltura(node.right));

        return node;
    }

    private int getAltura(Node node) {
        if (node == null) {
            return 0;
        }
        return node.altura;
    }
    
    @Override
    public void remove(int valor) {
        return;
    }

    @Override
    //raiz antes dos valores
    public int[] preOrdem() {
        return new int[]{1,2};
    }

    @Override
    //valores da esquerda, raiz, valores da direita
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    //raiz depois dos valores das folhas
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}