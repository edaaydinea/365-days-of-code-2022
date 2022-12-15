import pandas as pd

# Challenge 1

df = pd.read_csv("Squirrel_Data.csv")

# Get all the necessary information
df_new1 = df.value_counts(["Primary Fur Color"], sort=True).reset_index(name="Count")

# Change the column name
df_new1.rename(columns={"Primary Fur Color": "Fur Color"}, inplace=True)
df_new1.to_csv("squirrel_count.csv")
