#!/bin/sh

gradle_build() {

  ./gradlew clean build
}

docker_start() {

  docker-compose up -d --build --remove-orphans
}

gradle_build
docker_start
