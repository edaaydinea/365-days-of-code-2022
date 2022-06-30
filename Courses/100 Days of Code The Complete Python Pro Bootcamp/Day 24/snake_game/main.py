import time
from turtle import Screen

from food import Food
from scoreboard import ScoreBoard
from snake import Snake


class MainProgram:

    def __init__(self):
        self.snake_screen = Screen()
        self.game_is_on = True

    def start_screen(self):
        self.snake_screen.setup(width=600, height=600)
        self.snake_screen.bgcolor("black")
        self.snake_screen.title("My Snake Game")
        self.snake_screen.tracer(0)

    def start_game(self):
        snake = Snake()
        food = Food()
        scoreboard = ScoreBoard()
        self.snake_screen.listen()
        self.snake_screen.onkey(snake.up, "Up")
        self.snake_screen.onkey(snake.down, "Down")
        self.snake_screen.onkey(snake.left, "Left")
        self.snake_screen.onkey(snake.right, "Right")

        while self.game_is_on:
            self.snake_screen.update()
            time.sleep(0.1)

            snake.move_snake()

            # Detect collision with food
            if snake.head.distance(food) < 15:
                food.refresh()
                snake.extend()
                scoreboard.increase_score()

            # Detect collision with the wall
            if snake.head.xcor() > 280 or snake.head.xcor() < -280 or snake.head.ycor() > 280 or snake.head.ycor() < -280:
                scoreboard.reset()
                snake.reset()

            # Detect collision with tail
            """
            if head collides with any segment in the tail:
                trigger game_over
            """
            for segment in snake.segments[1:]:
                if segment == snake.head:
                    pass
                elif snake.head.distance(segment) < 10:  # collision
                    scoreboard.reset()
                    snake.reset()

    def exit_screen(self):
        self.snake_screen.exitonclick()


if __name__ == "__main__":
    new_program = MainProgram()
    new_program.start_screen()
    new_program.start_game()
    new_program.exit_screen()
