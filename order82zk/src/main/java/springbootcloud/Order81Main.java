package springbootcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Order81Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Order81Main.class,args);
    }
}
