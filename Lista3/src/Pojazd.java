/**
 * Class represents vehicle
 * @author Piotr Palus
 * 18.11.2015
 */
public abstract class Pojazd
{
    double maxV;
    double heightMax;
    double upkeepKm;
    double upkeepH;
    int id;

    /**
     * Abstract method
     * @param km
     *          Amount of driven/flown kilometers
     * @param hours
     *          Amount of driven/flown hours
     */
    public abstract double upkeep(double km, double hours);

}
