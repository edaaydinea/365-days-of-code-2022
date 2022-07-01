# Reading the file
with open("my_file.txt") as file:
    contents = file.read()
    print(contents)

# Writing to the file
with open("my_file2.txt", mode="w") as file2:
    file2.write("New text.")
