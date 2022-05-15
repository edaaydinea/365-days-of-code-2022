# 🚨 Don't change the code below 👇
two_digit_number = input("Type a two digit number: ")
# 🚨 Don't change the code above 👆

####################################
#Write your code below this line 👇
sum = 0
for digit in str(two_digit_number):
    sum += int(digit)

print(sum)