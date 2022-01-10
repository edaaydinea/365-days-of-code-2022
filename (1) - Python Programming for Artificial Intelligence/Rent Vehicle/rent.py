""""# Rent Vehicle

*Author: Eda AYDIN*

We have 2 different super classes.
1. Vehicle Class
- Display Stock
- Rent Daily, Hourly
- Return Vehicle

    (Subclasses)
    a. Car Rent
    - Discount
    b. Bicyle Rent

2. Customer Class
- Request Vehicle
- Return Vehicle

"""

from datetime import datetime


# Main class
class Customer:

    def __init__(self):
        self.bicycles = 0
        self.rentalBasis_b = 0
        self.rentalTime_b = 0

        self.cars = 0
        self.rentalBasis_c = 0
        self.rentalTime_c = 0

    def requestVehicle(self, brand):
        """
        :param: brand (car or bicycle)
        :return: just errors
        """
        if brand == "bicycle":
            bicycles = int(input("Enter the number of bicycles you want to rent:"))

            try:
                bicycles = int(bicycles)
            except ValueError:
                print("Number should be Number")
                return -1

            if bicycles < 1:
                print("Number of bicycles should be greater than zero")
                return -1
            else:
                self.bicycles = bicycles
            return self.bicycles

        elif brand == "car":
            cars = int(input("Enter the number of cars you want to rent:"))

            try:
                cars = int(cars)
            except ValueError:
                print("Number should be Number")
                return -1

            if cars < 1:
                print("Number of cars should be greater than zero")
                return -1
            else:
                self.cars = cars
            return self.cars

        else:
            print("Request vehicle error")

    def returnVehicle(self, brand):
        """
        :param brand : bicycle or car
        :return: rentalTime_b, rentalBasis_b, bicycles, rentalTime_c, rentalBasis_c, cars
        """
        if brand == "bicycle":
            if self.rentalTime_b and self.rentalBasis_b and self.bicycles:
                return self.rentalTime_b, self.rentalBasis_b, self.bicycles
            else:
                return 0, 0, 0

        elif brand == "car":
            if self.rentalTime_c and self.rentalBasis_c and self.cars:
                return self.rentalTime_c, self.rentalBasis_c, self.cars
            else:
                return 0, 0, 0
        else:
            print("Return vehicle error")


# Main - Super class
class VehicleRent:
    def __init__(self, stock):
        """

        :param stock: number of vehicles
        :param now: use in the calculation of duration
        """
        self.stock = stock
        self.now = 0

    def displayStock(self):
        """

        :return: number of stock
        """
        print("{} vehicle is available to rent.".format(self.stock))
        return self.stock

    def rentHourly(self, numcars):
        """

        :param numcars: get the car numbers from the user to rent hourly
        :return: cars (integer)
        """
        if numcars <= 0:
            print("Number should be positive.")
            return None
        elif numcars > self.stock:
            print("Sorry, {} vehicle is not available to rent.".format(self.stock))
            return None
        else:
            self.now = datetime.now()
            print("Rented a {} vehicle for hourly at {} hours".format(numcars, self.now.hour))

            self.stock -= numcars

            return self.now

    def rentDaily(self, numcars):
        """
        :param numcars:  get the car numbers from the user to rent daily
        :return: cars(integer)
        """
        if numcars <= 0:
            print("Number should be positive.")
            return None
        elif numcars > self.stock:
            print("Sorry, {} vehicle is not available to rent.".format(self.stock))
            return None
        else:
            self.now = datetime.now()
            print("Rented a {} vehicle for daily at {} days".format(numcars, self.now.day))

            self.stock -= numcars

            return self.now

    def returnVehicle(self, request, brand):
        """
        :param request , brand
        :return: a bill (string)
        """
        car_h_price = 10
        car_d_price = car_h_price * 8 / 10 * 24
        bicycle_h_price = 5
        bicycle_d_price = bicycle_h_price * 7 / 10 * 24

        rentalTime, rentalBasis, numofVehicle = request
        bill = 0

        if brand == "car":
            if rentalTime and rentalBasis and numofVehicle:
                self.stock += numofVehicle
                rentalPeriod = datetime.now() - rentalTime

                if rentalBasis == 1:  # hourly
                    bill = rentalPeriod.seconds / 3600 * car_h_price * numofVehicle

                elif rentalBasis == 2:  # daily
                    bill = rentalPeriod.seconds / (3600 * 24) * car_d_price * numofVehicle

                if 2 <= numofVehicle:
                    print("You have extra 20% discount.")
                    bill = bill * 0.8

                print("Thank you for returning your {}".format(brand))
                print("Price: ${}".format(bill))

        elif brand == "bicycle":
            if rentalTime and rentalBasis and numofVehicle:
                self.stock += numofVehicle
                rentalPeriod = datetime.now() - rentalTime

                if rentalBasis == 1:  # hourly
                    bill = rentalPeriod.seconds / 3600 * bicycle_h_price * numofVehicle

                elif rentalBasis == 2:  # daily
                    bill = rentalPeriod.seconds / (3600 * 24) * bicycle_d_price * numofVehicle

                if 2 <= numofVehicle:
                    print("You have extra 20% discount.")
                    bill = bill * 0.8

                print("Thank you for returning your {}".format(brand))
                print("Price: ${}".format(bill))


# subclass 1
class CarRent(VehicleRent):
    global discount_rate
    discount_rate = 15

    def __init__(self, stock):
        super().__init__(stock)

    def discount(self, bill):
        """
        :param bill (integer)
        :return: discount (integer)
        """
        bill_discount = bill - (bill * discount_rate) / 100
        return bill_discount


# subclass 2
class BicycleRent(VehicleRent):

    def __init__(self, stock):
        super().__init__(stock)
