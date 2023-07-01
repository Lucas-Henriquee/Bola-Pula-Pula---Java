package Jogadores;

import Game.Jogo;
import java.awt.Color;
import java.awt.Graphics;

public class Nan extends Jogador {
    public Nan(int x, int y, String NomeDoJogador){
        super(x,y,NomeDoJogador);
        special=3;
    }

    public void tick(){
        if(velocidade<0){
            Jogador.velocidade*=-1;
        }
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
        g.setColor(Color.blue);
        g.fillRect(x, y, comprimento, altura);
    }
}
