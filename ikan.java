class node{
    int data;
    node next;
    node(int data){
        this.data=data;
        this.next=null;
    }
}

class linkedlist{
    node head;
    linkedlist(){
        this.head=null;
    }
}

class ikan{
    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        ll.head=new node(1);
        ll.head.next=new node(2);
        ll.head.next.next=new node(3);
        ll.head.next.next.next=new node(4);
        ll.head.next.next.next.next=new node(5);
        ll.head.next.next.next.next.next=new node(6);
        ll.head.next.next.next.next.next.next=new node(7);
        ll.head.next.next.next.next.next.next.next=new node(8);
        ll.head.next.next.next.next.next.next.next.next=new node(9);
        ll.head.next.next.next.next.next.next.next.next.next=new node(10);
        ll.head.next.next.next.next.next.next.next.next.next.next=new node(11);
        ll.head.next.next.next.next.next.next.next.next.next.next.next=new node(12);
        ll.head.next.next.next.next.next.next.next.next.next.next.next.next=new node(13);
        ll.head.next.next.next.next.next.next.next.next.next.next.next.next.next=new node(14);
        ll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new node(15);
    }
}