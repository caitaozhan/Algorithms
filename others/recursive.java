package others;

import java.util.LinkedList;

/**
 * recursively sum up all the elements in a list
 * @author caitaozhan@gmail.com
 *
 */
public class recursive
{

	public static double sumRecursive(LinkedList<Double> list)
	{
		if(list.size() == 0)
		{
			return 0;
		}
		else
		{
			double first = list.removeFirst();
			return first + sumRecursive(list);
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList<Double> list = new LinkedList<Double>();
		for(int i = 0; i < 5; i++)
		{
			list.add((double)i);
		}
		double result = sumRecursive(list);
		System.out.println(result);
	}

}
