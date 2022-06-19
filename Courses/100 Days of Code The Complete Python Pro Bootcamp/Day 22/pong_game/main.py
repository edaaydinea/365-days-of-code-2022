import time
from turtle import Screen

from ball import Ball
from paddle import Paddle
from scoreboard import ScoreBoard


class MainProgram:

    def __init__(self):
        self.pong_screen = Screen()
        self.game_is_on = True

    def start_screen(self):
        self.pong_screen.setup(width=800, height=600)
        self.pong_screen.bgcolor("black")
        self.pong_screen.title("My Pong Game")
        self.pong_screen.tracer(0)

    def start_game(self):
        r_paddle = Paddle((350, 0))
        l_paddle = Paddle((-350, 0))
        ball = Ball()
        scoreboard = ScoreBoard()
        self.pong_screen.listen()
        self.pong_screen.onkey(r_paddle.go_up, "Up")
        self.pong_screen.onkey(r_paddle.go_down, "Down")
        self.pong_screen.onkey(l_paddle.go_up, "w")
        self.pong_screen.onkey(l_paddle.go_down, "s")

        while self.game_is_on:
            time.sleep(ball.move_speed)
            self.pong_screen.update()
            ball.move()

            # Detect collision with wall and bounce
            if ball.ycor() > 280 or ball.ycor() < -280:
                # needs to bounce
                ball.bounce_y()

            # Detect collision with paddle
            if ball.distance(r_paddle) < 50 and ball.xcor() > 320 or \
                    ball.distance(l_paddle) < 50 and ball.xcor() < -320:
                ball.bounce_x()

            # Detect when right paddle misses
            if ball.xcor() > 380:
                ball.reset_position()
                scoreboard.l_point()

            # Detect when left paddle misses
            if ball.xcor() < -380:
                ball.reset_position()
                scoreboard.r_point()

    def exit_screen(self):
        self.pong_screen.exitonclick()


if __name__ == '__main__':
    new_program = MainProgram()
    new_program.start_screen()
    new_program.start_game()
    new_program.exit_screen()
