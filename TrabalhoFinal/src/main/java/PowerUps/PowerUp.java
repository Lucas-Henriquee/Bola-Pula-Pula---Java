//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package PowerUps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public abstract class PowerUp {
    public int x, y;
    public final int COMPRIMENTO = 30, ALTURA = 30;

    public PowerUp(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean tick();

    public void render(Graphics g) {
        ImageIcon gifIcon = new ImageIcon("src/main/java/images/rainbow_star.gif");
        Image gifImage = gifIcon.getImage();
        int width = gifImage.getWidth(null);
        int height = gifImage.getHeight(null);

        // Create a temporary BufferedImage to draw the GIF
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bufferedGraphics = bufferedImage.createGraphics();
        bufferedGraphics.drawImage(gifImage, 0, 0, null);

        // Draw the GIF on the provided Graphics object
        g.drawImage(bufferedImage, x, y, null);
    }
}
