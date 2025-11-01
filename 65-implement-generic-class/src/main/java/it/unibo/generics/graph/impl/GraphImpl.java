package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N, List<N>> map;

    public GraphImpl(){
        map = new HashMap<>();
    }
    
    /**
     * {@inheritDoc} 
     * 
     * @param node
     */
    @Override
    public void addNode(N node){
        if (map.containsKey(node)){
            return;
        }
        map.put(node, new ArrayList<>());
    }

    /**
     *  {@inheritDoc}
     * 
     * @param source
     * @param target
     */
    @Override
    public void addEdge(N source, N target){
        if (source == null || 
            target == null ||
            !map.containsKey(source) ||
            !map.containsKey(target)){
            return;
        }
        map.get(source).add(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<N> nodeSet(){
        if (map.isEmpty()) {
            return null;
        }
        final Set<N> set = new HashSet<>(map.keySet());

        return set;
    }

    /**
     * {@inheritDoc}
     * 
     * @param node
     * @return
     */
    @Override
    public Set<N> linkedNodes(N node){
        if (node == null || !map.containsKey(node)){
            return null;
        }
        Set<N> linkedNodes = new HashSet<>(map.get(node));
        
        return linkedNodes;
    }

    /**
     * {@inheritDoc}
     * 
     * @param source
     * @param target
     * @return
     */
    @Override
    public List<N> getPath(N source, N target){
        final Map<N, BfsFields<N>> bfsGraph = createBfsGraph(source);
        final List<N> path = new LinkedList<>();
        N node = target;

        while (node != null) {
            path.addFirst(node);
            node = bfsGraph.get(node).parent;
        }

        return path;
    }

    static class BfsFields<N>{
        private Colors color;
        private int distance;
        private N parent;

        public BfsFields(){
            this.color = Colors.WHITE;
            this.distance = Integer.MAX_VALUE;
            this.parent = null;
        }

        public Colors getColor() {
            return color;
        }

        public int getDistance() {
            return distance;
        }

        public N getParent() {
            return parent;
        }

        void setColor(final Colors color){
            this.color = color;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setParent(N parent) {
            this.parent = parent;
        }
    }

    static enum Colors{
        WHITE, GREY, BLACK
    }

    private Map<N, BfsFields<N>> createBfsGraph(final N source){
        final Map<N, BfsFields<N>> bfsGraph = initEmptyBfsGraph();
        final Queue<N> q = new LinkedList<>();
        N node = null;

        bfsGraph.get(source).setColor(Colors.GREY);
        bfsGraph.get(source).setDistance(0);

        q.add(source);

        while(!q.isEmpty()){
            node = q.remove();
            for ( final N adj : GraphImpl.this.map.get(node)){
                if (bfsGraph.get(adj).getColor() == Colors.WHITE){
                    bfsGraph.get(adj).setColor(Colors.GREY);
                    bfsGraph.get(adj).setParent(node);
                    bfsGraph.get(adj).setDistance(bfsGraph.get(node).getDistance() + 1);
                    q.add(adj);
                }
            }
            bfsGraph.get(node).setColor(Colors.BLACK);
        }

        return bfsGraph;
    }

    private Map<N, BfsFields<N>> initEmptyBfsGraph(){
        final Map<N, BfsFields<N>> bfsGraph = new HashMap<>();
        for( final N node : map.keySet()){
            bfsGraph.put(node, new BfsFields<>());
        }
        return bfsGraph;
    }
}
