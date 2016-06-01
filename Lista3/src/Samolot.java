/**
 * Class represents plane
 * @author Piotr Palus
 * 18.11.2015
 */
public class Samolot
    extends Pojazd
{
    /**
     * Calculates the cost of maintaining the plane
     * @param km
     *          Amount of flown kilometers
     * @param hours
     *          Amount of flown hours
     * @return upkeep
     *          The cost of maintaining the plane
     */
    @Override
    public double upkeep(double km, double hours)
    {
        double upkeep=upkeepH*hours+(maxV/100)*hours;

        return upkeep;
    }
}
