import junit.framework.TestCase;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertTrue;


public class RecoberyBinarySearchTree {

    @Test
    public void test4(){

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(70);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(20);
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

        solution(rootNode);
        assertTrue(checkBinarySearchTree(rootNode));
    }


    private int prev = Integer.MIN_VALUE;
    private boolean checkBinarySearchTree(TreeNode root){

        if(root==null)
            return true;

        if(!checkBinarySearchTree((root.left)))
            return false;

        if(root.data < prev)
            return false;

        prev = root.data;

        return checkBinarySearchTree(root.right);

    }

    private TreeNode prevNode;
    private TreeNode wrongNode;
    private boolean complete = false;

    private void solution(TreeNode root) {

        if(root==null || complete)
            return;

        solution(root.left);

        if(Objects.nonNull(prevNode) && root.data < prevNode.data && Objects.isNull(wrongNode))
            wrongNode = prevNode;
        else if (Objects.nonNull(prevNode) && root.data < prevNode.data && Objects.nonNull(wrongNode)){
            int temp = root.data;
            root.data = wrongNode.data;
            wrongNode.data = temp;
            complete = true;
            return;
        }

        prevNode = root;

        solution(root.right);
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
