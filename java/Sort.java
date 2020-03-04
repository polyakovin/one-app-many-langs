// required modules
import java.util.Arrays;

public class Sort {
  // get console params
  public static void main(String[] inputArray) {
    Float[] floatInputArray = Helpers.toFloatArray(inputArray);
    Float[] sortedArray = Sort.perform(floatInputArray);
    // test
    System.out.println(Helpers.outputResult(inputArray, Helpers.toStringArray(sortedArray)));
  }

  // development
  private static Float[] perform(Float[] array) {
    boolean hasChanges = true;
    while (hasChanges) {
      hasChanges = false;

      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          hasChanges = true;
          float temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
        }
      }
    }

    return array;
  }
}

// custom helper functions
class Helpers {
  public static Float[] toFloatArray(String[] array) {
    return Arrays.stream(array)
      .map(Float::valueOf)
      .toArray(Float[]::new);
  }

  public static String[] toStringArray(Float[] array) {
    return Arrays.stream(array)
      .map(Helpers::convertNumberToString)
      .toArray(String[]::new);
  }

  public static String convertNumberToString(Float number) {
    return isInteger(number) ?
      String.valueOf(Math.round(number)) :
      String.valueOf(number);
  }

  public static Boolean isInteger(Float number) {
    return number % 1 == 0;
  }

  public static String outputResult(String[] inputArray, String[] outputArray) {
    return ""
      .concat(arrayToString(inputArray))
      .concat(" -> ")
      .concat(arrayToString(outputArray));
  }

  public static String arrayToString(String[] array) {
    return ""
      .concat("[")
      .concat(String.join(", ", array))
      .concat("]");
  }
}
