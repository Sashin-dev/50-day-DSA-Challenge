class Solution {
     List<List<Integer>>
        combinationSum(int[] arr, int sum)
        {
//            Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            List<List<Integer> > ans
                    = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();



            findNumbers(ans, arr, sum, 0, temp);
            return ans;
        }

        void findNumbers(List<List<Integer> > ans,
                         int[] arr, int sum, int index,
                         List<Integer> temp)
        {
//            if(index>=arr.length) {
                if (sum == 0) {

                    // Adding deep copy of list to ans

                    ans.add(new ArrayList<>(temp));
                    return;
                }
//            }

            for (int i = index; i < arr.length; i++) {

                // checking that sum does not become negative

                if ((sum - arr[i]) >= 0) {

                    // adding element which can contribute to
                    // sum

                    temp.add(arr[i]);

                    findNumbers(ans, arr, sum - arr[i], i,
                            temp);

                    // removing element from list (backtracking)
                        temp.remove(temp.size()-1);
                }
            }
        }

}