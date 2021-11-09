import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이진탐
public class Main2792 {
	static int[] colors;
	static int max;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		colors = new int[m];
		
		for(int i = 0; i < m; i++) {
			colors[i] = Integer.parseInt(br.readLine());
			if(max < colors[i]) {
				max = colors[i];
			}
		}
		
		int min = search(n, m);
		System.out.println(min);
	}
	
	static int search(int n, int m) {
		int min = Integer.MAX_VALUE;
		int low = 1;	
		int high = max;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			int sum = 0;
			for(int ele : colors) {
				int people = ele % mid == 0 ? ele / mid : ele / mid + 1;
				sum += people;	
			}
			
			if(n >= sum) { 
				min = Math.min(min, mid);	
				high = mid - 1;
			}
			else {
				low = mid + 1; 
			}
		}
		
		return min;
	}
}