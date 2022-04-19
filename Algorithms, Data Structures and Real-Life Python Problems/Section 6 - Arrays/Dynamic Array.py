import ctypes


class DynamicArray(object):

    # initialize (constructor)
    def __init__(self):
        self.n = 0
        self.capacity = 1
        self.A = self.make_array(self.capacity)

    def __len__(self):
        # return length of array
        return self.n

    def __getitem__(self, k):
        # return k[i]
        if not 0 <= k < self.n:
            return IndexError("k is out of bounds!")
        return self.A[k]

    def append(self, item):
        # append the item to array

        # doubles the capacity if the capacity is full
        if self.n == self.capacity:
            self._resize(2 * self.capacity)
        self.A[self.n] = item  # append the item to array
        self.n += 1  # increase length of array by one

    def _resize(self, new_capacity):
        # increase the capacity of array

        B = self.make_array(new_capacity)  # create new array

        # move the elements of A array into the new B array
        for i in range(self.n):
            B[i] = self.A[i]

        self.A = B  # update array
        self.capacity = new_capacity  # update the capacity

    def make_array(self, new_capacity):
        # return array
        return (new_capacity * ctypes.py_object)()
# %%
