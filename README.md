Algorithm repository assignment
Stage 2 2022
19209905 Zairui Zhang


There are 3 assignments which graded and 5 practicals which finished in week lab.

//All time calculate in nano
Practical 1:
Time for RussianpeasantMult
For 13*238, 1405
For 2*19 753
time complexity: O(logn)
space complexity: O(1)
//the function for multiply two numbers x and y :
x*y change to x*2 * y/2 when y is even, follow this in while loop, it is linear.
For Arraymax function
A={3,4,5,6,7} time: 662
time complexity: O(n)
space complexity: O(1)
// we initialize the first element in array is the maximum number, then we compare it in for loop to next again and again to find to max one.

Practical 2:

This practical count the number of triple use two different function.
ThreeSumA use brute-force algorithm:
Time:
Three sum A(1):266606529
Three sum A(2):1930309997
Three sum A(3):15044953750
Three sum A(4):125981535507
Three sum A(5):952648969312
Time complexity O(n^3)
ThreeSumB use binary search algorithm:
Time:
Three sum B(1):23141160
Three sum B(2):68615135
Three sum B(3):227029066
Three sum B(4):1087764189
Three sum B(5):4091171517
Time complexity O(n^2logn)
Test use the 5 given files.

Practical 3:
This practical focus on binary search.
Use {1,7,3,5,4,17,15,5} to find the index of 15 with three functions
The time for three function are :

Current time(1) in nano: 1957770
Current time(2) in nano: 479845
Current time(3) in nano: 424980
Time complexity ：
O(logn)
Space complexity :
O(1)
Function 1 use array and function 3 use list.
Function 2 use recursive
// Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise, narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

Practical 4:
This practical focus on string search. Use two functions, one is brute-force, one is KMP searching. Both algorithm search for a pattern in text.
Use two input to test time
String txt = "ABABDABACDABABCABAB";
String pat = "ABABCABAB";
For Brute force:
126692
time complexity : O(Pattern * txt)
space complexity :O(n)

For KMP:
9148019
time complexity : O(n)
space complexity :O(n)

Practical 5:
Runlength Compression and decompression of binary input. Counts the input character to compress the file. Use command line (+) for compress, (-) for expand.
Time complexity: O(n)
Space complexity :O(n)
