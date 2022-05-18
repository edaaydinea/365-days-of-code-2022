# 🚨 Don't change the code below 👇
print("Welcome to the Love Calculator!")
name1 = input("What is your name? \n")
name2 = input("What is their name? \n")
# 🚨 Don't change the code above 👆

# Write your code below this line 👇

names = name1.lower() + name2.lower()
word1 = {"t", "r", "u", "e"}
word2 = {"l", "o", "v", "e"}

count1 = 0
for i in word1:
    count1 += names.count(i)

count2 = 0
for i in word2:
    count2 += names.count(i)

total = int(str(count1) + str(count2))

if total < 10 or total > 90:
    print("Your score is {}, you go together like coke and mentos.".format(total))
elif 40 < total < 50:
    print("Your score is {}, you are alright together.".format(total))
else:
    print("Your score is {}".format(total))
