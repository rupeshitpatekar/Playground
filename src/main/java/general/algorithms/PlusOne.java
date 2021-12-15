package general.algorithms;

import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        if (args.length > 0){
            
        }
//        String s = "5F3Z-2e-9-w";
//        int K = 4;
//        System.out.println(licenseKeyFormatting(s , K));

//        int[] fruits = {1,2,3,2,2};
//        System.out.println(totalFruit(fruits));
//
//        System.out.println(lengthOfLongestSubstring("abcdabefghij"));

//        int[] height = {1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea(height));

//        System.out.println(multiply("234", "4567"));
//        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        rotate(matrix);


//        System.out.println(minWindow("aa","aa"));
//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));

        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Map<Character,Character> charSet = new HashMap();
        charSet.put(')','(');
        charSet.put('}','{');
        charSet.put(']','[');

        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if(charSet.containsKey(c)){
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    char topElement = stack.pop();
                    if(topElement != charSet.get(c)){
                        return false;
                    }
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean backspaceCompare(String s, String t) {

        return computeString(s).equals(computeString(t));

    }
    private static String computeString(String s){
        StringBuilder computedString = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '#'){
                if(computedString.length() > 0)
                    computedString.deleteCharAt(computedString.length()-1);
            }else{
                computedString.append(s.charAt(i));
            }
        }
        return computedString.toString();
    }

    public static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        String window = "";
        int size = s.length();
        int j = s.length();
        for(int i =0; i< size; i++){
            if(isAllCharsExists(s, t, size, i, false)) {
                if(isAllCharsExists(s, t, --j, i , false )){
                    window = s.substring(i, j);
                }else{
                    j++;
                    window = s.substring(i, size);
                }
            }
        }
        return window;
    }

    private static boolean isAllCharsExists(String s, String t, int size, int i, boolean allCharsExists) {
        for(int j = 0; j < t.length(); j++){
            if(s.substring(i, size).contains(t.charAt(j)+"")){
                allCharsExists = true;
            }else {
                allCharsExists = false;
                break;
            }
        }
        return allCharsExists;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < n; col++) {
            for (int row = n-1; row >= 0; row--) {
                sb.append(matrix[row][col] + ",");
            }
        }

        int row = 0, col = -1;
        for (String str : sb.toString().split(",")) {
            if (col < matrix[0].length - 1) {
                col++;
            } else {
                col = 0;
                row++;
            }
            matrix[row][col] = Integer.parseInt(str);
        }
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }

        return sb.toString();
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left =0;
        int right = height.length - 1;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, currentArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right++;
            }
        }
        return max;

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int totalFruit(int[] fruits) {

        HashSet<Integer> set = new HashSet();
        int count=0, max=0, index = 0;

        for(int i=0;i<fruits.length;i++){
            set.add(fruits[i]);
            if(set.size() == 3){
                max = Math.max(max,count);
                set.clear();
                count=0;
                i = index-1;
                continue;
            }
            if(i>0 && fruits[i] != fruits[i-1]) index = i;

            count++;
        }

        return Math.max(max,count);
    }

    public static String licenseKeyFormatting(String s , int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0 , n = s.length();
        char c;
        for(int i = n - 1 ; i >= 0 ; i--) {
            c = s.charAt(i);
            if(c != '-') {
                if(cnt == k) {
                    ans.append('-');
                    cnt = 0;
                }
                cnt++;
                if(c >= 'a' && c <= 'z') {
                    c += 'A' - 'a';
                }
                ans.append(c);
            }
        }
        return ans.reverse().toString();
    }

    public void reverseString(char[] s) {
        for(int i= s.length -1 ; i> 0; i--){
            System.out.println(s[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        for(int i=0; i< n -1; i++){
            for(int j=i+1; j<= n-1; j++){
                if(numbers[i] + numbers[j] == target){
                    result[0] = ++i;
                    result[1] = ++j;
                    break;
                }
            }
            if(result[0] > 0) break;
        }
        return result;
    }

    public static int[] plusOne(int[] digits) {
        String number = "";
        for(int digit: digits){
            number += digit;
        }
        int result = Integer.parseInt(number);
        result++;
        int[] finalArray = new int[digits.length];
        int i=0;
        for(char c: String.valueOf(result).toCharArray()){
            finalArray[i] = Character.forDigit(c,10);
            i++;
        }
        return finalArray;
    }
}
