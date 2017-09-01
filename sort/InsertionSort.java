package sort;

/**
 * SBU CSE 548, 8/29/2017
 * 
 * @author caitaozhan@gmail.com
 *
 */
public class InsertionSort
{
	
	public static void insertionSort(int[] array)
	{
		int n = array.length;
		for(int j = 1; j < n; j++)       // the core is to assume that array[0...j-1] is already sorted
		{
			int temp = array[j];         // insert array[j] into the right position
			int i = j - 1;
			while(i >= 0 && array[i] > temp)  // ascending order: small to big
			{
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = temp;
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[]{3, 5, 1, 7, 2, 9, 0, 8, 4, 6};
		insertionSort(array);
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
