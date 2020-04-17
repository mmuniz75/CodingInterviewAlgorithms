import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;


public class AddTwoNumber {

    @Test
    public void test(){
        //2 , 4 ,3
        ListNode n3 = new ListNode(3,null);
        ListNode n4 = new ListNode(4,n3);
        ListNode l1 = new ListNode(2,n4);

        //5,6,4
        ListNode n4_2 = new ListNode(4,null);
        ListNode n6 = new ListNode(6,n4_2);
        ListNode l2 = new ListNode(5,n6);

        assertArrayEquals(new Integer[]{7,0,8} , convert(solution(l1,l2)));
      }

    @Test
    public void test2(){
        //7,5,8,0
        ListNode n0 = new ListNode(0,null);
        ListNode n8 = new ListNode(8,n0);
        ListNode n5 = new ListNode(5,n8);
        ListNode l1 = new ListNode(7,n5);

        //6,9,2,3
        ListNode n3 = new ListNode(3,null);
        ListNode n2 = new ListNode(2,n3);
        ListNode n9 = new ListNode(9,n2);
        ListNode l2 = new ListNode(6,n9);

        assertArrayEquals(new Integer[]{3,5,1,4} , convert(solution(l1,l2)));
    }

    private ListNode solution(ListNode l1, ListNode l2) {
        int sum = l1.data + l2.data;

        if(sum>=10) {
            l1.next.data++;
            sum = sum%10;
        }

        ListNode node = new ListNode(sum, Objects.nonNull(l1.next)?this.solution(l1.next,l2.next):null);
        return node;
    }

    class ListNode {
        int data;
        ListNode next;
        ListNode(int x,ListNode next){
            this.data = x;
            this.next = next;
        }
    }

    private Integer[] convert(ListNode node){
        List<Integer> dataues = new ArrayList<>();
        dataues.add(node.data);

        while(Objects.nonNull(node.next)) {
            node = node.next;
            dataues.add(node.data);
        }

        return dataues.toArray(new Integer[dataues.size()]);

    }



}
