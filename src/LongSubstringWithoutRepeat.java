import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class LongSubstringWithoutRepeat {

    @Test
    public void test(){
        assertEquals(3,solution("abcabcbb"));
    }

    @Test
    public void test2(){
        assertEquals(1,solution("bbbbbb"));
    }


    @Test
    public void test3(){
        assertEquals(6,solution("pwwkewspr"));
    }

    @Test
    public void test4(){
        assertEquals(9,solution("12345617891"));
    }

    @Test
    public void test5(){
        assertEquals(10,solution("qwertyuizxzxzxzx"));
    }

    @Test
    public void test6(){
        assertEquals(3,solution("abababcabab"));
    }

    private int solution(String string) {

        int max = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int j = 0;
        for(int i=0; i<string.length();++i){
            char c = string.charAt(i);
            if(map.containsKey(c)) {
                int temp = map.get(c) + 1;
                j = Math.max(j, temp );
            }
            map.put(c,i);
            max = Math.max(max, i-j +1);
        }


        return max;
    }


    private int solution2(final String string) {
        int max = 0;
        char[] chars = string.toCharArray();
        String strings = "";

        for(char c:chars){
            if(strings.contains(Character.toString(c))) {
                max = Math.max(max,strings.length());
                strings = "";
            }
            strings = strings + c;
        }

        max = Math.max(max,strings.length());

        return max;
    }
}
