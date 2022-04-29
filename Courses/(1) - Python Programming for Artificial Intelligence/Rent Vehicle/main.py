import rent

if __name__ == '__main__':
    bicycle = rent.BicycleRent(100)
    car = rent.CarRent(10)
    customer = rent.Customer()

    main_menu = True

    while True:
        if main_menu:
            print("""
                  ****** VEHICLE RENTAL SHOP ******
                  A. Bicycle Menu
                  B. Car Menu
                  Q. Exit
                  """)
            main_menu = False
            choice = input("Enter choice:")

        if choice == "A" or choice == "a":
            print("""
                    ****** BICYCLE MENU ******
                    1. Display available bicycles
                    2. Request a bicycle on hourly basis $5
                    3. Request a bicycle on daily basis $84
                    4. Return a bicycle
                    5. Main Menu
                    6. Exit
                    """)

            choice = input("Enter choice:")

            try:
                choice = int(choice)
            except ValueError:
                print("It is not integer")
                continue

            if choice == 1:
                bicycle.displayStock()
                choice = "A"
            elif choice == 2:
                customer.rentalTime_b = bicycle.rentHourly(customer.requestVehicle("bicycle"))
                customer.rentalBasis_b = 1
                main_menu = True
                print("----------------")
            elif choice == 3:
                customer.rentalTime_b = bicycle.rentDaily(customer.requestVehicle("bicycle"))
                customer.rentalBasis_b = 2
                main_menu = True
                print("----------------")
            elif choice == 4:
                customer.bill = bicycle.returnVehicle(customer.returnVehicle("bicycle"), "bicycle")
                customer.rentalBasis_b, customer.rentalTime_b, customer.bicycles = 0, 0, 0
                main_menu = True
            elif choice == 5:
                main_menu = True
            elif choice == 6:
                break
            else:
                print("Invalid input. Please enter a number between 1 - 6:")
                main_menu = True

        elif choice == "B" or choice == "b":
            print("""
                    ****** CAR MENU ******
                    1. Display available cars
                    2. Request a car on hourly basis $10
                    3. Request a car on daily basis $192
                    4. Return a car
                    5. Main Menu
                    6. Exit
                    """)

            choice = input("Enter choice:")

            try:
                choice = int(choice)
            except ValueError:
                print("It is not integer")
                continue

            if choice == 1:
                car.displayStock()
                choice = "B"
            elif choice == 2:
                customer.rentalTime_c = car.rentHourly(customer.requestVehicle("car"))
                customer.rentalBasis_c = 1
                main_menu = True
                print("----------------")
            elif choice == 3:
                customer.rentalTime_c = car.rentDaily(customer.requestVehicle("car"))
                customer.rentalBasis_c = 2
                main_menu = True
                print("----------------")
            elif choice == 4:
                customer.bill = car.returnVehicle(customer.returnVehicle("car"), "car")
                customer.rentalBasis_c, customer.rentalTime_c, customer.cars = 0, 0, 0
                main_menu = True
            elif choice == 5:
                main_menu = True
            elif choice == 6:
                break
            else:
                print("Invalid input. Please enter a number between 1 - 6:")
                main_menu = True

        elif choice == "q" or choice == "Q":
            break

        else:
            print("Invalid input. Please Enter A-B-Q")
            main_menu = True

        print("Thank you for using the vehicle rental shop!")
