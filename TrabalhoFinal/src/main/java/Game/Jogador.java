package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador {
    public boolean right, left;
    public int x,y;
    public static int comprimento=200, altura=15;
    public static int velocidade=20, color=1;
    public static int lifes=4;

    public Jogador(int x, int y){
        this.x=x;
        this.y=y;
        lifes=4;
    }
    
    public void tick(){
        if(right){
            x+=velocidade;
        }
        else if(left){
            x-=velocidade;
        }
        if(x+comprimento>Jogo.COMPRIMENTO){
            x=Jogo.COMPRIMENTO-comprimento;
        }
        else if(x<0){
            x=0;
        }
    }
    
    public void render(Graphics g){
        if(color==1){
            g.setColor(Color.blue);
        }
        else if(color==-1){
            g.setColor(Color.red);
        }
        g.fillRect(x, y, comprimento, altura);
    }
}
