import random
from turtle import Turtle, Screen


class NinjaTurtlesRace:

    def __init__(self):
        self.user_bet = None
        self.turtle_screen = Screen()
        self.y_positions = [-70, -40, -10, 20, 50, 80]
        self.colors = ["red", "orange", "yellow", "green", "blue", "purple"]
        self.is_race_on = False
        self.all_turtles = []

    def screen(self):
        self.turtle_screen.setup(width=500, height=400)
        self.user_bet = self.turtle_screen.textinput(title="Make your bet",
                                                     prompt="Which turtle will win the race? Enter a color: ")

        if self.user_bet:
            self.is_race_on = True

    def create_turtles(self):
        for turtle_index in range(0, 6):
            turtle = Turtle(shape="turtle")
            turtle.color(self.colors[turtle_index])
            turtle.penup()
            turtle.goto(x=-230, y=self.y_positions[turtle_index])
            self.all_turtles.append(turtle)

    def turtles_race(self):
        while self.is_race_on:
            for turtle in self.all_turtles:
                if turtle.xcor() > 230:
                    self.is_race_on = False
                    winning_color = turtle.pencolor()
                    if winning_color == self.user_bet:
                        print("You've won! The {} turtle is the winner".format(winning_color))
                    else:
                        print("You've lost! The {} turtle is the winner".format(winning_color))
                rand_distance = random.randint(0, 10)
                turtle.forward(rand_distance)

    def exit_screen(self):
        self.turtle_screen.exitonclick()


if __name__ == "__main__":
    new_turtle = NinjaTurtlesRace()
    new_turtle.screen()
    new_turtle.create_turtles()
    new_turtle.turtles_race()
    new_turtle.exit_screen()
