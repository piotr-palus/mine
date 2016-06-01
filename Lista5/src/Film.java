/**
 * Class represents film
 * @author Piotr Palus
 * 12.01.2016
 */
public class Film
{
    String title="";
    float rating=0;
    int ratingNumber=0;

    /**
     * Constructor
     * @param title
     */
    public Film(String title)
    {
        this.title=title;
    }

    /**
     * Constructor
     * @param title
     * @param rating
     */
    public Film(String title, float rating)
    {
        this.title=title;
        this.rating=rating;

    }

    /**
     * Constructor
     * @param title
     * @param rating
     * @param ratingNumber
     */
    public Film(String title, float rating, int ratingNumber)
    {
        this.title=title;
        this.rating=rating;
        this.ratingNumber=ratingNumber;
    }
}
