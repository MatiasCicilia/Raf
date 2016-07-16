import java.io.Serializable;

/**
 * Created by Ignacio on 3/30/16.
 */
public class DoubleNode <T> implements Serializable{
    T elem;
    DoubleNode <T> right, left;

    public DoubleNode(){}

    public DoubleNode(T o){
        elem = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        elem = o;
        this.right = right;
        this.left = left;
    }
}
