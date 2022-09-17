// Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
// http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181 Вычислить запись если это возможно.
package HomeWork4;

import java.util.*;

public class RPNCalculator {
    public static void main(String[] args) {
        String[] testInput = {"(1+2)*4+3", "1+2*3", "(1+2)*3","1-2*38", "(8*(6+3)/(12-9.8))*3.5", "(1+2+1)*3", "(1+2+1*3", "1+2*+3"};
        for(String eval: testInput) {
            String postfixEval = InfixNotationToPrefixNotation(eval);
            String result;
            try {
                result = String.format("%f", CalculatePostfixEval(postfixEval));
            }
            catch (Exception ex) {
                result="Ошибка вычислений";
            }

            System.out.printf("%s -> %s -> %s\n", eval, postfixEval, result);
        }
    }

    public static String InfixNotationToPrefixNotation(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        Set<Character> operators =Set.of('(', ')', '+', '-', '*', '/');
        int i = 0;
        while(i<sb.length()) {
            if(operators.contains(sb.charAt(i))) {
                sb.insert(i++, ' ');
                sb.insert(++i, ' ');
            }
            i++;
        }

        String[] tokens = sb.toString().split(" ");
        Map<String, Integer> operatorsPriority = Map.of("+", 1, "-", 1, "*", 2, "/", 2);
        List<String> outputSequence = new ArrayList<>(tokens.length);
        Deque<String> stack = new LinkedList<>();
        for(String token: tokens) {
            if(token.equals(""))
                continue;
            if(token.equals("("))
                stack.push(token);
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                    outputSequence.add(stack.pop());
                if(!stack.isEmpty())
                    stack.pop();
            } else if (operatorsPriority.containsKey(token)) {
                while(!stack.isEmpty() &&
                        operatorsPriority.containsKey(stack.peek()) &&
                        operatorsPriority.get(stack.peek()) >= operatorsPriority.get(token))
                    outputSequence.add(stack.pop());
                stack.push(token);
            }
            else
                outputSequence.add(token);
        }

        while(!stack.isEmpty())
            outputSequence.add(stack.pop());

        return String.join(" ", outputSequence);
    }

    public static double CalculatePostfixEval(String postfixEval) {
        Deque<Object> stack = new LinkedList<>();
        String[] tokens = postfixEval.split(" ");
        for(String token: tokens) {
            switch (token) {
                case "+": {
                    double operand2 = (Double) stack.pop();
                    double operand1 = (Double) stack.pop();
                    stack.push(operand1 + operand2);
                    break;
                }
                case "-": {
                    double operand2 = (Double) stack.pop();
                    double operand1 = (Double) stack.pop();
                    stack.push(operand1 - operand2);
                    break;
                }
                case "/": {
                    double operand2 = (Double) stack.pop();
                    double operand1 = (Double) stack.pop();
                    stack.push(operand1 / operand2);
                    break;
                }
                case "*": {
                    double operand2 = (Double) stack.pop();
                    double operand1 = (Double) stack.pop();
                    stack.push(operand1 * operand2);
                    break;
                }
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }
        if(stack.size()==1 && stack.peek() instanceof Double)
            return (Double)stack.pop();
        else
            throw new IllegalArgumentException();
    }
}
