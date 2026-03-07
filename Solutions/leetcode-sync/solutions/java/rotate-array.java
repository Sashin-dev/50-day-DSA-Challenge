class Solution {
    public void rotate(int[] arr, int offset) {
        int n = arr.length;
        offset = offset%n;
        int[] rotated = new int[n];
        System.arraycopy(arr, n - offset, rotated, 0, offset);
        System.arraycopy(arr, 0, rotated, offset, n - offset);
        System.arraycopy(rotated, 0, arr, 0, n);
    }
}