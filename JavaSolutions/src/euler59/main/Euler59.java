package euler59.main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

/*
 * This Euler problem is not entirely solvable with pure computation because you are given the information that the
 * cipher text contains "common" english words. Using this code I was able to decrypt the cipher with all the possible
 * keys and filter out anything that doesn't contain the word "the." Looking through the fairly small pool of remaining
 * possible decryptions, I spotted the original text and entered its ascii sum as the answer.
 */

public class Euler59 {
    public static void main(String[] args) {
        int[] cipher;

        try {
            cipher = loadCipherText();
        } catch(IOException e) {
            e.printStackTrace();
            return;
        }

        Path decryptFile = Paths.get("Solutions", "src", "solutions", "Euler59", "java", "resources", "decrypted.txt");
        System.out.println("Writing to file: " + decryptFile.toAbsolutePath().toString());

        try {
            Files.write(decryptFile, "".getBytes());
        } catch(IOException e) {
            System.out.println("Error: could not clear file " + decryptFile.toAbsolutePath());
            return;
        }

        for(char k1 = 'a'; k1 <= 'z'; k1++) {
            for(char k2 = 'a'; k2 <= 'z'; k2++) {
                for(char k3 = 'a'; k3 <= 'z'; k3++) {
                    int[] decrypted = cyclicalXOR(cipher, k1, k2, k3);
                    String decryptedString = asciiArrayToString(decrypted);

                    if(!decryptedString.toLowerCase().contains("the")) {
                        continue; // Because cipher text must contain common English words, filter out anything that
                    }             // doesn't contain the word "the"

                    decryptedString = "\n\n|| key: \"" + k1 + k2 + k3 + "\", ascii sum: " + IntStream.of(decrypted).sum() + " ||\t" + decryptedString + "\t||";
                    System.out.println(decryptedString);

                    try {
                        Files.write(decryptFile, decryptedString.getBytes(), StandardOpenOption.APPEND);
                    } catch(IOException e) {
                        System.out.println("\nError: couldn't write \n" + decryptedString + "\n to file");
                    }
                }
            }
        }
    }

    static int[] cyclicalXOR(int[] cipher, int... key) {
        int[] decrypted = new int[cipher.length];
        int keyLength = key.length;

        outerLoop:
        for(int i = 0; i < cipher.length; i += keyLength) {
            for(int j = 0; j < key.length; j++) {
                if(i + j >= cipher.length) {
                    break outerLoop; // Once i + j is equal to cipher.length, the whole cipher has been XORed with the key
                }

                decrypted[i + j] = cipher[i + j] ^ key[j];
            }
        }

        return decrypted;
    }

    static int[] loadCipherText() throws IOException {
        InputStream is = Euler59.class.getResourceAsStream("..\\resources\\cipher.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String[] rawCipherText = reader.readLine().split("\\s*,\\s*");
        int[] asciiCipherText = new int[rawCipherText.length];

        for(int i = 0; i < rawCipherText.length; i++) {
            asciiCipherText[i] = Integer.parseInt(rawCipherText[i]);
        }

        return asciiCipherText;
    }

    static String asciiArrayToString(int[] asciiArray) {
        StringBuilder sb = new StringBuilder();

        for(int charInt : asciiArray) {
            sb.append((char)charInt);
        }

        return sb.toString();
    }
}
