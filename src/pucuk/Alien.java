package pucuk;
import java.util.Random;

/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Alien extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   *  Atribut KAL menyatakan kekuatan Alien.
   */
  private static final int KAL = 4;

  /**
   * Konstruktor Alien tanpa parameter.
   */
  public Alien() {
    Random randomNo = new Random();
    int newx = randomNo.nextInt(Board.getWidth());
    int newy = randomNo.nextInt(Board.getLength());
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KAL);
    setShape(SAL);
    setX(newx);
    setY(newy);
  }
  /**
   * Konstruktor Alien dengan parameter.
   * @param newx sebuah argumen bertipe int menyatakan absis.
   * @param newy sebuah argumen bertipe int menyatakan ordinat.
   */
  public Alien(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KAL);
    setShape(SAL);
    setX(newx);
    setY(newy);
  }
}
