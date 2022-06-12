from turtle import Turtle, Screen


class EtchASketch:

    def __init__(self):
        self.timmy_the_turtle = Turtle()
        self.turtle_screen = Screen()

    def move_forwards(self):
        return self.timmy_the_turtle.forward(10)

    def move_backwards(self):
        return self.timmy_the_turtle.backward(10)

    def turn_left(self):
        new_heading = self.timmy_the_turtle.heading() + 10
        return self.timmy_the_turtle.setheading(new_heading)

    def turn_right(self):
        new_heading = self.timmy_the_turtle.heading() - 10
        return self.timmy_the_turtle.setheading(new_heading)

    def clear(self):
        self.timmy_the_turtle.clear()

    def screen(self):
        self.turtle_screen.listen()
        self.turtle_screen.onkey(sketch.move_forwards, "w")
        self.turtle_screen.onkey(sketch.move_backwards, "s")
        self.turtle_screen.onkey(sketch.turn_left, "a")
        self.turtle_screen.onkey(sketch.turn_right, "d")
        self.turtle_screen.exitonclick()


if __name__ == "__main__":
    sketch = EtchASketch()
    sketch.screen()
    sketch.clear()

