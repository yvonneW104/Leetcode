/*
* Sorting Methods:
* Buuble Sort: O(n^2)
* Insertion Sort: O(n^2)
* Selection Sort: O(n^2)
* Heap Sort: O(n log n)
* Merge Sort: O(n log n)
* Quick Sort: O(n log n), worst case: O(n^2), memory: O(log n)
*/


/* 
Bubble Sort: is the simplest sorting algorithm 
that works by repeatedly swapping the adjacent 
elements if they are in wrong order.
*/

void bubbleSort (int arr[]) {
	int n = arr.length;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}

void bubbleSort (int arr[], int n) {
	int i, j, temp;
	boolean swapped;
	for (i = 0; i < n - 1; i++) {
		swapped = false;
		for (j = 0; i < n - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				swapped = true;
			}
		}

		if (swapped == false) {
			break;
		}
	}
}

/*
Insertion sort: At step k, put the kth element in the correct 
position among the first k elements.
*/

void insertionsort (int arr[]) {
	int n = arr.length;
	for (int i = 1; i < n; i++) {
		int key = arr[i];
		int j = i - 1;
		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
	}
}

/*
Selection sort: at step k, find the smallest element among the 
not-yet-sorted elements and put it at position k
*/

void selectionsort (int arr[]) {
	int n = arr.length;
	for (int i = 0; i < n - 1; i++) {
		int min_index = i;
		for (int j = i + 1; j < n; j++) {
			if (arr[j] < arr[min_index]) {
				min_index = j;
			}
		}
		int temp = arr[min_index];
		arr[min_index] = arr[i];
		arr[i] = temp;
	}
}


/*
Heap sort: buildHeap then call deleteMin n times
*/

void heapsort (int arr[]) {
	int n = arr.length;
	for (int i = n / 2 - 1; i >= 0; i--) {
		heapify(arr, n, i);
	}

	for (int i = n - 1; i >= 0; i--) {
		int temp = arr[0];
		arr[0] = arr[i];
		arr[i] = temp;
		heapify(arr, i ,0);
	}
}

void heapify (int arr[], int n, int i) {
	int largest = i;
	int l = 2 * i + 1;
	int r = 2 * i + 2;

	if (l < n && arr[l] > arr[largest]) {
		largest = l;
	}

	if (r < n && arr[r] > arr[largest]) {
		largest = r;
	}

	if (largest != i) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;

		heapify(arr, n, largest);
	}
}


/*
Merge sort: divides the array in half, sort each of those 
halves, and then merges them back together. Each of those 
halves has the same sorting algorithm applied to it.
*/

void merge(int arr[], int l, int m, int r) {
	int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int [n1];
    int R[] = new int [n2];

    for (int i=0; i<n1; ++i)
        L[i] = arr[l + i];
    for (int j=0; j<n2; ++j)
        R[j] = arr[m + 1+ j];

    int i = 0, j = 0;
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void sort(int arr[], int l, int r) {
    if (l < r) {
        int m = (l+r)/2;
        sort(arr, l, m);
        sort(arr , m+1, r);
        merge(arr, l, m, r);
    }
}


/*
Quick sort: pick a random element and partition the array, 
such that all numbers that are less than the partitioning 
element come before all elements that are greater than it.
*/

int partition(int arr[], int low, int high) {
    int pivot = arr[high]; 
    int i = (low-1);
    for (int j=low; j<high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;
}

void sort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        sort(arr, low, pi-1);
        sort(arr, pi+1, high);
    }
}



















