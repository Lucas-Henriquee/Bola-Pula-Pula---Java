package Game;

import PowerUps.Plus2Balls;
import PowerUps.SwitchControls;
import PowerUps.TripleBall;
import java.util.Random;

public class BlocoComPowerUp extends Bloco {
    private final int power;
    public BlocoComPowerUp(int x, int y){
        super(x,y);
        power=new Random().nextInt(3);
    }
    
    @Override
    public void breaking(){
        super.breaking();
        switch(power){
            case 0:Jogo.powerups.add(new TripleBall(this.x+10,this.y+10)); break;
            case 1:Jogo.powerups.add(new Plus2Balls(this.x+10,this.y+10)); break;
            case 2:Jogo.powerups.add(new SwitchControls(this.x+10,this.y+10)); break;
        }
    }
    
}
