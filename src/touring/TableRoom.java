package touring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TableRoom {

    @Test
    public void test(){

        String[][] array = {{"1","0","1","1","1"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        assertEquals(9, solution(array));
    }

    @Test
    public void test2(){

        String[][] array = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        assertEquals(6, solution(array));
    }

    @Test
    public void test3(){

        String[][] array = {{"1","0","1","0","0"},{"1","0","0","1","1"},{"1","1","1","1","1"},{"1","0","1","1","1"},{"1","0","1","1","1"}};
        assertEquals(8, solution(array));
    }

    @Test
    public void test4(){

        String[][] array = {{"0","1","1","1","1"},{"0","1","1","1","1"},{"0","0","1","1","1"},{"0","0","1","1","1"},{"0","0","1","1","1"}};
        assertEquals(9, solution(array));
    }

    @Test
    public void test5(){

        String[][] array = {{"0","1","1","1","1"},{"0","1","1","1","1"},{"0","0","1","1","1"},{"0","0","1","1","1"},
                            {"0","0","1","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"}};
        assertEquals(10, solution(array));
    }

    @Test
    public void test6(){

        String[][] array = {{"0","1","1","1","1"},{"0","1","1","1","1"},{"0","0","1","1","1"},{"0","0","1","1","1"},
                {"0","0","1","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},{"0","0","0","1","1"},
                {"0","1","1","1","1"},{"0","1","1","1","1"},{"0","1","1","1","1"}};
        assertEquals(16, solution(array));
    }


    private int solution(String[][] dataues) {
        int res = 0;

        int lastMax = 0;
        int lastCol = 0;
        for(String[] rows:dataues){

            int totalCol = 0;
            for(int i=rows.length-1;i>=0;i--){
                if(!rows[i].equals("0"))
                    totalCol++;
                else
                    break;
            }

            if(lastCol==0)
                lastCol = totalCol;

            if(totalCol >= lastCol)
                lastMax += lastCol;
            else {
                lastMax = totalCol;
                lastCol = totalCol;
            }

            res = Math.max(res,lastMax);

        }

        return res;
    }

}
