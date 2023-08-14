import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;


    public Peca(String cor, Posicao posicao){
        this.cor=cor;
        this.posicao= posicao;
    }

    public boolean mover( Posicao posicao, ArrayList<Posicao>possiveisMovimentos){


                if(this instanceof Peao){
                    ((Peao) this).setPrimMov(false);
                }else if (this instanceof Torre){
                    ((Torre)this).setPrimeiroMovimento(false);
                }

                //Atribuindo a peça para a nova posição no tabuleiro
                posicao.setPeca(this);
                //Removendo a peça da posição anterior
                this.posicao.setPeca(null);
                //Trocando a posição atual da peça
                this.posicao = posicao;
                return true;
    }

    public boolean validaExtremidade(int posicaoNoTabuleiro){
        return  posicaoNoTabuleiro % 8 == 0;
    }

    public abstract ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro, boolean simular);


    public void removerMovimentoDoRei(Posicao posicao,ArrayList<Posicao> poTabuleiro ,Jogador jogador, Jogador adversario){
        ArrayList<Posicao> possiveisMovimentos = possiveisMovimentos(poTabuleiro,true );
        for (Posicao i : possiveisMovimentos) {
            if (i == posicao){
                possiveisMovimentos.remove(posicao);
            }
        }

    }

    public Posicao getPosicao() {
        return posicao;
    }

    public String getCor() {
        return cor;
    }

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos, ArrayList<Posicao> poTabuleiro, boolean simular) {
        if(simular){
            if (simularJogada(posicao, possiveisMovimentos, poTabuleiro)) {
                if (posicao.getPeca() == null) {
                    possiveisMovimentos.add(posicao);
                    return false;
                } else {
                    if (!posicao.getPeca().getCor().equals(this.getCor())) {
                        possiveisMovimentos.add(posicao);
                    }
                    return true;
                }
            }
        } else{
            if (posicao.getPeca() == null) {
                possiveisMovimentos.add(posicao);
                return false;
            } else {
                if (!posicao.getPeca().getCor().equals(this.getCor())) {
                    possiveisMovimentos.add(posicao);
                }
                return true;
            }
        }
        return false;
    }

    private boolean simularJogada (Posicao posicao, ArrayList<Posicao> possiveisMovimentos,ArrayList<Posicao> poTabuleiro){
        Peca pecaAntiga = posicao.getPeca();
        Posicao antigaPosicao = this.posicao;

        this.mover( posicao,  possiveisMovimentos);
        System.out.println(Tabuleiro.verificarXeque(poTabuleiro, this));
        if(Tabuleiro.verificarXeque(poTabuleiro, this)){
           this.mover(antigaPosicao, possiveisMovimentos);
            posicao.setPeca(pecaAntiga);
           return false;
        }else{
            this.mover(antigaPosicao, possiveisMovimentos);
            posicao.setPeca(pecaAntiga);
            return true;
        }
    }



    @Override
    public String toString() {
        return "Peca{" +
                "cor='" + cor + '\'' +
                ", posicao=" + posicao +
                '}';
    }
}
