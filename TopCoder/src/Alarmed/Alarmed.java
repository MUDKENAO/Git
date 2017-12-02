/*
 * https://community.topcoder.com/stat?c=problem_statement&pm=7479&rd=10730
 * Difficulty: Medium Score: 1000
 */
package Alarmed;

public class Alarmed {

    public double noise(int[] x, int[] y, int[] threshold) {
	double[][] sensorGraph = completeGraph(x, y, threshold);
	return checkIntersect(sensorGraph, x, y, threshold);
    }

    private double[][] completeGraph(int[] x, int[] y, int[] threshold) {
	int n = x.length;
	double[][] edges = new double[n + 2][n + 2]; // n sensors and left,right
						     // wall
	for (int i = 0; i < n + 2; i++) {
	    for (int j = i; j < n + 2; j++) {
		if (i == j) {
		    edges[i][j] = 0;
		} else if (j == n) {
		    edges[i][j] = threshold[i] * x[i] * x[i];

		} else if (j == n + 1) {
		    if (i == n) {
			edges[i][j] = 0.0;
		    } else {
			edges[i][j] = threshold[i] * (100 - x[i]) * (100 - x[i]);
		    }
		} else {
		    edges[i][j] = ((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]))
			    / ((1 / Math.sqrt(threshold[i]) + 1 / Math.sqrt(threshold[j]))
				    * (1 / Math.sqrt(threshold[i]) + 1 / Math.sqrt(threshold[j])));
		}
		edges[j][i] = edges[i][j];
	    }
	}
	return edges;
    }

    private double checkIntersect(double[][] graph, int[] x, int[] y, int[] threshold) {

	double weight = getWeight(graph); // value of weight should be got by
	// Shortest path algorithm

	int numOfSensor = graph.length - 2;
	/*
	 * compare the minimal weight with the weight to Entrance and Exit, if
	 * any sensor's circle intersects the entrance or exit with minimal
	 * weight, the minimal weight should be decreased to certain value that
	 * keep the circle off the entrance/exit.
	 */
	double miniDisEntran = Double.MAX_VALUE;
	double miniDisExit = Double.MAX_VALUE;
	double disToEntrance;
	double disToExit;
	for (int i = 0; i < numOfSensor; i++) {
	    disToEntrance = ((x[i] - 50) * (x[i] - 50) + y[i] * y[i]) * threshold[i];
	    disToExit = ((x[i] - 50) * (x[i] - 50) + (y[i] - 100) * (y[i] - 100)) * threshold[i];

	    if (disToEntrance < miniDisEntran) {
		miniDisEntran = disToEntrance;
	    }
	    if (disToExit < miniDisExit) {
		miniDisExit = disToExit;
	    }
	}

	return Math.min(weight, Math.min(miniDisEntran, miniDisExit));
    }

    /*
     * Use Floyd-Warshall Algorithm to get shortest path from the undirected
     * graph
     */
    private double getWeight(double[][] graph) {
	int N = graph.length;
	int[][] path = new int[N][N];

	for (int k = 0; k < N; k++) {
	    for (int j = 0; j < N; j++) {
		for (int i = 0; i < N; i++) {
		    // if path i->k,k->j is un-reachable
		    if (graph[i][k] == 0.0 | graph[k][j] == 0.0) {
			continue;
			// find shortest path. If i,j is unreachable, set ikj as
			// its path weight
		    } else if ((Math.max(graph[i][k], graph[k][j]) < graph[i][j]) | (graph[i][j] == 0)) {
			graph[i][j] = Math.max(graph[i][k], graph[k][j]);
			path[i][j] = k;
		    }
		}
	    }
	}
	return graph[N - 2][N - 1]; // the shortest path from left wall to right
				    // wall
    }

    public static void main(String[] args) {
	int[] x = new int[] { 3, 11, 2, 62, 91 };
	int[] y = new int[] { 90, 10, 75, 25, 50 };
	int[] threshold = new int[] { 5, 4, 3, 2, 1 };
	double offset = 1.0E-9;
	double result = new Alarmed().noise(x, y, threshold);
	System.out.println("result is:" + (result - offset));

    }

}
