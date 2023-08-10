import java.util.ArrayList;

public class Bispo extends Peca {


    public Bispo(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =poTabuleiro.indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();
        for (int i = (validaExtremidade(posicaoNoTabuleiro)
                ? 64 : posicaoNoTabuleiro + 7)
             // IF Ternário
             ; i < poTabuleiro.size();
             i += 7) {


            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade(i)) {
                break;
            }
        }
        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1)) ?
                -1 : posicaoNoTabuleiro - 7)
             ; i >= 0;
             i -= 7) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1))
                ? 64 : posicaoNoTabuleiro + 9)
             ; i <poTabuleiro.size();
             i += 9) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade((i + 1))) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 9)
             ; i >= 0;
             i -= 9) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade(i)) {
                break;
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")){

            return "♗";
        }else {
            return "♝";
        }
    }
}