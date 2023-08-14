import java.util.ArrayList;

public class Jogador {
    static ArrayList<Jogador> listadeJogadores = new ArrayList<Jogador>();
    private String nome;
    private String senha;
    private String cor;
    private double pontos;
    private ArrayList<Peca> pecas;

    public Jogador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.pecas = new ArrayList<Peca>();
        listadeJogadores.add(this);
    }

    public Jogador() {

    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao : tabuleiro.getPosicoes()) {
            if (posicao.getPeca() != null && posicao.getPeca().getCor().equals(this.cor)) {
                this.pecas.add(posicao.getPeca());
            }
        }
        this.cor = cor;
    }


    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro,Jogador jogador, Jogador adversario) {
        ArrayList<Posicao> possiveisMovimentos = peca.possiveisMovimentos(tabuleiro.getPosicoes(),true );
        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover( posicao, possiveisMovimentos);
        if (posicao.getPeca() != null && valida) {
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }


    public static Jogador verificarSenha(String nome, String senha) {
        System.out.println(listadeJogadores);
        Jogador jogadorVer = null;
        for (Jogador jogador : listadeJogadores) {
            if (jogador.nome.equals(nome)) {
                if (jogador.senha.equals(senha)) {
                    jogadorVer = jogador;
                }
            }
        }
        return jogadorVer;
    }
//
//

// verifique se a peça que deu xeque mate não tem a possíbilidade de morrer, pois assim inibi o xeque
//    public boolean verificarPossivelMorteDeQuemDeuXeque(Jogador adversario, Tabuleiro tabuleiro) {
//
//        for (Peca peca : adversario.getPecas()) {
//            for (Posicao posicao : peca.possiveisMovimentos(tabuleiro)) {
//                if (posicao.getPeca() instanceof Rei) {
//
//                    for (Peca i : this.getPecas()) {
//                        for (Posicao posicao1 : i.possiveisMovimentos(tabuleiro)) {
//                            if (posicao1.getPeca() == peca) {
//                                return true;
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//        return false;
//
//    }

    public boolean proporEmpate(Jogador jogador) {
        return true;
    }

    public void desistir() {

    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }
}

