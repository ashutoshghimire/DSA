import java.util.*;

public class MinStepsToCompleteTasks {

    /**
     * Calculates the minimum steps needed to complete tasks with given prerequisites.
     *
     * @param N             The number of tasks.
     * @param prerequisites An array representing prerequisites as pairs (task, prerequisite).
     * @return The minimum steps needed to complete all tasks. Returns -1 if not possible.
     */
    public int minSteps(int N, int[][] prerequisites) {
        // Create a graph using adjacency list representation
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Count incoming edges for each task
        int[] inDegree = new int[N + 1];
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0]; // Task
            int y = prerequisite[1]; // Prerequisite
            graph[x].add(y); // Add prerequisite relationship to the graph
            inDegree[y]++; // Increment the incoming edge count for the prerequisite
        }

        // Initialize a queue to perform topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); // Add tasks with no prerequisites to the queue
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll(); // Current task being processed
                for (int neighbor : graph[curr]) {
                    inDegree[neighbor]--; // Reduce incoming edge count for prerequisites
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor); // Add tasks with no remaining prerequisites
                    }
                }
            }
            steps++;
        }

        return steps == N ? steps : -1; // If all tasks are completed, return steps; otherwise, return -1.
    }

    public static void main(String[] args) {
        MinStepsToCompleteTasks minSteps = new MinStepsToCompleteTasks();
        int N = 3;
        int[][] prerequisites = {{1, 3}, {2, 3}};
        int result = minSteps.minSteps(N, prerequisites);
        System.out.println("Minimum steps needed: " + result); // Expected Output: 2
    }
}
