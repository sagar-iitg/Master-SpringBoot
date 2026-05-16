package deadlock_java_demo.runner;

import deadlock_java_demo.service.DeadlockService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DeadlockRunner {

    private final DeadlockService service;

    public DeadlockRunner(
            DeadlockService service
    ) {
        this.service = service;
    }

    @PostConstruct
    public void run()
            throws Exception {

        Thread.sleep(2000);

        Thread t1 =
                new Thread(service::transactionA);

        Thread t2 =
                new Thread(service::transactionB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "\nFinished"
        );
    }
}