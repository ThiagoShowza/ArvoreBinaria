package provaArvoreBinaria;

public class ArvoreBinaria {
	No raiz = null;

	public No getRaiz() {
		return raiz;
	}

	public void liberaMemoria(No raiz) {
		if (raiz == null || raiz.noFolha()) {
			return;
		}

		if (raiz.getDireito() != null) {
			liberaMemoria(raiz.getDireito());
			raiz.setDireito(null);
		}

		if (raiz.getEsquerdo() != null) {
			liberaMemoria(raiz.getEsquerdo());
			raiz.setEsquerdo(null);
		}

		this.raiz = null;
	}

	void calculaNivelNos(No raiz, int nivel) {
//		VERIFICA SE EXISTE A ÁRVORE
		if (raiz == null)
			return;

		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel + 1);
		calculaNivelNos(raiz.getDireito(), nivel + 1);
	}

	public void insereValor(No raiz, int valor) {
//		VERFICIA SE A ÁRVORE ESTÁ VAZIA
		if (this.raiz == null) {
			this.raiz = new No(valor);
			return;
		}
//		VERIFICA O LADO QUE A RAIZ VAI ANDAR
		if (valor > raiz.getValor()) {
//			SE NÃO TIVER LADO DIREITO, É INSERIDO UM VALOR
				if (raiz.getDireito() == null) {
				raiz.setDireito(new No(valor));
				return;
			}

//			INSERE UM VALOR RECURSIVARMENTE
			insereValor(raiz.getDireito(), valor);
		} else {
			if (raiz.getEsquerdo() == null) {
				raiz.setEsquerdo(new No(valor));
				return;
			}

			insereValor(raiz.getEsquerdo(), valor);
		}
	}

	public boolean buscarValor(No raiz, int Valor) {
		boolean aux = false;

		if (raiz == null) {
			aux = false;
		} else if (raiz.getValor() == Valor) {
			aux = true;
		} else {
			if (raiz.getValor() > Valor) {
				aux = buscarValor(raiz.getDireito(), Valor);
			} else {
				aux = buscarValor(raiz.getEsquerdo(), Valor);
			}
		}
		return aux;
	}

	private No maiorValor(No no) {
		while (no.getDireito() != null) {
			no = no.getDireito();
		}

		return no;
	}

	public No removeNo(No raiz, int Valor) {

		if (raiz == null) {
			return raiz;
		}

//		VALOR MENOR, PROCURA NA SUB-ÁRVORE ESQUERDA
		if (Valor < raiz.getValor()) {
			raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), Valor));
		} else if (Valor > raiz.getValor()) {
			raiz.setDireito(removeNo(raiz.getDireito(), Valor));
		} else { 
//			VALOR ENCONTRADO
//			NÃO SÃO UMA FOLHA (NÃO TEM FILHOS)
			
			
			if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
//				REMOVE O VALOR
				return null;
			} else if (raiz.getEsquerdo() != null && raiz.getEsquerdo() != null) {
//				3: NÓ TEM 2 FILHOS
//				ENCONTRA O MAIOR FILHO DO NÓ
				No maiorAntecessor = maiorValor(raiz.getEsquerdo());
//				COPIA O VALOR ANTECESSOR DO NÓ
				raiz.setValor(maiorAntecessor.getValor());
				
//				REMOVE O ANTECESSOR DE FORMA RECURSSIVA
				raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), maiorAntecessor.getValor()));
			} else {
//				4: NÓ TEM UM FILHO
	
				raiz = (raiz.getEsquerdo() != null) ? raiz.getEsquerdo() : raiz.getDireito();
			}
		}

		return raiz;
	}

	public void imprimeArvore(No raiz) {
		if (raiz == null)
			return;

		imprimeArvore(raiz.getEsquerdo());
		System.out.println(raiz.getValor());
		imprimeArvore(raiz.getDireito());
	}
}
