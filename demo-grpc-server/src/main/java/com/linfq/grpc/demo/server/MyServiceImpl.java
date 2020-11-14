package com.linfq.grpc.demo.server;

import com.linfq.grpc.demo.lib.HelloReply;
import com.linfq.grpc.demo.lib.HelloRequest;
import com.linfq.grpc.demo.lib.MyServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * MyServiceImpl.
 *
 * @author linfq
 * @date 2020/11/14 22:30
 */
@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

	@Override
	public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
		HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

}
