package pucuk;

/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Military extends Human {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KM menyatakan kekuatan Military.
   */
  private static final int KM = 5;

  /**
   * Fungsi untuk mengembalikan kekuatan Military.
   * @return KM sebagai kekuatan
   */
  public static final int getK() {
      return KM;
  }
  /**
   * Konstruktor Military dengan parameter.
   * @param newx sebuah argumen bertipe int menyatakan absis.
   * @param newy sebuah argumen bertipe int menyatakan ordinat.
   */
  public Military(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(1);
    setKekuatan(KM);
    setShape(SM);
    setX(newx);
    setY(newy);
  }
}
