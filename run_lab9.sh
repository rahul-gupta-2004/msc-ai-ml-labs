#!/bin/bash

# Setup JAVA_HOME if not present
export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"

# Run the project using exec:exec which reliably forks a new Java process with the correct classpath
./apache-maven-3.9.6/bin/mvn clean compile exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath sem_2.java_lab.labs.lab_9.Main"
