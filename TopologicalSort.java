package com.shivapreals;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

import java.util.*;

class Graph {

    Stack<Integer> toppologicalSort=new Stack<>();
    Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
    int numOfVertices = 6;
    int[] indegree = new int[numOfVertices];
    int[] visitedNodes = new int[numOfVertices];

    public void addEdge(int source, int destination) {
        List<Integer> destinations = edges.get(source);
        if (destinations == null) {
            destinations = new ArrayList<Integer>();
        }

        destinations.add(destination);
        edges.put(source, destinations);
    }

    public void calculateMyDegree() {
        for (int i = 0; i < 5; i++) {
            indegree[i] = 0;
        }
        Iterator<Integer> edgeIt = edges.keySet().iterator();
        while (edgeIt.hasNext()) {
            int currentSource = edgeIt.next();
            List<Integer> destinationList = edges.get(currentSource);
            traverseNeighbours(currentSource, destinationList);
        }
    }

    public void traverseNeighbours(int currentVertex, List<Integer> destinationList) {
        for (int i = 0; i < destinationList.size(); i++) {
            int currentDestination = 0;
            try {
                currentDestination = destinationList.get(i);
                System.out.println(currentDestination);
            } catch (Exception e) {
                System.out.println("traverse problem" + e.getMessage());
            }

            incrementIndegree(currentDestination);
        }
    }
    public void traverseNeighboursDec(int currentVertex, List<Integer> destinationList) {
        for (int i = 0; i < destinationList.size(); i++) {
            int currentDestination = 0;
            try {
                currentDestination = destinationList.get(i);
                System.out.println(currentDestination);
            } catch (Exception e) {
                System.out.println("traverse problem" + e.getMessage());
            }

            decreamentIndegree(currentDestination);
        }
    }
    public void decreamentIndegree(int currentDestination){
        int currentInDegree = 0;
        try {
            currentInDegree = indegree[currentDestination];
            currentInDegree = currentInDegree - 1;
            indegree[currentDestination] = currentInDegree;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(":::" + e.getMessage());
        } catch (Exception e) {
            System.out.println("root exception" + e.getMessage());
        }
    }
public void incrementIndegree(int currentDestination){
    int currentInDegree = 0;
    try {
        currentInDegree = indegree[currentDestination];
        currentInDegree = currentInDegree + 1;
        indegree[currentDestination] = currentInDegree;
    } catch (IndexOutOfBoundsException e) {
        System.out.println(":::" + e.getMessage());
    } catch (Exception e) {
        System.out.println("root exception" + e.getMessage());
    }
}
    public void toppologicalSort() {
        int currentIndegree=0;
        for (int i = 0; i < indegree.length; i++) {

                if (indegree[i] == 0) {
                    visitedNodes[i]=1;
                    toppologicalSort.push(i);
                    List<Integer> destinationNodes = edges.get(i);
                    for (Integer node : destinationNodes) {
                        currentIndegree = indegree[node];
                        currentIndegree-=1;
                        indegree[node] = currentIndegree;
                        if (indegree[node] == 0) {
                            toppologicalSort.push(node);
                            visitedNodes[node]=1;
                        }
                    }
                }

        }
        checkRemainingVisitedSources();
    }

    private void checkRemainingVisitedSources() {
    //get all the keys from edges mean source nodes
    //check if present in visited nodes.
     //   if not then get that vertex take its destinations if dest=0 add them also to visited.
        Set<Integer> sources=edges.keySet();
        boolean found=false;
        for(Integer source:sources) {
           if(visitedNodes[source]==0){
               toppologicalSort.push(source);
               traverseNeighboursDec(source,edges.get(source));
           }
        }
        for(Integer source:sources) {

                System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>"+visitedNodes[source]);

        }
    }
}
public class TopologicalSort {
public static void main(String[] args){
    Graph g=new Graph();

    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.calculateMyDegree();
    /*for(Integer key:g.edges.keySet())
    {
        System.out.println("K"+key+"value");

    } */  /* for(int i=0;i<g.indegree.length;i++){
        System.out.println("index"+i+"indegree"+g.indegree[i]);
    }*/
    g.toppologicalSort();
System.out.println(g.toppologicalSort);
    System.out.println("g.indegree");

for(int i=0;i<g.indegree.length;i++){
    System.out.println("i:"+i+"indegree");
    System.out.println(g.indegree[i]);
}
}


}
