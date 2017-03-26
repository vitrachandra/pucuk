package pucuk;

/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Human extends Makhluk {
  /**
   * {@inheritDoc}.
   */
  /**
   * Konstrutor Human tanpa parameter.
   */
  public Human() {
    setId(getIdGlobal());
    setX(0);
    setY(0);
  }

  /**
   * Konstruktor Human dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public Human(final int newx, final int newy) {
    addIdGlobal();
    setId(getIdGlobal());
    setX(newx);
    setY(newy);
  }

  /**
   * Prosedur public move mengatur pergerakan Human.
   */
    public final void move() {
    setX(getX() + getdeltaX());
    setY(getY() + getdeltaY());
  }
}
