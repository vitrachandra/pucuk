package pucuk;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Vitra Chandra/13514043
 */
public class BoardView {
    /**
     * Image untuk makhluk Artist.
     */
    private static final ImageIcon IAR =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\artist.png")
                    .getImage().getScaledInstance(50, 65, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk GhostBuster.
     */
    private static final ImageIcon IGB =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\ghostbuster.png")
                    .getImage().getScaledInstance(45, 55, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Military.
     */
    private static final ImageIcon IM =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\military.png")
                    .getImage().getScaledInstance(45, 55, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Knight.
     */
    private static final ImageIcon IK =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\knight.png")
                    .getImage().getScaledInstance(55, 80, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Beast.
     */
    private static final ImageIcon IB =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\beast.png")
                    .getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Ghost.
     */
    private static final ImageIcon IG =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\ghost.png")
                    .getImage().getScaledInstance(45, 55, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Alien.
     */
    private static final ImageIcon IAL =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\alien.png")
                    .getImage().getScaledInstance(40, 60, Image.SCALE_SMOOTH));

    /**
     * Image untuk makhluk Predator.
     */
    private static final ImageIcon IP =
            new ImageIcon(new ImageIcon("..\\Pucuk\\image\\predator.png")
                    .getImage().getScaledInstance(45, 55, Image.SCALE_SMOOTH));

    /**
     * Variabel konstant panjang dimensi.
     */
    private static final int DL = 800;

    /**
     * Variabel konstant lebar dimensi.
     */
    private static final int DW = 600;

    /**
     * Variabel untuk frame pada java swing.
     */
    private static JFrame frame;

    /**
     * Variabel yang menyatakan panel background.
     */
    private static JPanelWithBackground jpwb;

    /**
     * Variabel yang menyatakan matriks label untuk menyimpan image makhluk.
     */
    private static JLabel[][] jlabel;

    /**
     * Konstruktor tanpa parameter.
     * @param keyL sebagai input key yang dibaca
     */
    public BoardView(final KeyListeners keyL) {
        frame = new JFrame("POP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(DL, DW));
        jpwb = new JPanelWithBackground("..\\Pucuk\\image\\map.jpg", DL, DW);
        frame.addKeyListener(keyL);
        frame.requestFocus();
        jpwb.setLayout(new GridLayout(Board.getLength(), Board.getWidth()));
        jlabel = new JLabel[Board.getLength()][Board.getWidth()];
        for (int i = 0; i < Board.getLength(); i++) {
            for (int j = 0; j < Board.getWidth(); j++) {
                jlabel[i][j] = new JLabel();
            }
        }
        for (int i = 0; i < Board.getLength(); i++) {
            for (int j = 0; j < Board.getWidth(); j++) {
                jpwb.add(jlabel[i][j]);
            }
        }
        frame.getContentPane().add(jpwb);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Fungsi untuk mengembalikan suatu ImageIcon dari suatu shape.
     * @param shape sebuah char berupa representasi makhluk
     * @return Image tiap-tiap makhluk
     */
    public final ImageIcon shapeImage(final char shape) {
        switch (shape) {
            case Makhluk.SAR:
                return IAR;
            case Makhluk.SGB:
                return IGB;
            case Makhluk.SM:
                return IM;
            case Makhluk.SK:
                return IK;
            case Makhluk.SB:
                return IB;
            case Makhluk.SG:
                return IG;
            case Makhluk.SAL:
                return IAL;
            case Makhluk.SP:
                return IP;
            default:
                return new ImageIcon();
        }
    }

    /**
     * Prosedur yang mengubah tampilan board menurut Board.
     * @param b sebuah board yang menyimpan makhluk
     */
    public final void update(final Board b) {
        for (int i = 0; i < Board.getLength(); i++) {
            for (int j = 0; j < Board.getWidth(); j++) {
                char shape;
                if (b.getElementBoard(i, j) != null) {
                    shape = b.getElementBoard(i, j).getShape();
                } else {
                    shape = ' ';
                }
                jlabel[i][j].setIcon(shapeImage(shape));
            }
        }
    }

    /**
     * Prosedur untuk me-request fokus dari sistem.
     */
    public final void reqfocus() {
        frame.requestFocus();
    }
}
