package provaArvoreBinaria;

public class Laboratorio {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();

		arvore.insereValor(arvore.raiz, 5);
		arvore.insereValor(arvore.raiz, 10);
		arvore.insereValor(arvore.raiz, 15);
		arvore.insereValor(arvore.raiz, 20);
		arvore.insereValor(arvore.raiz, 25);

		arvore.imprimeArvore(arvore.raiz);
		arvore.buscarValor(arvore.raiz, 10);	
		arvore.liberaMemoria(arvore.raiz);
	

	}

}

