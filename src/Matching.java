import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

import static org.junit.Assert.*;


public class Matching {

    @Test
    public void test1(){
        assertTrue(solution("(a[0]+b[2c[6]]){24 + 53}"));
    }

    @Test
    public void test2(){
        assertTrue(solution("f(e(d))"));
    }

    @Test
    public void test3(){
        assertTrue(solution("[()]{([])}"));
    }

    @Test
    public void test4(){
        assertFalse(solution("((b)"));
    }

    @Test
    public void test5(){
        assertFalse(solution("(c]"));
    }

    @Test
    public void test6(){
        assertFalse(solution("{(a[]))}"));
    }

    @Test
    public void test7(){
        assertFalse(solution("([)]"));
    }

    @Test
    public void test8(){
        assertFalse(solution(")("));
    }

    @Test
    public void test9(){
        assertFalse(solution(null));
    }

    private boolean solution(String dataue) {

        if (Objects.isNull(dataue) || dataue.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();

        int len = dataue.length();
        for(int i=0; i<len; i++){
            switch(dataue.charAt(i)){
                case '(' :
                case '[' :
                case '{':
                    stack.push(dataue.charAt(i));
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.peek()!='(') return false;
                    stack.pop();
                    break;
                case ']' :
                    if(stack.isEmpty() || stack.peek()!='[') return false;
                    stack.pop();
                    break;
                case '}' :
                    if(stack.isEmpty() || stack.peek()!='{') return false;
                    stack.pop();
                    break;
            }
        }
        return stack.empty();
    }
}
