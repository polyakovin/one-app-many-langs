# required modules
import sys

# get console params
test_array = map(lambda x: int(x) if float(x).is_integer() else float(x), sys.argv[1:])

# develop
def sort(input_array):
  array = input_array[:]
  has_changes = True

  while has_changes:
    has_changes = False

    for i in range(len(array) - 1):
      if array[i] > array[i + 1]:
        has_changes = True
        array[i], array[i + 1] = array[i + 1], array[i]

  return array

# test
print(test_array, '->', sort(test_array))
