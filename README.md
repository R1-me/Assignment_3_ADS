# Assignment 3

A.
This project implements and analyzes the performance of fundamental sorting and searching algorithms in Java. The chosen algorithms are
* Basic Sorting: Insertion Sort
* Advanced Sorting: Merge Sort
* Searching: Binary Search
I used `System.nanoTime()` to check the speed on arrays with small, medium, and large elements. The main goal was to compare how they handle random and already sorted data

B
1. Insertion Sort: Builds the final sorted array one item at a time by shifting elements
   * Time Complexity: $O(n^2)$ worst/average case, $O(n)$ best case (already sorted)
2. Merge Sort: A divide-and-conquer algorithm that divides the array into halves, sorts them recursively, and merges them
   * Time Complexity: $O(n \log n)$ in all cases
3. Binary Search: Finds the position of a target value within a sorted array by repeatedly dividing the search interval in half
   * Time Complexity: $O(\log n)$

C/
| Array Size | Data Type | Insertion Sort (ns) | Merge Sort (ns) | Binary Search (ns) |
| :--- | :--- | :--- | :--- | :--- |
| **10** | Random | 12600 | 19200 | 3500 |
| | Sorted | 2600 | 10200 | N/A |
| **100** | Random | 104500 | 94100 | 1500 |
| | Sorted | 6900 | 103000 | N/A |
| **1000** | Random | 4137900 | 293100 | 3000 |
| | Sorted | 13800 | 159700 | N/A |


Analysis Answers:
* Which sorting algorithm performed faster? Why? On large random datasets (1000 elements), Merge Sort was significantly faster. This matches the Big-O theory, as $O(n \log n)$ scales much better than $O(n^2)$.
* How does performance change with input size? As the size grows 10x (from 100 to 1000), Insertion Sort's execution time grows quadratically (~100x slower), while Merge Sort grows much slower (logarithmically).
* How does sorted vs unsorted data affect performance? Insertion Sort performed exceptionally fast (faster than Merge Sort) on sorted arrays. This happens because the inner `while` loop never executes, reducing its complexity to $O(n)$.
* Do the results match the expected Big-O complexity? Yes. The drastic time difference at $n=1000$ confirms the theoretical limits.
* Why does Binary Search require a sorted array? Binary Search logic depends on knowing that elements to the left are smaller and elements to the right are larger. Without a sorted array, it cannot safely discard half of the data.

D.
<img width="1920" height="1080" alt="Снимок экрана 2026-04-28 213740" src="https://github.com/user-attachments/assets/9ab90809-86de-4833-8e4d-077bae4501fa" />


E.
During this assignment, I saw how Big-O theory works in real life. It was interesting that a "slow" algorithm like Insertion Sort can beat Merge Sort on sorted data. The main challenge was organizing the files and using `Arrays.copyOf()` to keep the tests fair for each algorithm
