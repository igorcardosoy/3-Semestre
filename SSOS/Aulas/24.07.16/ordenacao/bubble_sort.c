#include "bubble_sort.h"

void bubble_sort(int dataset[], int size)
{
    int i, j, swap, aux;

    i = 0;
    while (i < (size - 1) && swap) {
        swap = false;
        for (j = 0; j < (size - (1 + i)); j++) {
            if (dataset[j] > dataset[j + 1]) {
                swap = true;
                swap_pointers(&dataset[j], &dataset[j + 1]);
            }
        }

        i++;
    }
}

void swap_pointers(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}