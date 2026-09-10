class Solution {
    public double myPow(double x, int n) {
        int N = n;

        if (N < 0) {
            return 1 / getPow(x, -N);
        }

        return getPow(x, N);

    }

    public double getPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = getPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}