rootProject.name = "lumie-backend"

include(
    "libs:common",
    "libs:grpc-api",
    "libs:messaging",
    "services:platform:tenant-svc"
)
