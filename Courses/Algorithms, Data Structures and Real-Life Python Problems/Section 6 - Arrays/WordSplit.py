def wordSplit(list1):
    word = list((list1[0]))  # "deeplearning" -> ["d","e",...]
    d = list1[1].split(",")  # ["d","dll","a","deep","dee","base","lear","learning"]

    for i in range(1, len(word)):
        c = word[:]
        c.insert(i, " ")

        x, y = "".join(c).split()  # "d" , "eeplearning"
        if x in d and y in d:
            return x + " , " + y

    return "There is no way."


print(wordSplit(["deeplearning", "d,dll,a,deep,dee,base,lear,learning"]))

# %%
