import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] block = new int[n];
		int time = 0;
		int temp = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(block[i] > block[i + 1]) temp = block[i] - block[i + 1];
			else temp = block[i + 1] - block[i];
			
			if(temp > k) time++;
		}
		
		if(time == 1) time = 2;
		if(time > 2) time--;
		
		System.out.println(time);
	}
}
