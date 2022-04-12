hrs = input("Enter the number of Hours worked: ")

rt = input ('Enter the require rate per hour: ')

hours = float(hrs)

rate = float(rt)

if hours < 40 :
    print(hours*rate)
else :
    print(40*rate + (hours - 40)*rate*1.5)