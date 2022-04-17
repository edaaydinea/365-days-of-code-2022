def reverseInput(word):
    # str[start:stop:step]
    return word[::-1]


def reverseInput2(word):
    new_word = ""
    for char in word:
        new_word = char + new_word
    return new_word


if __name__ == "__main__":
    word = input("Enter the word: ")
    print(reverseInput(word))
    print(reverseInput2(word))
