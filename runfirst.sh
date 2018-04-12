#!/bin/sh

rm -rf $HOME/.ivy2 ivy-cache

sbt update

cp -r $HOME/.ivy2 ivy-cache