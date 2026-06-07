#!/bin/sh
# OOP_Study — tüm kaynak dosyalarını derle
set -e
cd "$(dirname "$0")"
javac ch01/*.java ch02/*.java ch03/*.java ch04/*.java ch05/*.java ch06/*.java \
       ch07/*.java ch08/*.java ch09/*.java ch10/*.java ch11/*.java ch12/*.java \
       ch13/*.java vize_tekrar/*.java ornekler/*.java vize_ornekler/Book.java
echo "OK: tüm .java dosyaları derlendi."
