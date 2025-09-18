import java.util.*;

class TaskManager {
    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task a, Task b) {
            if (a.priority != b.priority) {
                return b.priority - a.priority; // higher priority first
            }
            if (a.taskId != b.taskId) {
                return b.taskId - a.taskId; // higher taskId first
            }
            return a.userId - b.userId; // avoid treating equal tasks as duplicates
        }
    }

    private final Map<Integer, Task> taskMap;
    private final TreeSet<Task> taskSet;

    // ✅ LeetCode passes List<List<Integer>> here
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>(new TaskComparator());

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);

            Task task = new Task(userId, taskId, priority);
            taskMap.put(task.taskId, task);
            taskSet.add(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old != null) {
            taskSet.remove(old);
            Task updated = new Task(old.userId, taskId, newPriority);
            taskMap.put(taskId, updated);
            taskSet.add(updated);
        }
    }

    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        if (task != null) {
            taskSet.remove(task);
        }
    }

    public int execTop() {
        if (taskSet.isEmpty()) return -1;

        Task top = taskSet.first();
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
