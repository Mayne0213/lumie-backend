package com.lumie.grpc.tenant;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.2)",
    comments = "Source: lumie/tenant.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TenantServiceGrpc {

  private TenantServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "lumie.TenantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantRequest,
      com.lumie.grpc.tenant.TenantResponse> getGetTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTenant",
      requestType = com.lumie.grpc.tenant.GetTenantRequest.class,
      responseType = com.lumie.grpc.tenant.TenantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantRequest,
      com.lumie.grpc.tenant.TenantResponse> getGetTenantMethod() {
    io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantRequest, com.lumie.grpc.tenant.TenantResponse> getGetTenantMethod;
    if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
          TenantServiceGrpc.getGetTenantMethod = getGetTenantMethod =
              io.grpc.MethodDescriptor.<com.lumie.grpc.tenant.GetTenantRequest, com.lumie.grpc.tenant.TenantResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTenant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.GetTenantRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.TenantResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("GetTenant"))
              .build();
        }
      }
    }
    return getGetTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantBySlugRequest,
      com.lumie.grpc.tenant.TenantResponse> getGetTenantBySlugMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTenantBySlug",
      requestType = com.lumie.grpc.tenant.GetTenantBySlugRequest.class,
      responseType = com.lumie.grpc.tenant.TenantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantBySlugRequest,
      com.lumie.grpc.tenant.TenantResponse> getGetTenantBySlugMethod() {
    io.grpc.MethodDescriptor<com.lumie.grpc.tenant.GetTenantBySlugRequest, com.lumie.grpc.tenant.TenantResponse> getGetTenantBySlugMethod;
    if ((getGetTenantBySlugMethod = TenantServiceGrpc.getGetTenantBySlugMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getGetTenantBySlugMethod = TenantServiceGrpc.getGetTenantBySlugMethod) == null) {
          TenantServiceGrpc.getGetTenantBySlugMethod = getGetTenantBySlugMethod =
              io.grpc.MethodDescriptor.<com.lumie.grpc.tenant.GetTenantBySlugRequest, com.lumie.grpc.tenant.TenantResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTenantBySlug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.GetTenantBySlugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.TenantResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("GetTenantBySlug"))
              .build();
        }
      }
    }
    return getGetTenantBySlugMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lumie.grpc.tenant.ValidateTenantRequest,
      com.lumie.grpc.tenant.ValidateTenantResponse> getValidateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateTenant",
      requestType = com.lumie.grpc.tenant.ValidateTenantRequest.class,
      responseType = com.lumie.grpc.tenant.ValidateTenantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lumie.grpc.tenant.ValidateTenantRequest,
      com.lumie.grpc.tenant.ValidateTenantResponse> getValidateTenantMethod() {
    io.grpc.MethodDescriptor<com.lumie.grpc.tenant.ValidateTenantRequest, com.lumie.grpc.tenant.ValidateTenantResponse> getValidateTenantMethod;
    if ((getValidateTenantMethod = TenantServiceGrpc.getValidateTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getValidateTenantMethod = TenantServiceGrpc.getValidateTenantMethod) == null) {
          TenantServiceGrpc.getValidateTenantMethod = getValidateTenantMethod =
              io.grpc.MethodDescriptor.<com.lumie.grpc.tenant.ValidateTenantRequest, com.lumie.grpc.tenant.ValidateTenantResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateTenant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.ValidateTenantRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lumie.grpc.tenant.ValidateTenantResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("ValidateTenant"))
              .build();
        }
      }
    }
    return getValidateTenantMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TenantServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TenantServiceStub>() {
        @java.lang.Override
        public TenantServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TenantServiceStub(channel, callOptions);
        }
      };
    return TenantServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TenantServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TenantServiceBlockingStub>() {
        @java.lang.Override
        public TenantServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TenantServiceBlockingStub(channel, callOptions);
        }
      };
    return TenantServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TenantServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TenantServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TenantServiceFutureStub>() {
        @java.lang.Override
        public TenantServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TenantServiceFutureStub(channel, callOptions);
        }
      };
    return TenantServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getTenant(com.lumie.grpc.tenant.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantMethod(), responseObserver);
    }

    /**
     */
    default void getTenantBySlug(com.lumie.grpc.tenant.GetTenantBySlugRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantBySlugMethod(), responseObserver);
    }

    /**
     */
    default void validateTenant(com.lumie.grpc.tenant.ValidateTenantRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.ValidateTenantResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTenantMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TenantService.
   */
  public static abstract class TenantServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TenantServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TenantService.
   */
  public static final class TenantServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TenantServiceStub> {
    private TenantServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTenant(com.lumie.grpc.tenant.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTenantBySlug(com.lumie.grpc.tenant.GetTenantBySlugRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantBySlugMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateTenant(com.lumie.grpc.tenant.ValidateTenantRequest request,
        io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.ValidateTenantResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTenantMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TenantService.
   */
  public static final class TenantServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TenantServiceBlockingStub> {
    private TenantServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lumie.grpc.tenant.TenantResponse getTenant(com.lumie.grpc.tenant.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lumie.grpc.tenant.TenantResponse getTenantBySlug(com.lumie.grpc.tenant.GetTenantBySlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lumie.grpc.tenant.ValidateTenantResponse validateTenant(com.lumie.grpc.tenant.ValidateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTenantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TenantService.
   */
  public static final class TenantServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TenantServiceFutureStub> {
    private TenantServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lumie.grpc.tenant.TenantResponse> getTenant(
        com.lumie.grpc.tenant.GetTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lumie.grpc.tenant.TenantResponse> getTenantBySlug(
        com.lumie.grpc.tenant.GetTenantBySlugRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantBySlugMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lumie.grpc.tenant.ValidateTenantResponse> validateTenant(
        com.lumie.grpc.tenant.ValidateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTenantMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TENANT = 0;
  private static final int METHODID_GET_TENANT_BY_SLUG = 1;
  private static final int METHODID_VALIDATE_TENANT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TENANT:
          serviceImpl.getTenant((com.lumie.grpc.tenant.GetTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse>) responseObserver);
          break;
        case METHODID_GET_TENANT_BY_SLUG:
          serviceImpl.getTenantBySlug((com.lumie.grpc.tenant.GetTenantBySlugRequest) request,
              (io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.TenantResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TENANT:
          serviceImpl.validateTenant((com.lumie.grpc.tenant.ValidateTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.lumie.grpc.tenant.ValidateTenantResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetTenantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lumie.grpc.tenant.GetTenantRequest,
              com.lumie.grpc.tenant.TenantResponse>(
                service, METHODID_GET_TENANT)))
        .addMethod(
          getGetTenantBySlugMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lumie.grpc.tenant.GetTenantBySlugRequest,
              com.lumie.grpc.tenant.TenantResponse>(
                service, METHODID_GET_TENANT_BY_SLUG)))
        .addMethod(
          getValidateTenantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lumie.grpc.tenant.ValidateTenantRequest,
              com.lumie.grpc.tenant.ValidateTenantResponse>(
                service, METHODID_VALIDATE_TENANT)))
        .build();
  }

  private static abstract class TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TenantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lumie.grpc.tenant.TenantProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TenantService");
    }
  }

  private static final class TenantServiceFileDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier {
    TenantServiceFileDescriptorSupplier() {}
  }

  private static final class TenantServiceMethodDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TenantServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TenantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TenantServiceFileDescriptorSupplier())
              .addMethod(getGetTenantMethod())
              .addMethod(getGetTenantBySlugMethod())
              .addMethod(getValidateTenantMethod())
              .build();
        }
      }
    }
    return result;
  }
}
