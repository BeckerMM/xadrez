import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primMov = true;

    public Peao(String cor, Posicao posicao) {
        super(cor, posicao);
    }


    @Override
    public ArrayList<Posicao>
    possiveisMovimentos(ArrayList<Posicao> poTabuleiro, boolean simular) {

        ArrayList<Posicao> posiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = poTabuleiro.indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesTabuleiro = poTabuleiro;
        if (this.getCor().equals("Preto")) {



            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro + 8), posiveisMovimentos, poTabuleiro)) {
                    posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                }
            }
            if (this.primMov) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro + 16), posiveisMovimentos, poTabuleiro)) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                        }

                    }
                }
            } else {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco")) {
                        if (!validaExtremidade((posicaoNoTabuleiro + 1))) {
                            if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro + 9), posiveisMovimentos, poTabuleiro)) {
                                posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                            }
                        }
                    }
                }
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco")) {
                        if (!validaExtremidade(posicaoNoTabuleiro)) {
                            if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro + 7), posiveisMovimentos, poTabuleiro)) {
                                posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                            }
                        }
                    }
                }

            }
        } else if (this.getCor().equals("Branco")) {

            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro - 8), posiveisMovimentos, poTabuleiro)) {
                    posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                }
            }
            System.out.println("primeiro Movimento BRANCO: "+ primMov);
            if (this.primMov) {

                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro - 16), posiveisMovimentos, poTabuleiro)) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                        }
                    }
                }
            } else {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                        if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro - 9), posiveisMovimentos, poTabuleiro)) {
                            posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") &&
                                !validaExtremidade((posicaoNoTabuleiro - 1))) {
                            if (!simular || simularJogada(posicoesTabuleiro.get(posicaoNoTabuleiro-7),posiveisMovimentos,poTabuleiro)){
                                posiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro -7));
                            }
                        }
                    }
                }
            }
        }

        return posiveisMovimentos;
    }
    @Override
    public boolean simularJogada (Posicao posicao, ArrayList<Posicao> possiveisMovimentos,ArrayList<Posicao> poTabuleiro){
        Peca pecaAntiga = posicao.getPeca();
        Posicao antigaPosicao = this.getPosicao();

        this.mover( posicao,  possiveisMovimentos);

        if(Tabuleiro.verificarXeque(poTabuleiro, this)){
            this.mover(antigaPosicao, possiveisMovimentos);
            posicao.setPeca(pecaAntiga);
            primMov= true;
            return false;
        }else{
            this.mover(antigaPosicao, possiveisMovimentos);
            posicao.setPeca(pecaAntiga);
            primMov=true;
            return true;
        }
    }
    public boolean isPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")) {

            return "♙";
        } else {
            return "♟";
        }
    }
}
