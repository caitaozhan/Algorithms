package sort;

/**
 * Homework-1, problem 9
 * 
 * You are told that an array A[1..n] consists of an increasing sequence followed by a decreasing sequence.
 * More precisely, there is a 1 < k < n such that A[k] is the maximum element in the array. Moreover, 
 * for all j != k, one of its predecessor or successor elements (i.e., A[j-1] or A[j+1]) is greater than itself. 
 * Can you develop a logarithmic-time algorithm to compute the maximum element in such an array?
 */

public class FindMax
{
	public static int findMax(int[] array, int l, int h)
	{
		int m = (l+h)/2;
		if(array[m] > array[m-1] && array[m] > array[m+1])
		{
			return array[m];
		}
		else if(array[m] > array[m-1] && array[m] < array[m+1])
		{
			return findMax(array, m+1, h);
		}
		else // array[m] < array[m-1] && array[m] > array[m+1]
		{
			return findMax(array, l, m-1);
		}
	}

	public static void main(String[] args)
	{
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
				               11, 10, 9, 8, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6};
		
		int largest = findMax(array, 0, array.length-1);
		System.out.println(largest);
	}

}
