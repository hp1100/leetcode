class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> taken_courses = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        int time = 0;
        for (int[] course: courses) {
            if (time + course[0] <= course[1]) {
                taken_courses.add(course[0]);
                time += course[0];
                res++;
            } else {
                if (taken_courses.size() > 0 && course[0] < taken_courses.peek()) {
                    time = time - taken_courses.poll() + course[0];
                    taken_courses.offer(course[0]);
                }
            }
        }
        return res;
    }
}
