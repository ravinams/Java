
/**
 *
 * @author onkar
 */
public class Circular_Queue {

    private Queue_Node front;
    private int size;
    // Construct a circular queue of strings with maximum size 12 
    private static final int MAX_SZIE = 12;
    
    private int totalSize  ;

    /**
     * constructor 
     */
    public Circular_Queue() {
        size = 0;
        front = null;
    }

    /**
     * push item to queue
     * @param val 
     */
    public void enqeue(String val) {
        
        // trival case 
        if (size < MAX_SZIE) {
            
            // make a new node
            Queue_Node qn = new Queue_Node(val, front);
            
            // first time 
            if (front == null) {
                front = qn;
                front.setQueue_Link(front);
            } else { // other time 
                
                // move to the end of the list
                Queue_Node curr = front;
                while (curr.getQueue_Link() != front) {
                    curr = curr.getQueue_Link();
                }
                // set it 
                curr.setQueue_Link(qn);
            }
            size++;
            totalSize = size ;
        } else { // non trival case
            // overwrite the oldest node
            totalSize ++ ;
            int extraCnt = totalSize % MAX_SZIE  ;
            
            // we need to find correct node to replace it 
         
            if (extraCnt == 0 )
                 extraCnt = size ;
             Queue_Node curr = front;
             int i = 1 ;
             while (i < extraCnt)
             {
                  curr = curr.getQueue_Link();
                  i++ ;
             }
           
            System.out.println ("totalSize = "+totalSize + " extraCnt = "+extraCnt + " node = "+curr.getData_Value()) ;
            curr.setData_Value(val);
                                 
        }  
    }

    public String dequeue() throws Exception {
        
        // bad case 
        if (front == null) {
            throw new Exception();
        }
        // get value 
        String val = front.getData_Value();
        
        // check whthere it is going to be empty one
        if (front.getQueue_Link() == front) {
            front = null;
        } else {
            // other case 
            // move the end of the list 
            Queue_Node curr = front;
            while (curr.getQueue_Link() != front) {
                curr = curr.getQueue_Link();
            }
            
            // update the link of the last node 
            front = front.getQueue_Link();
            curr.getQueue_Link().setQueue_Link(null);            
            curr.setQueue_Link(front);              
        }
        size--;
        return val;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String peek(){
        if (front == null) {
            return null;
        }
        // get value 
        String val = front.getData_Value();
        return val;
    }
    
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (front == null) {
            return "";
        }
        
        String str = "";
        Queue_Node curr = front;
        
        do {            
            str += curr.getData_Value() + System.lineSeparator();
            curr = curr.getQueue_Link();
        } while (curr != front);
        
        return str;
                
    }
    
    
}

class Queue_Node {

    protected String data_value;
    protected Queue_Node queue_link;

    public Queue_Node() {
        data_value = null;
        queue_link = null;
    }

    public Queue_Node(String data_value, Queue_Node queue_link) {
        this.data_value = data_value;
        this.queue_link = queue_link;
    }

    public void setQueue_Link(Queue_Node n) {
        queue_link = n;
    }

    public void setData_Value(String d) {
        data_value = d;
    }

    public Queue_Node getQueue_Link() {
        return queue_link;
    }

    public String getData_Value() {
        return data_value;
    }
}
