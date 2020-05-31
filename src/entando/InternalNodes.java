package entando;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class InternalNodes {
    public static int count(int[] tree) {
        Set<Integer> nums = new HashSet<>();
        for(int i:tree)
            if(i!=-1)
                nums.add(i);
         return nums.size();
    }

    @Test
    public void test(){
        assertEquals(2,InternalNodes.count(new int[] { 1, 3, 1, -1, 3 }));
    }

    @Test
    public void test2(){
        assertEquals(3,InternalNodes.count(new int[] { 1, 3, 1, -1, 3 ,4}));
    }
}