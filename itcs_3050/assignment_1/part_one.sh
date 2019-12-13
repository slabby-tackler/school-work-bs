#bin/sh
mkdir part_one
mv ./hello_world.cpp ./part_one/hello_world.cpp
cd part_one
g++ hello_world.cpp
./a.out
g++ hello_world.cpp -o hello_world
./hello_world

