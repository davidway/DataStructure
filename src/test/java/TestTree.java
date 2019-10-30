import java.util.LinkedList;
import java.util.Queue;

public class TestTree {

    @Test
    public void testNode(){
        Node n = new Node();
    }

    class  Tree{
        int data;
        Tree leftNode;
        Tree rightNode;
        int index=0;
        Tree[] node = new Tree[1000];

        public int newNode(int v){
            node[index].data = v;
            node[index].leftNode = null;
            node[index].rightNode = null;
            return index++;
        }
    }
    class Node{
        int data;
        int layer;//层次
        Node leftNode;
        Node rightNode;

        public Node createNode(int v){
            Node n = new Node();
            n.data = v;
            n.leftNode = n.rightNode = null;
            return n;
        }

        public  void search(Node root ,int x, int data){
            if ( root ==null){
                return ;
            }
            //
            if (root.data ==x){
                root.data = data;
            }
            search(root.leftNode , x,data);
            search(root.rightNode , x,data);

        }
        public void insert(Node root,int x){
            if ( root==null){
                root = createNode(x);
                return ;
            }
            insert(root.leftNode,x);

        }
        Node create(int[] data ,int n){
            Node root = null;
            for ( int i=0 ; i<n ; i++){
                insert(root,data[i]);
            }
        }

        void preorder(Node root){
            if ( root==null){
                return ;
            }
            System.out.format("%d\n",root.data);
            preorder(root.leftNode);
            preorder(root.rightNode);
        }

        void inorder(Node root){
            if ( root==null){
                return ;
            }
            inorder(root.leftNode);
            System.out.format("%d\n",root.data);
            inorder(root.rightNode);
        }
        void layerOrder(Node root){
            Queue<Node> q = new LinkedList<>();

            root.layer=1;//根节点的层号是1
            q.add(root);
            while ( q.size()>0){
                Node now = q.poll();
                System.out.format("%d\n",now.data);
                if ( now.leftNode!=null){
                    q.add(now.leftNode);
                }
                if ( now.rightNode!=null){
                    q.add(now.rightNode);
                }
            }
        }

        void postOrder(Node root){
            if ( root==null){
                return ;
            }
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.format("%d\n",root.data);

        }
    }


}
