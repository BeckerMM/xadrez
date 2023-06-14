import java.util.ArrayList;

public class Bispo extends Peca {


    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();
        for (int i = (validaExtremidade(posicaoNoTabuleiro)
                ? 64 : posicaoNoTabuleiro + 7)
             // IF Ternário
             ; i < tabuleiro.getPosicoes().size();
             i += 7) {


            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) ||
                    validaExtremidade(i)) {
                break;
            }
        }
        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1)) ?
                -1 : posicaoNoTabuleiro - 7)
             ; i >= 0;
             i -= 7) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) ||
                    validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1))
                ? 64 : posicaoNoTabuleiro + 9)
             ; i < tabuleiro.getPosicoes().size();
             i += 9) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) ||
                    validaExtremidade((i + 1))) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 9)
             ; i >= 0;
             i -= 9) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) ||
                    validaExtremidade(i)) {
                break;
            }
        }
        return possiveisMovimentos;
    }


}