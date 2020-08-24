package stack.user;

public class UserStack {

    Node top;

    public UserStack(){
        this.top = null;
    }

    public void push(int data){
        Node node = new Node(data);
        node.linkNode(top);
        top = node;
    }

    public int peek(){
        return top.getData();
    }

    public void pop(){
        if(empty())
            throw new ArrayIndexOutOfBoundsException();
        else{
            top = top.getNextNode();
        }
    }

    public int search(int item){
        Node searchNode = top;
        int index = 1;

        while(true){

            if (searchNode.getData() == item){
                return index;
            }else{
                searchNode = searchNode.getNextNode();
                index++;
                if (searchNode == null)
                    break;
            }
        }
        return -1;
    }

    public boolean empty(){
        return top == null;
    }

}
