/*
 * Read in Twp Floats and Print Sum
 * Eda AYDIN
 */
#include <stdio.h>

int main(void) {
    float a, b, sum;
    printf("Input two floats:");
    scanf_s("%f%f", &a, &b);
    printf("a = %f, b = %f\n", a, b);
    sum = a + b;
    printf("sum = %f\n\n", sum);
    return 0;
}

