// get console params
const testArray = process.argv.slice(2).map(x => +x);

// development
const sort = (inputArray) => {
  const array = [...inputArray];
  let hasChanges = true;

  while (hasChanges) {
    hasChanges = false;

    for (let i = 0, max = array.length - 1; i < max; i++) {
      if (array[i] > array[i + 1]) {
        hasChanges = true;
        [array[i], array[i + 1]] = [array[i + 1], array[i]];
      }
    }
  }

  return array;
};

// test
console.log(testArray, '->', sort(testArray));
