package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bloco {
    public int x , y , color;
    public static final int COMPRIMENTO = 50, ALTURA = 50;
    public Bloco(int x, int y){
        this.x=x;
        this.y=y;
        color= new Random().nextInt(9);
    }
    
    public void tick(){
        y+=ALTURA;
        if(y>=Jogo.ALTURA-Bloco.ALTURA){
            Jogo.jogador.lifes=0;
        }
    }
    
    public void breaking(){
        Jogo.jogador.pontuacao+=100;
    }
    
    public void render(Graphics g){
        switch(color){
            case 0 : g.setColor(Color.blue); break;
            case 3 : g.setColor(Color.gray); break;
            case 4 : g.setColor(Color.green); break;
            case 5 : g.setColor(Color.lightGray); break;
            case 6 : g.setColor(Color.magenta); break;
            case 7 : g.setColor(Color.orange); break;
            case 8 : g.setColor(Color.pink); break;
            case 1 : g.setColor(Color.red); break;
            case 2 : g.setColor(Color.yellow); break;
        }
        g.fillRect(x, y, COMPRIMENTO, ALTURA);
    }
    
    
}
