import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static Jogador[] jogadorLogado= new Jogador[2];
    public static void main(String[] args) {

        int decisao=0;
        do {
            decisao = menuDeCadastro();

        }while(decisao!=1);

    }
    private static int menuDeCadastro(){
        int decisao = 0;
        System.out.println("""
                ----- MENU DE LOGIN -----
                1- Login
                2- Cadastrar
                3- Sair
                """);
        decisao = sc.nextInt();
        switch (decisao){
            case 1:
                if ( verificarJogador()){
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

    private static void menuInicial(){
        int decisao = 0;
        System.out.println("""
                ----- MENU INICIAL -----
                
                1- Iniciar Partida
                2- Ver Lista de usuários
                3- Sair""");
                decisao = sc.nextInt();
        switch (decisao){
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
    private static void partida(){
        Tabuleiro tabuleiro = new Tabuleiro();
        jogadorLogado[0].setCor("Branco",tabuleiro);
        jogadorLogado[1].setCor("Preto",tabuleiro);
        Boolean ganhador = false;
        int cont = 0;
        int escolhaPeca = 0;
        int escolhaPosicao=0;
        do {

            System.out.println("\n"+tabuleiro);
            if(cont % 2 == 0){
                //Rodada do Jogador 1
                System.out.println("\n----- JOGADOR "+jogadorLogado[0].getNome()+ "-----");

                //Escolha da Peça
                System.out.println(jogadorLogado[0].getPecas());
                escolhaPeca = sc.nextInt();
                Peca peca = jogadorLogado[0].getPecas().get(escolhaPeca);
                System.out.println(peca);

                while (peca.possiveisMovimentos(tabuleiro).size()<=0) {
                    //Escolha da Peça
                    System.out.println("Escolha peça novamente \n" + jogadorLogado[0].getPecas());
                    escolhaPeca = sc.nextInt();
                    peca = jogadorLogado[0].getPecas().get(escolhaPeca);
                    System.out.println(peca);
                }



                //Escolha da posição para o movimento
                ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);

                System.out.println(posicoes);
                 escolhaPosicao = sc.nextInt();
                System.out.println("EscolhaPosicao: "+posicoes.get(escolhaPosicao) );
                Posicao posicao = posicoes.get(escolhaPosicao);

                //Movimentação da peça escolhida para a posição desejada
                jogadorLogado[0].moverPeca(peca, posicao,tabuleiro,jogadorLogado[1]);
                System.out.println(tabuleiro);
                ganhador = validarVitoria(jogadorLogado[1]);


            }else{
                //Rodada do Jogador 2
                System.out.println("\n----- JOGADOR "+jogadorLogado[1].getNome()+ "-----");
                //Escolha da Peça
                System.out.println(jogadorLogado[1].getPecas());
                 escolhaPeca = sc.nextInt();
                Peca peca = jogadorLogado[1].getPecas().get(escolhaPeca);
                System.out.println(peca);

                while (peca.possiveisMovimentos(tabuleiro).size()<=0) {
                    //Escolha da Peça
                    System.out.println("Escolha peça novamente \n" + jogadorLogado[1].getPecas());
                    escolhaPeca = sc.nextInt();
                    peca = jogadorLogado[1].getPecas().get(escolhaPeca);
                    System.out.println(peca);
                }



                //Escolha da posição para o movimento
                ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
                System.out.println(posicoes);
                 escolhaPosicao = sc.nextInt();
                System.out.println(escolhaPosicao);
                Posicao posicao = posicoes.get(escolhaPosicao);

                //Movimentação da peça escolhida para a posição desejada
                jogadorLogado[1].moverPeca(peca, posicao,tabuleiro,jogadorLogado[0]);

                ganhador = validarVitoria(jogadorLogado[0]);
            }
            cont++;
        }while(!ganhador);
    }


    private static boolean verificarJogador(){
        int cont= 0;
        String nome="";
        String senha="";
        for (int i = 0; i <2 ; i++) {
            cont = 0;
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
                    System.out.println(nome+" "+senha);
                }
                cont ++;
                System.out.println(nome+" "+senha);
                jogadorLogado[i] = Jogador.verificarSenha(nome,senha);
                System.out.println(jogadorLogado[i]);
                if (jogadorLogado[i]!=null){
                    cont = 4;
                }
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



    private static boolean validarVitoria(Jogador adversario){
        for (Peca peca: adversario.getPecas()) {
            if (peca instanceof Rei){
                return false;
            }
        }
        return true;
    }
}
