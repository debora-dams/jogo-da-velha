package jogoDaVelha;

public class Tabuleiro {

	private int[][] tabuleiro = new int[3][3];

	public Tabuleiro() {
		zerarTabuleiro();
	}

	public void zerarTabuleiro() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				tabuleiro[linha][coluna] = 0;
			}
		}
	}

	public void exibirTabuleiro() {
		System.out.println();
		System.out.println();
		System.out.printf("\t\t %s %s %s %s %s \n", tabuleiro[0][0], "|", tabuleiro[0][1], "|", tabuleiro[0][2]);
		System.out.printf("\t\t%s%s%s%s%s%s%s%s%s%s%s \n", "=", "=", "=", "╬", "=", "=", "=", "╬", "=", "=", "=");
		System.out.printf("\t\t %s %s %s %s %s \n", tabuleiro[1][0], "|", tabuleiro[1][1], "|", tabuleiro[1][2]);
		System.out.printf("\t\t%s%s%s%s%s%s%s%s%s%s%s \n", "=", "=", "=", "╬", "=", "=", "=", "╬", "=", "=", "=");
		System.out.printf("\t\t %s %s %s %s %s \n", tabuleiro[2][0], "|", tabuleiro[2][1], "|", tabuleiro[2][2]);
	}

	/*
	 * public void exibirTabuleiro() { System.out.println(); for (int linha = 0;
	 * linha < 3; linha++) { for (int coluna = 0; coluna < 3; coluna++) { if
	 * (tabuleiro[linha][coluna] == -1) { System.out.println(" X "); }
	 * 
	 * if (tabuleiro[linha][coluna] == 1) { System.out.println(" O "); }
	 * 
	 * if (tabuleiro[linha][coluna] == 0) { System.out.println("  "); }
	 * 
	 * if (coluna == 0 || coluna == 1) System.out.println(" | "); }
	 * 
	 * System.out.println();
	 * 
	 * } }
	 */

	public int getPosicao(int[] tentativa) {
		return tabuleiro[tentativa[0]][tentativa[1]];
	}

	public void setPosicao(int[] tentativa, int jogador) {
		if (jogador == 1)
			tabuleiro[tentativa[0]][tentativa[1]] = -1;
		else
			tabuleiro[tentativa[0]][tentativa[1]] = 1;

		exibirTabuleiro();
	}

	public int checarLinhas() {
		for (int linha = 0; linha < 3; linha++) {
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return -1;
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return 1;
		}

		return 0;
	}

	public int checarColunas() {
		for (int coluna = 0; coluna < 3; coluna++) {
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
				return -1;
		}

		return 0;
	}

	public int checarDiagonais() {
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
			return -1;
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
			return 1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
			return -1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
			return 1;

		return 0;
	}

	public boolean tabuleiroCompleto() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				if (tabuleiro[linha][coluna] == 0)
					return false;

			}
		}
		return true;
	}

}
