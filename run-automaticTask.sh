#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.TCP.AutomaticTask/target/base.TCP.AutomaticTask-1.3.0-SNAPSHOT.jar:base.TCP.AutomaticTask/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP TCPSERVER.TcpSrvAutomaticTask

