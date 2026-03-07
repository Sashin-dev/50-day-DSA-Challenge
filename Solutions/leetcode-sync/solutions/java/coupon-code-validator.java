class Solution {
    class Coupons {
        String code;
        String businessLine;

        public Coupons(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }

        public String getCode() {
            return code;
        }

        public String getBusinessLine() {
            return businessLine;
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Set validBusinessLine = Set.of("restaurant", "grocery", "pharmacy", "electronics");
        Map<String, Integer> prorityMap = Map.of("electronics", 0,
                "grocery", 1,
                "pharmacy", 2,
                "restaurant", 3);
        List<Coupons> couponsList = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (validBusinessLine.contains(businessLine[i]) && isActive[i] && isValid(code[i]))
                couponsList.add(new Coupons(code[i], businessLine[i]));
        }

        return couponsList.stream()
                .sorted(
                        Comparator.comparing((Coupons coupon) -> prorityMap.get(coupon.getBusinessLine()))
                                .thenComparing(Coupons::getCode))
                .map(Coupons::getCode)
                .toList();
    }

    boolean isValid(String code) {
        return code != null && !code.isEmpty() && code.matches("^[a-zA-Z0-9_]+$");
    }
}