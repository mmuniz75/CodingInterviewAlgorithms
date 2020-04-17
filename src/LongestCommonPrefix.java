import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class LongestCommonPrefix {

    @Test
    public void test(){

        assertEquals("a",solution(new String[]{"abcdefgh", "aefghijk", "abcefgh"}));
    }

    @Test
    public void test2(){

        assertEquals("abc",solution(new String[]{"abcdefgh", "abcefgh"}));
    }

    @Test
    public void test3(){

        assertEquals("ab",solution(new String[]{"abab", "ab", "abcd"}));
    }

    @Test
    public void test4(){

        assertEquals("ab",solution(new String[]{"abxcvxcvxcvxcvabab", "ab", "abc1121","abcd"}));
    }


    private String solution2(String strings[]) {

        StringBuilder result = new StringBuilder();
        Arrays.sort(strings);

        char[] a = strings[0].toCharArray();
        char[] b = strings[strings.length-1].toCharArray();

        for(int i=0;i<a.length;i++){

            if(b.length>i && a[i] == b[i])
                result.append(b[i]);
            else
                return result.toString();

        }
        return result.toString();

    }

    private String solution(String strings[]) {

        StringBuilder result = new StringBuilder();
        Arrays.sort(strings);

        char[] a = strings[0].toCharArray();
        char[] b = strings[strings.length-1].toCharArray();

        for(int i=0;i<a.length;i++){

            if(a[i] == b[i])
                result.append(b[i]);
            else
                return result.toString();

        }
        return result.toString();

    }



}
