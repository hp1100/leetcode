class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekday = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthLength = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int start = 5; // 1971-Jan-1 is Friday

        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0)
                start = (start + 366) % 7; // leap year
            else
                start = (start + 365) % 7;
        }

        for (int i = 1; i < month; i++) {
            if (i == 2 && year % 4 == 0)
                start = (start + monthLength[i] + 1) % 7; // leap month
            else
                start = (start + monthLength[i]) % 7;
        }

        start = (start + day - 1) % 7;

        return weekday[start];
    }
}
