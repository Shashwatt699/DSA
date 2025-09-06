package Strings;

public class ShortestPath {

    static float findShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

            // North
            if (dir == 'N') {
                y++;
            }
            // East
            else if (dir == 'E') {
                x++;
            }
            // South
            else if (dir == 'S') {
                y--;
            }
            // West
            else if (dir == 'W') {
                x--;
            } else {
                System.out.println("Wrong character Input at " + i);
                return 400;
            }
        }

        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static void main(String[] args) {
        String path = "WNEENNNESENNN";
        // System.out.println(findShortestPath(path));
    
        String S1 = "AAnySherKaBacchaHai";
        String S2 = "TTTTonySHerKaBacchaHaiWWWW";
        String S3 = new String("TTTTonySHerKaBacchaHaiWWWW");

        // if(S1.equals(S3)){
        //     System.out.println("S1 equals S3");
        // }
        
        // if(S1.equals(S2)){
        //     System.out.println("S1 equals S2");
        // }

        //System.out.println(S1.substring(1,11));

        //lexicographically
        // if(S1.compareToIgnoreCase(S2) > 0){
        //     System.out.println("String 1 is bigger and better");
        // }
        // else if(S1.compareToIgnoreCase(S2) < 0){
        //     System.out.println("String 2 is bigger and better");
        // }

        StringBuilder sb = new StringBuilder("Yellow");
        sb.append(" OLD");
        sb.insert(5, "m");
        sb.delete(0, 2);
        sb.deleteCharAt(6);
        sb.replace(0, 5, "Sher");
        sb.reverse();
        System.out.println(sb.capacity());
        sb.ensureCapacity(5000);
        //sb.toString();

        System.out.println(sb);
    }
}
