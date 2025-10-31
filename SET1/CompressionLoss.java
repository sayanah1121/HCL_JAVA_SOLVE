// Question 51
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompressionLoss {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        int n = scanner.nextInt();
        List<Integer> initialFeatureMap = new ArrayList<>();

        // Read the feature map elements
        for (int i = 0; i < n; i++) {
            initialFeatureMap.add(scanner.nextInt());
        }
        scanner.close();

        // Compute and print the compression loss
        int loss = computeCompressionLoss(initialFeatureMap);
        System.out.println(loss);
    }

    public static int computeCompressionLoss(List<Integer> featureMap) {
        int totalLoss = 0;
        List<Integer> currentMap = new ArrayList<>(featureMap);

        // Continue the reduction process until the map has a single element
        while (currentMap.size() > 0) {
            // Add the sum of the current map to the total loss
            int currentSum = 0;
            for (int value : currentMap) {
                currentSum += value;
            }
            totalLoss += currentSum;

            // If the map has only one element, the process is done
            if (currentMap.size() == 1) {
                break;
            }

            // Create the next reduced map
            List<Integer> nextMap = new ArrayList<>();
            for (int i = 0; i < currentMap.size() - 1; i++) {
                nextMap.add(currentMap.get(i) & currentMap.get(i + 1));
            }
            
            // Replace the current map with the new, smaller map
            currentMap = nextMap;
        }

        return totalLoss;
    }
}
