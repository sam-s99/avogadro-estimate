/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/
n = (640 * 480 * # frames)        running time    
----------------------------------------------
3,072,000 = (640 * 480 * 10)      0.735 seconds
6,144,000 = (640 * 480 * 20)      1.416 seconds 
12,288,000 = (640 * 480 * 40)     2.773 seconds 
24,576,000 = (640 * 480 * 80)     5.414 seconds  
49,152,000 = (640 * 480 * 160)    10.356 seconds

Estimated time for BeadTracker as a function of n: 2.39E-7 * (n) seconds
