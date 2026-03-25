package practise5.task5;

import java.io.*;
import java.util.*;

public class ExpressionParser {

    public static void main(String[] args) {
        // Sample expressions — replace "expressions.txt" with your actual input file
        String inputFile  = "expressions.txt";
        String resultsFile = "results.txt";
        String logFile     = "log.txt";

        try (BufferedReader reader  = new BufferedReader(new FileReader(inputFile));
             PrintWriter    results = new PrintWriter(new FileWriter(resultsFile));
             PrintWriter    log     = new PrintWriter(new FileWriter(logFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                processExpression(line, results, log);
            }

            System.out.println("Done. Check results.txt and log.txt.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private static void processExpression(String expr,
                                          PrintWriter results,
                                          PrintWriter log) {
        // Tokenize on +, -, *, / while keeping the delimiters
        StringTokenizer st = new StringTokenizer(expr, "+-*/", true);
        try {
            // --- Parse first operand ---
            if (!st.hasMoreTokens()) throw new NoSuchElementException();
            double operand1 = parseDouble(st.nextToken().trim());

            // --- Parse operator ---
            if (!st.hasMoreTokens()) throw new NoSuchElementException();
            String operator = st.nextToken().trim();
            validateOperator(operator);

            // --- Parse second operand ---
            if (!st.hasMoreTokens()) throw new NoSuchElementException();
            double operand2 = parseDouble(st.nextToken().trim());

            // --- Calculate ---
            double result = calculate(operand1, operator, operand2);
            String output = expr + " = " + result;
            System.out.println(output);
            results.println(output);

        } catch (NoSuchElementException e) {
            String msg = "MISSING OPERAND in: \"" + expr + "\"";
            System.out.println(msg);
            log.println(msg);
        } catch (NumberFormatException e) {
            String msg = "INVALID NUMBER in: \"" + expr + "\"";
            System.out.println(msg);
            log.println(msg);
        } catch (UnsupportedOperationException e) {
            String msg = "INVALID OPERATOR in: \"" + expr + "\"";
            System.out.println(msg);
            log.println(msg);
        } catch (ArithmeticException e) {
            String msg = "DIVISION BY ZERO in: \"" + expr + "\"";
            System.out.println(msg);
            log.println(msg);
        }
    }

    /** Wraps Double.parseDouble so empty/blank tokens throw NoSuchElementException */
    private static double parseDouble(String token) {
        if (token.isEmpty()) throw new NoSuchElementException();
        return Double.parseDouble(token); // throws NumberFormatException if invalid
    }

    /** Throws UnsupportedOperationException for anything that isn't +, -, *, / */
    private static void validateOperator(String op) {
        if (!op.equals("+") && !op.equals("-") &&
            !op.equals("*") && !op.equals("/")) {
            throw new UnsupportedOperationException();
        }
    }

    private static double calculate(double a, String op, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default: throw new UnsupportedOperationException();
        }
    }
}
