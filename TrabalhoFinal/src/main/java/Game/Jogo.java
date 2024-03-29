//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package Game;

import PowerUps.*;
import view.*;
import Jogadores.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.util.List;

import javax.swing.ImageIcon;

public class Jogo extends Canvas implements Runnable, KeyListener {

    public static final int COMPRIMENTO = 900, ALTURA = 600;

    private int i = 1000;
    public BufferedImage layer = new BufferedImage(COMPRIMENTO, ALTURA, BufferedImage.TYPE_INT_RGB);
    public static Jogador jogador;
    public static List<Bloco> blocos = new ArrayList<>();
    public static List<Bola> bolas = new ArrayList<>();
    public static List<PowerUp> powerups = new ArrayList<>();

    public Jogo(String NomeDoJogador, int TipoDoJogador) {
        this.setPreferredSize(new Dimension(COMPRIMENTO, ALTURA));
        this.addKeyListener(this);
        if (TipoDoJogador == 0) {
            jogador = new Jogador(COMPRIMENTO / 2 - 200 / 2, ALTURA - 15, NomeDoJogador);
        } else if (TipoDoJogador == 1) {
            jogador = new Nan(COMPRIMENTO / 2 - 200 / 2, ALTURA - 15, NomeDoJogador);
        }
        blocos.clear();
        powerups.clear();
        bolas.clear();
        TelaJogar.jlSpecial.setText(jogador.special + "x");
    }

    public void tick() {
        jogador.tick();
        List<Bola> bolasaremover = new ArrayList<>();
        for (Bola bola : Jogo.bolas) {
            if (bola.tick()) {
                bolasaremover.add(bola);
            }
        }
        for (Bola bola : bolasaremover) {
            Jogo.bolas.remove(bola);
        }
        List<PowerUp> powerupsaremover = new ArrayList<>();
        for (PowerUp powerup : powerups) {
            if (powerup.tick()) {
                powerupsaremover.add(powerup);
            }
        }
        for (PowerUp powerup : powerupsaremover) {
            Jogo.powerups.remove(powerup);
        }
        i++;
        if (i >= 500) {
            for (Bloco bloco : Jogo.blocos) {
                bloco.tick();
            }
            i = 0;
            generateB();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, COMPRIMENTO, ALTURA);
        jogador.render(g);
        for (Bola bola : bolas) {
            bola.render(g);
        }
        for (Bloco bloco : Jogo.blocos) {
            bloco.render(g);
        }
        for (PowerUp powerup : powerups) {
            powerup.render(g);
        }
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, COMPRIMENTO, ALTURA, null);

        bs.show();
        TelaJogar.jlPontuacao.setText("Pontuação: " + jogador.pontuacao);
    }

    @Override
    public void run() {
        while (jogador.lifes > 0) {
            tick();
            render();
            if (bolas.isEmpty()) {
                jogador.lifes--;
                switch (jogador.lifes) {
                    case 5:
                        TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/FiveHearts.png"));
                        break;
                    case 4:
                        TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/FourHearts.png"));
                        break;
                    case 3:
                        TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/ThreeHearts.png"));
                        break;
                    case 2:
                        TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/TwoHearts.png"));
                        break;
                    case 1:
                        TelaJogar.jlVidasImage.setIcon(new ImageIcon("src/main/java/images/OneHeart.png"));
                        break;
                    case 0:
                        TelaJogar.jlVidasImage.setIcon(null);
                }
                bolas.add(new Bola(jogador.x + jogador.comprimento / 2, ALTURA - jogador.altura));
            }
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new TelaFimDeJogo();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Método inutilizado
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jogador.right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jogador.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jogador.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jogador.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            if (jogador.special > 0) {
                jogador.special--;
                TelaJogar.jlSpecial.setText(jogador.special + "x");
                blocos.clear();
                i = 1000;
            }
        }
    }

    public void generateB() {
        int g;
        for (int i = 0; i < COMPRIMENTO; i = i + Bloco.COMPRIMENTO) {
            g = new Random().nextInt(10);
            if (g < 7) {
                blocos.add(new Bloco(i, 0));
            } else if(g<9) {
                blocos.add(new BlocoComPowerUp(i, 0));
            }
        }
    }
}
