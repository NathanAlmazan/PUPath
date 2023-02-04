package com.nathanael;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Good Day! Where do you want to go?");
        String inputDestination = scanner.nextLine();

        System.out.println("Please tell me where you are right now.");
        String inputLocation = scanner.nextLine();

        scanner.close();

        // cannot be changed

        GraphGenerator generator = new GraphGenerator();

        Integer destination = generator.analyzeChat(inputDestination); // put the destination chat response
        Integer location = generator.analyzeChat(inputLocation); // put the current location chat response

        System.out.println("Finding path from " + GraphGenerator.destinations.get(location) + " to " + GraphGenerator.destinations.get(destination) + "...");

        Dijkstra dijkstra = new Dijkstra();
        List<Integer> paths = dijkstra.generateShortestPath(generator.generateMatrixGraph(), location, destination);

        Collections.reverse(paths);

        List<String> instructions = generator.generateInstructions(paths);

        // variable instruction contains the steps


        // change on how you will display the data
        System.out.println("Follow these steps to arrive at your destination: ");
        for (String step : instructions)
            System.out.println(step);
    }
}
