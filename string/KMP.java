package string;

/**
 * Implement the famous Knuth-Morris-Pratt substring search
 */
public class KMP
{
	private String  pattern;
	private int[][] dfa;
	
	/**
	 * Build DFA from pattern
	 * @param pattern
	 */
	public KMP(String pattern)
	{
		this.pattern = pattern;
		int M = pattern.length();
		int R = 128;                             // standard ASCII
		dfa = new int[R][M];
		dfa[pattern.charAt(0)][0] = 1;
		for(int X = 0, j = 1; j < M; j++)
		{
			for(int c = 0; c < R; c++)
			{
				dfa[c][j] = dfa[c][X];           // copy mismatch cases
			}
			dfa[pattern.charAt(j)][j] = j + 1;   // set match cases
			X = dfa[pattern.charAt(j)][X];       // update restart state
		}
	}
	
	public int search(String text)
	{
		int i, j, M = pattern.length(), N = text.length();
		for(i = 0, j = 0; i < N && j < M; i++)
		{
			j = dfa[text.charAt(i)][j];
		}
		if(j == M)
			return i - M;  // found
		else
			return N;      // not found
	}
	
	public static void main(String[] args)
	{
		String text = "The linear-time worst-case guarantee provided by the KMP algorithm is a significant "      +
                      "theoretical result. In practice, the speedup over the brute-force method is not often "    +
                      "important because few applications involve searching for highly self-repetitive patterns " +
                      "in highly self-repetitive text.";
		
		String pattern ="involve";
		
		KMP kmp = new KMP(pattern);
		int index = kmp.search(text);
		System.out.println(index);
	}

}
