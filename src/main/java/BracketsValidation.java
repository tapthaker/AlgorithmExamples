import java.util.ArrayList;

/**
 * Created by Tapan on 9/3/2017.
 */
public class BracketsValidation {

    class Stack {
        private ArrayList<Character> arrayList;

        public Stack() {
            this.arrayList = new ArrayList<Character>();
        }

        void push(Character c) {
            arrayList.add(c);
        }

        Character pop() {
            if (arrayList.size() == 0) {
                return null;
            }
            Character c = arrayList.remove(arrayList.size() - 1);
            return c;
        }

        Character getTop() {
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList.get(arrayList.size() - 1);
        }
    }

    boolean validate(String expression) {
        Stack stack = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            Character top = stack.getTop();
            switch (expression.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    stack.push(expression.charAt(i));
                    break;
                case '}':
                    if (top == null) {
                        return false;
                    } else if (top == '{')  {
                        stack.pop();
                    } else {
                        stack.push(expression.charAt(i));
                    }
                    break;
                case ']':
                    if (top == null) {
                        return false;
                    } else if (top == '[')  {
                        stack.pop();
                    } else {
                        stack.push(expression.charAt(i));
                    }
                    break;
                case ')':
                    if (top == null) {
                        return false;
                    } else if (top == '(')  {
                        stack.pop();
                    } else {
                        stack.push(expression.charAt(i));
                    }
                    break;
            }
        }
        return stack.pop() == null;
    }


}
