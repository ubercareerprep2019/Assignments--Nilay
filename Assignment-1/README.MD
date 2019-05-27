# Homework 1

## Part 2: Arrays & Strings
##### `isStringPermutation(String s1, String s2)`
The function uses 2 HashMaps to store the frequencies from each of the input strings and a HashSet to store all the unique characters (needed to interate over the 2 HashMaps in the end). The function basically calculates the frequency of each unique character from the strings and then returns true only if the frequencies match for every character. The runtime for this function should be `O(n)`.

##### `pairsThatEqualSum(int[] arr, int target)`
The function first transfers all the integers from the array to a Hashtable and computes each integers frequency. For a given `n`, it checks if there exists a number `target-n` (also makes sure for cases where `n = target-n` and there is only 1 occurance of `n`). If it can find a valid pair, it adds both in a list which is returned. The algorithm should run in `O(n)` time.

## Part 3: Stacks & Queues
### Stack-
The Stack is implemented using an ArrayList. It keeps track of the index of the element on the top of the stack and also keeps track of the min element on the stack. The top index is updated every time an element is pushed or popped. The min is updated every time an element smaller than it is pushed and everytime it is popped.
The Stack has the following methods-
- `push(T element)` - It adds an element to the top stack
- `pop()`	- It removes the top element from the stack
- `pop(T element)`	- It removes the specified element from the stack
- `top()`	- It returns the top element on the stack without removing it
- `isEmpty()`	- It returns a boolean depending on if the stack is empty or not
- `min()`	- It returns the smallest element from the stack without removing it in `O(1)` time.
- `updateMin()` - It is used when the smallest element of the stack is popped, it iterates through the stack and finds the next smallest element.

### Queue- 
The Queue is implemented using the Stack we created before.
The Queue has the following methods-
- `enqueue(T element)` - It adds an element to the queue
- `dequeue()` - It removes the first element from the queue
- `isEmpty()` - It returns a boolean depending on if the queue is empty or not
- `min()`	- It returns the smallest element from the queue without removing it in `O(1)` time.

## Part 4: Linked List
The Linked List has been implemented using the Node class. It keeps track of the `head` node, `tail` node and size of the list.

The list had the following methods-
- `print()` - Prints the list
- `pushBack(T ele)` - Inserts an element to the back of the list
- `popBack()` - Removes the last element from the list
- `insert(int index, T ele)` - Inserts the element at the given index. 
- `erase(int index)` - Removes the element from the given index
- `elementAt(int index)` - Returns the element at given index.
- `size()` - Returns the size of the list
- `hasCycle()` - Checks if the list is cyclic or not
- `isPalindrome()` - Checks if the list is a palindrome or not

_Note-_
- _The Linked List is indexed from `0`._
- _The Linked List class contains a helper Node class._


## Part 5: Tower of Hanoi
