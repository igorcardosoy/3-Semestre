package model;

public class MergeSort {

        private int[] array;
        private int[] tempArray;

        public void sort(int[] inputArray) {
            this.array = inputArray;
            int length = inputArray.length;
            this.tempArray = new int[length];
            mergeSort(0, length - 1);
        }

        private void mergeSort(int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;

                Thread thread1 = new Thread(() -> mergeSort(low, mid));
                Thread thread2 = new Thread(() -> mergeSort(mid + 1, high));

                thread1.start();
                thread2.start();

                try {
                    thread1.join();
                    thread2.join();

                    merge(low, mid, high);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        private void merge(int low, int mid, int high) {
            // Copy both halves into the temporary array
            System.arraycopy(array, low, tempArray, low, high - low + 1);

            int leftIndex = low;
            int rightIndex = mid + 1;
            int currentIndex = low;

            // Merge the two halves back into the original array
            while (leftIndex <= mid && rightIndex <= high) {
                if (tempArray[leftIndex] <= tempArray[rightIndex]) {
                    array[currentIndex] = tempArray[leftIndex];
                    leftIndex++;
                } else {
                    array[currentIndex] = tempArray[rightIndex];
                    rightIndex++;
                }
                currentIndex++;
            }

            // Copy the remaining elements of the left half (if any)
            while (leftIndex <= mid) {
                array[currentIndex] = tempArray[leftIndex];
                leftIndex++;
                currentIndex++;
            }

            // Copy the remaining elements of the right half (if any)
            while (rightIndex <= high) {
                array[currentIndex] = tempArray[rightIndex];
                rightIndex++;
                currentIndex++;
            }
        }
}
