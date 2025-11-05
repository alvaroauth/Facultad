package ejercicio25;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bag<T> extends AbstractCollection<T> implements IBag<T> {
    Map<T, Integer> bolsa = new HashMap<>();

    @Override
    public boolean add(T element) {
        if (this.bolsa.containsKey(element))
            this.bolsa.put(element, this.bolsa.get(element) + 1);
        else
            this.bolsa.put(element, 1);
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        return this.bolsa.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        if (this.bolsa.containsKey(element)){
            if(this.bolsa.get(element) > 1)
                this.bolsa.put(element, this.bolsa.get(element) - 1);
            else
                this.bolsa.remove(element);
        }
    }

    @Override
    public void removeAll(T element) {
        if (this.bolsa.containsKey(element))
            this.bolsa.remove(element);
    }

    @Override
    public int size() {
        return this.bolsa.entrySet().stream()
                .mapToInt(t -> occurrencesOf(t.getKey())).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> iterador = bolsa.entrySet().iterator();
            private int elementosRestantes;
            private Map.Entry<T, Integer> act;

            @Override
            public boolean hasNext() {
                return ((elementosRestantes > 0) || (iterador.hasNext()));
            }

            @Override
            public T next() {
                if (elementosRestantes == 0) {
                    act = iterador.next();
                    elementosRestantes = act.getValue();
                }
                elementosRestantes = elementosRestantes - 1;
                return act.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(act.getKey());
            }
        };
    }
}
