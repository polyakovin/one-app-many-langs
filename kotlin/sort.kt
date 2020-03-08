fun main(args: Array<String>) {
  val inputArray = args.toList().map { it.toFloat() };
  val sortedArray = sort(inputArray);
  println(arrayToString(inputArray) + " -> " + arrayToString(sortedArray))
}

fun sort(array: List<Float>): List<Float> {
  var hasChanges = true
  var sortedArray = array.toMutableList()
  while (hasChanges) {
    hasChanges = false

    for (i in 0 until sortedArray.size - 1) {
      if (sortedArray[i] > sortedArray[i + 1]) {
        hasChanges = true
        val temp = sortedArray[i]
        sortedArray[i] = sortedArray[i + 1]
        sortedArray[i + 1] = temp
      }
    }
  }

  return sortedArray
}

fun arrayToString(array: List<Float>): String {
  return array
    .map { if (isInt(it)) it.toInt().toString() else it.toString() }
    .joinToString(prefix = "[", postfix = "]")
}

fun isInt(number: Float): Boolean {
  return number.toInt().toFloat().equals(number)
}
