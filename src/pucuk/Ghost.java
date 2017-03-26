package pucuk;
import java.util.Random;

/**
 * @author Friska/13514042.
 */
public class Ghost extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KG menyatakan kekuatan Ghost.
   */
  private static final int KG = 2;

  /**
   * Konstruktor Military tanpa parameter.
   */
  public Ghost() {
    Random randomNo = new Random();
    int newx = randomNo.nextInt(Board.getWidth());
    int newy = randomNo.nextInt(Board.getLength());
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KG);
    setShape(SG);
    setX(newx);
    setY(newy);
  }

  /**
  * Konstruktor Ghost dengan parameter.
  * @param newx sebuah argumen bertipe int menyatakan absis.
  * @param newy sebuah argumen bertipe int menyatakan ordinat.
  */
  public Ghost(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KG);
    setShape(SG);
    setX(newx);
    setY(newy);
  }
}
