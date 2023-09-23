import java.util.Scanner;
import java.util.StringTokenizer;

public class LexemeConvertor {
    private static String[] reservedWords = {"cin>>", "for", "int", "while"};
    private static String[] operators = {"+", "-", "*", "/", "++", "--"};
    private static String[] specialSymbols = {">", "=", ";", "(", ")", ">=", ","};

    private static boolean isReservedWord(String lexeme) {
        for (String word : reservedWords) {
            if (lexeme.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }

    private static boolean isOperator(String lexeme) {
        for (String op : operators) {
            if (lexeme.equalsIgnoreCase(op))
                return true;
        }
        return false;
    }

    private static boolean isSpecialSymbol(String lexeme) {
        for (String sym : specialSymbols) {
            if (lexeme.equalsIgnoreCase(sym))
                return true;
        }
        return false;
    }

    private static boolean isNumber(String lexeme) {
        return lexeme.matches("^-?\\d+$");
    }

    private static boolean isIdentifier(String lexeme) {
        return lexeme.matches("^[a-zA-Z_][a-zA-Z_\\d]*$") && !isReservedWord(lexeme);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter a statement: ");
            
            if (scanner.hasNextLine()) {
                String statement = scanner.nextLine();

                StringTokenizer tokenizer = new StringTokenizer(statement);
                while (tokenizer.hasMoreTokens()) {
                    String lexeme = tokenizer.nextToken();

                    if (isReservedWord(lexeme))
                        System.out.println(lexeme + " is a reserved word");
                    else if (isOperator(lexeme))
                        System.out.println(lexeme + " is an operator");
                    else if (isSpecialSymbol(lexeme))
                        System.out.println(lexeme + " is a special symbol");
                    else if (isNumber(lexeme))
                        System.out.println(lexeme + " is a number");
                    else if (isIdentifier(lexeme))
                        System.out.println(lexeme + " is an identifier");
                    else
                        System.out.println(lexeme + " is invalid");
                }
            } else {
                System.out.println("No input found. Exiting.");
                break;
            }

            System.out.print("CONTINUE(y/n)? ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline
        } while (Character.toLowerCase(choice) == 'y');
    }
}
