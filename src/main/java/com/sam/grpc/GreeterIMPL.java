/**
 * 
 */
package com.sam.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sam.gen.proto.GreeterGrpc.GreeterImplBase;
import com.sam.gen.proto.HelloReply;
import com.sam.gen.proto.HelloRequest;
import io.grpc.stub.StreamObserver;

@GRpcService
public class GreeterIMPL extends GreeterImplBase {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(GreeterIMPL.class);

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		LOGGER.info("server received {}", request);
	    String message = "Hello " + request.getName() +"!";
	    HelloReply helloReply = HelloReply.newBuilder().setReply(message).build();
	    LOGGER.info("server responded {}", helloReply);
	    responseObserver.onNext(helloReply);
	    responseObserver.onCompleted();
	}
	
}
