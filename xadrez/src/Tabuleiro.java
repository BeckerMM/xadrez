import java.util.ArrayList;

public class Tabuleiro {

    private ArrayList<Posicao> posicoes = new ArrayList<>();

    public Tabuleiro(){
        for (int i = 0; i <64 ; i++) {
            posicoes.add(new Posicao());
            posicoes.get(i).setNumero(i);
            if (i>=8 && i<=15){
                posicoes.get(i).setPeca(new Peao("Preto",posicoes.get(i)));


            }if (i>=48 && i<=55){
                posicoes.get(i).setPeca(new Peao("Branco",posicoes.get(i)));

            }
            if(i ==0 || i ==7){
                posicoes.get(i).setPeca(new Torre("Preto",posicoes.get(i)));


            }
//            if(i ==56 || i ==63){
//                posicoes.get(i).setPeca(new Torre("Branco",posicoes.get(i)));
//
//
//            }
//            if(i ==2 || i ==5){
//                posicoes.get(i).setPeca(new Bispo("Preto",posicoes.get(i)));
//
//
//            }
            if(i ==58 || i ==61){
                posicoes.get(i).setPeca(new Bispo("Branco",posicoes.get(i)));


            }
            if(i ==1 || i ==6){
                posicoes.get(i).setPeca(new Cavalo("Preto",posicoes.get(i)));

            }
//            if(i ==57 || i ==62){
//                posicoes.get(i).setPeca(new Cavalo("Branco",posicoes.get(i)));
//
//
//            }
            if(i==4){
                posicoes.get(i).setPeca(new Rei("Preto",posicoes.get(i)));


            }
            if(i==60){
                posicoes.get(i).setPeca(new Rei("Branco",posicoes.get(i)));


            }
            if(i==3){
                posicoes.get(i).setPeca(new Rainha("Preto",posicoes.get(i)));


            }
//            if(i==59){
//                posicoes.get(i).setPeca(new Rainha("Branco",posicoes.get(i)));
//
//
//            }
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

    private  String tabuleiroImpresso(){
        StringBuilder tabuleiro= new StringBuilder();
        for (int i = 0; i <64 ; i++) {
            if (i%8 ==0 && i!= 0 && i!=63 ){
                tabuleiro.append("\n -------------------------------------------\n");
                tabuleiro.append(" [").append(posicoes.get(i).getPeca()!=null ?posicoes.get(i).getPeca(): " " ).append("] ");
            }else {
                tabuleiro.append(" [").append(posicoes.get(i).getPeca()!=null ?posicoes.get(i).getPeca(): " " ).append("] ");
            }

        }

        return tabuleiro.toString();
    }

    public static boolean verificarXeque(ArrayList<Posicao> poTabuleiro, Peca peca) {
        for (Posicao posicao : poTabuleiro) {
            if (posicao!=null && posicao.getPeca()!=null) {
                if (!posicao.getPeca().getCor().equals(peca.getCor())) {
                    for (Posicao pecaVerificar : posicao.getPeca().possiveisMovimentos(poTabuleiro,false )) {
                        if (pecaVerificar.getPeca() instanceof Rei) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return tabuleiroImpresso();
    }
}
