package pucuk;

/**
 * @author Scarletta Julia Yapfrine/13514074
 */
public final class Score {
    /**
     * Variabel yang menyatakan score pemain.
     */
    private static int score;

    /**
     * Fungsi untuk mengambil nilai score.
     * @return score sebuah variabel berupa score
     */
    public static int getScore() {
        return score;
    }

    /**
     * Konstruktor tanpa parameter.
     */
    private Score() {
        score = 0;
    }

    /**
     * Prosedur untuk mereset score menjadi 0.
     */
    public static void reset() {
        score = 0;
    }

    /**
     * Prosedur untuk mengakumulasi nilai score dengan parameter.
     * @param add sebuah nilai yang akan ditambahkan kedalam score
     */
    public static void addScore(final int add) {
        score += add;
    }
}
