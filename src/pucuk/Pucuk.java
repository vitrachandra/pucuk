package pucuk;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author Friska/13514042
 */
public final class Pucuk {
    /**
     * Variabel yang menyatakan pemain.
     */
    private static Makhluk player;

    /**
     * Konstruktor tanpa parameter.
     */
    private Pucuk() {
    }

    /**
     * Fungsi yang mengembalikan suatu makhluk pemain.
     * @return player
     */
    public static Makhluk getPlayer() {
        return player;
    }

    /**
     * Suatu konstanta yang menyatakan lv 1.
     */
    public static final int LV1 = 2;

    /**
     * Suatu konstanta yang menyatakan lv 2.
     */
    public static final int LV2 = 5;

    /**
     * Suatu konstanta yang menyatakan lv 3.
     */
    public static final int LV3 = 10;

    /**
     * Suatu konstanta yang menyatakan lv 4.
     */
    public static final int LV4 = 50;

    /**
     * Konstanta bilangan 3.
     */
    public static final int THREE = 3;
    /**
     * Konstanta bilangan 4.
     */
    public static final int FOUR = 4;
    /**
     * Konstanta bilangan 10.
     */
    public static final int TEN = 10;
    /**
     * Konstanta bilangan 500.
     */
    public static final int FIVEHUNDRED = 500;

    /**
     * Prosedur yang mengubah makhluk pemain ke tingkat yang lebih tinggi.
     * @param m sebuah makhluk yang akan berubah
     */
    public static void evolve(final Makhluk m) {
        switch (m.getShape()) {
            case Artist.SAR:
                m.setKekuatan(GhostBuster.getK());
                m.setShape(Makhluk.SGB);
                break;
            case Makhluk.SGB:
                m.setKekuatan(Military.getK());
                m.setShape(Makhluk.SM);
                break;
            case Makhluk.SM:
                m.setKekuatan(Knight.getK());
                m.setShape(Makhluk.SK);
                break;
            default:
                break;
        }
    }
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException untuk exception
     */
    public static void main(final String[] args) throws InterruptedException {
        boolean youWin = false;
        int level = 1;
        MonsterFactory m = new MonsterFactory();
        player = new Artist(0, 0);
        ListMakhluk l = new ListMakhluk();
        KeyListeners keyL = new KeyListeners();
        Board b = Board.getInstance();
        BoardView v = new BoardView(keyL);
        BoardController bc = new BoardController(b, v);

        l.insert(player);
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));
        l.insert(m.getMonster("beast"));

        while (l.search(player) != -1 && !youWin) {
            for (int i = 0; i < l.neff(); i++) {
                if (l.get(i) == player) {
                    v.reqfocus();
                    continue;
                }
                Thread t = new Thread(new Move(l.get(i)));
                t.start();
                t.join();
            }
            int kunci = keyL.getKunci();
            System.out.println(kunci);
            switch (kunci) {
                case KeyListeners.KLEFT:
                    if (player.getY() > 0) {
                        player.setY(player.getY() - 1);
                    }
                    break;
                case KeyListeners.KRIGHT:
                    if (Board.getWidth() >= player.getY()) {
                        player.setY(player.getY() + 1);
                    }
                    break;
                case KeyListeners.KUP:
                    if (player.getX() > 0) {
                        player.setX(player.getX() - 1);
                    }
                    break;
                case KeyListeners.KDOWN:
                    if (player.getX() < Board.getLength()) {
                        player.setX(player.getX() + 1);
                    }
                    break;
                default:
                    break;
            }
            bc.updateBoard(l);
            System.out.println("Score : " + Score.getScore());
            MILLISECONDS.sleep(FIVEHUNDRED);
            if (l.neff() < TEN) {
                while (l.neff() < TEN) {
                    l.insert(m.getMonster(""));
                }
            }
            if (level == 1 && Score.getScore() > LV1) {
                evolve(player);
                level++;
            } else if (level == 2 && Score.getScore() > LV2) {
                evolve(player);
                level++;
            } else if (level == THREE && Score.getScore() > LV3) {
                evolve(player);
                level++;
            } else if (level == FOUR && Score.getScore() > LV4) {
                youWin = true;
            }
        }
        if (youWin) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }
}
