import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 * Class represents data base of films
 * @author Piotr Palus
 * 12.01.2016
 */

public class Table
{
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="*****************";




    /**
     * Adds film to the data base
     * @param f
     *          Object of Film class
     */
    public void addFilm(Film f)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            java.sql.PreparedStatement pst=null;
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) System.out.println("Connected");
            String sql ="INSERT INTO sakila.films (Title,Rating,RatingNumber) VALUES(?,?,?)";
            pst=conn.prepareStatement(sql);


            pst.setString(1,f.title);
            pst.setFloat(2,f.rating);
            pst.setInt(3,f.ratingNumber);

            pst.executeUpdate();

        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Driver problem");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Removes film from data base
     * @param f
     *          Object of Film class
     */
    public void deleteFilm(Film f)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            java.sql.PreparedStatement pst=null;
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) System.out.println("Connected");
            String sql ="DELETE FROM sakila.films WHERE Title ='"+f.title+"';";
            pst=conn.prepareStatement(sql);

            pst.executeUpdate();

        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Driver problem");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Changes title of chosen film
     * @param f
     *          Object of Film class
     * @param title
     *          New title
     */
    public void editFilm(Film f, String title)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            java.sql.PreparedStatement pst=null;
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) System.out.println("Connected");
            String sql ="UPDATE sakila.films SET Title='"+title+"' WHERE Title='"+f.title+"';";
            pst=conn.prepareStatement(sql);

            pst.executeUpdate();

            f.title=title;

        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Driver problem");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Adds rating to chosen films
     * @param f
     *          Object of Film class
     * @param rate
     *          Rating to add
     */
    public void addRating(Film f, int rate)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement st1 = null;
            Statement st2 = null;
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) System.out.println("Connected");
            String sql = "SELECT Rating FROM sakila.films WHERE Title='" + f.title + "';";
            st1 = conn.createStatement();
            st2 = conn.createStatement();
            String sql2 = "SELECT RatingNumber FROM sakila.films WHERE Title='" + f.title + "';";
            ResultSet rst = st1.executeQuery(sql);
            ResultSet rs = st2.executeQuery(sql2);

            float rating;
            int number;

            if (rst.next())
            {
                rating = rst.getFloat("Rating");

                if (rs.next())
                {
                    number = rs.getInt("RatingNumber");

                    float suma = rating * number;
                    System.out.println(suma);
                    float niu = (suma + rate) / number + 1;
                    System.out.println(niu);

                    String sql3 = "UPDATE sakila.films SET Rating="+niu+" WHERE Title='"+f.title+"';";
                    String sql4 = "UPDATE sakila.films SET RatingNumber=" +(number +1)+ " WHERE Title='"+f.title+"';";

                    java.sql.PreparedStatement pst = null;
                    pst = conn.prepareStatement(sql3);
                    pst.executeUpdate();
                    pst = conn.prepareStatement(sql4);
                    pst.executeUpdate();

                    f.rating = niu;
                    f.ratingNumber++;
                }


            }

        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Driver problem");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Displays the data base
     */
    public void displayDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();
            String query = "SELECT * FROM sakila.films";
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (rs.next())
            {
                for (int i = 1; i <= columnsNumber; i++)
                {
                    System.out.print(rs.getString(i) + " ");
                }

                System.out.println();
            }
        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Driver problem");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }


    /**
     * Testing
     */
    public static void main(String[] args)
    {
        Film f=new Film("Incepcja",9,110);
        Film n=new Film("Masz wiadomosc",10,1);

        Table table=new Table();
        table.displayDB();
    }


}

