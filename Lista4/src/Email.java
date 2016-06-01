import java.util.*;

/**
 * Class represents set of unique e-mails
 * @author Piotr Palus
 * 02.12.2015
 */
public class Email
{
    Set<String> set=new HashSet<String>();

    /**
     * Adds e-mail to the set
     * @param email
     *          Chosen e-mail to add
     */
    public void add_new_email(String email)
    {
        set.add(email);
    }

    /**
     * Removes e-mail from the set, if it exists
     * @param email
     *          Chosen e-mail to remove
     */
    public void remove_email(String email)
    {
        if(set.contains(email)) set.remove(email);
    }

    /**
     * Checks if chosen e-mail exists in the set
     * @param email
     *          Chosen e-mail
     * @return true/false
     *          Exists in the set/Doesn't exist in the set
     *
     */
    public boolean check_if_email_exists(String email)
    {
        if(set.contains(email)) return true;
        else return false;
    }



}
