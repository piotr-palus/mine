/**
 * Class represents train
 * @author Piotr Palus
 * 18.11.2015
 */
public class Kolej
    extends Pojazd
{
    int carriageAmount;

    /**
     * Calculates the cost of maintaining the train
     * @param km
     *          Amount of driven kilometers
     * @param hours
     *          Amount of driven hours
     * @return upkeep
     *          The cost of maintaining the train
     */
    @Override
    public double upkeep(double km, double hours)
    {
        double upkeep=upkeepKm*km+upkeepH*hours;

        return upkeep;
    }
}
