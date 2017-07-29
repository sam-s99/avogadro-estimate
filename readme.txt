/******************************************************************************
 *  Name: Justin Tran
 *  NetID: jctran
 *  Precept: P09
 *
 *  Partner Name: No partner   
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 ******************************************************************************/

Which partner is submitting the program files? No partner

Final Programming Project: Atomic Nature of Matter

Hours to complete assignment (optional):


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

I determined the integer b by using Stopwatch to calculate the runtimes for
n = 3,072,000 and n = 6,144,000. I divided the time from n = 6,144,000 by the 
time for n = 3,072,000 which came out to be around 2 (note that dividing other n
values by their successive n values also had results around 2). Log base 2 of 2
is equal to 1 which is the equation for roughly determining b, the integer in 
the exponent. So, the expressions both took on the form of: a * (n).

I determined the value of the decimal a by using the runtimes for a certain n
and dividing that runtime by that n. For instance, (0.735 / 3,072,000) = 2.39E-7

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no? Went to the tips and tricks precept with Donna Gabai



/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no? No



/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/
