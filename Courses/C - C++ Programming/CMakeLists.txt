cmake_minimum_required(VERSION 3.21)
project(C___C___Programming C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(C___C___Programming
        "Section 1.1/add2.c"
        "Section 1.1/add3.c"
        "Section 1.1/circle.c"
        "Section 1.1/Marathon.c" "Section 1.1/FahrenheitToCelsius.c" "Section 1.1/mistake.c" "Section 1.1/poem.c")
