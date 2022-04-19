/* Binary Tree  ---> Hierarchial Data structure
  General Tree---  Root Node (There will be branches from this node) ---->Branch ---->leaf node( No Further Division)
   Binary tree can hav atmax of 2 branches
   one node has two nodes:  left node-- left child  right node - right child ( same parent so they are sibling nodes)
   Ansestors--- Parent ka parent until we reach to the main root
   Question asked in interview-- lowest common ansestors
   Levels the nodes lying on same position 
   Subtree---> There is always a small tree below the root node and it is known as sub tree

   */
  import java.util.*;
public class BinarytreeYT{

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree {
        static int idx = -1;// we need a variable to go on indexes

        public static Node buildTree(int nodes[]) // In this we will pass the Array of data and it will return the root
                                                  // node back
        {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }


    
/*Preorder traversal
1. Root
2. Left Subtree
3. Right Subtree
time complexity big-o (n)
*/
//PREORDER


    public static void preorder(Node root)
    {
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }


    
/*Inorder traversal
1. Left Subtree
2. Root
3. Right Subtree
time complexity big-o (n)
*/
//PREORDER

    public static void inorder(Node root)
    {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    /*postorder traversal
1. Left Subtree
2. Right Subtree
3. Root
time complexity big-o (n)
*/
//postORDER

public static void postorder(Node root)
{
    if(root == null){
        return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data +" ");
}
/* level order traversal
We will store the data of nodes on each level in a queue 
We will use null to perform level traversal
null is used as next line 
BFS--> Bredth first search(We print data of nodes in bredth rather
 than in up to down manner)
 Liner time complexity

*/

public static void levelOrder(Node root) {
 if(root == null)
 {
     return;
 }
    Queue<Node> q =new LinkedList<>();
    q.add(root);
    q.add(null);
    
    while(!q.isEmpty()){
        Node curNode = q.remove();
        if(curNode== null)
        {
            System.out.println();
        if(q.isEmpty())
        {
            break;
        }
        else{
            q.add(null);
        }}
        else{
            System.out.print(curNode.data+" ");
            if(curNode.left != null)
            {
                q.add(curNode.left);
            }
            if(curNode.right != null) {
                q.add(curNode.right);
            }
        }
    }
}


    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Binarytree tree = new Binarytree();
        Node root = tree.buildTree(nodes);
        levelOrder(root);
    }
}
