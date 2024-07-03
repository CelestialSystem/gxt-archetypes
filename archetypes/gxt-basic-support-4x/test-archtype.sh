#!/bin/sh
# Test import archetype

mvn clean
mkdir target
mkdir target/test
cd target/test

mvn archetype:generate -DarchetypeGroupId=com.sencha.gxt.archetypes \
-DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots \
-DarchetypeArtifactId=gxt-basic-support-4x-archetype \
-DarchetypeVersion=1.1-SNAPSHOT \
-DgroupId=com.projectname.project \
-DartifactId=new-project-name \
-DinteractiveMode=false
