def missingDigit(problem):
    for i in range(10):
        c = problem.replace("x", str(i))
        x = problem.index("=")

        if eval(c[:x]) == eval(c[x + 1:]):
            return str(i)


if __name__ == '__main__':
    problem = input("Enter the problem with spaces: ")
    print(missingDigit(problem))
