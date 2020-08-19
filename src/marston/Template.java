package marston;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class Template {

    @Test
    public void test(){
        printFizzBuzz();
    }

    @Test
    public void test2(){
        assertArrayEquals(new int[]{3},getRareNotes(new int[]{1, 2, 3, 2, 2, 1, 5, 5}));
    }

    @Test
    public void test3(){
        assertTrue(areAnagrams("Kylo Ren","KN Lore Y"));
    }


    void printFizzBuzz() {
        for(int i=1;i<=100;i++){
            String result = "";
            if(i%3 == 0)
                result = "Fizz";

            if(i%5 == 0)
                result = result + "Buzz";

            if (result.isEmpty())
                result = Integer.toString(i);

            System.out.println(result);
        }
    }


    int[] getRareNotes(int[] notes) {
        Map<Integer,Boolean> maps = new HashMap<>();
        List<Integer> backList = new ArrayList<>();
        for(int i:notes){
            if (maps.containsKey(i)){
                maps.remove(i);
                backList.add(i);
            }else{
                if(!backList.contains(i))
                    maps.put(i,true);
            }
        }

        Set<Integer> rares = maps.keySet();

        int [] ints = rares.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    boolean areAnagrams(String word1, String word2) {

        word1 = word1.replace(" ","");
        word2 = word2.replace(" ","");

        char[] w1 = word1.toLowerCase().toCharArray();
        char[] w2 = word2.toLowerCase().toCharArray();

        Arrays.sort(w1);
        Arrays.sort(w2);

        String s1 = new String(w1);
        String s2 = new String(w2);

        return s1.equals(s2);

    }


}
