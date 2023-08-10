import java.util.ArrayList;
import java.util.Iterator;

public class Rei extends Peca {
    private boolean primeiroMovimento;
    private ArrayList<Posicao> posicaoReiNao;

    public Rei(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro) {

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
                poTabuleiro.indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();

        for (Posicao posicao :
                poTabuleiro) {
            int indice =
                    poTabuleiro.indexOf(posicao);

            if (indice == posicaoNoTabuleiro - 9 ||
                    indice == posicaoNoTabuleiro - 8 ||
                    indice == posicaoNoTabuleiro - 7 ||
                    indice == posicaoNoTabuleiro - 1 ||
                    indice == posicaoNoTabuleiro + 1 ||
                    indice == posicaoNoTabuleiro + 7 ||
                    indice == posicaoNoTabuleiro + 8 ||
                    indice == posicaoNoTabuleiro + 9) {

                // Coluna H
                if (validaExtremidade((posicaoNoTabuleiro + 1)) && (
                        indice == posicaoNoTabuleiro - 7 ||
                                indice == posicaoNoTabuleiro + 1 ||
                                indice == posicaoNoTabuleiro + 9
                )) {
                    verificaPeca(posicao, possiveisMovimentos , poTabuleiro);
                }
                // Coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) && (
                        indice == posicaoNoTabuleiro + 7 ||
                                indice == posicaoNoTabuleiro - 1 ||
                                indice == posicaoNoTabuleiro - 9
                )) {
                    verificaPeca(posicao, possiveisMovimentos,poTabuleiro);
                } else {
                    verificaPeca(posicao, possiveisMovimentos,  poTabuleiro);
                }

            }

        }

        if (posicaoReiNao != null) {

            Iterator<Posicao> iterator = possiveisMovimentos.iterator();

            while (iterator.hasNext()) {
                Posicao posicao = iterator.next();

                for (Posicao posicaoRei : posicaoReiNao) {
                    if (posicao.equals(posicaoRei)) {
                        iterator.remove();
                        break; // No need to continue checking after a match is found
                    }
                }
            }
        }


        return possiveisMovimentos;
    }

    public void setPosicaoReiNao(ArrayList<Posicao> posicaoReiNao) {
        this.posicaoReiNao = posicaoReiNao;
    }

    @Override
    public String toString() {

        if (this.getCor().equals("Branco")) {

            return "♔";
        } else {
            return "♚";
        }
    }
}
