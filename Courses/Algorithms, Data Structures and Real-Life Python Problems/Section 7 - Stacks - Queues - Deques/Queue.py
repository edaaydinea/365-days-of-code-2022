class Queue:
    def __init__(self):
        """
        intialize (constructor)
        """
        self.items = []

    def isEmpty(self):
        """
        Check if the stack is empty or not
        :return: boolean
        """
        return self.items == []

    def enqueue(self, item):
        """
        Add the item to the queue
        :param item: variable to add into the stack
        :return: list
        """
        self.items.insert(0, item)
        return self.items

    def dequeue(self):
        """
        Remove the item from the queue
        :return: variable
        """
        return self.items.pop()

    def size(self):
        """
        Return size of queue
        :return: integer
        """
        return len(self.items)
# %%
