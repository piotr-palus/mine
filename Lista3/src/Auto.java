/**
 * Class represents car
 * @author Piotr Palus
 * 18.11.2015
 */
public class Auto
    extends Pojazd
{

    /**
     * Calculates the cost of maintaining the car
     * @param km
     *          Amount of driven kilometers
     * @param hours
     *          Amount of driven hours
     * @return upkeep
     *          The cost of maintaining the car
     */
    @Override
    public double upkeep(double km, double hours)
    {
        double upkeep=upkeepKm*km;

        return upkeep;
    }

}

