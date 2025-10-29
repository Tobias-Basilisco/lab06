package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    public GraphImpl(){
    }
    
    /**
     * {@inheritDoc} 
     * 
     * @param node
     */
    @Override
    public void addNode(N node){
    }

    /**
     *  {@inheritDoc}
     * 
     * @param source
     * @param target
     */
    @Override
    public void addEdge(N source, N target){
    }

    /**
     * {@inheritDoc}
     */
    public Set<N> nodeSet(){
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @param node
     * @return
     */
    public Set<N> linkedNodes(N node){
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @param source
     * @param target
     * @return
     */
    public List<N> getPath(N source, N target){
        return null;
    }
}
