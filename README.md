# leetcode

## numberOfIslands:

## logic:

I take in an adjacency matrix (2D array) of 1's and 0's.

1's indicates land, 0 indicates water.

I need to find the number of islands in the matrix (tiles of 1's that are all adjacent together (I.E, NOT diagonal))

EX: 

11

11

This would count as one island.

But...

11000

11000

00100

This would could as two islands, because the 1 in the bottom row is not adjacent to the set of four 1's, therefore it is its own island.

To solve this, I traverse left to right, starting from the top row to the bottom row.

If I find a one, I set it to 0 (marking it as seen), and increment a counter storing the numberOfIslands found.

Now that I found an island, I know that it can extend to everything adjacent to that piece of land I found.

Therefore, I recurse on the node above, below, left, and right.  

In those cases, I return out if I end up out of bounds of my array. If I find a 1, I will set it to 0, and recurse again. (Note: I do not increment the numberOfIslands counter, because I did not find a new island, I am still processing the same island). 

If I find a 0, I do nothing (don't traverse anymore on that node).

This is similar to a BFS algorithm (iterating out 1 node at a time), and by using this recursive logic, I can set the entire island to 0's.

Now, I'm still inside my nested for loops. I keep traversing the array (Note: that my 2D array is modified as the island I just processed turned to all 0's), and find any other islands, and repeat (incrementing by numberOfIslands counter, and setting all of its nodes to 0).

### output:

```java
height is 4
width is 5
----------------
Initialized Map:
----------------
11000
11000
00100
00011
----------------
the number of islands is 3
----------------
Processed Map:
----------------
00000
00000
00000
00000
----------------
```
