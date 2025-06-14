# Multithreaded-File-Word-Counter

![image](https://github.com/user-attachments/assets/529002f0-171e-438c-b22d-1e42851e1a3a)

## About
This Java program processes multiple text files to count the occurrences of two specific words. The goal is to compare and analyze the performance trade-offs between single-threaded and multithreaded implementations, exploring both the challenges and benefits of parallelization.

As file sizes and numbers increase, reading and analyzing them sequentially may not be optimal. Parallelization can improve performance, but it introduces challenges like thread safety, synchronization, and optimal thread allocation.

This was an assignment for the CMPS211 - Advanced Programming Techniques Course

## Part 1 Single Thread Version:
### Features:

#### i. **WordCounter Class**: Converts a given text to lowercase then counts the occurrences of the word in the string.

#### ii. **Main Function**:

1. Takes multiple words from the user and convert them to lowercase.
   
2. Reads a text file. The filename is hardcoded. If the file is not found, prints an informative error message and exits.

3. Calculates the occurrences of each word in the document using WordCounter.
   
4. Prints the result and the time taken to execute the program.
   
## Part 2 Multithreaded Version:
### Features:

#### i. WordCounter Class: Makes the class in Part 1 implement Runnable.

#### ii. Main Function:

1. Takes two words from the user and convert them to lowercase.
   
2. Reads a text file. The filename is hardcoded. If the file is not found, prints an informative error message and exits.
   
3. Calculates the occurrences of each word in the document using a thread pool of WordCounter tasks.
   
4. Prints the result and the time taken to execute the program.

## Demo

https://github.com/user-attachments/assets/65285dbb-0b59-49cc-8b55-51098ca501ce

