# Import the required packages, with their conventional names
import matplotlib.pyplot as plt
import numpy as np

# Generate the data
x = np.arange(start=0, stop=10, step=0.2)
y = np.sin(x)

# Generate the plot
fig = plt.figure()
ax = fig.add_subplot(111)
ax.plot(x, y)

# Display it on the screen
fig.savefig("Generate the plot.png", bbox_inches='tight')

# %%
