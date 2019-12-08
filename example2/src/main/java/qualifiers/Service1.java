package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Service1 {

    @Autowired
    @C1
    private List<String> values;

    public void print() {
        values.forEach(System.out::println);
    }
}
