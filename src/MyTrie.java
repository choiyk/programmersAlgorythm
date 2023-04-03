import java.util.HashMap;
import java.util.Map;

public class MyTrie {

    private Node root;

    public MyTrie() {
        root = new Node();
    }

    public void insert(String str) {
        Node node = root;

        for(Character key : str.toCharArray()) {
            node = node.childNode.computeIfAbsent(key, c -> new Node());
        }

        node.endOfWord = true;
    }

    public boolean search(String str) {
        Node node = root;

        for(Character key : str.toCharArray()) {
            node = node.childNode.get(key);

            if(node == null)
                return false;
        }

        return node.endOfWord;
    }

    class Node {
        private Map<Character, Node> childNode = new HashMap<>();
        private boolean endOfWord;
    }
}
