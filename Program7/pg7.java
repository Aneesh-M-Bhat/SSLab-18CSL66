import java.util.Scanner;

class pg7 {
    static void srtf() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of processes");
        int numP = s.nextInt();
        System.out.println("Enter arrival time & burst time of processes");
        int[] arrival = new int[numP];
        int[] burst = new int[numP];
        int[] temp = new int[numP];
        int[] finish = new int[numP];
        for (int i = 0; i < numP; i++) {
            arrival[i] = s.nextInt();
            burst[i] = s.nextInt();
            temp[i] = burst[i];
        }
        int minP;
        boolean check;
        for (int currTime = 0;; currTime++) {
            check = true;
            minP = -1;
            for (int i = 0; i < numP; i++) {
                if (arrival[i] <= currTime) {
                    if (temp[i] != 0) {
                        if (minP == -1)
                            minP = i;
                        else if (temp[minP] > temp[i])
                            minP = i;
                    }
                }
                if (finish[i] == 0)
                    check = false;
            }
            if (minP != -1) {
                temp[minP]--;
                if (temp[minP] == 0)
                    finish[minP] = currTime + 1;
            }
            if (check)
                break;
        }
        System.out.println("ArrivalTime\tBurstTime\tFinishTime");
        for (int i = 0; i < numP; i++) {
            System.out.printf("%d\t\t%d\t\t%d\n", arrival[i], burst[i], finish[i]);
        }
    }

    static void rr() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of processes");
        int numP = s.nextInt();
        System.out.println("Enter quantum time");
        int quant = s.nextInt();
        System.out.println("Enter burst time of processes");
        int burst[] = new int[numP];
        int temp[] = new int[numP];
        int finish[] = new int[numP];
        for (int i = 0; i < numP; i++) {
            burst[i] = s.nextInt();
            temp[i] = burst[i];
        }
        int check = 0;
        for (int currTime = 0, i = 0;; i = (i + 1) % numP) {
            if (temp[i] > quant) {
                temp[i] -= quant;
                currTime += quant;
                check = 0;
            } else if (temp[i] > 0) {
                currTime += temp[i];
                temp[i] = 0;
                finish[i] = currTime;
                check = 0;
            } else
                check++;

            if (check == numP)
                break;
        }
        System.out.println("BurstTime\tFinishTime");
        for (int i = 0; i < numP; i++) {
            System.out.printf("%d\t\t%d\n", burst[i], finish[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (;;) {
            System.out.println("Enter your choice\n1.SRTF\n2.RR\n3.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    srtf();
                    break;
                case 2:
                    rr();
                    break;
                case 3:
                    return;
            }
        }
    }
}