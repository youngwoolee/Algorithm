package code;

import java.util.*;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    List list = new ArrayList();

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
//            visit(r);
            list.add(r.data);

        }
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }
}
public class BackJoon_13023 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        Graph g = new Graph(N);

        List list2 = new ArrayList();

        for(int i=0; i< N; i++) {
            list2.add(i);
        }
        for(int i=0; i< M; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            g.addEdge(s1, s2);

        }

        g.dfs();



        if(g.list.equals(list2)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);


    }
}
