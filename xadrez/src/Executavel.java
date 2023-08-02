import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static Jogador[] jogadorLogado= new Jogador[2];
    public static void main(String[] args) {

        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "wilson");
        Tabuleiro tabuleiro = new Tabuleiro();
        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto", tabuleiro);

        System.out.println(tabuleiro);
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
        System.out.println(tabuleiro);
        System.out.println(validarVitoria(j2));


    }

    private static void partida(){
        Tabuleiro tabuleiro = new Tabuleiro();
        jogadorLogado[0].setCor("Branco",tabuleiro);
        jogadorLogado[1].setCor("Preto",tabuleiro);
        Boolean ganhador = false;
        do {

        }while(!ganhador);
    }


    private static boolean verificarJogador(){
        int cont= 0;
        String nome="";
        String senha="";
        for (int i = 0; i <2 ; i++) {

            do {
                if(cont==0){
                    System.out.println("Digite seu nome:");
                    nome = sc.next();
                    System.out.println("Digite sua senha:");
                    senha = sc.next();
                }else{
                    System.out.println("Digite seu nome novamente:");
                    nome = sc.next();
                    System.out.println("Digite sua senha novamente:");
                    senha = sc.next();
                }
                cont ++;
                jogadorLogado[i] = jogadorLogado[i].verificarSenha(nome,senha);
            }while( cont<3 );
        }
        if (jogadorLogado[0] !=null && jogadorLogado[1] != null){
            return true;
        }else{
            return false;
        }
    }

    private  static void cadastrarJogador(){
        System.out.println("Digite o nome do jogador:");
        String nome = sc.next();
        System.out.println("Digite a senha do Jogador");
        String senha= sc.next();
        new Jogador(nome, senha);
    }

    private static void iniciarTabuleiro(){
        for (int i = 0; i < 2; i++) {


            if (i== 1 ){

            }

        }

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
