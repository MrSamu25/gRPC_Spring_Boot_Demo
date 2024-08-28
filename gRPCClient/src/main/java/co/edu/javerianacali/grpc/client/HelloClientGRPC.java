package co.edu.javerianacali.grpc.client;

import co.edu.javerianacali.lib.hello.HelloRequest;
import co.edu.javerianacali.lib.hello.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloClientGRPC {

    @GrpcClient("myClient")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String receiveGreeting(String title, String description, String url) {

        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setTitle(title)
                .setDescription(description)
                .setUrl(url)
                .build();

        return helloServiceBlockingStub.hello(helloRequest).getGreeting();
    }
}
