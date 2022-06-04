import features

exit_number = 7


def menu():
    print("Menu:")
    print("     0. Menu")
    print("     1. Change features")
    print("     2. Draw a square")
    print("     3. Draw a dashed line")
    print("     4. Draw different shapes ({}) ".format(features.get_items("different_shape")))
    print("     5. Draw a random walk")
    print("     6. Draw a Spirograph")
    print("     7. Exit")

    access = int(input("Make a selection from above list: "))

    if access in range(1, exit_number):
        return access
    elif access == 0:
        print("Here is the menu: ")
        return access
    else:
        print("You entered the wrong number! Please try again.")
        return access


def continue_or_not():
    answer = input("Are you sure? : -  {}".format(features.get_items("option"))).lower()
    if answer == features.options[0]:
        menu()
        return answer
    elif answer == features.options[1]:
        return answer
