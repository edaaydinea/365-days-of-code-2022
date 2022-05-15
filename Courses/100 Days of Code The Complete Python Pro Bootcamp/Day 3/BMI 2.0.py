# 🚨 Don't change the code below 👇
height = float(input("enter your height in m: "))
weight = float(input("enter your weight in kg: "))
# 🚨 Don't change the code above 👆

# Write your code below this line 👇
from math import *

bmi = int(ceil(weight / (height * height)))

if bmi < 18.5:
    print("Your BMI is {}, you are underweight.".format(floor(bmi)))
elif 18.5 < bmi <= 25:
    print("Your BMI is {}, you have a normal weight".format(bmi))
elif 25 < bmi <= 30:
    print("Your BMI is {}, you are slightly overweight".format(bmi))
elif 30 < bmi <= 35:
    print("Your BMI is {}, you are obese".format(bmi))
elif bmi > 35:
    print("Your BMI is {}, you are clinically obese".format(bmi))
