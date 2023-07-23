if (head == null || head.next == null) {
            return head;
        }

        int[] count = new int[3]; // To count the occurrences of 0, 1, and 2
        Node curr = head;

        // Count the occurrences of 0, 1, and 2 in the linked list
        while (curr != null) {
            count[curr.data]++;
            curr = curr.next;
        }

        curr = head;

        // Modify the linked list according to the counts
        for (int i = 0; i < count[0]; i++) {
            curr.data = 0;
            curr = curr.next;
        }
        for (int i = 0; i < count[1]; i++) {
            curr.data = 1;
            curr = curr.next;
        }
        for (int i = 0; i < count[2]; i++) {
            curr.data = 2;
            curr = curr.next;
        }

        return head;