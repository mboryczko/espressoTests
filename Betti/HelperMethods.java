package betti.ready4s.betti;

import java.util.Random;

/**
 * Created by Bartek on 19.04.2017.
 */

public class HelperMethods {

    public HelperMethods(){}

    public String GenerateRandomStringDownCase(int numberOfDigits)
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String GenerateRandomStringUpperCase(int numberOfDigits)
    {
        char[] chars = "ABCDEFGHIJKLMNOPRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
    public String GenerateRandomStringMixedLetters(int numberOfDigits)
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String GenerateRandomNumber(int numberOfDigits)
    {
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String GenerateRandomStringMixedAll(int numberOfDigits)
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String GenerateRandomStringWeirdSigns(int numberOfDigits)
    {
        char[] chars = "!@#$%^&*()-=_+[]{};':,<.>/?`~ ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numberOfDigits; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String GenerateRandomEmail()
    {
        String prefix = GenerateRandomStringMixedAll(10);
        String sufix = GenerateRandomStringDownCase(4);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("@");
        sb.append(sufix);
        sb.append(".com");
        return sb.toString();
    }
}
