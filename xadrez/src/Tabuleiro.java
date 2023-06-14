import java.util.ArrayList;

public class Tabuleiro {

    private ArrayList<Posicao> posicoes = new ArrayList<>();

    public Tabuleiro(){
        for (int i = 0; i <64 ; i++) {
            posicoes.add(new Posicao());
            if (i>=8 && i<=15){
                posicoes.get(i).setPeca(new Peao("Preto"));
            }if (i>=48 && i<=55){
                posicoes.get(i).setPeca(new Peao("Branco"));
            }
            if(i ==0 || i ==7){
                posicoes.get(0).setPeca(new Torre("Preto"));

            }
            if(i ==56 || i ==63){
                posicoes.get(0).setPeca(new Torre("Branco"));

            }
            if(i ==2 || i ==5){
                posicoes.get(0).setPeca(new Bispo("Preto"));

            }
            if(i ==58 || i ==61){
                posicoes.get(0).setPeca(new Bispo("Branco"));

            }
            if(i ==1 || i ==6){
                posicoes.get(0).setPeca(new Cavalo("Preto"));

            }
            if(i ==57 || i ==62){
                posicoes.get(0).setPeca(new Cavalo("Branco"));

            }
            if(i==4){
                posicoes.get(0).setPeca(new Rei("Preto"));

            }
            if(i==60){
                posicoes.get(0).setPeca(new Rei("Branco"));

            }
            if(i==3){
                posicoes.get(0).setPeca(new Rainha("Preto"));

            }
            if(i==59){
                posicoes.get(0).setPeca(new Rainha("Branco"));

            }
        }

    }

    public void removerPecas(Posicao posicao){

    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }
}
