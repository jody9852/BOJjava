import java.util.Scanner;

public class Main11502 {
	public static boolean[] isPrime = new boolean[1001];
	public static int[] primeList = new int[1001];
	public static int primeSize = 0;
	
	public static void findPrime(int m) {
		for (int i = 2; i*i <= m; i++) 
			for (int j = i * i; j <= m; j += i)
				if (!isPrime[j]) 
					isPrime[j] = true;

		for (int i = 2; i <= m; i++)
			if (!isPrime[i])
				primeList[primeSize++] = i;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int max = -1;
		int[] K = new int[T];
		
		for(int i = 0; i < T; i++) {
			K[i] = scan.nextInt();
			if(max < K[i]) max = K[i];
		}
		
		findPrime(max);
		
		for (int i = 0; i < T; i++) {
    		int cnt=0;
            
            // 2 + 2 + 홀수인 소수
    		if (!isPrime[K[i] - 4])
    		{
    			cnt++;
    			System.out.println(2+" "+ 2+" "+ (K[i] - 4));
    			continue;
    		}
    		
            // 홀수인 소수 3개로 이루어진 경우
    		outerloop:
    		for (int j = 1; j < primeSize; j++) {
    			for (int k = 1; k < primeSize; k++) {
    				for (int u = 1; u < primeSize; u++) {
    					if (primeList[j]+primeList[k]+primeList[u]==K[i])
    					{
    						cnt++;
    						System.out.println(primeList[j]+" "+ primeList[k]+" "+primeList[u]);
    						break outerloop;
    					}
    				}
    			}
    		}
            // 3개의 소수로 이루어지지 않은 경우
    		if (cnt==0)
    			System.out.println(0);
    	}
	}
}
