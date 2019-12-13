#bin/sh
mkdir part_two
mkdir part_two/project
mkdir part_two/project/lib
mkdir part_two/project/include
mkdir part_two/project/src
mv ./talker.h part_two/project/include
mv ./main.cpp part_two/project/src
mv ./talker.cpp part_two/project/src
cd part_two/project/src
g++ main.cpp
./a.out

