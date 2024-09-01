import java.util.Scanner;

public class mergesort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int low = 0;
        int high = n - 1;
        DivideConquer dc = new DivideConquer();
        dc.mergeSort(arr, low, high);
        dc.printArray(arr, n);
    }
}

class DivideConquer {
    public void mergeSort(int arr[], int low, int high) {
        if (low < high) {
    
        int mid = (low + (high - low)) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
       }
    }

    void merge(int arr[], int low, int mid, int high) {5
        int i = low;
        int j = mid + 1;
        int h = 0;
        int b[] = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                b[h++] = arr[j++];
            } else {
                b[h++] = arr[i++];
            }
        }

        while (i <= mid) {
            b[h++] = arr[i++];
        }

        while (j <= high) {
            b[h++] = arr[j++];
        } 

        for (i = 0; i < b.length; i++) {
            arr[i] = b[i];
        }
    }

    void printArray(int arr[], int n) {
        System.out.println("sorted array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
