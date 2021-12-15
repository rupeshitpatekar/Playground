package general;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'carParkingRoof' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY cars
     *  2. INTEGER k
     */

    public static long carParkingRoof(List<Long> cars, int k) {
        // Write your code here
        Collections.sort(cars);
        int size = cars.size();
        int left =0, right =0;
        long minLength = Long.MAX_VALUE;
        while(left < size && right < size){
            while(right - left + 1 >= k) {
                minLength = Math.min(minLength, cars.get(right) - cars.get(left) + 1);
                left++;
            }
            right++;
        }
        return minLength;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int carsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> cars = IntStream.range(0, carsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.carParkingRoof(cars, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

