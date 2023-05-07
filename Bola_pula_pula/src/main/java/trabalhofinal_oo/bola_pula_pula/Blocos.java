package trabalhofinal_oo.bola_pula_pula;

public class Blocos extends Tabuleiro{

    private String color;
    public Blocos(){
        int a=(int)(Math.random()*7);
        switch(a){
            case 1:
                color="🟥";
                break;
            case 2:
                color="🟧";
                break;
            case 3:
                color="🟨";
                break;
            case 4:
                color="🟩";
                break;
            case 5:
                color="🟦";
                break;
            case 6:
                color="🟪";
                break;
            case 0:
                color="🟫";
                break;
        }
    } 

    public void print(){
        System.out.print(color);
    }
}
