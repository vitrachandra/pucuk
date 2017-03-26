package pucuk;
import java.util.ArrayList;

/**
 * @author Friska/13514042.
 */
public final class Board {
  /**
   * Atribut private Board berbentuk matriks list.
   */
  private final ArrayList<ArrayList<ArrayList<Makhluk>>> papan;

  /**
   * membuat single object dari board (singleton pattern).
   */
  private static final Board INSTANCE = new Board(10, 10, 1);

  /**
   * Atribut Length menyatakan ukuran panjang Board.
   */
  private static int length;

  /**
   * Atribut height menyatakan ukuran tinggi Board.
   */
  private static int height;

  /**
   * Atribut width menyatakan ukuran lebar Board.
   */
  private static int width;

  /**
   * Pemanggilan single object pada board.
   * @return INSTANCE sebuah intansiasi Board sebagai single object board
   */
  public static  Board getInstance() {
    return INSTANCE;
  }

  /**
   * Konstruktor Board dengan parameter.
   * Membuat board berdasarkan parameter.
   * @param x sebuah argumen bertipe int.
   * @param y sebuah argumen bertipe int.
   * @param n sebuah argumen bertipe int.
   */
  private Board(final int x, final int y, final int n) {
    width = x;
    length = y;
    height = n;
    papan = new ArrayList<>();

    for (int i = 0; i < width; i++) {
      papan.add(new ArrayList<>());
      for (int j = 0; j < length; j++) {
        papan.get(i).add(new ArrayList<>());
        for (int k = 0; k < height * height + 1; k++) {
          papan.get(i).get(j).add(null);
        }
      }
    }
  }

  /**
   * Prosedur private setElmtBoard untuk mengeset element board.
   * @param c sebuah argumen bertipe int.
   * @param x sebuah argumen bertipe int.
   * @param y sebuah argumen bertipe int.
   */
  public void setElementBoard(final Makhluk c, final int x, final int y) {
    papan.get(x).get(y).set(0, c);
  }

  /**
   * Prosedur private setElmtBoard untuk mengeset element board.
   * @param c sebuah argumen bertipe int.
   * @param x sebuah argumen bertipe int.
   * @param y sebuah argumen bertipe int.
   * @param z sebuah argumen bertipe int.
   */
  public void setElementBoard(
          final Makhluk c, final int x, final int y, final int z) {
    papan.get(x).get(y).set(z, c);
  }

  /**
   * Fungsi getElementpapan untuk mengembalikan elemen papan.
   * @param i sebuah argumen bertipe int.
   * @param j sebuah argumen bertipe int.
   * @return (papan.get(i).get(j).get(k)) sebuah elemen papan pada i, j, k.
   */
  public Makhluk getElementBoard(final int i, final int j) {
    return (papan.get(i).get(j).get(0));
  }

  /**
   * Fungsi getElementpapan untuk mengembalikan elemen papan.
   * @param i sebuah argumen bertipe int.
   * @param j sebuah argumen bertipe int.
   * @param k sebuah argumen bertipe int.
   * @return (papan.get(i).get(j).get(k)) sebuah elemen papan pada i, j, k.
   */
  public Makhluk getElementBoard(
          final int i, final int j, final int k) {
    return (papan.get(i).get(j).get(k));
  }

  /**
   * Fungsi untuk mengambil nilai height.
   * @return height sebuah variabel statik
   */
  public static int getHeight() {
      return height;
  }

  /**
   * Fungsi untuk mengambil nilai width.
   * @return width sebuah variabel statik
   */
  public static int getWidth() {
      return width;
  }

  /**
   * Fungsi untuk mengambil nilai length.
   * @return length sebuah variabel statik
   */
  public static int getLength() {
      return length;
  }
}
