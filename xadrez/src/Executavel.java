import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static Jogador[] jogadorLogado = new Jogador[2];

    public static void main(String[] args) {

        int decisao = 0;
        do {
            decisao = menuDeCadastro();

        } while (decisao != 1);
    }

    private static int menuDeCadastro() {
        int decisao = 0;
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
        int decisao = 0;
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
        boolean ganhador = false;
        int cont = 0;

        do {

            System.out.println("\n" + tabuleiro);
            if (cont % 2 == 0) {
               ganhador =  jogada(jogadorLogado[0], jogadorLogado[1], tabuleiro);
            } else {
              ganhador = jogada(jogadorLogado[1], jogadorLogado[0], tabuleiro);

            }
            cont++;
        }
        while (!ganhador);
    }

    private static boolean jogada(Jogador jogador, Jogador adversario, Tabuleiro tabuleiro) {


        int escolhaPeca = 0;
        int escolhaPosicao = 0;

        System.out.println("\n----- JOGADOR " + jogador.getNome() + "-----");

        //Escolha da Peça
        System.out.println(jogador.getPecas());
        escolhaPeca = sc.nextInt();
        Peca peca = jogador.getPecas().get(escolhaPeca);
        System.out.println(peca);

        while (peca.possiveisMovimentos(tabuleiro.getPosicoes()).size() <= 0) {
            //Escolha da Peça
            System.out.println("Escolha peça novamente \n" + jogador.getPecas());
            escolhaPeca = sc.nextInt();
            peca = jogador.getPecas().get(escolhaPeca);
            System.out.println(peca);
        }

        ArrayList<Posicao> posicoes = new ArrayList<>();
        if (peca instanceof Rei) {
            //Escolha da posição para o movimento
            ((Rei) peca).setPosicaoReiNao(verificarmovimentosNaoRei(tabuleiro.getPosicoes(), peca,jogador,adversario));
            posicoes = peca.possiveisMovimentos(tabuleiro.getPosicoes());
        } else {
            posicoes = peca.possiveisMovimentos(tabuleiro.getPosicoes());
        }
        System.out.println(posicoes);
        escolhaPosicao = sc.nextInt();
        System.out.println("EscolhaPosicao: " + posicoes.get(escolhaPosicao));
        Posicao posicao = posicoes.get(escolhaPosicao);

        //Movimentação da peça escolhida para a posição desejada
        jogador.moverPeca(peca, posicao, tabuleiro,jogador, adversario);
        System.out.println(tabuleiro);
        return validarVitoria(adversario);
    }


    private static boolean verificarJogador() {
        int cont = 0;
        String nome = "";
        String senha = "";
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
        if (jogadorLogado[0] != null && jogadorLogado[1] != null) {
            return true;
        } else {
            return false;
        }
    }

    private static void cadastrarJogador() {

        System.out.println("Digite o nome do jogador:");
        String nome = sc.next();
        System.out.println("Digite a senha do Jogador");
        String senha = sc.next();
        new Jogador(nome, senha);
    }


    private static boolean validarVitoria(Jogador adversario) {
        for (Peca peca : adversario.getPecas()) {
            if (peca instanceof Rei) {
                return false;
            }
        }
        return true;
    }


    public static ArrayList<Posicao> verificarmovimentosNaoRei(ArrayList<Posicao> poTabuleiro, Peca rei ,Jogador jogador, Jogador adversario) {

        ArrayList<Posicao> posicoesReiNao = new ArrayList<>();
        for (Posicao posicao : poTabuleiro) {
            if (posicao.getPeca() != null) {
                if (rei.getCor().equals("Branco")) {

                    if (posicao.getPeca().getCor().equals("Preto")) {
                        for (Posicao possiveis : posicao.getPeca().possiveisMovimentos(poTabuleiro)) {
                            for (Posicao movRei : rei.possiveisMovimentos(poTabuleiro)) {
                                if (movRei == possiveis) {

                                    posicoesReiNao.add(possiveis);
                                }
                            }
                        }
                    }
                } else {
                    // terminar está parte
                    if (posicao.getPeca().getCor().equals("Branco")) {

                        for (Posicao possiveis : posicao.getPeca().possiveisMovimentos(poTabuleiro)) {
                            if (possiveis.getPeca() instanceof Rei) {

                                posicoesReiNao.add(possiveis);
                            }
                        }
                    }
                }
            }
        }
        return posicoesReiNao;
    }

    public static ArrayList<Peca> pecasPermitidasParaJogoEmXeque(Jogador jogador, ArrayList<Posicao> movimentosReiNao) {
        ArrayList<Peca> pecasPossui = new ArrayList<>();
        for (Peca peca : jogador.getPecas()) {
            for (Posicao posicao : movimentosReiNao) {
                if (peca.getPosicao().equals(posicao)) {
                    pecasPossui.add(peca);
                }
            }
        }

        return pecasPossui;
    }




}