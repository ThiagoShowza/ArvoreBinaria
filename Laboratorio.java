package provaArvoreBinaria;

import java.util.Random;
import java.util.Scanner;

public class Laboratorio {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random gerador = new Random();
       
        int grau, escolha;
        
        //CADA NÚMERO REPRESENTA UM GRAU DE PARENTESCO, E O USUÁRIO TERÁ A OPÇÃO DE EXCLUIR ESSE GRAU DA FORMA QUE DESEJAR;
        //O PROGRAMA AUTOMATICAMENTE VAI PUXAR OS DADOS DE CONSULTA, E IRÁ INFORMA-LOS NA TELA;
        
		arvore.insereValor(arvore.raiz, gerador.nextInt(100)+1);
		arvore.insereValor(arvore.raiz, gerador.nextInt(100)+1);
		arvore.insereValor(arvore.raiz, gerador.nextInt(100)+1);
		arvore.insereValor(arvore.raiz, gerador.nextInt(100)+1);
		arvore.insereValor(arvore.raiz, gerador.nextInt(100)+1);


        
		arvore.imprimeArvore(arvore.getRaiz());
		
        System.out.println("Insira o grau de parentesco que voce deseja consultar: ");
        grau = leitor.nextInt();

        arvore.buscarValor(arvore.getRaiz(), grau);

        System.out.println("Deseja deletar o parentesco: 1- DELETAR");
        escolha = leitor.nextInt();

        if (escolha == 1){
            arvore.removeNo(arvore.getRaiz(), grau);
            System.out.println("Grau de parentesco deletado !");
        }
        arvore.imprimeArvore(arvore.getRaiz());
        arvore.liberaMemoria(arvore.getRaiz());
	

		
		
	}

}

