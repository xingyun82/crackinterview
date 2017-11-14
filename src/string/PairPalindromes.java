package string;

import java.util.ArrayList;
import java.util.HashSet;


public class PairPalindromes {


        public static void main(String[] args) {
            PairPalindromes test = new PairPalindromes();
            //Test word list
            String[] words = new String[] { "abc", "cba","llaba", "aba" };
            ArrayList<String> returnStringList = test.palindromeTest(words);
            returnStringList.forEach(System.out::println);
        }

        /**
         * Test whether there are palindromes when we concatenate and compare the words
         * given in an array
         * @param words : Array of words which when combined (2 words at a time) would be a palindrome
         * @return : All concatenated strings that are palindromes and the words that did not have a palindrome
         */
        public ArrayList<String> palindromeTest(String[] words) {

            ArrayList<String> retString = new ArrayList<>();
            // Store words which can form palindromes with other words in the array.
            // Use a set so that the words are unique
            HashSet<String> palindromeExists = new HashSet<String>();

            // For every word in the given list
            for (int i = 0; i < words.length; i++) {
                // Starting from the i+1 word check whether there is a palindrome by
                // combining
                // another word
                // E.g word1 + word2 or word1 + word3
                for (int j = i + 1; j < words.length; j++) {
                    // Test whether the combination is a palindrome
                    String palindromeString = words[i] + words[j];
                    if (isPalindrome(palindromeString)) {
                        // Add the palindrome to the return list
                        retString.add(palindromeString);
                        // Add both words to palindromeExists set so that they will not be
                        //individually added to the return list.
                        palindromeExists.add(words[i]);
                        palindromeExists.add(words[j]);
                        // Finally if it is a palindrome, check whether it is still a
                        //palindrome when the word orders are reversed. If so
                        // add the same
                        if (isPalindrome(words[j] + words[i])) {
                            retString.add(words[j] + words[i]);
                        }
                    }
                }
                // Finally if the word did not have a palindrome add it to the
                // return string list
                if (palindromeExists.contains(words[i]) == false) {
                    retString.add(words[i]);
                }
            }
            return retString;

        }

        /**
         * Check whether the given string is a palindrome
         *
         * @param palindromeString
         * @return True if it is a palindrome or False if it is not
         */
        public boolean isPalindrome(String palindromeString) {
            int length = palindromeString.length();
            // Compare the first and last and first +1 and last-1 till i and j are
            // same
            // if at any point they are different return false else return true
            for (int i = 0, j = length - 1; i < length && j > i; i++, j--) {
                if (palindromeString.charAt(i) != palindromeString.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
