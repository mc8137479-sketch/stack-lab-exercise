import java.util.Scanner;
import java.util.Stack;

/*
 * Description: Checks whether delimiters are properly matched and nested.
 *
 * Programmed by: [Jezrel Dacanay] BSIT [B3] [DSA]
 * Last Modified: October 23, 2026
 * Version: 1.0
 */

public class MatchingDelimiters {

    public static boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isClosing(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean isMatch(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }

    public static void displayStack(Stack<Character> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack: Empty");
        } else {
            System.out.print("Stack: ");

            for (Character ch : stack) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }

    public static boolean checkDelimiters(String input) {
        Stack<Character> stack = new Stack<>();

        System.out.println("\nInput: " + input);
        System.out.println("\n--- STACK EXECUTION TRACE ---");

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            // Ignore characters that are not delimiters.
            if (!isOpening(current) && !isClosing(current)) {
                System.out.println("\nRead: " + current);
                System.out.println("Operation: IGNORE (not a delimiter)");
                displayStack(stack);
                continue;
            }

            System.out.println("\nRead: " + current);

            // Push an opening delimiter onto the stack.
            if (isOpening(current)) {
                stack.push(current);

                System.out.println("Operation: PUSH " + current);
                displayStack(stack);

            } else {
                // A closing delimiter cannot match an empty stack.
                if (stack.isEmpty()) {
                    System.out.println(
                        "Operation: INVALID"
                    );
                    System.out.println(
                        "Reason: Closing delimiter has no matching opening delimiter."
                    );
                    displayStack(stack);
                    System.out.println("\nResult: Invalid");
                    return false;
                }

                // Examine the most recent opening delimiter.
                char top = stack.peek();

                System.out.println("Operation: PEEK " + top);

                // Check whether the delimiters match.
                if (isMatch(top, current)) {
                    stack.pop();

                    System.out.println(
                        "Operation: POP " + top
                    );
                    displayStack(stack);

                } else {
                    System.out.println(
                        "Operation: INVALID - Mismatched delimiters"
                    );
                    System.out.println(
                        "Reason: Closing delimiter '" + current
                        + "' does not match opening delimiter '" + top + "'."
                    );
                    displayStack(stack);
                    System.out.println("\nResult: Invalid");
                    return false;
                }
            }
        }

        // Any remaining opening delimiter makes the input invalid.
        if (!stack.isEmpty()) {
            System.out.println("\nOperation: INVALID");
            System.out.println(
                "Reason: Unmatched opening delimiter remains."
            );
            displayStack(stack);
            System.out.println("\nResult: Invalid");
            return false;
        }

        System.out.println("\nOperation: isEmpty() = true");
        System.out.println("All delimiters are properly matched.");
        System.out.println("Result: Valid");

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MATCHING DELIMITERS CHECKER");
        System.out.print("Enter a sequence: ");

        String input = scanner.nextLine();

        checkDelimiters(input);

        scanner.close();
    }
}
