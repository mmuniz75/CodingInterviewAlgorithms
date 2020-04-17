import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class CloneGraph {

    @Test
    public void test(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        assertTrue(node.equals(clone));
    }


    @Test
    public void testX(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);

        System.out.println(node.neighbors.get(0).neighbors.get(0).neighbors.get(0).label);
        node.neighbors.get(0).neighbors.get(0).neighbors.get(0).label = 3;

        int clonelabel = clone.neighbors.get(0).neighbors.get(0).neighbors.get(0).label;

        assertEquals(2,clonelabel);
    }

    @Test
    public void test2(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        node.label = 3;
        assertFalse(node.equals(clone));
    }

    @Test
    public void test3(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        node.neighbors.get(0).label = 3;
        assertFalse(node.equals(clone));
    }

    @Test
    public void test4(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        node.neighbors.get(0).neighbors.remove(0);
        assertFalse(node.equals(clone));
    }

    @Test
    public void test5(){
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        node.neighbors.get(0).neighbors.get(0).neighbors.get(0).label = 3;
        assertFalse(node.equals(clone));
    }

    @Test
    public void test6(){
        UnidirectedGraphnode node3 = new UnidirectedGraphnode(3);
        UnidirectedGraphnode node = build();
        UnidirectedGraphnode clone = solution(node);
        node.neighbors.get(0).neighbors.get(0).neighbors.get(0).add(node3);;
        assertFalse(node.equals(clone));
    }

    private UnidirectedGraphnode build(){
        UnidirectedGraphnode node0 = new UnidirectedGraphnode(0);
        UnidirectedGraphnode node1 = new UnidirectedGraphnode(1);
        UnidirectedGraphnode node2 = new UnidirectedGraphnode(2);

        node0.add(node1);
        node0.add(node2);

        node1.add(node2);

        node2.add(node2);

        return node0;
    }


    private Map<Integer,UnidirectedGraphnode> clones = new HashMap<>();
    private UnidirectedGraphnode solution(UnidirectedGraphnode root) {

        if(clones.containsKey(root.label))
            return clones.get(root.label);

        UnidirectedGraphnode clone = new UnidirectedGraphnode(root.label);

        clones.put(root.label,clone);

        for(UnidirectedGraphnode child:root.neighbors)
            clone.add(solution(child));

        return clone;
    }

    class UnidirectedGraphnode {
        int label;
        List<UnidirectedGraphnode> neighbors;

        public UnidirectedGraphnode(int x){
            this.label = x;
            neighbors = new ArrayList<>();
        }

        void add(UnidirectedGraphnode neighbor){
            this.neighbors.add(neighbor);

        }

        private Set<Integer> testeds = new HashSet<>();
        private boolean _equals(UnidirectedGraphnode node){

            if(testeds.contains(node.label))
                return true;
            else
                testeds.add(node.label);

            if(this.label!= node.label)
                return false;

            if(this.neighbors.size()!= node.neighbors.size())
                return false;

            for(int i=0;i<this.neighbors.size();i++) {

                boolean check = neighbors.get(0)._equals(node.neighbors.get(0));
                if(!check)
                    return false;
            }

            return true;
        }

        boolean equals(UnidirectedGraphnode node){
            boolean check = _equals(node);
            return check;
        }


    }

}
