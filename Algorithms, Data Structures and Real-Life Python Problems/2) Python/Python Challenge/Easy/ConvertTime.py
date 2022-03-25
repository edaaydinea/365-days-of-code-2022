def convertTime(number):
    hours = number // 60
    minutes = number % 60

    return "{} hours ,{} minutes".format(hours, minutes)


if __name__ == '__main__':
    number = int(input("Enter the number in the minutes format (Example: 128 minutes): "))
    print(convertTime(number))
