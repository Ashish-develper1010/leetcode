import java.util.*;

class Router {
    private int memoryLimit;
    private Deque<int[]> queue;  // stores packets as [source, destination, timestamp]
    private Set<String> seen;    // for duplicate check
    private Map<Integer, List<Integer>> dstTimestamps; // destination -> sorted timestamps
    private Map<Integer, Integer> dstRemoved; // destination -> count of removed timestamps

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.dstTimestamps = new HashMap<>();
        this.dstRemoved = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) {
            return false; // duplicate
        }

        // If full, evict oldest
        if (queue.size() == memoryLimit) {
            forwardPacket();
        }

        // Add new packet
        int[] packet = new int[]{source, destination, timestamp};
        queue.offerLast(packet);
        seen.add(key);

        dstTimestamps.putIfAbsent(destination, new ArrayList<>());
        dstTimestamps.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};

        int[] packet = queue.pollFirst();
        int source = packet[0], destination = packet[1], timestamp = packet[2];

        String key = source + "#" + destination + "#" + timestamp;
        seen.remove(key);

        // Mark this packet as removed from destination’s timeline
        dstRemoved.put(destination, dstRemoved.getOrDefault(destination, 0) + 1);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!dstTimestamps.containsKey(destination)) return 0;

        List<Integer> times = dstTimestamps.get(destination);
        int removed = dstRemoved.getOrDefault(destination, 0);

        if (removed >= times.size()) return 0; // all removed

        // Search only in the current valid portion
        int lo = lowerBound(times, startTime, removed);
        int hi = upperBound(times, endTime, removed);

        return Math.max(0, hi - lo);
    }

    // Binary search helpers
    private int lowerBound(List<Integer> arr, int target, int start) {
        int l = start, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> arr, int target, int start) {
        int l = start, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
