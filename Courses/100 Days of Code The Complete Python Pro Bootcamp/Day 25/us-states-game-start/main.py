import turtle

import pandas as pd

# Change the title
screen = turtle.Screen()
screen.title("U.S. States Game")

# Change the shape as an image
image = "blank_states_img.gif"
screen.addshape(image)
turtle.shape(image)

# Read the dataframe
df = pd.read_csv("50_states.csv")
all_states = df.state.to_list()
guessed_states = []

while (len(guessed_states)) < 50:
    answer_state = screen.textinput(title="{}/50 States Correct".format(len(guessed_states)),
                                    prompt="What's another state's name?").title()

    if answer_state == "Exit":
        missing_states = []
        for state in all_states:
            if state not in guessed_states:
                missing_states.append(state)
        new_data = pd.DataFrame(missing_states)
        new_data.to_csv("stats_to_learn.csv")
        break
    if answer_state in all_states:
        guessed_states.append(answer_state)
        t = turtle.Turtle()
        t.hideturtle()
        t.penup()
        state_data = df[df.state == answer_state]
        t.goto(int(state_data.x), int(state_data.y))
        t.write(answer_state)
