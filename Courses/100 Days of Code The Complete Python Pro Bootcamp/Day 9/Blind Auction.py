from replit import clear

from art import logo

# HINT: You can call clear() to clear the output in the console.

print(logo)

bids = {}
bidding_finished = False


def find_highest_bidder(bidding_record):
    highest_bid = 0
    winner = ""

    for bidder in bidding_record:
        bid_amount = bidding_record[bidder]
        if bid_amount > highest_bid:
            highest_bid = bid_amount
            winner = bidder

    print("The winner is {} with a bind of ${}".format(winner, highest_bid))


while not bidding_finished:
    name = input("What is your name?: ")
    price = int(input("What is your bid?: $"))
    bids[name] = price
    continue_or_not = input("Are there any other bidders? Type 'yes' or 'no'. \n")
    if continue_or_not == "no":
        bidding_finished = True
        find_highest_bidder(bids)
    elif continue_or_not == "yes":
        clear()
