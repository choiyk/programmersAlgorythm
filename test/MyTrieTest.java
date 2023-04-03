import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTrieTest {

    @Test
    public void 테스트() {
        MyTrie trie = new MyTrie();

        trie.insert("cap");
        trie.insert("code");

        assertEquals(true, trie.search("code"));
        assertEquals(true, trie.search("cap"));
        assertEquals(false, trie.search("kakao"));
        assertEquals(false, trie.search("cop"));
    }

}