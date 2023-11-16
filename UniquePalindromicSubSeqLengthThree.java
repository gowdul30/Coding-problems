class Solution {
   public int countPalindromicSubsequence(String s) {
    int[] firstOccurrence = new int[26];
    int[] lastOccurrence = new int[26];
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        if (firstOccurrence[index] == 0) {
            firstOccurrence[index] = i + 1;
        } else {
            lastOccurrence[index] = i + 1;
        }
    }

    for (int i = 0; i < 26; i++) {
        if (firstOccurrence[i] != 0 && lastOccurrence[i] != 0) {
            count += countUniqueCharactersBetween(s, firstOccurrence[i], lastOccurrence[i]);
        }
    }

    return count;
}

private int countUniqueCharactersBetween(String s, int start, int end) {
    int[] uniqueChars = new int[26];
    int count = 0;
    for (int i = start; i < end - 1; i++) {
        int index = s.charAt(i) - 'a';
        if (uniqueChars[index] == 0) {
            uniqueChars[index] = 1;
            count++;
        }
    }
    return count;
}
}