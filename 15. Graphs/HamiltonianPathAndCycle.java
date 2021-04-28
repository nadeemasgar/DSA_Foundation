public static void  hamiltonain(ArrayList<Edge>[] graph, int src, String psf, boolean[] visited, int osrc) {
       
    // Self work
    if(psf.length() == graph.length) {
        
        System.out.print(psf);
        
        for(Edge e : graph[osrc]) {
            if(e.nbr == src) {
                System.out.println("*");
                return;
            }
        }
        
        System.out.println(".");
        return;
    }
    
    // All Path
    visited[src] = true;
    
    for(Edge e : graph[src]) {
        int nbr = e.nbr;
        
        if(visited[nbr] == false) {
            hamiltonain(graph, nbr, psf+nbr+"", visited, osrc);
        }
    }
    
    visited[src] = false;
}

public static void solve(ArrayList<Edge>[] graph, int src) {
    
    boolean[] visited = new boolean[graph.length];
    
    hamiltonain(graph, src, src+"", visited, src);
}