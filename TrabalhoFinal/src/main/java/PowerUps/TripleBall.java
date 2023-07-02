//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package PowerUps;

import Game.Bola;
import Game.Jogo;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class TripleBall extends PowerUp {
    public TripleBall(int x, int y) {
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
            List<Bola> bolasaclonar = new ArrayList<>();
            for (Bola bola : Jogo.bolas) {
                bolasaclonar.add(bola);
            }
            for (Bola bola : bolasaclonar) {
                if (Jogo.bolas.size() >= 300)
                    break;
                Jogo.bolas.add(new Bola((int) bola.x, (int) bola.y));
                Jogo.bolas.add(new Bola((int) bola.x, (int) bola.y));
            }
            return true;
        }
        return false;
    }
}
