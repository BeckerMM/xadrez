import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primMov = true;

    public Peao(String cor, Posicao posicao){
        super(cor,posicao);
    }


    @Override
    public ArrayList<Posicao>
    possiveisMovimentos(Tabuleiro tabuleiro) {

        ArrayList<Posicao> posiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();

        if (this.getCor().equals("Preto")) {

            System.out.println("foi");

            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {

                posiveisMovimentos.add(posicoesTabuleiro.get(
                        posicaoNoTabuleiro + 8
                ));
            }
            if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));

                        }
                    }
                }else {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") &&
                                !validaExtremidade((posicaoNoTabuleiro + 1))) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                        }
                    }  if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") &&
                                !validaExtremidade(posicaoNoTabuleiro)) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                        }
                    }

                }
        } else if (this.getCor().equals("Branco")){
            System.out.println("foi");
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {

                posiveisMovimentos.add(posicoesTabuleiro.get(
                        posicaoNoTabuleiro - 8
                ));
            }
            if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));

                        }
                    }
                }
             else{
                 if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null) {
                     if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                         posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                     }
                     if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null) {
                         if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") &&
                                 !validaExtremidade((posicaoNoTabuleiro - 1))) {
                             posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));

                         }
                     }
                 }
                    }
                }


        return posiveisMovimentos;
    }

    public boolean isPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")){

            return "♙";
        }else {
            return "♟";
        }
    }
}
