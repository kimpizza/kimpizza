import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5557 {
    
    static int n, number[];
    static long count[] = new long[21];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        number = new int[n];
        for(int i = 0; i < n; i++)
            number[i] = Integer.parseInt(stz.nextToken());
    
        count[number[0]] = 1;
        cal(0);
        System.out.println(count[number[n-1]]);
    }
    
    public static void cal(int index) {
        if(index == n-2)
            return;
        long temp[] = new long[21];
        for(int i = 0 ; i <= 20; i++){
            if(count[i] != 0) {
                if(i - number[index+1] >= 0)
                    temp[i-number[index+1]] += count[i];
                if(i + number[index+1] <= 20)
                    temp[i+number[index+1]] += count[i];
            }
        }
        count = temp.clone();
        cal(index+1);
    }
    
}
