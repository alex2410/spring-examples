package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

class Service2 {

    @Autowired
    @C2
    private List<String> values;

    public void print() {
        values.forEach(System.out::println);
    }
}
