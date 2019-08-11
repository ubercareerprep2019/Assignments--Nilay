## Trees

### Ex 1: Printing a tree
`print()`, `print(int num)`
- Located in [`/Trees/Tree.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/Tree.java)
- The method prints all the values of the Tree in an `Inorder` traversal by default. Additionally, you can pass an additional integer `(1, 2, or 3)` and it will generate an `Inorder`, `Preorder`, or `Postorder` output.

### Ex 2: Printing a tree level by level 
`printLevelByLevel()`
- Located in [`/Trees/OrganizationStructure.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/OrganizationStructure.java)
- The method prints out all the `Employees` in a tree by their level. It uses a queue to first print all `Employees` at the current level and adds all the `Employees` under them to the next queue.
- It runs in `O(v)` time which is slightly faster than the runtime of a BFS `O(v+e)`.

### Ex 3: Printing the number of levels
`printNumLevels()`
- Located in [`/Trees/OrganizationStructure.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/OrganizationStructure.java)
- This method works very similar to `printLevelByLevel()` except that it is counting the number of times elements are added to a new queue.
- It runs in `O(v)` time which is slightly faster than the runtime of a DFS `O(v+e)`.

### Ex 4: Implement a binary search tree
Located in [`/Trees/BinarySearchTree.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/BinarySearchTree.java).
The tree is a generic Binary Search Tree that is implemented using the `Tree` class. It works with any objects or data types as long as they are subclasses of `Comparable`. The Binary Search Tree has the following methods -
- Required-
  - `insert(T key)`
    - Inserts a key into this binary search tree in `O(log n)` time.
  - `find(T key)`
    - Checks whether or not a key exists in this binary search tree in `O(log n)` time
- Additional-
  - `search(T key)`
    - It searches the tree with the key passed in and returns an object with a matching key. If there is no object with the same key, it return null. Used for the `Phonebook` part.
    - **Note:** Only makes sense when the Tree consists of objects like `Pair` which have a key and value.
  - `size()`
    - returns the size of the Binary Search Tree

### Ex 5: Implement a phone book
- List Phone book
  - Located in [`/Trees/ListPhoneBook.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/ListPhoneBook.java)
  - It uses an `ArrayList` to implement the `PhoneBook` interface.
  
- Binary Search Tree Phone book
  - Located in [`/Trees/BSTPhoneBook.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/BSTPhoneBook.java)
  - It uses an `Binary Search Tree` to implement the `PhoneBook` interface.
  - **Note:** The Binary search tree used is the same from Ex. 4

**Note:** Both the implementations are done using the [`BookEntry`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/BookEntry.java) object I created to store each entry. `BookEntry` extends the `Pair` class and similarly consists of a key and a value. However, it has its own `compareTo(BookEntry e)` method which compares to `BookEntry` objects solely on their keys. The reason for this was to make it easier to find the value from its corresponding key in the Binary Search Tree. It is located in [`/Trees/BookEntry.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/BookEntry.java).

### Ex 6: Unsorted lists v.s. Binary search trees
Located in [`/Trees/List_vs_BST.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Trees/List_vs_BST.java). The program uses the `ListPhoneBook` and `BSTPhoneBook` implemented in `Ex5`, and populates them with the entries from `data.csv`. It then uses the queries from `search.txt` to get the results from each of the phone book and times them. It then prints out the time taken for the search and also checks if the search was successful by comparing the results from the two phone books.

