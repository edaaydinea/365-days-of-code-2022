def arrayPairs(array, length):
    new = ""
    for i in range(length):
        new += str(array[i]) + " "

        if i % 2 == 1:
            new += ","
    new = new.split(" ,")

    # reverse
    lst = []
    for i in new:
        if i[::-1] not in new:
            for j in i.split():
                lst.append(j)
        elif i == i[::-1] and new.count(i) < 2:
            for j in i.split():
                lst.append(j)

    if not lst:
        return "ok"
    return ",".join(lst)


if __name__ == '__main__':
    test = False
    while not test:
        length = int(input("Enter the length of list: "))
        array = []
        if length % 2 == 0:
            test = True
            for i in range(1, length + 1):
                number = int(input("Enter the {} number: ".format(str(i))))
                array.append(number)
            print(arrayPairs(array, length))
        else:
            test = False
            print("You should enter the even number to calculate array pairs.")
