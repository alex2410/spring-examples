package qualifiers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config2 {

    @Bean
    @C2
    public List<String> messages() {
        List<String> messages = new ArrayList<>();
        messages.add("config 2 str1");
        messages.add("config 2 str2");
        return messages;
    }

}
