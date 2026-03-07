class MyLinkedList {
    private static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;
    int currentSize = 0;
    
    public int get(int index) {
        if(index<0 || index>=currentSize){
            return -1;
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next= head;
        head = newNode; 
        if(currentSize==0){
            tail=head;
        }
        currentSize++;
    }
    
    public void addAtTail(int val) {
        if(currentSize==0){
           addAtHead(val);
        }
        else{
        tail.next = new Node(val);
        tail = tail.next;
        currentSize++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>currentSize){
            return;
        }
        else if(index==0){
            addAtHead(val);
        }
        else if(index==currentSize){
            addAtTail(val);
        }
        else{
            Node newNode = new Node(val);
            Node prevNode = getNodeAtIndex(index-1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            currentSize++;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=currentSize){
            return;
        }
        else if(currentSize==1){
            head = null;
            tail = null;
        }
        else if(index==0){
            head = head.next;
        }
        else if(index == currentSize-1){
          Node prevNode = getNodeAtIndex(index-1);
          prevNode.next = null;
          tail=prevNode;
        }
        else{
            Node prevNode = getNodeAtIndex(index-1);
            prevNode.next = prevNode.next.next;
        }
        //if(currentSize>0){
        currentSize--;
        //}
    }

    public Node getNodeAtIndex(int index){
        if(index<0 || index>=currentSize){
            return null;
        }

        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */