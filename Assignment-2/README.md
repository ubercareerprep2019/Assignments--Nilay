# Assignment 2

## Trees

### Ex 1: Printing a tree
`print()`, `print(int num)`
- Located in `/Tree.java`
- The method prints all the values of the Tree in an `Inorder` traversal by default. Additionally, you can pass an additional integer `(1, 2, or 3)` and it will generate an `Inorder`, `Preorder`, or `Postorder` output.

### Ex 2: Printing a tree level by level 
`printLevelByLevel()`
- Located in `/OrganizationStructure.java`
- The method prints out all the `Employees` in a tree by their level. It uses a queue to first print all `Employees` at the current level and adds all the `Employees` under them to the next queue.
- It runs in `O(v)` time which is slightly faster than the runtime of a BFS `O(v+e)`.

### Ex 3: Printing the number of levels
`printNumLevels()`
- Located in `/OrganizationStructure.java`
- This method works very similar to `printLevelByLevel()` except that it is counting the number of times elements are added to a new queue.
- It runs in `O(v)` time which is slightly faster than the runtime of a DFS `O(v+e)`.

### Ex 4: Implement a binary search tree
`insert(int key)`
- pending

`find(int key)`
- pending

### Ex 5: Implement a phone book

### Ex 6: Unsorted lists v.s. Binary search trees

## Graphs

### Ex 1: Implement a graph using adjacency list

### Ex 2: DFS Traversal

### Ex 3: BFS Traversal

### Ex 4: Minimum number of edges between two nodes of a Graph

### Ex 5: Number of islands
