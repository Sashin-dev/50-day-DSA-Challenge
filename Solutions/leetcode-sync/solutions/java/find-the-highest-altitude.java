class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude=gain[0];

        for(int i=1; i<gain.length; i++)
        {
            maxAltitude = Math.max(maxAltitude, gain[i-1]+gain[i]);
            gain[i] += gain[i-1];
        }

        return maxAltitude<0 ? 0 : maxAltitude;
    }
}