class Solution {
    public List<String> subs(String word) { //gets all possible substrings
        List theSubs = new ArrayList<String>();

        for (int x = 0; x < word.length() + 1; x++) {
            for (int y = x + 1; y < word.length() + 1; y++) {
                theSubs.add(word.substring(x, y));
            }
        }

        return theSubs;
    }

    public boolean isDistinct(String word) { //Checks for distinct letters
        String letter1, letter2;
        for (int x = 0; x < word.length(); x++) {
            letter1 = word.substring(x, x + 1);
            for (int y = x + 1; y < word.length(); y++) {
                letter2 = word.substring(y, y + 1);
                if (letter1.compareTo(letter2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int lengthOfLongestSubstring(String s) {
        if(s.compareTo("") == 0){                   //Null comparison
            return 0;
        }else{
        List <String> sortedSubstrings = new ArrayList<String>();

        List <String> substrings = new ArrayList<String>();
        substrings = subs(s); // All possible substrings

        // Creates a sorted substring list
        int maxStringLen, maxIndex;
        while (substrings.size() != 0) {
            maxIndex = 0;
            maxStringLen = 0;
            for (int index = 0; index < substrings.size(); index++) { //Finds substring with max
                if (substrings.get(index).length() > maxStringLen) {
                    maxStringLen = substrings.get(index).length();
                    maxIndex = index;
                }
            }
            sortedSubstrings.add(substrings.get(maxIndex)); //adds it to the top of a new list
            substrings.remove(maxIndex); //removes it from previous
        }

        int answerIndex;
        for(answerIndex = 0; answerIndex < sortedSubstrings.size(); answerIndex++) //Gets the disinct substring
        {
            if(isDistinct(sortedSubstrings.get(answerIndex))){
                break;
            }
        }
        return sortedSubstrings.get(answerIndex).length();
    }
    }
}