import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomPortPicker {
    private Set<Integer> whitelist; // Set to store allowed ports
    private Random random; // Random number generator instance

    /**
     * Constructor to initialize the RandomPortPicker with a whitelist and blacklist.
     *
     * @param k                The maximum port value to consider (whitelist range).
     * @param blacklisted_ports An array of ports to be blacklisted (not used).
     */
    public RandomPortPicker(int k, int[] blacklisted_ports) {
        whitelist = new HashSet<>();
        
        // Initialize the whitelist with ports from 0 to k-1
        for (int i = 0; i < k; i++) {
            whitelist.add(i);
        }

        // Remove blacklisted ports from the whitelist
        for (int port : blacklisted_ports) {
            whitelist.remove(port);
        }

        random = new Random(); // Initialize random number generator
    }

    /**
     * Gets a random port from the whitelist.
     *
     * @return A randomly selected port from the whitelist.
     */
    public int get() {
        int randomIndex = random.nextInt(whitelist.size()); // Generate a random index within the whitelist size
        int randomPort = 0;
        for (int port : whitelist) {
            if (randomIndex == 0) {
                randomPort = port; // Select the port at the chosen index
                break;
            }
            randomIndex--;
        }
        return randomPort;
    }

    public static void main(String[] args) {
        int[] blacklisted_ports = {2, 3, 5};
        RandomPortPicker picker = new RandomPortPicker(7, blacklisted_ports);
        
        // Get and print two random ports from the whitelist
        System.out.println(picker.get()); // Expected Output: A port value not present in {2, 3, 5}
        System.out.println(picker.get()); // Expected Output: Another random port value not present in {2, 3, 5}
    }
}
