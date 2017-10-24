package Design;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Observer {
    public static void main(String args[])
    {
        // Create objects for testing
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();

        // Pass the displays to Cricket data
        CricketData cricketData = new CricketData();
        cricketData.subcribe(averageScoreDisplay);
        cricketData.subcribe(currentScoreDisplay);

        // In real app you would have some logic to call this
        // function when data changes
        cricketData.dataChanged();

        cricketData.unsubcribe(currentScoreDisplay);

        cricketData.dataChanged();

    }
}
interface MyObserver{
    public void update(CricketData cricketData);
}

class CricketData
{
    int runs, wickets;
    float overs;
    CurrentScoreDisplay currentScoreDisplay;
    AverageScoreDisplay averageScoreDisplay;
    List<MyObserver> list = new LinkedList<>();


    // Constructor
    public CricketData()
    {

    }
    public void subcribe(MyObserver observer){
        list.add(observer);
    }
    public void unsubcribe(MyObserver observer){
        list.remove(observer);
    }
    // Get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return new Random().nextInt();
    }

    // Get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return new Random().nextInt();
    }

    // Get latest overs from stadium
    private float getLatestOvers()
    {
        // return 10.2 for simplicity
        return (float)(new Random().nextInt() / new Random().nextInt());
    }

    // This method is used update displays when data changes
    public void dataChanged()
    {
        // get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        for(MyObserver ob : list){
            ob.update(this);
        }
    }
}

// A class to display average score. Data of this class is
// updated by CricketData
class AverageScoreDisplay implements MyObserver {
    private float runRate;
    private int predictedScore;

    public void update(CricketData cricketData)
    {
        this.runRate = (float)cricketData.runs/cricketData.overs;
        this.predictedScore = (int) (this.runRate * 50);
        display();
    }

    public void display()
    {
        System.out.println("\nAverage Score Display:\n" +
                "Run Rate: " + runRate +
                "\nPredictedScore: " + predictedScore);
    }
}

// A class to display score. Data of this class is
// updated by CricketData
class CurrentScoreDisplay implements MyObserver {
    private int runs, wickets;
    private float overs;

    public void update(CricketData cricketData)
    {
        this.runs = cricketData.runs;
        this.wickets = cricketData.wickets;
        this.overs = cricketData.overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display: \n" +
                "Runs: " + runs +"\nWickets:"
                + wickets + "\nOvers: " + overs );
    }
}