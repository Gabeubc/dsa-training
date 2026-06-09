class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    void remove(Node curr){
        Node prev=curr.prev;
        Node next=curr.next;
        prev.next=next;
        next.prev=prev;
    }
    void insertR(Node r, Node curr){
        Node next=r.next; 
        r.next=curr;
        curr.next=next;
        curr.prev=r;
        next.prev=curr;   
    }
    void insertL(Node l, Node curr){
        Node prev=l.prev; 
        prev.next=curr;
        curr.next=l;
        curr.prev=prev;
        l.prev=curr;
    }
    Map<Integer, Node> cache;
    final int capacity;
    final Node r;
    final Node l;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.r=new Node(0, 0);
        this.l=new Node(0, 0);
        this.r.next=l;
        this.l.prev=r;
    }

    public int get(int key){
        Node node=cache.get(key);
        if(node==null) return -1;
        remove(node);
        insertL(this.l, node);
        return node.val;
    }

    public void put(int key, int value){
        Node node=cache.get(key);
        if(node!=null){
            remove(node);
            node.val=value;
        }else{
            node=new Node(key, value);
            cache.put(key, node);
        }
        insertL(this.l, node);
        if(cache.size()>this.capacity){
            Node lru=this.r.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }


}
