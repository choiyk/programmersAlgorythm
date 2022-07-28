import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Maraton {

    int bucketSize;
    List<Entry>[] bucket;

    public String solution(String[] participant, String[] completion) {
        bucketSize = (completion.length / 5)+1;
        bucket = new List[bucketSize];

        for (int i = 0; i < completion.length; i++) {
            Entry entry = get(completion[i]);
            entry.value += 1;
        }

        for (int i = 0; i < participant.length; i++) {
            Entry entry = get(participant[i]);
            if (entry != null && entry.value > 0) {
                entry.value -= 1;
            } else {
                return entry.key;
            }
        }
        throw new RuntimeException("error");
    }

    private Entry get(String s) {
        int idx = hash(s);
        List<Entry> list = bucket[idx];
        if (list == null) {
            list = new List<Entry>();
            Entry entry = new Entry(s, 0);
            list.add(entry);
            bucket[idx] = list;
            return entry;
        } else {
            Entry entry = list.get(s);
            if (entry == null) {
                entry = new Entry(s, 0);
                list.add(entry);
            }
            return entry;
        }
    }


    private int hash(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            num += s.codePointAt(i) * 31 + s.codePointAt(i);
        }
        return num % bucketSize;
    }

    class Entry {
        String key;
        int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class List<T extends Entry> {
        Node head;

        public void add(T entry) {
            Node nn = new Node(entry, null);

            if (head == null) {
                head = nn;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = nn;
            }
        }

        public <T extends Entry> T get(String s) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(s)) {
                    return (T) node.data;
                }
                node = node.next;
            }

            return null;
        }

        class Node<T extends Entry> {
            T data;
            Node next;

            public Node(T data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
    }

    public static String solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String name : participant){
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }
        for(String name : completion){
            hashMap.put(name, hashMap.get(name) - 1);
        }

        String answer = "";
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) == 1){
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        Maraton m = new Maraton();
        System.out.println(m.solution(participant, completion));
    }
}
