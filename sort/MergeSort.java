package sort;

import java.util.Random;

public class MergeSort
{

	static int [] aux;   //auxiliary array
	
	/** In-place merge a[l...mid] and a[mid+1...h], with the help of an auxiliary array
	 * 
	 * @param a    integer array
	 * @param lo   lower bound
	 * @param mid  middle 
	 * @param hi   higher bound
	 */
	public static void merge(int[] a, int lo, int mid, int hi)
	{
		int i = lo, j = mid + 1;

		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for(int k = lo; k <= hi; k++)
		{
			if     (i > mid)             a[k] = aux[j++];
			else if(j > hi)              a[k] = aux[i++];
			else if(aux[i] <= aux[j])    a[k] = aux[i++];
			else  /*aux[i] >  aux[j]*/   a[k] = aux[j++];
		}
	}
	
	public static void sort(int[] a)
	{
		aux = new int[a.length];
		int lo = 0;
		int hi = a.length - 1;
		
		mergeSort(a, lo, hi);
	}
	
	private static void mergeSort(int[] a, int lo, int hi)
	{
		if(lo == hi)
			return;
		
		int mid = (lo + hi)/2;
		
		mergeSort(a, lo, mid);
		mergeSort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] array = new int[1000];
		for (int i = 0; i< array.length; i++)
		{
			array[i] = rand.nextInt(1000);
		}
		
		sort(array);
		
		for (int i = 0; i< array.length; i++)
		{
			System.out.print(array[i] + ", ");
			if(i%10 == 9)
				System.out.println();
		}
	}

}
