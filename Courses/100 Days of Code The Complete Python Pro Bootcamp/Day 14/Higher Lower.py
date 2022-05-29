import random

from replit import clear

from art import logo, vs
from game_data import data


# Generate a random account from the game data.
def get_random_account():
    return random.choice(data)


# Format account data into printable format.
def format_data(account):
    name = account["name"]
    description = account["description"]
    country = account["country"]

    return "{}, a {}, from {}".format(name, description, country)


# Check if user is correct.
## Get follower count.
## If Statement

def check_answer(guess, a_followers, b_followers):
    if a_followers > b_followers:
        return guess == "a"
    else:
        return guess == "b"


def game():
    print(logo)
    score = 0
    game_should_continue = True
    account_a = get_random_account()
    account_b = get_random_account()

    while game_should_continue:
        account_a = account_b
        account_b = get_random_account()

        while account_a == account_b:
            account_b = get_random_account()

        print("Compare A: {}".format(account_a))
        print(vs)
        print("Against B: {}".format(account_b))

        guess = input("Who has more followers? Type 'A' or 'B':").lower()
        a_followers_count = account_a["follower_count"]
        b_followers_count = account_b["follower_count"]
        is_correct = check_answer(guess, a_followers_count, b_followers_count)

        clear()
        print(logo)
        if is_correct:
            score += 1
            print(f"You're right! Current score: {score}.")
        else:
            game_should_continue = False
            print(f"Sorry, that's wrong. Final score: {score}")

    game()
