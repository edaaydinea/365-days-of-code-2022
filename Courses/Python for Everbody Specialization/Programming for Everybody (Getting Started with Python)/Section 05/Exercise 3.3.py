score = float(input("Enter your Score:"))
if 0 <= score <= 1:
    if score >= 0.9:
        print("A")
    elif score >= 0.8:
        print("B")
    elif score >= 0.7:
        print("C")
    elif score >= 0.6:
        print("D")
    else:
        print("F")
else:
    print("Enter a valid score")
quit()