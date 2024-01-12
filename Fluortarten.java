import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fluortarten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] happiness = br.readLine().split(" ");
        br.close();

        List<Long> o = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            o.add(Long.parseLong(happiness[i]));
        }
        o.remove(Long.valueOf(0));

        List<Long> lst = new ArrayList<>();
        lst.add((o.get(0)));
        for (int i = 1; i < n-1; i++) {
            lst.add(((i + 1) * o.get(i)) + lst.get(lst.size()-1));
        }

        List<Long> lstAdd = new ArrayList<>();
        lstAdd.add(2 * o.get(0));
        for (int i = 1; i < n-1; i++) {
            lstAdd.add(((i + 2) * o.get(i) ) + lstAdd.get(lstAdd.size()-1));
        }

        long max = lstAdd.get(lstAdd.size()-1);
        for (int curr = 1; curr < n; curr++) {
            max = Math.max(max, lst.get(curr-1) + (lstAdd.get(lstAdd.size()-1) - lstAdd.get(curr-1)));
        }
        System.out.println(max);

    }
}