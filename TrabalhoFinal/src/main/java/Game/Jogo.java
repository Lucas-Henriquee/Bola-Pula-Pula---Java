package Game;

import PowerUps.PowerUp;
import view.Tela;
import view.TelaJogar;
import view.TelaRanking;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Jogo extends Canvas implements Runnable,KeyListener {
    
    public static final int COMPRIMENTO = 900, ALTURA = 600;
    
    private int i=1000;
    public BufferedImage layer = new BufferedImage(COMPRIMENTO, ALTURA, BufferedImage.TYPE_INT_RGB);
    public static Jogador jogador;
    public static List<Bloco> blocos = new ArrayList<>();
    public static List<Bola> bolas = new ArrayList<>();
    public static List<PowerUp> powerups = new ArrayList<>();
    public static long pontuacao=0;
    public Jogo(){
        this.setPreferredSize(new Dimension(COMPRIMENTO,ALTURA));
        this.addKeyListener(this);
        jogador= new Jogador(COMPRIMENTO/2-Jogador.comprimento/2, ALTURA-15);
        blocos.clear();
        powerups.clear();
        bolas.clear();
    }
    
    public void tick(){
        jogador.tick();
        List<Bola> bolasaremover = new ArrayList<>();
        for(Bola bola : Jogo.bolas){
            if(bola.tick()){
                bolasaremover.add(bola);
            }
        }
        for(Bola bola : bolasaremover){
            Jogo.bolas.remove(bola);
        }
        List<PowerUp> powerupsaremover =new ArrayList<>();
        for(PowerUp powerup:powerups){
            if(powerup.tick()) {
                powerupsaremover.add(powerup);
            }
        }
        for(PowerUp powerup:powerupsaremover){
            Jogo.powerups.remove(powerup);
        }
        i++;
        if(i>=500){
            for (Bloco bloco : Jogo.blocos){
            bloco.tick();
            }
            i=0;
            generateB();
        }
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, COMPRIMENTO, ALTURA);
        jogador.render(g);
        for(Bola bola:bolas){
            bola.render(g);
        }
        for (Bloco bloco : Jogo.blocos){
            bloco.render(g);
        }
        for(PowerUp powerup:powerups){
            powerup.render(g);
        }
        g=bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, COMPRIMENTO,ALTURA,null);
        
        bs.show();
        TelaJogar.jlPontuacao.setText("Pontuação: "+Jogo.pontuacao);
    }

    @Override
    public void run() {
        while(Jogador.lifes>0){
            tick();
            render();
            if(bolas.isEmpty()){
                Jogador.lifes--;
                switch(Jogador.lifes){
                case 3: TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/ThreeHearts.png")); break;
                case 2: TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/TwoHearts.png")); break;
                case 1: TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/OneHeart.png")); break;
                case 0: TelaJogar.jlVidasImage.setIcon(null);
                }
                bolas.add(new Bola(jogador.x+Jogador.comprimento/2, ALTURA-Jogador.altura));
            }
            try{
                Thread.sleep(1000/60);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Você perdeu");
        new TelaRanking();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT|| e.getKeyCode()==KeyEvent.VK_PAGE_UP){
            jogador.right=true;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            jogador.left=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT|| e.getKeyCode()==KeyEvent.VK_PAGE_UP){
            jogador.right=false;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            jogador.left=false;
        }
    }
    
    public void generateB(){
        int g;
        for(int i=0;i<COMPRIMENTO;i=i+Bloco.COMPRIMENTO){
            g = new Random().nextInt(10);
            if(g<7){
                blocos.add(new Bloco(i,0));
            }
            else {
                blocos.add(new BlocoComPowerUp(i,0));
            }
        }
    }
}
