package pucuk;
import java.util.ArrayList;

/**
 * @author Chalvi/13514032
 */
public class BoardController {
  /**
   * Atribut v menyatakan vektor.
   */
  private final ArrayList<Makhluk> tempatHapus;

  /**
   * Board yang dicontrol oleh BoardController.
   */
  private final Board b;

  /**
   * BoardView yang dicontrol oleh BoardController.
   */
  private final BoardView v;

  /**
   * Constructor dengan parameter.
   * @param inB sebuah input Board
   * @param inV sebuah input BoardView
   */
  public BoardController(final Board inB, final BoardView inV) {
    this.b = inB;
    this.v = inV;
    tempatHapus = new ArrayList<>();
  }

  /**
   * Prosedur private bertarung membunuh satu makhluk jika sel penuh.
   * @param i sebuah argumen bertipe int.
   * @param j sebuah argumen bertipe int.
   */
  private void bertarung(final int i, final int j) {
    int k;
    int kmin = 0;
    int kekuatanMin = b.getElementBoard(i, j, 0).getKekuatan();
    for (k = 1; k <= Board.getHeight() * Board.getHeight(); k++) {
      if (b.getElementBoard(i, j, k).getKekuatan() < kekuatanMin) {
        kmin = k;
        kekuatanMin = b.getElementBoard(i, j, k).getKekuatan();
      }
    }
    if (b.getElementBoard(i, j, 1 - kmin) == Pucuk.getPlayer()) {
      Score.addScore(b.getElementBoard(i, j, kmin).getKekuatan() + 1);
    }
    tempatHapus.add(b.getElementBoard(i, j, kmin));
    b.setElementBoard(null, i, j, kmin);
  }

  /**
   * Prosedur deleteHasilBertarung menghapus hasil bertarung dari list.
   * @param listM sebuah argumen bertipe ListMakhluk.
   */
  private void deleteHasilBertarung(final ListMakhluk listM) {
    int sizeVector = tempatHapus.size();
    int i;
    Makhluk indeks;
    for (i = sizeVector - 1; i >= 0; i--) {
        indeks = tempatHapus.get(i);
            listM.delete(listM.search(indeks));
    }
    tempatHapus.clear();
  }

  /**
   * Prosedur addToBoard menambahkan isi list makhluk ke board.
   * @param listM sebuah argumen bertipe ListMakhluk.
   */
  private void addToBoard(final ListMakhluk listM) {
    clearBoard();
    tempatHapus.clear();
    int k;
    for (int i = 0; i < listM.neff(); i++) {
      Makhluk m = listM.get(i);
      k = 0;
      while (k < Board.getHeight() * Board.getHeight()
              && b.getElementBoard(m.getX(), m.getY(), k) != null) {
        k++;
      }
      if (k >= Board.getHeight() * Board.getHeight()) {
        b.setElementBoard(m, m.getX(), m.getY(),
                Board.getHeight() * Board.getHeight());
        bertarung(m.getX(), m.getY());
        k = 0;
        while (k < Board.getHeight() * Board.getHeight()
                && b.getElementBoard(m.getX(), m.getY(), k) != null) {
          k++;
        }
        b.setElementBoard(b.getElementBoard(m.getX(), m.getY(),
                Board.getHeight() * Board.getHeight()), m.getX(), m.getY(), k);
      } else {
        b.setElementBoard(m, m.getX(), m.getY(), k);
      }
    }
  }

  /**
   * Prosedur clearBoard menghapus isi Board.
   */
  private void clearBoard() {
    for (int i = 0; i < Board.getWidth(); i++) {
      for (int j = 0; j < Board.getLength(); j++) {
        for (int k = 0; k < Board.getHeight() * Board.getHeight(); k++) {
          b.setElementBoard(null, i, j, k);
        }
      }
    }
  }

  /**
   * Prosedur untuk melakukan update pada Board.
   * @param listM sebuah list of Makhluk
   */
  public final void updateBoard(final ListMakhluk listM) {
      addToBoard(listM);
      deleteHasilBertarung(listM);
      v.update(b);
  }
}
