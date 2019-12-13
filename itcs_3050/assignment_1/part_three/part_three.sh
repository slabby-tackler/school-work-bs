#bin/sh
cd project/src
g++ -c -fPIC talker.cpp
g++ -shared talker.o -o libtalker.so
mv libtalker.so ../lib
g++ main.cpp
./a.out

