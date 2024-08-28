package co.edu.javerianacali.grpc.server.service;

import co.edu.javerianacali.lib.hello.HelloRequest;
import co.edu.javerianacali.lib.hello.HelloResponse;
import co.edu.javerianacali.lib.hello.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcHelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest req, StreamObserver<HelloResponse> responseObserver) {

        String responseMessage = new StringBuilder()
                .append("Hello ")
                .append(req.getTitle())
                .append(" ")
                .append(req.getDescription())
                .append(", With URL=")
                .append(req.getUrl())
                .toString();

        HelloResponse reply = HelloResponse.newBuilder().setGreeting(responseMessage).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}