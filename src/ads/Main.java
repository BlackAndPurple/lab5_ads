package ads;

public class Main {

    public static void main(String[] args) {
	// write your code here
       boolean[][] graph = new boolean[][]{
                {false, true, true, true, false},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

       GraphProcessing gp = new GraphProcessing(graph, 5);
       System.out.println(gp.getMinSchoolNumber());
    }
}
