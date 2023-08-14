import java.util.ArrayList;

public class Rainha extends Peca{
    public Rainha(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro, boolean simular) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoTabuleiro = poTabuleiro.indexOf(posicaoAtual);

        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = (validaExtremidade(posicaoTabuleiro) ? 64 : posicaoTabuleiro + 7); i <poTabuleiro.size(); i += 7) {

            this.verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular );

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro, simular) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1) ? 7 : posicaoTabuleiro - 7); i > 7; i -= 7) {

            this.verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro, simular);

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular ) || validaExtremidade(i+1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1)? 64 : posicaoTabuleiro + 9); i <poTabuleiro.size(); i += 9) {

            this.verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro, simular);

            if (poTabuleiro.get(i).getPeca() == null) {
                possiveisMovimentos.add(poTabuleiro.get(i));
            }

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular ) || validaExtremidade(i+1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro) ? 9 : posicaoTabuleiro - 9); i > 9; i -= 9) {

            this.verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular);

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular ) || validaExtremidade(i)) {
                break;
            }

        }

        for (int i = posicaoTabuleiro+8; i < poTabuleiro.size(); i += 8) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular )) {
                break;
            }
        }

        for (int i = posicaoTabuleiro-8; i >= 0; i -= 8) {
            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro,simular )) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro+1)? 64 : posicaoTabuleiro + 1); i < poTabuleiro.size(); i ++) {

            if (verificaPeca(poTabuleiro.get(i), possiveisMovimentos,poTabuleiro, simular)||validaExtremidade(i+1)){
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoTabuleiro) ? -1 : posicaoTabuleiro - 1); i >= 0; i --) {
            Posicao posicao = poTabuleiro.get(i);

            this.verificaPeca(posicao, possiveisMovimentos,poTabuleiro, simular);

            if (validaExtremidade(i)||
                    verificaPeca(posicao, possiveisMovimentos,poTabuleiro, simular)) {
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
