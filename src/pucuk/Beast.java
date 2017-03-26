package pucuk;
import java.util.Random;

/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Beast extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KB menyatakan kekuatan Beast.
   */
  private static final int KB = 0;

  /**
   * Konstruktor Beast tanpa parameter.
   */
  public Beast() {
    Random randomNo = new Random();
    int newx = randomNo.nextInt(Board.getWidth());
    int newy = randomNo.nextInt(Board.getLength());
    setdeltaX(0);
    setdeltaY(1);
    setKekuatan(KB);
    setShape(SB);
    setX(newx);
    setY(newy);
  }

  /**
  * Konstruktor Beast dengan parameter.
  * @param newx sebuah argumen bertipe int menyatakan absis.
  * @param newy sebuah argumen bertipe int menyatakan ordinat.
  */
  public Beast(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(1);
    setKekuatan(KB);
    setShape(SB);
    setX(newx);
    setY(newy);
  }

}
