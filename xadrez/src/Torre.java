import java.util.ArrayList;

public class Torre extends Peca {
    private boolean PrimeiroMovimento;

    public Torre(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();

        for (int i = posicaoNoTabuleiro + 8
             ; i < tabuleiro.getPosicoes().size();
             i += 8) {


            if (verificaPeca(tabuleiro.getPosicoes().get(i),
                    possiveisMovimentos)) {
                break;
            }
        }
        for (int i = posicaoNoTabuleiro - 8
             ; i >= 0;
             i -= 7) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i),
                    possiveisMovimentos)) {
                break;
            }
        }

        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1))
                ? 64 : posicaoNoTabuleiro + 1)
             ; i < tabuleiro.getPosicoes().size();
             i++) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade((i + 1))) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                -1 : posicaoNoTabuleiro - 1)
             ; i >= 0;
             i--) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i) ) {
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
