import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EliudsEggs {
    public int eggCount(int number) {

        if(number == 0) {
            return 0;
        }

        List<String> eggs = new ArrayList<String>(
            Arrays.asList(Integer.toBinaryString(number).split(""))
        );
        
        return (int) eggs.stream().filter(b -> b.equals("1")).count();
    }
}
