import java.util.*;
class Node
{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left =right =null;
    }
}
class TopViewOfBinaryTree{
    static class Pair{
        Node node;
        int hd;//horizontal distance
        Pair(Node node,int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;

        Queue<Pair> q=new LinkedList<>();// queue which takes pair
        Map<Integer,Integer> map=new TreeMap<>();

        q.add(new Pair(root,0));
        while(!q.isEmpty()){// if queue is not empty
            Pair it=q.remove();// first remove the element ans store in it
            int hd=it.hd;// retrive hd
            Node temp=it.node;// retrive node
            if(!map.containsKey(hd)){// if the mao doesnot conatin the current hd value then
                map.put(hd,temp.data);// add it to the map along with current node value
            }
            if(temp.left!=null){// if currrent node has left then add it to the queue
                q.add(new Pair(temp.left,hd - 1 ));// here horizontal distance will get reduced by -1 for every left movement
            }
            if(temp.right!=null){// similarly if left exists add it to the queue
                q.add(new Pair(temp.right,hd + 1));// here hd value will get incrementes by +1 for every right movement
            }
            for(int val: map.values()){// iterate over the map
                ans.add(val);
            }
        }
        return ans;
    }
}