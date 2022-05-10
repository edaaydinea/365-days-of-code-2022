# Import the required packages
import matplotlib.pyplot as plt
import numpy as np

# Generate the data
x = np.arange(start=0, stop=10, step=0.2)
y = np.sin(x)
z = np.cos(x)

# Generate the figure and the taxes
fig, axs = plt.subplots(nrows=2, ncols=1)

# On the first axis, plot the sine and label the ordinate
axs[0].plot(x, y)
axs[0].set_ylabel("Sine")

# On the second axis, plot the cosine
axs[1].plot(x, y)
axs[1].set_ylabel("Cosine")

# Display the resulting plot
# plt.show()
plt.savefig("Sine and Cosine.png", bbox_inches='tight')

# %%
