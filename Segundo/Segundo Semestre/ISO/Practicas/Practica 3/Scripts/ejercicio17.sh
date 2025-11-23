#!/bin/bash
echo `ls` | tr 'a-zA-Z' 'A-Za-z' | tr -d 'a' | tr -d 'A'
