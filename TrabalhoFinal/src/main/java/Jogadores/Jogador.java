//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package Jogadores;

import Game.Jogo;
import java.awt.*;

public class Jogador {
    public boolean right, left;
    public int x, y;
    public int special, color = 1;
    public int comprimento, altura = 15;
    public int velocidade;
    public int lifes = 4;
    public String nome;
    public double pontuacao;

    public Jogador(int x, int y, String NomeDoJogador) {
        this.x = x;
        this.y = y;
        lifes = 4;
        special = 1;
        pontuacao = 0;
        nome = NomeDoJogador;
        velocidade=20;
        comprimento=200;
    }

    public void tick() {
        if (right) {
            x += velocidade;
        } else if (left) {
            x -= velocidade;
        }
        if (x + comprimento > Jogo.COMPRIMENTO) {
            x = Jogo.COMPRIMENTO - comprimento;
        } else if (x < 0) {
            x = 0;
        }
    }

    public void render(Graphics g) {
        if (color == 1) {
            g.setColor(Color.blue);
        } else if (color == -1) {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, comprimento, altura);
    }
}
