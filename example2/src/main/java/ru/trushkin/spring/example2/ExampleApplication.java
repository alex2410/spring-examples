package ru.trushkin.spring.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.trushkin.spring.example2.app.Quoter;

public class ExampleApplication {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Quoter quoter = ctx.getBean(Quoter.class);
        while (true) {
            Thread.sleep(1000);
            quoter.sayQuote();
        }

    /*    Service2 service2 = ctx.getBean(Service2.class);
        System.out.println(service2.text());
        System.out.println(service2.text2());

        service2 = BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx, Service2.class, "impl2");
        System.out.println(service2.text());
        System.out.println(service2.text2());

          Service1 service1 = ctx.getBean(Service1.class);
        System.out.println(service1.text());*/
    }

}
