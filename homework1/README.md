# Part 2: Arrays & Strings

### Function 1:
#### `isStringPermutation(String s1, String s2)`
The function uses 2 HashMaps to store the frequencies from each of the input strings and a HashSet to store all the unique characters (needed to interate over the 2 HashMaps in the end). The function basically calculates the frequency of each unique character from the strings and then returns true only if the frequencies match for every character. The runtime for this function should be O(n).

Following assumptions made for this program-
- The strings can contain any character including numbers and other characters.
- The function is case sensitive, meaning that it will look at 'A' and 'a' differently and hence they won't be a valid permutation.
- The function will consider 2 strings to be valid permutations only if they have the same length.


### Function 2:
#### `pairsThatEqualSum(int[] inputArray, int targetSum)`
The function first transfers all the integers from the array to a Hashtable and computes each integers frequency. For a given n, it checks if there exists a number 'target-n' (also makes sure for cases where n = target-n and there is only 1 occurance of n). If it can find a valid pair, it adds both in a list which is returned. The algorithm should run in O(n) time.

Assumptions made-
- The array might contains multiple occurances of the same number.
- The output list should only consider unique equations (eg- 1 + 2 and 2 + 1 are the same and not unique)
