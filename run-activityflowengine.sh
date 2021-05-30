#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies

export BASE_CP=base.core/target/base.core-1.3.0-SNAPSHOT.jar;base.core/target/dependency/*

#REM call the java VM, e.g,
# eapli.base.app.backoffice.console.BaseBackoffice
java -cp $BASE_CP eapli.base/Dashboardmanagement.TCPSrvMFA
