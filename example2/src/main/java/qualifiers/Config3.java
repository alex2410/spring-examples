package qualifiers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Config1.class, Config2.class})
public class Config3 {

    @Bean
    public Service2 service2() {
        return new Service2();
    }

    @Bean
    public Service1 service1() {
        return new Service1();
    }

    @Bean
    public Service3 service3(Service1 service1, Service2 service2) {
        return new Service3(service1, service2);
    }

}
