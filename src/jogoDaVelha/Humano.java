package jogoDaVelha;

import java.util.Scanner;

public class Humano extends Jogador {

	public Scanner leitor = new Scanner(System.in);

	public Humano(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador 'Humano' entrou no jogo");
	}

	@Override
	public void jogar(Tabuleiro tabuleiro) {
		tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, jogador);

	}

	@Override
	public void tentativa(Tabuleiro tabuleiro) {
		do {
			do {
				System.out.print("Linha: ");
				tentativa[0] = leitor.nextInt();

				if (tentativa[0] > 3 || tentativa[0] < 1)
					System.out.println("Linha nvalida. É 1, 2 ou 3");
			} while (tentativa[0] > 3 || tentativa[0] < 1);

			do {
				System.out.print("Coluna: ");
				tentativa[1] = leitor.nextInt();

				if (tentativa[1] > 3 || tentativa[1] < 1)
					System.out.println("Coluna invalida. É 1, 2 ou 3");
			} while (tentativa[1] > 3 || tentativa[1] < 1);

			tentativa[0]--;
			tentativa[1]--;

			if (!checarTentativa(tentativa, tabuleiro))
				System.out.println("Esse local já foi marcado. Tente outro.");
		} while (!checarTentativa(tentativa, tabuleiro));

	}

}
