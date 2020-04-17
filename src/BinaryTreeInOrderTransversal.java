import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class BinaryTreeInOrderTransversal {

    @Test
    public void test(){

        TreeNote three = new TreeNote(3,null,null);
        TreeNote two = new TreeNote(2,three,null);
        TreeNote one = new TreeNote(1,null,two);

        assertArrayEquals(new Integer[]{1,3,2},solution2(one).toArray());
      }


    List<Integer> result = null;
    private List<Integer> solution(TreeNote root) {

        result = new ArrayList();

        this.addInorder(root);

        return result;

    }


    private List<Integer> solution2(TreeNote node){
        List<Integer> result = new ArrayList();
        Stack<TreeNote> stack = new Stack<>();

        while(!stack.isEmpty() || Objects.nonNull(node)) {

            if(Objects.nonNull(node)){
                stack.push(node);
                node = node.left;
                continue;
            }

            node = stack.pop();
            result.add(node.data);

            node = node.right;
        }

        return result;
    }

    void addInorder(TreeNote node)
    {
        if (node == null)
            return;
        addInorder(node.left);

        result.add(node.data);

        addInorder(node.right);
    }

    class TreeNote {
        int data;
        TreeNote left;
        TreeNote right;

        TreeNote(int data,TreeNote left,TreeNote right){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }


}
