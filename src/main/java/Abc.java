import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Abc extends JFrame {
    private static final long serialVersionUID = 1L;
    public static Point[] points;
    public static ArrayList<String> list,list_1;
    public static ArrayList<String> buslist;
    public Abc() throws HeadlessException {

    }
    private static void fetchDataFromStart() throws IOException {
        Path path;
        list=new ArrayList<>();
        path= Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/StartPoint.txt");
        var s=  Files.readAllLines(path);
        list= (ArrayList<String>) s;
    }
    private static void fetchDataFromDestination() throws IOException {
        Path path;
        list_1=new ArrayList<>();
        path= Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/DestPoint.txt");
        var s=  Files.readAllLines(path);
        list_1= (ArrayList<String>) s;
    }
    private static void fetchDataFromBusList() throws IOException {
        Path path;
        buslist=new ArrayList<>();
        path= Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/BusName.txt");
        var s=  Files.readAllLines(path);
        buslist= (ArrayList<String>) s;
    }
    static void Example1stConstructor()
    {
        // Creating an empty TreeMap
        TreeMap<Integer, String> tree_map
                = new TreeMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        tree_map.put(10, "Geeks");
        tree_map.put(15, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(25, "Welcomes");
        tree_map.put(30, "You");
        tree_map.put(30, "Dujoy");

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }
    public static void main(String[] args) throws IOException {
        fetchDataFromStart();
        fetchDataFromDestination();
        fetchDataFromBusList();
        points= new Point[list.size()];

//      System.out.println(Arrays.toString(Arrays.stream(points).toArray()));

        for (int i = 0; i < list.size(); i++) {
            points[i]=new Point();
            points[i].setStart(list.get(i));
            points[i].setDest(list_1.get(i));
            points[i].setBus(buslist.get(i));

        }
        var s=new Point();
        s.setStart("Dhour");
        s.setDest("Madanpur");
        for (int i = 0; i < points.length; i++)
            if ((points[i].getStart().equals(s.getStart()))&&(points[i].getDest().equals(s.getDest())))
               System.out.println(points[i].getBus());





    }

}
class Point{
    public String start;
    public String dest;
    public String bus;

    public Point() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Point{" +
                "Start='" + start + '\'' +
                ", Dest='" + dest + '\'' +
                ", Bus='" + bus + '\'' +
                '}';
    }
}

