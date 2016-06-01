import java.util.*;
/**
 * Class represents task
 * @author Piotr Palus
 * 02.12.2015
 */
public class Task
{
    Map<Worker,Task> tasks = new HashMap<Worker, Task>();

    /**
     * Assigns worker to the task
     * @param w
     *          Added worker
     * @param t
     *          Added task
     */
    public void assign_worker_to_task(Worker w, Task t)
    {
        if(!tasks.containsKey(w)) tasks.put(w,t);
        else System.out.println("This task exists already");
    }

    /**
     * Exempts worker from the task
     * @param w
     *          Chosen worker
     */
    public void unassign_worker(Worker w)
    {
        if(tasks.containsKey(w)) tasks.remove(w);
        else System.out.println("This worker do not exist!");
    }

    /**
     * Returns worker's task, if exists
     * @param w
     *          Chosen worker
     * @return tasks.get(w)/null
     *          Worker's task/If worker doesn't exist in the set
     */
    public Task get_worker_task(Worker w)
    {
        if(tasks.containsKey(w)) return tasks.get(w);
        else return null;
    }

    /**
     * Returns first worker assigned to the chosen task
     * @param t
     *          Chosen task
     * @return i.getKey()/null
     *          Worker with chosen task/If chosen task isn't assigned to any of the workers
     */
    public Worker get_assigned_worker(Task t)
    {
        if(tasks.containsValue(t))
        {
            for(Map.Entry<Worker,Task> i : tasks.entrySet())
            {
                if(i.getValue()==t) return i.getKey();
            }

        }

        return null;
    }

}
