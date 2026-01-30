plugins {
    id("java-library")
    id("com.google.protobuf")
}

dependencies {
    api("io.grpc:grpc-protobuf:${property("grpcVersion")}")
    api("io.grpc:grpc-stub:${property("grpcVersion")}")
    api("com.google.protobuf:protobuf-java:${property("protobufVersion")}")

    // Required for @Generated annotation
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${property("protobufVersion")}"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${property("grpcVersion")}"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs(
                "build/generated/source/proto/main/java",
                "build/generated/source/proto/main/grpc"
            )
        }
    }
}
