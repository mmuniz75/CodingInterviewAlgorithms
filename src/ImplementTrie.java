import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ImplementTrie {

    @Test
    public void test(){

        Trie obj = new Trie();
        obj.insert("word");

        assertTrue(obj.search("word"));
    }

    @Test
    public void test2(){

        Trie obj = new Trie();
        obj.insert("word");

        assertTrue(obj.startWith("wo"));
    }

    @Test
    public void test3(){
        Trie obj = new Trie();
        obj.insert("casa");
        assertFalse(obj.search("cama"));
    }

    @Test
    public void test4(){
        Trie obj = new Trie();
        obj.insert("casa");
        obj.insert("coma");


        assertFalse(obj.search("cama"));
    }




    class Trie {

        class Node {
            char val;
            boolean isWord;
            Node[] children = new Node[26];

            Node(char val){
                this.val = val;
            }
        }

        Node values;

        public Trie(){
            values = new Node(' ');
        }

        public void insert(String word) {

            Node current = values;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);

                if(current.children[c - 'a'] == null)
                    current.children[c - 'a'] = new Node(c);

                current = current.children[c - 'a'];

            }
            current.isWord = true;

        }

        public boolean search(String word){
            Node current = values;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);

                if(current.children[c - 'a'] == null)
                    return false;

                current = current.children[c - 'a'];

            }

            return current.isWord;
        }

        public boolean startWith(String word){

            Node current = values;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);

                if(current.children[c - 'a'] == null)
                    return false;

                current = current.children[c - 'a'];

            }

            return true;
        }

    }



}
