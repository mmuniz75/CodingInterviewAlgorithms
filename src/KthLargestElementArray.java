import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class KthLargestElementArray {

    @Test
    public void test(){
        assertEquals(5,solution(new int[]{3,2,1,5,6,4},2));
    }

    @Test
    public void test2(){
        assertEquals(6,solution(new int[]{3,2,1,5,6,4},1));
    }

    @Test
    public void test3(){
        assertEquals(4,solution(new int[]{3,2,1,5,6,4},3));
    }



    private int solution(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length-k];
    }

}
