package ads;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//       boolean[][] graph = new boolean[][]{
//                {false, true, true, true, false},
//                {false, false, false, true, true},
//                {false, false, false, false, false},
//                {false, false, false, false, false},
//                {true, false, false, false, false}};
//
//       GraphProcessing gp = new GraphProcessing(graph, 5);
//       System.out.println(gp.getMinSchoolNumber());
//       System.out.println(gp.getExtensionsNumber());

        String inFilename = "input.txt", outFilename = "output.txt";
        int size, j;
        boolean[][] graph;
        try{
            File file = new File(inFilename);
            Scanner scanner = new Scanner(file);
            size = scanner.nextInt();
            graph = new boolean[size][size];
            for (int i = 0; i < size; i++){
                while (scanner.hasNextInt()){
                    j = scanner.nextInt();
                    if (j == 0)
                        break;
                    graph[i][j - 1] = true;
                }
            }
        }catch (FileNotFoundException  e){
            System.out.println("Unable to read " + inFilename);
            return;
        }


        GraphProcessing gp = new GraphProcessing(graph, size);

        try{
            FileWriter fw = new FileWriter(outFilename);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(gp.getMinSchoolNumber());
            pw.println(gp.getExtensionsNumber());
            pw.close();
        }catch(IOException e){
            System.out.println("Unable to write to file " + outFilename);
        }


    }
}
