package statistics.matcher;

import java.util.Stack;

public class QueryBuilder {

    private Stack<Matcher> stack;

    public QueryBuilder() {
        stack = new Stack();
    }

    public QueryBuilder playsIn(String team) {
        stack.push(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        stack.push(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        stack.push(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        stack.push(new Or(m1, m2));
        return this;
    }

    public Matcher build() {
        if (stack.size() == 1) {
            return stack.pop();
        }
                
        Matcher m = null;
        while (!stack.empty()) {
            if (m != null) {
                stack.push(m);
            }
            m = new And(stack.pop(), stack.pop());
        }
        return m;
    }
}
