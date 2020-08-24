package stack.user;

public class Node {

    private int data;
    private Node nextNode;

    public Node(int data){
        this.data = data;
        this.nextNode = null;
    }

    public void linkNode(Node node){
        this.nextNode = node;
    }

    public int getData(){
        return this.data;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

}
