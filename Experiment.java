import java.util.Arrays;

public class Experiment {
// Creating Sorter and Searcher
    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else if (type.equals("advanced")) {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("Array Size: " + size + "  ");

            // Test with random array
            int[] randomArr1 = sorter.generateRandomArray(size);
            // Copying array for second sorter to work
            int[] randomArr2 = Arrays.copyOf(randomArr1, randomArr1.length);

            long basicRandom = measureSortTime(randomArr1, "basic");
            long advRandom = measureSortTime(randomArr2, "advanced");

            // For binary search
            int target = randomArr1[size / 2];
            long searchTime = measureSearchTime(randomArr1, target);

            System.out.println("Type: RANDOM");
            System.out.println("Insertion Sort: " + basicRandom + " ns");
            System.out.println("Merge Sort: " + advRandom + " ns");
            System.out.println("Binary Search: " + searchTime + " ns\n");

            // Test with sorted array
            int[] sortedArr1 = sorter.generateSortedArray(size);
            int[] sortedArr2 = Arrays.copyOf(sortedArr1, sortedArr1.length);

            long basicSorted = measureSortTime(sortedArr1, "basic");
            long advSorted = measureSortTime(sortedArr2, "advanced");

            System.out.println("Type: SORTED");
            System.out.println("Insertion Sort: " + basicSorted + " ns");
            System.out.println("Merge Sort:     " + advSorted + " ns");
        }
    }
}