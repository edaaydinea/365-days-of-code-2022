def findFrequency(string1):
    all_freq = dict()

    for i in string1:
        if i in all_freq:
            all_freq[i] += 1
        else:
            all_freq[i] = 1

    return "Count of all characters in this string is :\n {}".format(str(all_freq))


if __name__ == '__main__':
    string1 = input("Enter the string: ")
    print(findFrequency(string1))
