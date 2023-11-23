package AVLtest;

import dataStructures.*;
public class AVLTest {
    public static void main(String[] args) {

        AVLTree<Integer, objetoTeste> teste = new AVLTree<>();
        Iterator<Entry<Integer, objetoTeste>> it;
        for (int i = 0; i <= 10; i++) {
            addValues(teste,i);
        }

        printValues(teste);

        teste.remove(5);
        teste.remove(3);
        teste.remove(9);

        printValues(teste);

    }

    private static void printValues(AVLTree<Integer, objetoTeste> teste){
        System.out.println("==PRINT==");
        Iterator<Entry<Integer, objetoTeste>> it = teste.iterator();
        while (it.hasNext()) {
            Entry<Integer, objetoTeste> entrada = it.next();
            int chave = entrada.getKey();
            int numero = entrada.getValue().getNumero();
            System.out.printf("Chave %d, numero %d\n",chave,numero);
        }
    }

    private static void addValues(AVLTree<Integer, objetoTeste> teste, int number){
        teste.insert(number, new objetoTeste(number));
    }
}

