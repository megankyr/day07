import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Please input file path in your command line argument");
            return;
        }

        WordDistribution distribution = new WordDistribution();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim().replaceAll("[^a-zA-Z0-9 ]", "");

                if (line.length() <= 0)
                    continue;

                line = line.toLowerCase();

                String[] words = line.split(" ");
                System.out.println("Line: " + line);

                for (int i = 0; i < words.length - 1; i++) {
                    String current = words[i];
                    String next = words[i + 1];
                    System.out.println("Current word: " + current + " Next word: " + next);
                    distribution.addWord(current, next);
                }

            }
        }

        System.out.println("Distributions are: ");
        distribution.distDisplay();

    }
}