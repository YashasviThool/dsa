package struckture;

import java.util.*;

public class huffmanCode {
    HashMap<Character, String> encoder = new HashMap<>();
    HashMap<String, Character> decoder = new HashMap<>();

    private class Node implements Comparable<Node> {
        Character data;
        int cost; // frequncy
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public huffmanCode(String feeder) throws Exception {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            if (fmap.containsKey(cc)) {
                fmap.put(cc, fmap.get(cc) + 1);
            } else {
                fmap.put(cc, 1);
            }
        }

        heap<Node> minHeap = new heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node(null, first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.insert(newNode);

        }
        Node ft =minHeap.remove();
        this.encoder =new HashMap<>();
        this.decoder =new HashMap<>();
        this.initEncoderDecoder(ft,"");
    }

    private void initEncoderDecoder(Node node, String osf) {
        if(node==null){
            return ;
        }
        if(node.left==null && node.right==null){
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);

        }
        initEncoderDecoder(node.left, osf+"0");
        initEncoderDecoder(node.right, osf+"1");

    }
    public String encode(String src){
        String ans="";
        for(int i=0;i<src.length();i++){
            ans=ans+this.encoder.get(src.charAt(i));
        }
        return ans;
    }
    public String decoder(String src){
        String ans="";
        String key="";
        for(int i=0;i<src.length();i++){
            key= key+ src.charAt(i);
            if(this.decoder.containsKey(key)){
                ans=ans+this.decoder.get(key);
                key="";
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        String a="a abac aafds ";
        huffmanCode hf=new huffmanCode(a);
        String cs=hf.encode(a);
        System.out.println(cs);
        String out=hf.decoder(cs);
        System.out.println(out);

    }

}
