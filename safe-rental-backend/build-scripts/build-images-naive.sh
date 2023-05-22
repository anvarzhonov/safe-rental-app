#!/bin/bash

function build_basic() {
    JAR_FILE=$1
    APP_NAME=$2

    docker build -f ./build-scripts/docker/basic/Dockerfile \
    --build-arg JAR_FILE="${JAR_FILE}" \
    -t "${APP_NAME}":latest \
    -t "${APP_NAME}":naive .
}

APP_VERSION=0.0.1-SNAPSHOT

cd ..

echo "Building JAR files"
mvn clean package -DskipTests

echo "Building Docker images"
build_basic ./eureka-server/target/eureka-server-${APP_VERSION}.jar application eureka-server