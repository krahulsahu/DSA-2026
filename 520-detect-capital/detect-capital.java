class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCount++;
            }
        }
        return upperCount == 0 || upperCount == word.length() || (upperCount ==1 && Character.isUpperCase(word.charAt(0)));
    }
}