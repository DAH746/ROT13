import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Assumptions:
*   - Non-alphabetic characters are accepted & do not require encoding
*   - The file can have multiple lines
*   - The file can have multiple words, with spaces in between
*   - Words/letters can be upper or lower case.
*   */

class Solution {

    public static void main(String args[]) {

        StringBuilder encodedToROT13StringBuilder = new StringBuilder();

        try {
            File rawFileFromDirectoryToBeEncodedToROT13 = new File("src/nonEncodedROT13.txt");
            Scanner reader = new Scanner(rawFileFromDirectoryToBeEncodedToROT13);

            Boolean isThereANextLine = reader.hasNextLine();

            if (!isThereANextLine) throw new IllegalArgumentException("File is empty");

            while (isThereANextLine) {

                String currentLine = reader.nextLine();
                char[] currentLineAsChars = currentLine.toCharArray();

                for(char character : currentLineAsChars){

                    if ('A' <= character && character <= 'M' || 'a' <= character && character <= 'm') {
                        character += 13;
                    } else if('N' <= character && character <= 'Z' || 'n'<= character && character <= 'z') {
                        character -= 13;
                    }
                    encodedToROT13StringBuilder.append(character);
                }

                isThereANextLine = reader.hasNextLine();

                if (isThereANextLine) encodedToROT13StringBuilder.append("\n");

            }
            System.out.println(encodedToROT13StringBuilder.toString());
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("An error occurred.");
            fileNotFoundException.printStackTrace();
        }
    }
}