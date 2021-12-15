package general.algorithms;

public class MinWindowSubstring {

    public static void main(String[] args) {
        System.out.println("Output is " + minWindow("abc","a"));
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
            String subString = s.substring(i, size);
            if( size != 0 && subString.contains(t.charAt(j)+"") && subString.length() >= t.length()){
                allCharsExists = true;
            }else {
                allCharsExists = false;
                break;
            }
        }
        return allCharsExists;
    }
}
