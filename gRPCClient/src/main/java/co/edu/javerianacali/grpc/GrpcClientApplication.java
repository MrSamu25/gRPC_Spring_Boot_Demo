package co.edu.javerianacali.grpc;

import co.edu.javerianacali.grpc.client.HelloClientGRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GrpcClientApplication {

    @Autowired
    private HelloClientGRPC helloClientGRPC;

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String response = helloClientGRPC.receiveGreeting("Mr", "Samu", "www.samu.com");
        System.out.println(response);
    }

}
