package pucuk;

/**
 * @author Chalvin/13514043
 */
public class Move extends Thread {
    /**
     * Sebuah variabel makhluk.
     */
    private final Makhluk m;

    /**
     * Konstruktor dengan parameter.
     * @param inM sebuah variabel masukan berupa makhluk
     */
    public Move(final Makhluk inM) {
        m = inM;
    }

    /**
     * Prosedur untuk menjalankan thread.
     */
    @Override
    public final void run() {
         if (m.getX() + m.getdeltaX() < 0) {
            m.setX(m.getX() + m.getdeltaX() + Board.getWidth());
          } else {
            m.setX((m.getX() + m.getdeltaX()) % Board.getWidth());
          }
        if ((m.getY() + m.getdeltaY()) < 0) {
            m.setY(m.getY() + m.getdeltaY() + Board.getLength());
        } else {
            m.setY((m.getY() + m.getdeltaY()) % Board.getLength());
        }
    }
}
