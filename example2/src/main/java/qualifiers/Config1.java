package qualifiers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean
    @C1
    public String str1() {
        return "config1 str1";
    }

    @Bean
    @C1
    public String str3() {
        return "config1 str3";
    }

    @Bean
    @C1
    public String str2() {
        return "config1 str2";
    }
}
