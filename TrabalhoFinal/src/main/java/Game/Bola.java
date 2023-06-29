package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola {
    
    public double x,y;
    public int comprimento=12,altura=12;
    public int raio=7;
    public double dx, dy;
    public double velocidade=10;
    
    public Bola(int x, int y){
        this.x=x;
        this.y=y;
        
        int angle= new Random().nextInt(90)+46;
        dx= Math.cos(Math.toRadians(angle));
        dy= Math.sin(Math.toRadians(angle));
    }
    
    public boolean tick(){
        if(x+(dx*velocidade)+comprimento>=Jogo.COMPRIMENTO||x+(dx*velocidade)<0){
            dx*=-1;
        }
        if(y+(dy*velocidade)<=0){
            dy*=-1;
        }
        else if(y+(dy*velocidade)>=Jogo.ALTURA){
            return true;
        }
        
        Rectangle bounds = new Rectangle((int)(x+(dx*velocidade)),(int)(y+(dy*velocidade)),comprimento,altura);
        Rectangle boundsJogador = new Rectangle(Jogo.jogador.x,Jogo.jogador.y,Jogador.comprimento,Jogador.altura);
        
        if(bounds.intersects(boundsJogador)){
            int angle = new Random().nextInt(90)+46;
            dx= Math.cos(Math.toRadians(angle));
            dy= Math.sin(Math.toRadians(angle));
            if(dy>0){
                dy*=-1;
            }
        }
        
        for (Bloco bloco : Jogo.blocos) {
            Rectangle boundsBloco = new Rectangle(bloco.x,bloco.y,Bloco.COMPRIMENTO,Bloco.ALTURA);
            if(bounds.intersects(boundsBloco)){
                if(x+(dx*velocidade)>=bloco.x+Bloco.COMPRIMENTO||x+(dx*velocidade)<=bloco.x){
                    dx*=-1;
                }
                if(y+(dy*velocidade)>=bloco.y+(dy*velocidade)+(Bloco.ALTURA)||y+(dy*velocidade)<=(bloco.y)){
                    dy*=-1;
                }
                bloco.breaking();
                Jogo.blocos.remove(bloco);
                break;
            }
        } 
        
        x+=dx*velocidade;
        y+=dy*velocidade;
        return false;
    }
    
    public void render(Graphics g){
        int diameter= 2*raio;
        int centerX = (int)x - raio;
        int centerY = (int)y - raio;
        g.setColor(Color.white);
        g.fillOval(centerX, centerY, diameter, diameter);
    }
    
}
