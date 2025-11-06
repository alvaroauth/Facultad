package ejercicio18;

import java.util.HashSet;
import java.util.Set;

public class EvenNumberSet extends HashSet<Integer>{

    @Override
    public boolean add(Integer number){
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }
}
