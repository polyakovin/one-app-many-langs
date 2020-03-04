# get console params
test_array = ARGV.map {|x| x.to_f % 1 == 0 ? x.to_i : x.to_f }

# development
def sort(input_array)
  array = input_array
  has_changes = true

  while has_changes
    has_changes = false

    0.upto(array.length - 2) do |i|
      if array[i] > array[i + 1]
        has_changes = true
        array[i], array[i + 1] = array[i + 1], array[i]
      end
    end
  end

  return array
end

# test
puts test_array.to_s + ' -> ' + sort(test_array).to_s
