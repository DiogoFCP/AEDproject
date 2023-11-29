package AVLtest;

import dataStructures.*;
public class AVLTest {
    public static void main(String[] args) {

        AVLTree<Integer, objetoTeste> teste = new AVLTree<>();
        Iterator<Entry<Integer, objetoTeste>> it;
        int numb = (int)(Math.random()*1000 % 100);
        for (int i = 0; i <= numb; i++) {
            addValues(teste,i);
        }

        int numb2 = (int)(Math.random()*1000 % numb);
        for (int i = 0; i < numb2; i++) {
            System.out.println("Removing " + numb2);
            teste.remove(numb2);
            numb2 = (int) (Math.random()*1000 % numb);
        }
        System.out.println("Removing " + numb2);
        teste.remove(numb2);

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

