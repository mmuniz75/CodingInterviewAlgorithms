import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;


public class TwoSum {

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        assertArrayEquals(new int[]{0,1},solution(nums,9));
    }

    @Test
    public void test2(){
        int[] nums = {4,5,3,2,1,6,7};
        assertArrayEquals(new int[]{1,6},solution(nums,12));
    }

    private int[] solution2(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
                if(nums[j]+nums[i]==target)
                    return new int[]{i,j};
        }

        return new int[]{};
    }

    private int[] solution(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            Integer data = map.get(target-nums[i]);

            if(Objects.isNull(data))
                map.put(nums[i],i);
            else{
                result[0] = data;
                result[1] = i;
                break;
            }

        }

        return result;
    }
}
