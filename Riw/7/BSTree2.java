public class BSTree2 extends BTreePrinter{
    Node root;
    
    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key){
        Node curr = root;
        while (curr != null) {
            if (curr.key == search_key) return curr;
            else if (search_key < curr.key) curr = curr.left;
            else if (search_key >= curr.key) curr = curr.right;
        }
        
        return curr;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin(){
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr; // Fix this
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax(){
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr; // Fix this
    }
    
    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
        if (root == null) root = new Node(key);
        else {
            Node curr = root;
            
            while (curr != null) {
                if (curr.left == null && curr.right == null) break;
                if (key < curr.key) {
                    if (curr.left == null) break;
                    else curr = curr.left;
                }
                else {
                    if (curr.right == null) break;
                    else curr = curr.right;
                }
            }
            
            if (key < curr.key) {
                Node temp = new Node(key);
                curr.left = temp;
                temp.parent = curr;
            }
            else {
                Node temp = new Node(key);
                curr.right = temp;
                temp.parent = curr;
            }
        }
        
    }

    public long height() {
        return height(root);
    }
    // Use this function to check the node height
    // This function is complete, no need to edit
    public static long height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    
    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
}