class Deque:
    def __init__(self):
        """
        initialize constructor
        """
        self.items = []

    def isEmpty(self):
        """
        Check if the stack is empty or not
        :return: boolean
        """
        return self.items == []

    def addFront(self, item):
        """
        Add the item to the list by using the Front part (Stack)
        :param item: variable
        :return: list
        """
        self.items.append(item)
        return self.items

    def addRear(self, item):
        """
        Add the item to the list by using the rear part (Queue)
        :param item: variable
        :return: list
        """
        self.items.insert(item)
        return self.items

    def removeFront(self):
        """
        Remove the item from front - Stack
        :return: list
        """
        return self.items.pop()

    def removeRear(self):
        """
        Remove the item from rear - Queue
        :return: list
        """
        return self.items.pop(0)

    def size(self):
        """
        Return size of dequeue
        :return: integer
        """
        return len(self.items)
