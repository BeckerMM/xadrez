import java.util.ArrayList;

public class Rainha extends Peca{
    public Rainha(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro) {

        int posicaoNoTabuleiro =poTabuleiro.indexOf(this.getPosicao());
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();

        for (int i = (validaExtremidade(posicaoNoTabuleiro)
                ? 64 : posicaoNoTabuleiro + 7); i < poTabuleiro.size(); i += 7) {


            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro) ||
                    validaExtremidade(i)) {
                break;
            }
        }

        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1)) ? -1 : posicaoNoTabuleiro - 7); i >= 0; i -= 7) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade(i + 1)) {
                break;
            }
        }

        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1)) ? 64 : posicaoNoTabuleiro + 9); i < poTabuleiro.size(); i += 9) {

            if (verificaPeca(possiveisMovimentos.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade((i + 1))) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 9); i >= 0; i -= 9) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos, poTabuleiro) ||
                    validaExtremidade(i)) {
                break;
            }
        }

        for (int i = posicaoNoTabuleiro + 8; i < poTabuleiro.size(); i += 8) {


            if (verificaPeca(poTabuleiro.get(i),
                    possiveisMovimentos,  poTabuleiro)) {
                break;
            }
        }

        for (int i = posicaoNoTabuleiro - 8; i >= 0; i -= 8) {

            if (verificaPeca(poTabuleiro.get(i),
                    possiveisMovimentos,  poTabuleiro)) {
                break;
            }
        }

        for (int i = (validaExtremidade((posicaoNoTabuleiro + 1)) ? 64 : posicaoNoTabuleiro + 1); i < poTabuleiro.size(); i++) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,  poTabuleiro) || validaExtremidade((i + 1))) {
                break;
            }
        }

        //
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 1); i >= 0; i--) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,  poTabuleiro) || validaExtremidade(i)) {
                break;
            }
        }
        return possiveisMovimentos;

    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")){

            return "♕";
        }else {
            return "♛";
        }
    }
}
