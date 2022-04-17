import collections


def compareWords(string1, string2):
    if len(string1) == len(string2):
        new_string1 = sorted(string1)
        new_string2 = sorted(string2)
        if collections.Counter(new_string1) == collections.Counter(new_string2):
            return True
        else:
            return False
    else:
        return False


if __name__ == '__main__':
    string1 = input("Enter the first string: ")
    string2 = input("Enter the second string: ")
    print(compareWords(string1, string2))
