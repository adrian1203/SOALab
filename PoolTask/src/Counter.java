import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class Counter {
    private static List<Integer> listOfClicks = new ArrayList<Integer>();

    public String getClicks(int index){
        if (listOfClicks.size() > index)
            return listOfClicks.get(index).toString();
        else
            return "0";
    }

    public void increment(int index){
        if (listOfClicks.size() > index)
            listOfClicks.set(index, listOfClicks.get(index)+1);
        else
            listOfClicks.add(1);
    }
}