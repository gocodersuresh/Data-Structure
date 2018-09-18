package com.company;
/**
 * Graph simple example to check if EDGE exist
 * Author:wwww.shivapreals.tech
 */

import java.util.Scanner;

class GraphA{
    int MAX;
    int[][] graph;

    public void addEdge(int x,int y){
        // graph[x][y]=1; 1 error
        graph[x][y]=1;
    }
    public void init(int MAX){
        this.MAX=MAX;
        this.graph=new int[MAX][MAX];
        for(int xaxis=0;xaxis<MAX;xaxis++){
            for(int yaxis=0;yaxis<MAX;yaxis++){
                graph[xaxis][yaxis]=-1;
            }
        }
    }

    public void edgeExist(int i, int i1) {
        if(graph[i][i1]!=-1){
            System.out.print("Edge exist");
        }
    }
}
public class GraphAdjency {
    public static void main(String[] args) {
        GraphA graph = new GraphA();

        System.out.println("Enter Graph 2d size");
        Scanner sc=new Scanner(System.in);
       int MAX=sc.nextInt();//these will be number of rows and columns
        graph.init(MAX);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.edgeExist(2,1);
    }


}
