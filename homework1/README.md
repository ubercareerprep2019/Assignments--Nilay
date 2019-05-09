# Part 2: Arrays & Strings

### Function 1: isStringPermutation(String s1, String s2)
The function uses 2 HashMaps to store the frequencies from each of the input strings and a HashSet to store all the unique characters (needed to interate over the 2 HashMaps in the end). The function basically calculates the frequency of each unique character from the strings and then returns true only if the frequencies match for every character. The runtime for this function should be O(n).

Following assumptions made for this program-
- The strings can contain any character including numbers and other characters.
- The function is case sensitive, meaning that it will look at 'A' and 'a' differently and hence they won't be a valid permutation.
- The function will consider 2 strings to be valid permutations only if they have the same length.



### Function 2: pairsThatEqualSum(int[] inputArray, int targetSum)
The function first transfers all the integers from the array to a HashSet for maximium efficiency. For a given num1 there has to be only one num1 which will add to the target (num2 = target - num1). So for each number, we look up if the HashSet contains its pair such that they add up to the target. If it does, it add this pair to a list which is eventually returned.
