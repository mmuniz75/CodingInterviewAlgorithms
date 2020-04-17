import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SymmetricTree {

    @Test
    public void test1(){
        TreeNode rootNode =new TreeNode(1);
        TreeNode nodeL2=new TreeNode(2);
        TreeNode nodeR2=new TreeNode(2);
        TreeNode nodeL3=new TreeNode(3);
        TreeNode nodeR3=new TreeNode(3);
        TreeNode nodeL4=new TreeNode(4);
        TreeNode nodeR4=new TreeNode(4);
        rootNode.left=nodeL2;
        rootNode.right=nodeR2;
        nodeL2.left=nodeL3;
        nodeL2.right=nodeL4;
        nodeR2.left=nodeR4;
        nodeR2.right=nodeR3;
        assertTrue(solution(rootNode));
    }

    @Test
    public void test3(){
        TreeNode rootNode =new TreeNode(1);
        TreeNode nodeL2=new TreeNode(2);
        TreeNode nodeR2=new TreeNode(5);
        TreeNode nodeL3=new TreeNode(3);
        TreeNode nodeR3=new TreeNode(3);
        TreeNode nodeL4=new TreeNode(4);
        TreeNode nodeR4=new TreeNode(4);
        rootNode.left=nodeL2;
        rootNode.right=nodeR2;
        nodeL2.left=nodeL3;
        nodeL2.right=nodeL4;
        nodeR2.left=nodeR4;
        nodeR2.right=nodeR3;
        assertFalse(solution(rootNode));
    }


    @Test
    public void test2(){
        TreeNode rootNode =new TreeNode(1);
        TreeNode nodeL2=new TreeNode(2);
        TreeNode nodeR2=new TreeNode(2);
        TreeNode nodeL3=new TreeNode(3);
        TreeNode nodeR3=new TreeNode(3);
        rootNode.left=nodeL2;
        rootNode.right=nodeR2;
        nodeL2.right=nodeL3;
        nodeR2.right=nodeR3;
        assertFalse(solution(rootNode));
    }


    private boolean solution(TreeNode root) {

        if(Objects.isNull(root))
            return true;

        return sameTree(root.left, root.right);
    }

    private boolean sameTree(TreeNode t1, TreeNode t2){

        if(Objects.isNull(t1) && Objects.isNull(t2))
            return true;

        if(Objects.isNull(t1) || Objects.isNull(t2))
            return false;

        if(t1.data == t2.data)
            return sameTree(t1.left,t2.right)
                    && sameTree(t1.right,t2.left);

        return false;

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
