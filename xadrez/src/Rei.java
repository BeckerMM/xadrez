import java.util.ArrayList;

public class Rei extends Peca{
    private boolean primeiroMovimento;

    public Rei(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<Posicao>();

        for (Posicao posicao:
             tabuleiro.getPosicoes()) {
         int indice =
                 tabuleiro.getPosicoes().indexOf(posicao);

         if (indice == posicaoNoTabuleiro -9 ||
                 indice == posicaoNoTabuleiro -8 ||
                 indice == posicaoNoTabuleiro -7 ||
                 indice == posicaoNoTabuleiro -1 ||
                 indice == posicaoNoTabuleiro +1 ||
                 indice == posicaoNoTabuleiro +7 ||
                 indice == posicaoNoTabuleiro +8 ||
                 indice == posicaoNoTabuleiro +9){

             // Coluna H
             if (validaExtremidade((posicaoNoTabuleiro + 1))&& (
                     indice == posicaoNoTabuleiro - 7 ||
                             indice == posicaoNoTabuleiro + 1 ||
                             indice == posicaoNoTabuleiro + 9
             )) {
                 verificaPeca(posicao, possiveisMovimentos);
             }
             // Coluna A
             else if (validaExtremidade(posicaoNoTabuleiro) && (
                     indice == posicaoNoTabuleiro + 7 ||
                             indice == posicaoNoTabuleiro - 1 ||
                             indice == posicaoNoTabuleiro - 9
             )) {
                 verificaPeca(posicao, possiveisMovimentos);
             }else{
                 verificaPeca(posicao, possiveisMovimentos);
             }

         }

        }



        return possiveisMovimentos;
    }

    private ArrayList<Posicao> verificarmovimentosNaoRei(Tabuleiro tabuleiro){
    ArrayList <Posicao> posicoesReiNao = new ArrayList<>();
        for (Posicao posicao :tabuleiro.getPosicoes()) {
            if (this.getCor().equals("Branco")){
                if (posicao.getPeca().getCor().equals("Preto")){
                    for (Posicao possiveis: posicao.getPeca().possiveisMovimentos(tabuleiro)) {
                        for (Posicao movRei: this.possiveisMovimentos(tabuleiro)) {
                            if (movRei == possiveis){
                                posicoesReiNao.add(possiveis);
                            }
                        }
                    }
                }else{

                    // terminar está parte
                    if (posicao.getPeca().getCor().equals("Branco")) {
                        for (Posicao possiveis : posicao.getPeca().possiveisMovimentos(tabuleiro)) {
                            if (possiveis.getPeca() instanceof Rei){
                                posicoesReiNao.add(possiveis);
                            }
                        }
                    }
                }
            }
        }

        return posicoesReiNao;
    }

    public boolean removerMovimentos(Tabuleiro tabuleiro){
        ArrayList<Posicao>posicoesReiNao = verificarmovimentosNaoRei(tabuleiro);
        for (Posicao posicao : posicoesReiNao) {

        }

        return false;
    }

    @Override
    public String toString() {

        if (this.getCor().equals("Branco")){

            return "♔";
        }else {
            return "♚";
        }
    }
}
