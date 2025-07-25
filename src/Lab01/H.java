package Lab01;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); sc.nextLine();
        Train[] trains = new Train[N];  // all the trains
        for (int i = 0; i < N; ++i) {
            String info = sc.nextLine();
            trains[i] = new Train(info, i); // setting the train info and serial number and inserting the name and time
        }
        // Sorting the trains in the lexicographical order based on the name of the trains
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (trains[i].name.compareTo(trains[j].name) > 0) {
                    Train temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
                else if (trains[i].name.compareTo(trains[j].name) == 0) {
                    if (trains[i].timeMin < trains[j].timeMin) {
                        Train temp = trains[i];
                        trains[i] = trains[j];
                        trains[j] = temp;
                    }
                    else if (trains[i].timeMin == trains[j].timeMin) {
                        if (trains[i].index > trains[j].index) {
                            Train temp = trains[i];
                            trains[i] = trains[j];
                            trains[j] = temp;
                        }
                    }
                }
            }
        }

        // Printing the trains in the sorted order
        for (int i = 0; i < N; ++i) {
            System.out.println(trains[i].trainInfo);
        }
        sc.close();
    }

    static class Train {
        String name;
        String trainInfo;
        int timeMin;  // time in minutes
        int index;    // train serial number

        Train(String info, int i) {
            trainInfo = info;
            index = i;
            name = insertName(info);
            timeMin = insertTime(info);
        }
        private String insertName(String info) {
            String name = "";
            for (int i = 0; i < info.length(); ++i) {
                if (info.charAt(i) == ' ') {
                    break;
                }
                name += info.charAt(i);
            }
            return name;
        }

        private int insertTime(String info) {
            String time = info.substring(info.length() - 5);  // last 5 characters
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3, 5));
            return hour * 60 + min;
        }
//        private int insertTime(String info) {
//            String reversedTime = "";
//            for(int i = info.length() - 1; i >= 0; --i) {
//                if (info.charAt(i) == ' ') {
//                    break;
//                }
//                reversedTime = info.charAt(i) + reversedTime;
//            }
//            String time = "";
//            for(int i = reversedTime.length() - 1; i >= 0; --i) {
//                time += reversedTime.charAt(i);
//            }
//            int hour = Integer.parseInt("" + time.charAt(0) + time.charAt(1));
////            if(hour == 0) hour = 24; // Adjusting for midnight
//            int min = Integer.parseInt("" + time.charAt(3) + time.charAt(4));
////            return hour * 60 + min;
//            return hour;
//        }
    }
}