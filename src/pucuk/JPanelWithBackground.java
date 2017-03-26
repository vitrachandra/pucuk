package pucuk;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Vitra Chandra/13514043
 */
public class JPanelWithBackground extends JPanel {
    /**
     * Suatu variabel image.
     */
    private Image image;

    /**
     * Konstruktor dengan parameter.
     * @param path sebuah string yang menyatakan path image
     * @param newx sebuah integer yang menyatakan ukuran panel
     * @param newy sebuah integer yang menyatakan ukuran panel
     */
    public JPanelWithBackground(
            final String path, final int newx, final int newy) {
       try {
            Image x = ImageIO.read(new File(path));
            image = x.getScaledInstance(newx, newy, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
        }
    }

    /**
     * Prosedur untuk mengisi panel dengan image.
     * @param g sebuah prosedur untuk meng-override prosedur paintComponent
     *          dengan image
     */
    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
