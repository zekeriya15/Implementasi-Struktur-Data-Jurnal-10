// jurnal dfs

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTraversal {
    private int vertex;
    
    // array list untuk represenatsi list ketetenggaan
    private LinkedList<Integer> adj[];

    // array penanda visited
    private boolean visited[];


    // constructor
    @SuppressWarnings("unchecked")
    public DFSTraversal(int v) {
        vertex = v;
        adj = new LinkedList[vertex];       // initialize array sebanyak jumlah vertex

        // bikin linkedlist untuk setiap index array (vertex)
        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }

        visited = new boolean[vertex];      // initialize array sebnayak jumlah vertex
        // isi semua index dengen elemen FALSE
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
        }
    }


    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }


    public String convert(int s) {
        String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return alphabet[s];
    }


    public void dfs(int source) {
        // buat stack untuk DFS
        Stack<Integer> stack = new Stack<>();

        // push vertex source yg saat ini
        stack.push(source);

        while (stack.empty() == false) {
            // pop vertex yg ada di stack, print vertex
            source = stack.peek();
            stack.pop();

            // ada kemungkinan push 2 vertex yg sama ke stack. jadi perlu
            // print vertex yg suadh di POP kalo belum dikunjungi
            if (visited[source] == false) {
                System.out.print(convert(source) + " ");
                visited[source] = true;
            }

            // ambil semua tetangga (isi dari vertex parent) vertex yg di-pop
            // kalo tetangga itu blum dikunjungi, PUSH ke stack
            Iterator<Integer> it = adj[source].iterator();

            while (it.hasNext()) {
                int v = it.next();
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }
    }

}
