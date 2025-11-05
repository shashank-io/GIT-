import java.util.*;
public class TW2{
    static class Task{
        int taskId;
        String priority;
        List<Integer> dependencies;

        public Task(int taskId, String priority, List<Integer> dependencies){
            this.taskId=taskId;
            this.priority=priority;
            this.dependencies=dependencies;
        }
        public boolean isReadyToExecute(Set<Integer> completedTasks){
            return completedTasks.containsAll(dependencies);
        }

        
    }
    private Deque<Task>deque;
    private Set<Integer> completedTasks;

    public TW2(){
        deque = new LinkedList<>();
        completedTasks=new HashSet<>();
    }

    public void addTask(Task task){
        if (task.priority.equals("HIGH")){
            deque.addFirst(task);
        }else{
            deque.addLast(task);
        }
    }
    public void processTasks(){
        while(!deque.isEmpty()){
            Task task=deque.peek();

            if(task.isReadyToExecute(completedTasks)){
                deque.poll();
                System.out.println("Executing Task ID;"+task.taskId);
                completedTasks.add(task.taskId);
            }else{
                System.out.println("Task ID: "+task.taskId+ " is waiting for dependencies");
                deque.poll();
                deque.addLast(task);

            }
        }
    }

    public static void main(String[]args){
        TW2 scheduler=new TW2();

        Task task1= new Task(1, "HIGH",Arrays.asList());
        Task task2= new Task(2, "LOW",Arrays.asList());
        Task task3= new Task(3, "HIGH",Arrays.asList());
        Task task4= new Task(4, "LOW",Arrays.asList());
        Task task5= new Task(5, "HIGH",Arrays.asList());
        Task task6= new Task(6, "LOW",Arrays.asList());

        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);
        scheduler.addTask(task4);
        scheduler.addTask(task5);
        scheduler.addTask(task6);

    }
}
