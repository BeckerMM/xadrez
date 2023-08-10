import java.util.ArrayList;

public class Cavalo extends Peca {
    public Cavalo(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(ArrayList<Posicao> poTabuleiro) {

        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
               poTabuleiro.indexOf(posicaoAtual);

        for (Posicao posicao : poTabuleiro) {
            int indice = poTabuleiro.indexOf(posicao);
            if (poTabuleiro.indexOf(posicao) == posicaoNoTabuleiro - 17 ||
                    indice == posicaoNoTabuleiro - 15 ||
                    indice == posicaoNoTabuleiro - 10 ||
                    indice == posicaoNoTabuleiro - 6 ||
                    indice == posicaoNoTabuleiro + 6 ||
                    indice == posicaoNoTabuleiro + 10 ||
                    indice == posicaoNoTabuleiro + 15 ||
                    indice == posicaoNoTabuleiro + 17) {

                // Coluna H
                if (validaExtremidade((posicaoNoTabuleiro + 1))) {
                    if (indice == posicaoNoTabuleiro + 15 ||
                            indice == posicaoNoTabuleiro + 6 ||
                            indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro - 17
                    ) {
                        verificaPeca(posicao, possiveisMovimentos,  poTabuleiro);
                    }
                }
                // Coluna A
                else if (validaExtremidade(posicaoNoTabuleiro)) {
                    if (
                            indice == posicaoNoTabuleiro + 17 ||
                                    indice == posicaoNoTabuleiro + 10 ||
                                    indice == posicaoNoTabuleiro - 6 ||
                                    indice == posicaoNoTabuleiro - 15
                    ) {
                        verificaPeca(posicao, possiveisMovimentos,  poTabuleiro);
                    }
                }

                //Coluna B
                else if (validaExtremidade((posicaoNoTabuleiro - 1))) {
                    if ((indice == posicaoNoTabuleiro - 17 ||
                            indice == posicaoNoTabuleiro - 15 ||
                            indice == posicaoNoTabuleiro - 6 ||
                            indice == posicaoNoTabuleiro + 10 ||
                            indice == posicaoNoTabuleiro + 17 ||
                            indice == posicaoNoTabuleiro + 15
                    )) {
                        verificaPeca(posicao, possiveisMovimentos,poTabuleiro);
                    }
                }

                //Coluna G
                else if (validaExtremidade((posicaoNoTabuleiro + 2))) {
                    if (indice == posicaoNoTabuleiro + 17 ||
                            indice == posicaoNoTabuleiro + 15 ||
                            indice == posicaoNoTabuleiro + 6 ||
                            indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro - 17 ||
                            indice == posicaoNoTabuleiro - 15) {
                        verificaPeca(posicao, possiveisMovimentos,  poTabuleiro);
                    }
                }
                //Não é de canto
                else {
                    if (indice == posicaoNoTabuleiro + 15 ||
                            indice == posicaoNoTabuleiro + 6 ||
                            indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro - 17 ||
                            indice == posicaoNoTabuleiro - 15 ||
                            indice == posicaoNoTabuleiro + 10 ||
                            indice == posicaoNoTabuleiro - 6 ||
                            indice == posicaoNoTabuleiro + 17
                    ) {
                        verificaPeca(posicao, possiveisMovimentos, poTabuleiro);
                    }

                }
            }

        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")) {

            return "♘";
        } else {
            return "♞";
        }
    }
}
