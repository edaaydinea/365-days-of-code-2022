def arrayRotation(new_list):
    string1 = ""
    for i in new_list:
        string1 += str(i)

    return string1[::-1]


if __name__ == '__main__':
    length = int(input("Enter the length of list: "))
    new_list = []
    for i in range(1, length + 1):
        number = int(input("Enter the {} number: ".format(str(i))))
        new_list.append(number)

    print(arrayRotation(new_list))
