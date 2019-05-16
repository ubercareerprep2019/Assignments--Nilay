# Homework 1

## Arrays & Strings
#### `isStringPermutation(String s1, String s2)`
The function uses 2 HashMaps to store the frequencies from each of the input strings and a HashSet to store all the unique characters (needed to interate over the 2 HashMaps in the end). The function basically calculates the frequency of each unique character from the strings and then returns true only if the frequencies match for every character. The runtime for this function should be `O(n)`.

#### `pairsThatEqualSum(int[] arr, int target)`
The function first transfers all the integers from the array to a Hashtable and computes each integers frequency. For a given n, it checks if there exists a number `target-n` (also makes sure for cases where `n = target-n` and there is only 1 occurance of n). If it can find a valid pair, it adds both in a list which is returned. The algorithm should run in `O(n)` time.

## Stacks & Queues
### Stack-
The Stack is implemented using a generic array. It has a default size of 10 but you can also specify the desired size when initializing your stack.
The Stack has the following methods-
- `push(T ele)` - It adds an element to the stack
- `pop()`	- It removes the top element from the stack
- `pop(T ele)`	- It removes the specified element from the stack
- `top()`	- It returns the top element on the stack without removing it
- `isEmpty()`	- It returns a boolean depending on if the stack is empty or not
- `isFull()`	- It returns a boolean depending on if the stack is full or not
