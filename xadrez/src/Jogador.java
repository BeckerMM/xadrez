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

    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro, posicao);
        if (posicao.getPeca() != null && valida) {
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }


    public static Jogador verificarSenha(String nome, String senha){
        System.out.println(listadeJogadores);
        Jogador jogadorVer = null;
        for (Jogador jogador: listadeJogadores) {
            if (jogador.nome.equals(nome)){
                if (jogador.senha.equals(senha)){
                    jogadorVer = jogador;
                }
            }
        }
        return jogadorVer;
    }

    public boolean proporEmpate(Jogador jogador) {
        return true;
    }

    public void desistir() {

    }

    public String getNome() {
        return nome;
    }
}

