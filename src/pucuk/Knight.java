package pucuk;

/**
 * @author Vitra Chandra/13514043.
 */
public class Knight extends Human {
  /**
   * {@inheritDoc} .
   */
  /**
   *  Atribut KK menyatakan kekuatan Artist.
   */
  private static final int KK = 7;

  /**
   * Fungsi untuk mengembalikan kekuatan Knight.
   * @return KK sebagai kekuatan
   */
  public static final int getK() {
      return KK;
  }

  /**
   * Konstruktor Knight dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public Knight(final int newx, final int newy) {
    setdeltaX(1);
    setdeltaY(1);
    setKekuatan(KK);
    setShape(SK);
    setX(newx);
    setY(newy);
  }
}
