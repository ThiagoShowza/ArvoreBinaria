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
		// Verifica se existe a arvore
		if (raiz == null)
			return;

		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel + 1);
		calculaNivelNos(raiz.getDireito(), nivel + 1);
	}

	public void insereValor(No raiz, int valor) {
		// Verifica se a árvore está vazia
		if (this.raiz == null) {
			this.raiz = new No(valor);
			return;
		}

		// Verifica para que lado da raiz vai andar
		if (valor > raiz.getValor()) {
			// Se nao tiver lado direito, insere
			if (raiz.getDireito() == null) {
				raiz.setDireito(new No(valor));
				return;
			}

			// Insere recursivamente
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
		return false;
	}

	public No removeNo(No raiz, int Valor) {

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
