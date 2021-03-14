#!/bin/bash
TARGET_DIRECTORY="target"
if [ -d "$TARGET_DIRECTORY" ]; then
  # target directory exists
  cd $TARGET_DIRECTORY
  java -jar --enable-preview leetcode-test-1.0-SNAPSHOT-jar-with-dependencies.jar
else
  # no directory
  echo "Directory: ${TARGET_DIRECTORY} not exists, build project before run"
fi