"""
Interactive graphs with Matplotlib have haunted me. So here I have collected a number of
tricks that should make interactive use plots simpler. The functions below show how to

- Position figures on the screen (e.g top left half of display)
- Pause to display the plot, and proceed automatically after a few sec.
- Proceed on a click, or a keyboard hit
- Evaluate keyboard inputs
"""

import matplotlib.pyplot as plt
# Import standard packages
import numpy as np

# additional packages
try:
    import tkinter as tk
except:  # different capitalization in Python 2.x
    import Tkinter as tk

t = np.arange(start=0, stop=10, step=0.1)
c = np.cos(t)
s = np.sin(t)


def normalPlot():
    """
    Just shw a plot. Th program stops, and only continues when the plot is closed,
    either by hitting the "Window Close" button, or y typing "ALT + F4".
    :return: nothing
    """
    plt.plot(t, s)
    plt.title("Normal Plot: you have to close it to continue \n by clicking the "
              "'Window Close' button, or by hitting 'ALT + F4'")
    plt.show()


def positionOnScreen():
    """
    Position two plots on your screen. This uses the Tickle-backend which I think is the
    default on all platforms.
    :return: nothing
    """

    # Get the screen size
    root = tk.Tk()
    screen_w, screen_h = root.winfo_screenwidth(), root.winfo_screenheight()

    root.destroy()

    def positionFigure(figure, geometry):
        """
        :param figure: location of figure
        :param geometry:
        :return: nothing
        """
        mgr = figure.canvas.manager
        pos_x, pos_y, width, height = geometry
        try:
            # positioning commands for Tk
            position = '{0}x{1} + {2} + {3}'.format(width, height, pos_x, pos_y)
            mgr.window.geometry(position)
        except:
            # positioning commands for Qt5
            mgr.window.setGeometry(pos_x, pos_y, width, height)

    # The program continues after the first plot
    fig = plt.figure()
    ax = fig.add_subplot(111)
    ax.plot(t, c)
    ax.set_title("Top Left: Close this one last")

    # Position the first graph in the top-left half of the screen
    topLeft = (0, 0, screen_w // 2, screen_h // 2)
    positionFigure(fig, topLeft)

    # Put another graph in the top right half
    fig2 = plt.figure()
    ax2 = fig2.add_subplot(111)
    ax2.plot(t, s)
    ax2.set_title("Top Right: Close this one first (e.g. with ALT + F4)")

    topRight = (screen_w // 2, 0, screen_w // 2, screen_h // 2)
    positionFigure(fig2, topRight)

    plt.show()


def showAndPause():
    """
    Show a plot only for 2 seconds, and then proceed automatically
    :return: nothing
    """
    plt.plot(t, s)
    plt.title("Don't touch! I will proceed automatically")

    plt.show(block=False)
    duration = 2  # [sec]
    plt.pause(duration)
    plt.close()


def waitForInput():
    """
    This time, proceed with a click or by hitting any key to continue
    :return: nothing
    """
    plt.show(t, c)
    plt.title("Click in that window, or hit any key to continue")
    plt.waitforbuttonpress()
    plt.close()


def keySelection():
    """
    Wait for user input, and proceed depending on the key entered.
    This is a bit complex. But None of the versions I tried without key binding
    were completely stable.
    :return: nothing
    """
    fig, ax = plt.subplots()
    fig.canvas.mpl_connect("key_press_event", on_key_event)

    # Disable default Matplotlib shortcut keys:
    keymaps = [param for param in plt.rcParams if param.find("keymap") >= 0]
    for key in keymaps:
        plt.rcParams[key] = ""

    ax.plot(t, c)
    ax.set_title("First, enter a vowel:")
    plt.show()


def on_key_event(event):
    """
    Keyboard interaction
    :param event:
    :return:
    """

    key = event.key

    if key.find("alt") == 0:
        key = key.split("+")[1]

    curAxis = plt.gca()

    if key in "aeiou":
        curAxis.set_title("Well done!")
        plt.pause(1)
        plt.close()
    else:
        curAxis.set_title(key + "is not a vowel: try again to find a vowel ...")
        plt.draw()


if __name__ == '__main__':
    normalPlot()
    positionOnScreen()
    showAndPause()
    waitForInput()
    keySelection()
#%%
