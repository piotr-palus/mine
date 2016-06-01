import java.util.*;

/**
 * Class represents hotel with 100 rooms
 * @author Piotr Palus
 * 18.11.2015
 */
public class Hotel
{
    Osoba[] tablica=new Osoba[101];


    /**
     * Attributes person to chosen room
     * @param room
     *          Chosen room number
     * @param imie
     *          Person's first name
     * @param nazwisko
     *          Person's surname
     */
    public void giveRoom(int room, String imie, String nazwisko)
    {
        if(room>0&&room<101)
        {
            if(tablica[room]==null) tablica[room]=new Osoba(imie, nazwisko);
            else System.out.println("Room is not empty");
        }
        else System.out.println("Wrong room number");
    }

    /**
     * Makes chosen room empty
     * @param room
     *          Chosen room number
     */
    public void makeEmpty(int room)
    {
        if(tablica[room]!=null) tablica[room]=null;
        else System.out.println("Room is already empty");
    }

    /**
     * Switches people from two chosen rooms
     * @param room1
     *          first chosen room
     * @param room2
     *          second chosen room
     */
    public void roomSwitch(int room1, int room2)
    {
        Osoba tmp=tablica[room1];
        tablica[room1]=tablica[room2];
        tablica[room2]=tmp;
    }

    /**
     * @return amount
     *          Amount of empty rooms
     */
    public int amountOfEmpty()
    {
        int amount=0;
        for(int i=1; i<tablica.length;i++)
        {
            if(tablica[i]==null) amount++;
        }
        return amount;
    }

    /**
     * @return tab
     *          Array of empty rooms
     */
    public int[] findEmpty()
    {
        int[] tab=new int[amountOfEmpty()];
        int j=0;

        for(int i=1; i<tablica.length;i++)
        {
            if(tablica[i]==null)
            {
                tab[j]=i;
                j++;
            }
        }
        return tab;
    }

    /**
     * Attributes people to 50 to empty rooms by random, if this amount exists
     */
    public void getRoomByRandom()
    {
        int[] shuffledTab=new int[amountOfEmpty()];
        shuffledTab=shuffleArray(findEmpty());
        if(amountOfEmpty()>=50)
        {
            for(int i=0;i<=50;i++)
            {
                tablica[shuffledTab[i]]=new Osoba();
            }
        }
        else System.out.println("Cannot find 50 empty rooms");

    }


    /**
     * Shuffling array
     * @param array
     *          Array for shuffling
     * @return array
     *          Shuffled arrray
     */
    public int[] shuffleArray(int[] array){
        Random rand = new Random();

        for (int i=0; i<array.length; i++) {
            int randPosition = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randPosition];
            array[randPosition] = temp;
        }

        return array;


    }

    /**
     * Writes every room with guests' information
     */
    public void roomInfo()
    {
        for(int i=1;i<tablica.length;i++)
        {
            if(tablica[i]!=null) System.out.println("Room "+i+": "+tablica[i].imie+" "+tablica[i].nazwisko);
            else System.out.println("Room "+i+" is empty");
        }
    }

    /**
     * For testing
     */
    public static void main(String[] args)
        {
            Hotel hotel=new Hotel();
            System.out.println(Arrays.toString(hotel.findEmpty()));
        }

}







