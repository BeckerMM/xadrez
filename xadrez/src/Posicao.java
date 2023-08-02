public class Posicao {

    private Peca peca;
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }


    @Override
    public String toString() {
        return "Posicao{" +
                "peca=" + peca +
                ", numero=" + numero +
                '}';
    }
}
