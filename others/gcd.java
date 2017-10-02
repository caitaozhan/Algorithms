package others;

/**
 * Compute greatest common divisor
 * 
 * @author caitaozhan@gmail.com
 */
public class gcd
{	
	/**
	 * The classical euclid algorithm
	 */
	static public int euclid(int a, int b)
	{
		if(b == 0)
			return a;
		
		return euclid(b, a % b);
	}
	
	/**
	 * The divide and conquer method
	 */
	static public int divideConquer(int a, int b)
	{
		if(b == 0)
			return a;
		else if(a < b)
			return divideConquer(b, a);
		
		if(a%2==0 && b%2==0)
			return 2*divideConquer(a/2, b/2);
		else if(a%2==0 && b%2==1)
			return divideConquer(a/2, b);
		else if(a%2==1 && b%2==0)
			return divideConquer(a, b/2);
		else // a%2==1 && b%2==1
			return divideConquer((a-b)/2, b);
	}
	
	public static void main(String[] args)
	{
		int a = 345;
		int b = 123;
		System.out.println(euclid(a, b));
		System.out.println(divideConquer(a, b));
		System.out.println(divideConquer2(a, b));
	}

}


