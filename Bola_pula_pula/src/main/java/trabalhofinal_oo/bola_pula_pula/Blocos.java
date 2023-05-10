//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package trabalhofinal_oo.bola_pula_pula;

public class Blocos extends Tabuleiro {

    private String color;

    public Blocos() {
        int a = (int) (Math.random() * 7);
        switch (a) {
            case 1:
                color = ConsoleColors.RED_BACKGROUND_BRIGHT;
                break;
            case 2:
                color = ConsoleColors.GREEN_BACKGROUND_BRIGHT;
                break;
            case 3:
                color = ConsoleColors.YELLOW_BACKGROUND_BRIGHT;
                break;
            case 4:
                color = ConsoleColors.BLACK_BACKGROUND_BRIGHT;
                break;
            case 5:
                color = ConsoleColors.PURPLE_BACKGROUND_BRIGHT;
                break;
            case 6:
                color = ConsoleColors.CYAN_BACKGROUND_BRIGHT;
                break;
            case 0:
                color = ConsoleColors.WHITE_BACKGROUND_BRIGHT;
                break;
        }
    }

    public void print() {
        System.out.print(color + "  " + ConsoleColors.RESET);
    }
}