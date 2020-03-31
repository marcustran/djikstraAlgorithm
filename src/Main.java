public class Main {
    public int minDistance(int dist[], Boolean b[]){
        int min = Integer.MAX_VALUE, index = -1;
        for (int x = 0; x<6; x++){
            if (b[x] == false && dist[x] <= min)
            {
                min = dist[x];
                index = x;
            }
        }
        return index;
    }

    public void printGraph(int dist[], int x){
        System.out.println("Distance from A to destination");
        for (int i = 0; i<6; i++){
            System.out.println((char)(i+65) + "=" + dist[i]);
        }
    }
    public void dijsktra(int graph[][], int src){
        int dist[] = new int[6];
        Boolean b[] = new Boolean[6];
        for(int i = 0; i<6; i++ ){
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }
    dist[src] = 0;
    for( int count = 0 ; count < 6; count ++) {
        int u = minDistance(dist, b);
        b[u] = true;
        for(int x = 0; x<6; x++){

            if(!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x])
            {
                dist[x] = dist[u] + graph[u][x];
            }
        }
        printGraph(dist, 6);
    }
    }

    public static void main(String args[])
    {
        int graph[][] = new int[][] {{0,10,5,9999,3,12}, {10,0,17,9,17,12}, {5,17,0,35,3,12}, {9999,9,35,0,3,12}, {3,17,3,9999,0,12}, {12,12,12,12,12,0}};


    Main p = new Main();
    p.dijsktra(graph,0);

    }

}
