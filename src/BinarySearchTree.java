import org.junit.Test;

import java.util.Objects;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;


public class BinarySearchTree {

    @Test
    public void test(){

        TreeNode two = null;
        TreeNode one = null;
        TreeNode three = new TreeNode(3,null,null);
        one = new TreeNode(1,null,null);
        two = new TreeNode(2,one,three);

        assertTrue(solution(two));
    }

    @Test
    public void test2(){

        TreeNode two = null;
        TreeNode one = null;
        TreeNode three = new TreeNode(3,two,null);
        two = new TreeNode(2,null,one);
        one = new TreeNode(1,two,three);

        assertFalse(solution(one));
    }


    @Test
    public void test3(){
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node5=new TreeNode(5);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node10;

        node20.left=node60;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        node10.left=node5;
        node50.right=node55;

        assertFalse(solution(rootNode));
    }

    @Test
    public void test4(){

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node5=new TreeNode(5);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        node10.left=node5;
        node50.right=node55;

        assertTrue(solution(rootNode));
    }

    @Test
    public void test5(){
        TreeNode rootNode =new TreeNode(3);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);

        rootNode.left=node2;
        rootNode.right=node6;

        node2.left=node1;
        node2.right=node4;

        node6.left=node5;
        node6.right=node7;

        assertFalse(solution(rootNode));
    }


    private int prev = Integer.MIN_VALUE;
    private boolean solution(TreeNode root){

        if(root == null)
            return true;

        if(!solution(root.left))
            return false;

        if(root.data < prev)
            return false;

        prev = root.data;

        return solution(root.right);
    }


    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data, TreeNode left, TreeNode right){
            this.left = left;
            this.right = right;
            this.data = data;
        }

        TreeNode(int data){
            this.data = data;
        }
    }


}
