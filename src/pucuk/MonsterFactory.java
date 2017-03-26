package pucuk;
import java.util.Random;

/**
 * @author Scarletta Julia Yapfrine/13514074
 */
public class MonsterFactory {
   /**
    * Atribut yang menyatakan banyaknya tipe monster.
    */
    private static final int MONSNUM = 4;

   /**
    * Atribut private randomno digunakan sebagai random number generator.
    */
    private final Random randomNo;

   /**
    * Konstruktor tanpa parameter.
    */
    MonsterFactory() {
        randomNo = new Random();
    }

   /**
    * getMonster memproduksi 1 type monster dan mengembalikannya pada user.
    * jika parameternya kosong, memproduksi 1 monster dengan type di-random
    * bila tidak, mengeluarkan monster sesuai type monster yang diberi input
    * @param monsterType type monster yang akan diproduksi
    * @return Moster sebagai makhluk yang di-spawn pada layar
    */
    public final Monster getMonster(final String monsterType) {
      if (monsterType.equals("")) {
        int type = randomNo.nextInt(MONSNUM);
        switch (type) {
            case 0:
                return new Alien();
            case 1:
                return new Beast();
            case 2:
                return new Predator();
            default:
                return new Ghost();
        }
      }
      if (monsterType.equalsIgnoreCase("ALIEN")) {
        return new Alien();
      } else if (monsterType.equalsIgnoreCase("BEAST")) {
         return new Beast();
      } else if (monsterType.equalsIgnoreCase("PREDATOR")) {
         return new Predator();
      } else if (monsterType.equalsIgnoreCase("GHOST")) {
         return new Ghost();
      }
      return null;
   }
}
