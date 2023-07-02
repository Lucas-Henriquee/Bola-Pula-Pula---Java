//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package PowerUps;

import Game.Jogo;
import Jogadores.Jogador;
import java.awt.Rectangle;

public class IncreasePlayerLenght extends PowerUp {
    public IncreasePlayerLenght(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean tick() {
        y += 3;
        if (y >= Jogo.ALTURA)
            return true;
        Rectangle bounds = new Rectangle(x, y, COMPRIMENTO, ALTURA);
        Rectangle boundsJogador = new Rectangle(Jogo.jogador.x, Jogo.jogador.y, Jogador.comprimento, Jogador.altura);
        if (bounds.intersects(boundsJogador)) {
            if (Jogador.comprimento < 400) {
                Jogador.comprimento += 50;
                Jogo.jogador.x += 25;
            }
            return true;
        }
        return false;
    }
}
