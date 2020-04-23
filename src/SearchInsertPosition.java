import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SearchInsertPosition {

    @Test
    public void test(){
        assertEquals(2,solution(new int[]{1,3,5,6},5));
    }

    @Test
    public void test2(){
        assertEquals(1,solution(new int[]{1,3,5,6},2));
    }

    @Test
    public void test3(){
        assertEquals(4,solution(new int[]{1,3,5,6},7));
    }

    @Test
    public void test4(){
        assertEquals(0,solution(new int[]{1,3,5,6},0));
    }


    private int solution2(int[] values, int target) {
        int result = 0;
        for(int i=0;i<values.length;i++){
            result = i;
            if(values[i] >= target)
                break;
        }
        return result==values.length-1?values.length:result;
    }

    private int solution(int[] values, int target) {

        int low = 0;
        int high = values.length-1;

        while(low <= high){

            int mid = (low + high) / 2;
            if(values[mid] == target)
                return mid;

            if(values[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;

        }

        return low;

    }

}
