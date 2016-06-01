import java.util.*;

/**
 * Class stores up to 1000 integers
 * @author Piotr Palus
 * 18.11.2015
 */

public class Tablica
{
    public int[] tablica;
    public int amount;

    /**
     * Array constructor
     * @param amount
     *          Amount of elements in array
     */
    public Tablica(int amount)
    {
        if(amount>0&&amount<=1000)
        {
            tablica=new int[amount];
            this.amount=amount;

        }
        else System.out.println("Wrong amount");
    }

    /**
     * Puts integers into array from chosen range
     * @param begin
     *          Lower limit
     * @param end
     *          Higher limit
     */
    public void random(int begin, int end)
    {
        Random rand=new Random();
        for(int i=0; i<amount; i++)
        {
            tablica[i]=rand.nextInt(end-begin+1)+begin;
        }

    }

    /**
     * @return sum
     *          Sum of every element in array
     */

    public int sum()
    {
        int sum=0;
        for(int i=0; i<amount; i++)
        {
            sum+=tablica[i];

        }
        return sum;
    }

    /**
     * @return max
     *          Max value in array
     */
    public int findMax()
    {
        int max=tablica[0];
        for(int i=0; i<amount; i++)
        {
            if(tablica[i]>max) max=tablica[i];
        }
        return max;
    }

    /**
     * Removes chosen value in array
     * @param x
     *          Chosen value
     */
    public void remove(int x)
    {
        int ilosc=0;

        for(int i=0; i<amount; i++)
        {
            if(tablica[i]==x) ilosc++;
        }

        int[] tablica2=new int[amount-ilosc];

        int j=0;
        for(int i=0; i<amount; i++)
        {
            if(tablica[i]!=x)
            {
                tablica2[j]=tablica[i];
                j++;
            }


        }

        tablica=tablica2;

    }

    /**
     * Writes all elements in array
     */
    public void arrayShow()
    {
        System.out.println(Arrays.toString(tablica));
    }




}
