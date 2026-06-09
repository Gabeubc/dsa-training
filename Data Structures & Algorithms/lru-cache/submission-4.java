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
    void insertHead(Node head, Node curr){
        Node next=head.next; 
        head.next=curr;
        curr.next=next;
        curr.prev=head;
        next.prev=curr;   
    }
    void insertTail(Node tail, Node curr){
        Node prev=tail.prev; 
        prev.next=curr;
        curr.next=tail;
        curr.prev=prev;
        tail.prev=curr;
    }
    Map<Integer, Node> cache;
    final int capacity;
    final Node head;
    final Node tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(0, 0);
        this.tail=new Node(0, 0);
        this.head.next=tail;
        this.tail.prev=head;
    }

    public int get(int key){
        Node node=cache.get(key);
        if(node==null) return -1;
        remove(node);
        insertTail(this.tail, node);
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
            if(cache.size()>this.capacity){
                Node lru=this.head.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
        insertTail(this.tail, node);
    }


}
