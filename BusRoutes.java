import java.util.*;

public class BusRoutes {

    static int findMinBuses(int[][] routes) {
        // Step 1: Sort the routes by starting point
        Arrays.sort(routes, (a , b) -> a[0] - b[0]);

        // Step 2: Traverse and merge overlapping intervals
        int count = 0;
        int start = routes[0][0];
        int end = routes[0][1];

        for(int i = 1; i<routes.length; i++){
            if(routes[i][0] <= end){
                //overlap
                end = Math.max(end, routes[i][1]);
            } else {
                //no overlap -> finalize one bus
                count ++;
                start = routes[i][0];
                end = routes[i][1];
            }
        }

        //last one
        count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of routes
        int n = sc.nextInt();
        int[][] routes = new int[n][2];

        // Input the 2D array (routes)
        for (int i = 0; i < n; i++) {
            routes[i][0] = sc.nextInt(); // start
            routes[i][1] = sc.nextInt(); // end
        }

        // Call function
        int result = findMinBuses(routes);

        // Output the result
        System.out.println(result);

        sc.close();
    }
}
