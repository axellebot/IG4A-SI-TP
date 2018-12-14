package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercice2 {
    // TODO : [ ]

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose test [1-3] ?\n");
        String st = sc.nextLine();
        int n = Integer.valueOf(st);

        Exercice2 ex2 = new Exercice2();

        ArrayList<Event> finalArray = new ArrayList<>();

        ArrayList<Event> arrayList = new ArrayList<>();
        switch (n) {
            case 1:
                arrayList.add(new Event(0, 4, 7));
                arrayList.add(new Event(1, 1, 5));
                arrayList.add(new Event(2, 6, 10));
                break;
            case 2:
                arrayList.add(new Event(0, 1, 10));
                arrayList.add(new Event(1, 2, 3));
                arrayList.add(new Event(2, 4, 5));
                arrayList.add(new Event(3, 6, 7));
                arrayList.add(new Event(4, 8, 9));

                break;
            case 3:
                arrayList.add(new Event(0, 6, 8));
                arrayList.add(new Event(1, 1, 4));
                arrayList.add(new Event(2, 10, 13));
                arrayList.add(new Event(3, 4, 7));
                arrayList.add(new Event(4, 7, 10));
                arrayList.add(new Event(5, 3, 5));
                arrayList.add(new Event(6, 3, 5));
                arrayList.add(new Event(7, 3, 5));
                arrayList.add(new Event(8, 9, 11));
                arrayList.add(new Event(9, 9, 11));
                arrayList.add(new Event(10, 9, 11));

                break;
        }

        arrayList.sort((o1, o2) -> {
            if (o1.end > o2.end) {
                return 1;
            } else if (o1.end < o2.end) {
                return -1;
            }
            return 0;
        });

        do {
            Event event = arrayList.remove(0);
            if (finalArray.isEmpty()) {
                finalArray.add(event);
            }else if (event.start >= finalArray.get(finalArray.size()-1).end) {
                finalArray.add(event);
            }
            arrayList.removeIf(e -> e.start < event.start);
        }
        while (!arrayList.isEmpty());

        System.out.println(finalArray.toString());
    }


}

class Event {
    public final int initialIndex;
    public final int start;
    public final int end;

    Event(int initialIndex, int start, int find) {
        this.initialIndex = initialIndex;
        this.start = start;
        this.end = find;
    }

    @Override
    public String toString() {
        return "Event{" +
                "initialIndex=" + initialIndex +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
