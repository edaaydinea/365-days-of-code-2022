from animal import Animal


# Sub Class
class Fish(Animal):
    def __init__(self):
        super().__init__()

    def swim(self):
        print("Moving in water")

    def breathe(self):
        super().breathe()
        print("doing this underwater.")


if __name__ == '__main__':
    nemo = Fish()
    nemo.swim()
    nemo.breathe()
    print(nemo.num_eyes)
