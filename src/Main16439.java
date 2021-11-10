import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main16439 {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] satis = new int[n][m];
		int maxSum = 0, temp = 0;
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				satis[i][j] = scan.nextInt();
			}
		}
		
		for(int j = 0; j < m - 2; j++) {
			temp = 0;
			for(int i = 0; i < n; i++) {
				max = 0;
				for(int k = j; k < j + 3; k++) {
					if(satis[i][k] > max) max = satis[i][k];
				}
				System.out.print(max + " ");
				temp += max;
			}
			System.out.println("temp : " + temp);
			if(temp > maxSum) maxSum = temp;
		}
		System.out.println(maxSum);
	}
}
