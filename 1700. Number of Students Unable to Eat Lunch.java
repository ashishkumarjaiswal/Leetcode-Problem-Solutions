class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stud = new LinkedList<>();
        for (Integer i : students) {
            stud.add(i);
        }

        int total = students.length;

        Stack<Integer> sand = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sand.push(sandwiches[i]);
        }

        int count = 0;

        while (!stud.isEmpty()) {
            int size = stud.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                if (stud.peek() == sand.peek()) {
                    stud.poll();
                    sand.pop();
                    flag = false;
                    count++;
                } else {
                    stud.add(stud.poll());
                }
            }
            if (flag)
                return total - count;
        }
        return total - count;
    }
}
