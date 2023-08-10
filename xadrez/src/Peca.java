import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;


    public Peca(String cor, Posicao posicao){
        this.cor=cor;
        this.posicao= posicao;
    }

    public boolean mover( Posicao posicao, ArrayList<Posicao>possiveisMovimentos){

        for (Posicao possicaoPossivel: possiveisMovimentos) {
            System.out.println("possiçãoPossivel : "+possicaoPossivel);
            System.out.println(posicao);
            if (possicaoPossivel==posicao){
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

        }
        return false;
    }

    public boolean validaExtremidade(int posicaoNoTabuleiro){
        return  posicaoNoTabuleiro % 8 == 0;
    }

    public abstract ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro);


    public void removerMovimentoDoRei(Posicao posicao,ArrayList<Posicao> poTabuleiro ,Jogador jogador, Jogador adversario){
        ArrayList<Posicao> possiveisMovimentos = possiveisMovimentos(poTabuleiro );
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

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos, ArrayList<Posicao> poTabuleiro) {

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
        }else {
            return false;
        }
    }

    private boolean simularJogada (Posicao posicao, ArrayList<Posicao> possiveisMovimentos,ArrayList<Posicao> poTabuleiro){
        Peca pecaAntiga = posicao.getPeca();


        this.mover( posicao,  possiveisMovimentos);
        if(Tabuleiro.verificarXeque(poTabuleiro)){
           this.mover(posicao, possiveisMovimentos);
            posicao.setPeca(pecaAntiga);
           return false;
        }else{
            this.mover(posicao, possiveisMovimentos);
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
