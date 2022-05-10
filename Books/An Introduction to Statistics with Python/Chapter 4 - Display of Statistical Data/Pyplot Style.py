# Import the required packages, with their conventional names
import matplotlib.pyplot as plt
import numpy as np

# Generate the data
x = np.arange(start=0, stop=10, step=0.2)
y = np.sin(x)

# Generate the plot
plt.plot(x, y)

# Display it on the screen
plt.savefig("Pyplot Style.png", bbox_inches='tight')

# %%
