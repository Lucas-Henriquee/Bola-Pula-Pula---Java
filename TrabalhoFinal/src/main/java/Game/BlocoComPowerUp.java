package Game;

import PowerUps.*;
import java.util.*;

public class BlocoComPowerUp extends Bloco {
    private final int power;

    public BlocoComPowerUp(int x, int y) {
        super(x, y);
        power = new Random().nextInt(5);
    }

    @Override
    public void breaking() {
        super.breaking();
        switch (power) {
            case 0:
                Jogo.powerups.add(new TripleBall(this.x + 10, this.y + 10));
                break;
            case 1:
                Jogo.powerups.add(new Plus2Balls(this.x + 10, this.y + 10));
                break;
            case 2:
                Jogo.powerups.add(new SwitchControls(this.x + 10, this.y + 10));
                break;
            case 3:
                Jogo.powerups.add(new ReducesPlayerLenght(this.x + 10, this.y + 10));
                break;
            case 4:
                Jogo.powerups.add(new IncreasePlayerLenght(this.x + 10, this.y + 10));
                break;
        }
    }

}
