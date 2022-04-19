def capitalization(sentence):
    return " ".join(word.capitalize() for word in sentence.split())


if __name__ == '__main__':
    sentence = input("Enter the sentence: ")
    print(capitalization(sentence))
