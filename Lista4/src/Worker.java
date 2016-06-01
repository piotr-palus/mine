import java.util.*;
/**
 * Class represents worker
 * @author Piotr Palus
 * 02.12.2015
 */
public class Worker
{
    List<Worker> list = new ArrayList<Worker>();

    /**
     * Adds worker to the list
     * @param w
     *          Added worker
     */
    public void add_worker(Worker w)
    {
        list.add(w);
    }

    /**
     * Returns worker from the list by random
     * @return list.get(los)
     *          Worker from the list
     */
    public Worker choose_random_worker()
    {
        int los=0;
        Random rand = new Random();
        los=rand.nextInt(list.size());

        return list.get(los);

    }

    /**
     * Selects every n-th worker
     * @param n
     *          Which worker
     * @return tab
     *          Array of selected workers
     */
    public Worker[] choose_every_nth_worker(int n)
    {
        Worker[] tab = new Worker[list.size()/n-1];
        int count_tab=0;
        for(int i=0;i<tab.length;i+=3)
        {
            tab[count_tab]=list.get(i);
            count_tab++;
        }

        return tab;

    }



}
