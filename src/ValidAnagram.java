import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidAnagram {

    @Test
    public void test(){

        assertTrue(solution("anagram","nagaram"));
    }

    @Test
    public void test2(){

        assertFalse(solution("rat","car"));
    }


    private boolean solution2(String s,String t) {

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        s = new String(sChar);
        t = new String(tChar);

        return s.equals(t);
    }

    private boolean solution(String s,String t) {

        int[] chars = new int[26];

        for(char c:s.toCharArray())
            chars[c - 'a']++;

        for(char c:t.toCharArray())
            chars[c - 'a']--;


        for(int count:chars)
            if(count!=0)
                return false;

        return true;

    }

}
