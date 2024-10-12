package com.example.mipt_2.utils;

public class TextCounter {
    public static int getCharsCount(String userInput)
    {
        return userInput.length();
    }
public static int getWordsCount(String text)
    {
        if (text == null || text.isEmpty())
        {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}
