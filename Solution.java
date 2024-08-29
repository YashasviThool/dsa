import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'polynomialDivision' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     *  3. 2D_INTEGER_ARRAY queries
     */

    public static List<String> polynomialDivision(int a, int b, List<List<Integer>> queries) {
    // Write your code here
    List<String> result = new ArrayList<>();

    List<Integer> sequence = new ArrayList<>();
    for (int i = 0; i < a; i++) {
        sequence.add(0);
    }

    for (List<Integer> query : queries) {
        int type = query.get(0);
        int i = query.get(1);
        int x = query.get(2);

        if (type == 1) {
            if (i >= sequence.size()) {
                sequence.add(x);
            } else {
                sequence.set(i, x);
            }
        } else if (type == 2) {
            boolean divisible = true;
            for (int j = 0; j < sequence.size(); j++) {
                if (sequence.get(j) % b != 0) {
                    divisible = false;
                    break;
                }
            }
            result.add(divisible ? "Yes" : "No");
        }
    }

    return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int a = Integer.parseInt(firstMultipleInput[1]);

        int b = Integer.parseInt(firstMultipleInput[2]);

        int q = Integer.parseInt(firstMultipleInput[3]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cTemp[i]);
            c.add(cItem);
        }

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<String> result = Result.polynomialDivision(a, b, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
