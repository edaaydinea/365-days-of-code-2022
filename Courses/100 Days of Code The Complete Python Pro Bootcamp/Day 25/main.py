# %% Challenge 1

with open("weather_data.csv") as data_file:
    data = data_file.readlines()
    print(data)

# %%

import csv

with open("weather_data.csv") as data_file:
    data = csv.reader(data_file)
    for row in data:
        print(row)

# %% Challenges 2

import csv

with open("weather_data.csv") as data_file:
    data = csv.reader(data_file)
    temperatures = []
    for row in data:
        if row[1] != "temp":
            temperatures.append(int(row[1]))

    print(temperatures)

# %%

import pandas as pd

df = pd.read_csv("weather_data.csv")
print(df["temp"])
print(len(df["temp"]))
print("Mean : {}".format(df["temp"].mean()))
print("Max : {}".format(df["temp"].max()))

# Get Data in Columns
print(df["condition"])  # df.condition

# Get Data in Row
print(df[df.day == "Monday"])

# Get the row which has a maximum temperature
print(df[df.temp == df["temp"].max()])

monday = df[df.day == "Monday"]
print(monday.condition)


# Convert temperature from Celsius into Fahrenheit
def convert_data(temp):
    fahrenheit = (temp * 1.8) + 32
    return fahrenheit


df["temp"] = df["temp"].apply(convert_data)
print(df.temp)

# Create a dataframe from scratch
data_dict = {
    "students": ["Amy", "James", "Angela"],
    "scores": [76, 56, 65]
}

data = pd.DataFrame(data_dict)

"""
  students  scores
0      Amy      76
1    James      56
2   Angela      65
"""

data.to_csv("new_data.csv")