class maxascsubarray {
    public static void main(String args[]) {
        int arr[] = {1, 3, 4, 5, 6, 7, 8, 0};
        int left = 0;
        int right = 0;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;

        while (right < n - 1) {
            if (right < n - 1 && arr[right] > arr[right + 1] ) {
                res = Math.max(res, right - left + 1);
                while (arr[right] > arr[right + 1]) {
                    right += 1;
                }
                left = right;
            } 

            right++;
        }

        res = Math.max(res, right - left + 1);

        System.out.println(res);
    }
}