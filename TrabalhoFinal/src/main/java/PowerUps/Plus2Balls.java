//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package PowerUps;

import Game.Bola;
import Game.Jogo;
import java.awt.Rectangle;

public class Plus2Balls extends PowerUp {
    public Plus2Balls(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean tick() {
        y += 3;
        if (y >= Jogo.ALTURA)
            return true;
        Rectangle bounds = new Rectangle(x, y, COMPRIMENTO, ALTURA);
        Rectangle boundsJogador = new Rectangle(Jogo.jogador.x, Jogo.jogador.y, Jogo.jogador.comprimento, Jogo.jogador.altura);
        if (bounds.intersects(boundsJogador)) {
            Jogo.bolas.add(new Bola(Jogo.jogador.x + Jogo.jogador.comprimento / 2, Jogo.jogador.y));
            Jogo.bolas.add(new Bola(Jogo.jogador.x + Jogo.jogador.comprimento / 2, Jogo.jogador.y));
            return true;
        }
        return false;
    }
}
