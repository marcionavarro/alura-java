#!/usr/bin/env bash

if [ ! -d node_modules/.bin ]; then
  npm install
fi

npm start
