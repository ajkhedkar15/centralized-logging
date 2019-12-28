#!/bin/sh

docker_stop() {

  docker-compose down --remove-orphans
}

docker_stop
