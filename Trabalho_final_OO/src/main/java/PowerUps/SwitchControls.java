package PowerUps;

import Jogo.Jogador;
import Jogo.Jogo;
import java.awt.Rectangle;

public class SwitchControls extends PowerUp {
    public SwitchControls(int x, int y){
        super(x,y);
    }
    
    @Override
    public boolean tick(){
        y+=3;
        if(y>=Jogo.ALTURA)
            return true;
        Rectangle bounds = new Rectangle(x,y,COMPRIMENTO,ALTURA);
        Rectangle boundsJogador = new Rectangle(Jogo.jogador.x,Jogo.jogador.y,Jogador.comprimento,Jogador.altura);
        if(bounds.intersects(boundsJogador)){
            Jogador.velocidade*=-1;
            Jogador.color*=-1;
            return true;
        }
        return false;
    }
}
