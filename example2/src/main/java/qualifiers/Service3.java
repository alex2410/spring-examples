package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

class Service3 {

    private Service1 service1;

    private Service2 service2;

    public Service3(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    public void print(){
        service1.print();
        service2.print();
    }
}
