import java.io.Serializable;

/**
 * Created by matias on 4/19/16.
 */
public class BinarySearchTree <T extends Comparable<T>> implements Serializable {
    private DoubleNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T e) {
        if (!this.contains(e)) {
            root = insert(root,e);
        }
    }

    public void delete(T e) {
        if (this.contains(e))
        root = delete(root,e);
    }

    public T getMin(){
        if (this.isEmpty()){
            throw new RuntimeException("Tree is empty");
        }
        return getMin(root).elem;
    }

    public T getMax(){
        if (this.isEmpty()){
            throw new RuntimeException("Tree is Empty");
        }
        return getMax(root).elem;
    }

    public T search(T e)  {
        if (this.contains(e))
        return search(root,e).elem;
        else throw new RuntimeException("Element not in tree");
    }

    public boolean contains(T e) {
        return contains(root,e);
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public T getRoot(){
        if (!this.isEmpty())
        return root.elem;
        else throw new RuntimeException("Tree is empty");
    }

    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.left;
        return t;
    }

    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.right;
        return t;

    }

    // Private Methods

    private DoubleNode<T> getMax (DoubleNode<T> t) {
        if (t.right == null) {
            return t;
        }
        else return getMax(t.right);
    }

    private DoubleNode<T> getMin(DoubleNode<T> t) {
        if (t.left == null){
            return t;
        }
        else return getMin(t.left);
    }

    private DoubleNode<T> search (DoubleNode<T> t, T x) {
        if (x.compareTo(t.elem) == 0) return t;
        else if (x.compareTo(t.elem) < 0 )
            return search(t.left, x);
        else
            return search(t.right, x);
    }

    private boolean contains (DoubleNode<T> t, T x) {
        if (t == null) return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo(t.elem) < 0)
            return contains(t.left,x);
        else
            return contains(t.right,x);
    }

    private DoubleNode<T> insert (DoubleNode<T> t, T x) {
        if (t == null) {
            t = new DoubleNode<T>();
            t.elem = x;
        }
        else if (x.compareTo(t.elem) < 0)
            t.left = insert(t.left,x);
        else t.right = insert(t.right,x);
        return t;
    }

    private DoubleNode<T> delete(DoubleNode<T> t, T x) {
        if (x.compareTo(t.elem) < 0)
            t.left = delete(t.left,x);
        else if (x.compareTo(t.elem) > 0)
            t.right = delete(t.right,x);
        else
            if (t.left != null && t.right != null) {
                t.elem = getMin(t.right).elem;
                t.right = deleteMin(t.right);
            }
            else if (t.left != null)
                t = t.left;
            else
                t = t.right;
        return t;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t) {
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }





}
