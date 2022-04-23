class Stack:
    def __init__(self):
        """
        initialize (constructor)
        """
        self.items = []

    def isEmpty(self):
        """
        Check if the stack is empty or not
        :return: boolean
        """
        return self.items == []

    def push(self, item):
        """
        Add the item to the stack
        :param item: variable to add into the stack
        :return: stack (items)
        """
        return self.items.append(item)

    def pop(self):
        """
        Remove the item from the stack
        :return: stack (items)
        """
        return self.items.pop()

    def top(self):
        """
        Show the last item in the stack
        :return: variable
        """
        return self.items[::-1]

    def size(self):
        """
        Return size of stack
        :return: integer
        """
        return len(self.items)

# %%
