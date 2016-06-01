/**
 * Class represents company
 * @author Piotr Palus
 * 18.11.2015
 */

import java.util.List;
import java.util.ArrayList;
public class Firma
{
    List<Pojazd> lista= new ArrayList<Pojazd>();

    /**
     * Returns reference to vehicle by id
     * @param id
     *          Vehicle's id
     * @return lista.get(i)
     *          Reference to vehicle, if it exists
     */
    public Pojazd vehicleRef(int id)
    {
        int i=0;

        while(lista.size()>i)
        {
            if(lista.get(i).id==id) break;
            else i++;
        }

        if(lista.size()==i) return null;
        else return lista.get(i);
    }

    /**
     * Adds vehicle of chosen type
     * @param type
     *          Chosen type
     */
    public void addVehicle(Pojazd type)
    {
        lista.add(type);
    }

    /**
     * Removes vehicle by id
     * @param id
     *          Vehicle's id
     */
    public void removeVehiclebyId(int id)
    {
        int i=0;

        while(lista.size()>i)
        {
            if(lista.get(i).id==id)
            {
                lista.remove(i);
                break;
            }
            else i++;
        }

    }

    /**
     * Adds chosen amount of vehicles of every type
     * @param auto
     *          Amount of cars
     * @param train
     *          Amount of trains
     * @param plane
     *          Amount of planes
     */
    public void addMany(int auto, int train, int plane)
    {
        int i=0;

        while(i<auto)
        {
            lista.add(new Auto());
            i++;
        }
        i=0;
        while(i<train)
        {
            lista.add(new Kolej());
            i++;
        }
        i=0;
        while(i<plane)
        {
            lista.add(new Samolot());
            i++;
        }

    }

    /**
     * Calculates the cost of maintaining the vehicle
     * @param id
     *          Vehicle's id
     * @param kmAmount
     *          Amount of driven/flown kilometers
     * @param hoursAmount
     *          Amount of driven/flown hours
     */
    public double upkeep(int id, double kmAmount, double hoursAmount)
    {
        int i=0;

        while(i<lista.size())
        {
            if(lista.get(i).id==id) break;
            else i++;
        }

        if(i==lista.size()) return 0;
        else return lista.get(i).upkeep(kmAmount,hoursAmount);



    }


    /**
     * Testing
     */
    public static void main(String[] args)
    {
        Firma firma=new Firma();
        firma.addMany(5,5,5);









    }

}

