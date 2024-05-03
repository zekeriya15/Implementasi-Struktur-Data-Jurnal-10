// jurnal bfs

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int nodes;
    private LinkedList<Integer> adj[];
    private Queue<Integer> vertexQueue;
    

    // pembuattan list adjacency dan insialisasi vertexQueue (constructor)
    public BFSTraversal(int vertex) {
        nodes = vertex;
        adj = new LinkedList[nodes];    // bikin array sebanyak jumlah vertex

        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();        // bikin linkedlist untuk setiap index (vertex)
        }

        vertexQueue = new LinkedList<Integer>();
    }


    // list adjacency, penambahan edge
    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    // melihat hasil list adjacency
    // public void getAdj() {
    //     for (LinkedList<Integer> linkedlist: adj) {
    //         System.out.println(linkedlist);
    //     }
    // }

    public void getAdj() {
        for (int i = 0; i < nodes; i++) {
            if (adj[i].size() > 0) {            // size = method linkedlist
                System.out.print(convert(i) + " --> ");
                for (int j = 0; j < adj[i].size(); j++) {
                    System.out.print(convert(adj[i].get(j)) + " ");         // get = method linkedlist
                }
                System.out.println();
            }
        }
    }

    // method convert angka => huruf
    public String convert(int s) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return alphabet[s];
    }


    // penulusuran BFS
    public void bfs(int source) {
        // buat queue untux vertex yg sudah dikunjungi, length = nodes (sebnyak vertex)
        boolean traversalOrder[] = new boolean[nodes];

        // nilai awal vertex yg dikunjungi
        int visitedVertex = 0;

        traversalOrder[source] = true;      // vertex sumber dikunjungi, masukkan ke dalam queue

        vertexQueue.add(source);


        while (!vertexQueue.isEmpty()) {
            // ambil dan hapus vertex pertama
            visitedVertex = vertexQueue.poll();

            // print vertex pertama
            System.out.print(convert(visitedVertex) + " ");

            // cek tetangga dari awal vertex
            for (int tetangga : adj[visitedVertex]) {   // for each untuk linkedlist bukan array, jadi bakal nge loop isi linkedlist adj[index]
                // jika tetangga belum dikunjungi, kunjungi tetangga
                if (!traversalOrder[tetangga]) {        // int tetangga bukan dari 0 kyk index tapi element asli dari array adj
                    traversalOrder[tetangga] = true;

                    // masukkan tetangga ke vertexQueue
                    vertexQueue.add(tetangga); 
                }
            }
        }
    }

}