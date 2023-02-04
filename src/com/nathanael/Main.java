package com.nathanael;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GraphGenerator generator = new GraphGenerator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Good Day! Where do you want to go?");
        String inputDestination = scanner.nextLine();

        System.out.println("Please tell me where you are right now.");
        String inputLocation = scanner.nextLine();

        scanner.close();

        Integer destination = generator.analyzeChat(inputDestination);
        Integer location = generator.analyzeChat(inputLocation);

        System.out.println("Finding path from " + GraphGenerator.destinations.get(location) + " to " + GraphGenerator.destinations.get(destination) + "...");

        Dijkstra dijkstra = new Dijkstra();
        List<Integer> paths = dijkstra.generateShortestPath(generator.generateMatrixGraph(), location, destination);

        Collections.reverse(paths);

        System.out.println("Follow these steps to arrive at your destination: ");

        for (String step : generator.generateInstructions(paths))
            System.out.println(step);
    }
}
