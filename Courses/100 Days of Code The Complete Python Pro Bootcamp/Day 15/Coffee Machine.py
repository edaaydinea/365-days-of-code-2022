from menu import MENU
from resources import resources

profit = 0


def is_resource_sufficient(order_ingredients):
    """Return True when order can be made, False if ingredients are insufficent"""
    for item in order_ingredients:
        if order_ingredients[item] > resources[item]:
            print("Sorry there is not enough {}.".format(item))
            return False
        return True


def process_coins():
    """Returns the total calculated from coins inserted."""
    print("Please insert coins.")
    total = int(input("How many quarters?: ")) * 0.25
    total += int(input("How many dimes?: ")) * 0.1
    total += int(input("How many nickles?: ")) * 0.05
    total += int(input("How many pennies?: ")) * 0.01
    return total


def is_transaction_successful(money_receieved, drink_cost):
    """Return True when the patyment is accepted, or False if money is insufficient"""
    if money_receieved >= drink_cost:
        change = round(money_receieved - drink_cost, 2)
        print("Here is ${} in change.".format(change))
        global profit
        profit += drink_cost
        return True
    else:
        print("Sorry that's not enough money. Money refunded.")
        return False


def make_coffee(drink_name, order_ingredients):
    """Deduct the required ingredients from the resources."""
    for item in order_ingredients:
        resources[item] -= order_ingredients[item]
    print("Here is your {} ☕. Enjoy!".format(drink_name))


def machine_program():
    is_on = True

    while is_on:
        choice = input("What would you like? (espresso / latte / cappucino): ").lower()
        if choice == "off":
            is_on = False
        elif choice == "report":
            print("Water: {} ml".format(resources["water"]))
            print("Milk: {} ml".format(resources["milk"]))
            print("Coffee: {} g".format(resources["coffee"]))
            print("Money: ${}".format(profit))
        else:
            drink = MENU[choice]
            if is_resource_sufficient(drink["ingredients"]):
                payment = process_coins()
                if is_transaction_successful(payment, drink["cost"]):
                    make_coffee(choice, drink["ingredients"])


if __name__ == "__main__":
    machine_program()
