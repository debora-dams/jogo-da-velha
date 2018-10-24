package jogoDaVelha;

import java.util.Scanner;

public class Jogo {

	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private Jogador jogador1;
	private Jogador jogador2;
	public Scanner entrada = new Scanner(System.in);
	
	public Jogo() {
		tabuleiro = new Tabuleiro();
		iniciarJogadores();
		
		while(Jogar());
	}
	
	public void iniciarJogadores() {
		System.out.println("Quem sera o Jogador 1?");
		if(escolherJogador() == 1)
			this.jogador1 = new Humano(1);
		
		else
			this.jogador1 = new Computador(1);
		
		System.out.println("-----------------------");
		System.out.println("Quem sera o Jogador 2?");
		
		if(escolherJogador() == 1)
			this.jogador2 = new Humano(2);
		else
			this.jogador2 = new Computador(2);
	}
	
	public int escolherJogador() {
		int opcao = 0;
		
		do {
			System.out.println("1 - Humano");
			System.out.println("2 - Computador\n");
			System.out.println("Opção: ");
			opcao = entrada.nextInt();
			
			if((opcao != 1) && (opcao != 2))
				System.out.println("Opcao invalida! Tente novamente");
		}
		while((opcao != 1) && (opcao != 2));
		
		return opcao;
	}
	
	public boolean jogar() {
		if(ganhou() == 0) {
			System.out.println("-------------------");
			System.out.println("\nRodada " + rodada);
			System.out.println("É a vez d jogador " + vez());
			
			if(vez() == 1)
				jogador1.jogar(tabuleiro);
			else
				jogador2.jogar(tabuleiro);
			
			if(tabuleiro.tabuleiroCompleto()) {
				System.out.println("Tabuleiro Completo. Jogo empatado");
				return false;
			}
			
			vez++;
			rodada++;
			
			return true;
		}
		else {
			if(ganhou() == -1)
				System.out.println("Jogador 1 ganhou!!!");
			else
				System.out.println("Jogador 2 ganhou!!!");
		}
	}
	
}
