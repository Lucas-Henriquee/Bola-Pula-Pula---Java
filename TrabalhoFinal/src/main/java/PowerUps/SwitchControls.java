//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package PowerUps;

import Jogadores.Jogador;
import Game.Jogo;
import java.awt.Rectangle;

public class SwitchControls extends PowerUp {
    public SwitchControls(int x, int y) {
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
            Jogador.velocidade *= -1;
            Jogo.jogador.color *= -1;
            return true;
        }
        return false;
    }
}
