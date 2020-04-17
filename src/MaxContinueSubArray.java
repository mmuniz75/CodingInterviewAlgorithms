import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MaxContinueSubArray {

    @Test
    public void test(){
        assertEquals(6,(solution(new int[]{-2,-3,4,-1,2,1,-5,4})));
    }

    private int solution(int[] values) {

        int result = values[0];
        int max = result;

        for(int i=1;i<values.length;i++) {
            result = Math.max(values[i], result + values[i]);
            max = Math.max(max,result);
        }

        return max;
    }

}
