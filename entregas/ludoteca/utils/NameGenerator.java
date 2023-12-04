package entregas.ludoteca.utils;

import java.util.Random;

public class NameGenerator {
  private static final Random random = new Random();
  private static final String[] FIRST_NAMES = { "Cole", "Nathan", "Saul", "Samus", "Joel", "Lara", "Grace", "Henry" };
  private static final String[] LAST_NAMES = { "MacGrath", "Drake", "Goodman", "Aran", "Miller", "Croft", "Miller" };

  public static String generateRandomName() {
      String firstName = getRandomElement(FIRST_NAMES);
      String lastName = getRandomElement(LAST_NAMES);
      return firstName + " " + lastName;
  }

  private static String getRandomElement(String[] array) {
      int index = random.nextInt(array.length);
      return array[index];
  }
}
