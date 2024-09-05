package tree;

import estrut.Tree;


public class BinarySearchTree implements Tree{

    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    @Override
    public boolean buscaElemento(int x) {
        return auxBuscaElemento(root, x);
    }

    public boolean auxBuscaElemento(Node root, int x){
        if (root == null) return false;

        if (root.value == x) return true;

        if (x < root.value) {
            return auxBuscaElemento(root.left, x);
        }

        return auxBuscaElemento(root.right, x);
    }

    @Override
    public int minimo() {
        return auxMaximo(root);
    }

    public int auxMinimo(Node root) {
        if (root.left == null) return root;
        return auxMinimo(root.left);
    }

    @Override
    public int maximo() {
        return auxMaximo(root);
    }

    public int auxMaximo(Node root) {
        if (root.right == null) return root;
        return auxMaximo(root.right);
    }

    @Override
    public void insereElemento(int valor) {
        root = auxInserir(root, valor);
    }

    public auxInserir(Node root, int valor) {
        if (root == null) {
            return new Node(valor);
        }
    
        if (valor < root.value) {
            root.left = auxInserir(root.left, valor);
        } else if (valor > root.value) {
            root.right = auxInserir(root.right, valor);
        }
        
        return root;
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