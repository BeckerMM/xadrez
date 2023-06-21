import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "wilson");
        Tabuleiro tabuleiro = new Tabuleiro();
        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto", tabuleiro);

        //Escolha da Peça
        System.out.println(j1.getPecas());
        int escolhaPeca = sc.nextInt();
        Peca peca = j1.getPecas().get(escolhaPeca);
        System.out.println(peca);

        //Escolha da posição para o movimento
        ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
        System.out.println(posicoes);
        int escolhaPosicao = sc.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao);

        //Movimentação da peça escolhida para a posição desejada
        j1.moverPeca(peca, posicao,tabuleiro,j2);
        System.out.println(validarVitoria(j2));


    }
    private static boolean validarVitoria(Jogador adversario){
        for (Peca peca: adversario.getPecas()) {
            if (peca instanceof Rei){
                return false;
            }
        }
        return true;
    }
}
