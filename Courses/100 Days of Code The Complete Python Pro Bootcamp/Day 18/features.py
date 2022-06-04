import random

main_shapes = ["square", "arrow", "circle", "turtle", "triangle", "classic"]
main_colors = ["red", "blue", "green"]
options = ["no", "yes"]

different_colors = ["CornflowerBlue", "DarkOrchid", "IndianRed", "DeepSkyBlue",
                    "LightSeaGreen", "wheat", "SlateGray", "SeaGreen"]

different_shapes = ["triangle", "square", "pentagon", "hexagon",
                    "heptagon", "octagon", "nonagon", "decagon"]

directions = [0, 90, 180, 270]


def get_items(type):
    """Get the items"""

    shape_items = ""
    color_items = ""
    option_items = ""
    different_color_items = ""
    different_shape_items = ""

    if type == "main_shape":
        for item in main_shapes:
            shape_items += f"{item}/"
        return shape_items
    elif type == "main_color":
        for item in main_colors:
            color_items += f"{item}/"
        return color_items
    elif type == "option":
        for item in options:
            option_items += f"{item}/"
        return option_items
    elif type == "different_color":
        for item in different_colors:
            different_color_items += f"{item}/"
        return different_color_items
    elif type == "different_shape":
        for item in different_shapes:
            different_shape_items += f"{item}/"
        return different_shape_items


def random_color():
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)

    random_color = (r, g, b)
    return random_color
