import random
import time
import turtle
from turtle import Turtle, Screen

import features
import menu

turtle.colormode(255)


def show_screen(option):
    screen = Screen()
    if option in range(1, menu.exit_number):
        time.sleep(4)
        screen.clear()
    if option == 4:
        screen.bye()


class TimmyTurtle:
    def __init__(self):
        self.timmy_the_turtle = Turtle()

    def changing_features(self):
        shape = input("Enter the shape -  ({}):".format(features.get_items("main_shape"))).lower()
        color = input("Enter the color of the shape -  ({}):".format(features.get_items("main_color"))).lower()
        self.timmy_the_turtle.shape(shape)
        self.timmy_the_turtle.color(color)
        print("You can see the result for 4 seconds.")

    def drawing_square(self):
        side = int(input("Enter the length of the side of the Square: "))
        for _ in range(4):
            self.timmy_the_turtle.forward(side)
            self.timmy_the_turtle.left(90)
        print("You can see the result for 4 seconds.")

    def drawing_dashed_line(self):
        for _ in range(15):
            self.timmy_the_turtle.forward(10)
            self.timmy_the_turtle.penup()
            self.timmy_the_turtle.forward(10)
            self.timmy_the_turtle.pendown()
        print("You can see the result for 4 seconds.")

    def draw_shape(self, num_sides):
        angle = 360 / num_sides
        for _ in range(num_sides):
            self.timmy_the_turtle.forward(100)
            self.timmy_the_turtle.right(angle)

    def drawing_shapes(self):
        for shape_side_n in range(3, 10):
            self.timmy_the_turtle.color(random.choice(features.different_colors))
            self.draw_shape(shape_side_n)

    def drawing_random_walk(self):
        for _ in range(200):
            self.timmy_the_turtle.pensize(15)
            self.timmy_the_turtle.speed("fastest")
            self.timmy_the_turtle.color(features.random_color())
            self.timmy_the_turtle.forward(30)
            self.timmy_the_turtle.seth(random.choice(features.directions))

    def drawing_spirograph(self):
        size_of_gap = int(input("Enter the size of gap:"))
        for _ in range(int(360 / size_of_gap)):
            self.timmy_the_turtle.color(features.random_color())
            self.timmy_the_turtle.circle(100)
            self.timmy_the_turtle.setheading(self.timmy_the_turtle.heading() + size_of_gap)


if __name__ == "__main__":

    while True:
        choice = menu.menu()
        features.get_items(choice)
        if choice == 1:
            turtle = TimmyTurtle()
            turtle.changing_features()
            show_screen(choice)
        elif choice == 2:
            turtle = TimmyTurtle()
            turtle.drawing_square()
            show_screen(choice)
        elif choice == 3:
            turtle = TimmyTurtle()
            turtle.drawing_dashed_line()
            show_screen(choice)
        elif choice == 4:
            turtle = TimmyTurtle()
            turtle.drawing_shapes()
            show_screen(choice)
        elif choice == 5:
            turtle = TimmyTurtle()
            turtle.drawing_random_walk()
            show_screen(choice)
        elif choice == 6:
            turtle = TimmyTurtle()
            turtle.drawing_spirograph()
            show_screen(choice)
        elif choice == 7:
            answer = menu.continue_or_not()
            if answer == "no":
                continue
            elif answer == "yes":
                print("See you later. Goodbye.")
                break
