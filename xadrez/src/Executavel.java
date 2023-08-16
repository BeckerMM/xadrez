import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static Jogador[] jogadorLogado = new Jogador[2];

    public static void main(String[] args) {

        int decisao;
        do {
            decisao = menuDeCadastro();

        } while (decisao != 1);
    }

    private static int menuDeCadastro() {
        int decisao;
        System.out.println("""
                ----- MENU DE LOGIN -----
                1- Login
                2- Cadastrar
                3- Sair
                """);
        decisao = sc.nextInt();
        switch (decisao) {
            case 1:
                if (verificarJogador()) {
                    menuInicial();
                }
                break;
            case 2:
                cadastrarJogador();
                break;
            case 3:
                return 1;
            default:
                System.out.println("Número inválido!");
        }
        return 0;
    }

    private static void menuInicial() {
        int decisao;
        System.out.println("""
                ----- MENU INICIAL -----
                                
                1- Iniciar Partida
                2- Ver Lista de usuários
                3- Sair""");
        decisao = sc.nextInt();
        switch (decisao) {
            case 1:
                partida();
                break;
            case 2:

                break;
            case 3:

            default:
                System.out.println("Valor inválido!");
        }

    }

    private static void partida() {
        Tabuleiro tabuleiro = new Tabuleiro();
        jogadorLogado[0].setCor("Branco", tabuleiro);
        jogadorLogado[1].setCor("Preto", tabuleiro);
        boolean ganhador;
        int cont = 0;

        do {

            System.out.println("\n" + tabuleiro);
            if (cont % 2 == 0) {
                ganhador = jogada(jogadorLogado[0], jogadorLogado[1], tabuleiro);
            } else {
                ganhador = jogada(jogadorLogado[1], jogadorLogado[0], tabuleiro);

            }
            cont++;
        }
        while (!ganhador);
    }

    private static boolean jogada(Jogador jogador, Jogador adversario, Tabuleiro tabuleiro) {

        boolean xequeMate = verificarXequeMate(jogador, tabuleiro.getPosicoes());
        if (!xequeMate) {
            int escolhaPeca;
            int escolhaPosicao;

            System.out.println("\n----- JOGADOR " + jogador.getNome() + "-----");

            //Escolha da Peça
            Peca peca;
            System.out.println(Tabuleiro.verificarXeque(tabuleiro.getPosicoes(), adversario.getPecas().get(0)));

            if (Tabuleiro.verificarXeque(tabuleiro.getPosicoes(), jogador.getPecas().get(0))) {
                ArrayList<Peca> pecaSalvamRei = pecasPermitidasParaJogoEmXeque(jogador, tabuleiro.getPosicoes(), adversario.getCor());
                System.out.println("Rei em perigo !!");
                System.out.println("Escolha uma peça para tirar seu rei do perigo:");
                System.out.println(pecaSalvamRei);
                escolhaPeca = sc.nextInt();
                peca = pecaSalvamRei.get(escolhaPeca);
                System.out.println(peca);
                while (peca.possiveisMovimentos(tabuleiro.getPosicoes(), true).size() <= 0) {
                    //Escolha da Peça
                    System.out.println("Escolha peça novamente \n" + pecaSalvamRei);
                    escolhaPeca = sc.nextInt();
                    peca = pecaSalvamRei.get(escolhaPeca);
                    System.out.println(peca);
                }
            } else {
                System.out.println(jogador.getPecas());
                escolhaPeca = sc.nextInt();
                peca = jogador.getPecas().get(escolhaPeca);
                System.out.println(peca);
                while (peca.possiveisMovimentos(tabuleiro.getPosicoes(), true).size() <= 0) {
                    //Escolha da Peça
                    System.out.println("Escolha peça novamente \n" + jogador.getPecas());
                    escolhaPeca = sc.nextInt();
                    peca = jogador.getPecas().get(escolhaPeca);
                    System.out.println(peca);
                }
            }
            ArrayList<Posicao> posicoes;
            posicoes = peca.possiveisMovimentos(tabuleiro.getPosicoes(), true);
            System.out.println(posicoes);
            escolhaPosicao = sc.nextInt();
            Posicao posicao = percorrerPosicoesDojogador(escolhaPosicao, posicoes);
            if (posicao == null) {
                do {
                    System.out.println("\nPosição invalida!! escolha outra:");
                    escolhaPosicao = sc.nextInt();
                    posicao = percorrerPosicoesDojogador(escolhaPosicao, posicoes);
                } while (posicao == null);

            }

            System.out.println("EscolhaPosicao: " + posicao);

            //Movimentação da peça escolhida para a posição desejada
            jogador.moverPeca(peca, posicao, tabuleiro, jogador, adversario);
            System.out.println(tabuleiro);
        }else {
            System.out.println("Jogador "+ adversario.getNome()+ " venceu!! ");
        }
        System.out.println("xequeMate " + xequeMate);
        return xequeMate;
    }

    private static Posicao percorrerPosicoesDojogador(int numeroDaPosicao, ArrayList<Posicao> posicoes) {
        for (Posicao posicao : posicoes) {
            if (posicao.getNumero() == numeroDaPosicao) {
                return posicao;
            }
        }
        return null;
    }

    private static boolean verificarJogador() {
        int cont;
        String nome;
        String senha;
        for (int i = 0; i < 2; i++) {
            cont = 0;
            do {

                if (cont == 0) {
                    System.out.println("Digite seu nome:");
                    nome = sc.next();
                    System.out.println("Digite sua senha:");
                    senha = sc.next();
                } else {
                    System.out.println("Digite seu nome novamente:");
                    nome = sc.next();
                    System.out.println("Digite sua senha novamente:");
                    senha = sc.next();
                    System.out.println(nome + " " + senha);
                }
                cont++;
                System.out.println(nome + " " + senha);
                jogadorLogado[i] = Jogador.verificarSenha(nome, senha);
                System.out.println(jogadorLogado[i]);
                if (jogadorLogado[i] != null) {
                    cont = 4;
                }
            } while (cont < 3);
        }
        return jogadorLogado[0] != null && jogadorLogado[1] != null;
    }

    private static void cadastrarJogador() {

        System.out.println("Digite o nome do jogador:");
        String nome = sc.next();
        System.out.println("Digite a senha do Jogador");
        String senha = sc.next();
        new Jogador(nome, senha);
    }

    public static ArrayList<Peca> pecasPermitidasParaJogoEmXeque(Jogador jogador, ArrayList<Posicao> posicoes, String corAdversario) {
        ArrayList<Peca> pecasPossui = new ArrayList<>();
        for (Peca peca : jogador.getPecas()) {
            if (!peca.getCor().equals(corAdversario)) {
                if (peca.pecaSalvaRei(posicoes)) {
                    pecasPossui.add(peca);
                }
            }
        }

        return pecasPossui;
    }

    private static boolean verificarXequeMate(Jogador jogador ,ArrayList<Posicao> poTabuleiro){
        int verificarMate=0;
        for (Peca peca: jogador.getPecas()) {
            if(peca.possiveisMovimentos(poTabuleiro,true).size()>0){
                verificarMate++;

            }

        }

        return verificarMate == 0;
    }

}