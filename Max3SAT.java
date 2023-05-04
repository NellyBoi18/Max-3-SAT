import java.util.*;

public class Max3SAT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // number of variables
        int m = in.nextInt(); // number of clauses
        List<int[]> clauses = new ArrayList<>(); // list of clauses

        // read input
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            clauses.add(new int[]{x, y, z});
        }

        in.close();

        // initialize random assignment
        int[] assignment = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            assignment[i] = rand.nextBoolean() ? 1 : -1;
        }

        // repeat for log n rounds
        for (int r = 0; r < Math.log(n) / Math.log(2); r++) {
            // evaluate each clause under current assignment
            int[] clauseValues = new int[m];
            for (int i = 0; i < m; i++) {
                int[] clause = clauses.get(i);
                int x = clause[0];
                int y = clause[1];
                int z = clause[2];
                clauseValues[i] = (assignment[Math.abs(x) - 1] * x < 0 ? 0 : 1)
                        + (assignment[Math.abs(y) - 1] * y < 0 ? 0 : 1)
                        + (assignment[Math.abs(z) - 1] * z < 0 ? 0 : 1);
            }

            // pick the best variable to flip
            int bestVar = -1;
            int bestDelta = 0;
            for (int i = 0; i < n; i++) {
                int delta = 0;
                for (int j = 0; j < m; j++) {
                    int[] clause = clauses.get(j);
                    if (clauseValues[j] == 0 && (clause[0] == i + 1 || clause[1] == i + 1 || clause[2] == i + 1)) {
                        delta++;
                    } else if (clauseValues[j] == 2 && (clause[0] == -(i + 1) || clause[1] == -(i + 1) || clause[2] == -(i + 1))) {
                        delta++;
                    }
                }
                if (delta > bestDelta) {
                    bestVar = i;
                    bestDelta = delta;
                }
            }

            // flip the best variable
            if (bestVar != -1) {
                assignment[bestVar] *= -1;
            }
        }

        // output final assignment
        for (int i = 0; i < n; i++) {
            System.out.print(assignment[i] + " ");
        }
        System.out.println();
    }
}