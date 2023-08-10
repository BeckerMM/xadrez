import java.util.ArrayList;

public class Torre extends Peca {
    private boolean PrimeiroMovimento;

    public Torre(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoTabuleiro = poTabuleiro.indexOf(posicaoAtual);

        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = posicaoTabuleiro+8; i < poTabuleiro.size(); i += 8) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro)) {
                break;
            }
        }

        for (int i = posicaoTabuleiro-8; i >= 0; i -= 8) {
            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1)? 64 : posicaoTabuleiro + 1); i < poTabuleiro.size(); i ++) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro)||validaExtremidade(i+1)){
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro) ? -1 : posicaoTabuleiro - 1); i >= 0; i --) {
            Posicao posicao = poTabuleiro.get(i);

            this.verificaPeca(posicao, possiveisMovimentos, poTabuleiro);

            if (validaExtremidade(i)||
                    verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro)) {
                break;
            }

        }

        return possiveisMovimentos;
    }

    public boolean isPrimeiroMovimento() {
        return PrimeiroMovimento;
    }

    public void setPrimeiroMovimento(boolean primeiroMovimento) {
        PrimeiroMovimento = primeiroMovimento;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")){

            return "♖";
        }else {
            return "♜";
        }
    }
}
