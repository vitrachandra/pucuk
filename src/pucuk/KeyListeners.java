package pucuk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * @author Friska/13514032
 */
public class KeyListeners extends JFrame implements KeyListener {
    /**
     * Atribut kunci menyatakan nilai suatu kunci.
     */
    private int kunci;

    /**
     * Atribut processed menyatakan apakah suatu key sedang diproses.
     */
    private boolean processed;

    /**
     * Atribut KC menyatakan kunci UP.
     */
    public static final  int KUP = 1;

    /**
     * Atribut KS menyatakan kunci DOWN.
     */
    public static final int KDOWN = 2;

    /**
     * Atribut KP menyatakan kunci Left.
     */
    public static final int KLEFT = 3;

    /**
     * Atribut KA menyatakan kunci RIGHT.
     */
    public static final int KRIGHT = 4;

    /**
     * Konstruktor KeyListeners tanpa parameter.
     */
    public KeyListeners() {
    }

    /**
     * Prosedur keyPressed untuk mengecek tombol yang sedang ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    @Override
    public final void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                kunci = KUP;
                processed = false;
                break;
            case KeyEvent.VK_DOWN:
                kunci = KDOWN;
                processed = false;
                break;
            case KeyEvent.VK_LEFT:
                kunci = KLEFT;
                processed = false;
                break;
            case KeyEvent.VK_RIGHT:
                kunci = KRIGHT;
                processed = false;
                break;
            default:
                break;
        }
    }

    /**
     * Prosedur keyTyped untuk mengabaikan tombol yang sudah ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    @Override
    public final void keyTyped(final KeyEvent e) {
    }

    @Override
    /**
     * Prosedur keyReleased untuk mengabaikan tombol yang tidak ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    public final void keyReleased(final KeyEvent e) {
    }

    /**
     * Fungsi getKunci untuk mengembalikan kunci yang telah diproses.
     * @return kunci jika tidak diproses
     */
    public final int getKunci() {
        if (!processed) {
            processed = true;
            return kunci;
        } else {
            return 0;
        }
    }
}
