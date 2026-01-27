#!/bin/bash
export JAVA_HOME=/run/host/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
unset JAVA_TOOL_OPTIONS
cd "/media/jaireth/Datos/Juls/Proyectos Personales/ToDo List/backend"
./gradlew clean build
