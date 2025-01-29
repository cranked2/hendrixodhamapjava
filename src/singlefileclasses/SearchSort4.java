package singlefileclasses;

import java.util.Scanner;

public class SearchSort4 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {
        int selection;
        do {
            System.out.println("What would you like to do?  \n1: linerSearch\n2: Binary Search\n3: RecursiveBinarySearch\n4: binaryStringSearch\n5: Selectionsort\n6: insertionSort\n7: Bubble Sort\n8: linerSearch with strings\n0: To Exit");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection) {
                case 1:
                    int[] vals = {-1,2,-5,3,4,1,5,6,-1,-2};

                    display(vals);
                    System.out.println("Item At: " + linerSearch(vals,6));
                    break;
                case 2:
                    int[] prime = {2,3,5,13,17,19,23,29};
                    System.out.println("BIN : " + BINS(prime,5));
                    System.out.println("BIN : " + BINS(prime,1));
                    break;
                case 3:
                    int[] primer = {2,3,5,13,17,19,23,29,212,9,1,6,21,78,23,21,23};
                    System.out.println("BINR : " + RecursiveBinarySearch(primer,5,0,primer.length - 1));
                    System.out.println("BINR : " + RecursiveBinarySearch(primer,1,0,primer.length - 1));
                    break;
                case 4:
                    String[] bstr = {"app","rap","clap","crap","snap","lap","frap","nap","lit"};
                    System.out.println("STRB : " + binaryStringSearch(bstr,"clap"));
                    System.out.println("STRB : " + binaryStringSearch(bstr,"nap"));
                case 5:
                    int[] newarr = {-1,2,-5,3,4,1,5,6,-1,-2};
                    selectionSort(newarr);
                case 6:
                    int[] array = {12, 11, 13, 5, 6};
                    insertionSort(array);
                    System.out.println("Sorted array:");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                case 7:
                    int[] array2 = {64, 34, 25, 12, 22, 11, 90};
                    bubbleSort(array2);
                    System.out.println("Sorted array:");
                    for (int i = 0; i < array2.length; i++) {
                        System.out.print(array2[i] + " ");
                    }
                case 8:
                    String[] strs = {"mints","chocolate","target worker","car","red shirt"};
                    display(strs);

                    System.out.println("Item At: " + linerSearch(strs,"target worker"));
                case 0:
                    System.out.println("GOOD BYE");
                    break;
            }
        }while(selection != 0);
        sc.close();






    }

    public static void display(int [] values)
    {
        for(int val : values)
            System.out.println(val + "");
        System.out.println("");
    }


    public static void display(String [] values)
    {
        for(String val : values)
            System.out.println(val + "");
        System.out.println("");
    }

    public static int linerSearch(int [] values,int val)
    {
        for(int k = 0; k < values.length;k++)
        {
            if(val == values[k])
                return k;
        }
        return -1;
    }

    public static int binaryStringSearch(String [] values,String val)
    {
        int left = 0,right = values.length-1,mid;

        while(left<=right)
        {
            mid = left + (right-left) / 2;
            if (values[mid].equals(val)) return mid;
            else if (values[mid].compareTo(val) > 0) right = mid -1;
            else left = mid + 1;
        }
        return -1;
    }

    public static int linerSearch(String [] values,String val)
    {
        for(int k = 0; k < values.length;k++)
        {
            if(val.equals(values[k]))
                return k;
        }
        return -1;
    }

    public static int BINS(int [] values,int val)
    {
        int left = 0, right = values.length - 1;

        while (left<=right)
        {
            int mid = left + (right - left) / 2;

            if(values[mid] == val)
                return mid;

            right = (values[mid] > val) ? mid - 1 : right;
            left = (values[mid] < val) ? mid + 1 : left;

        }
        return -1;
    }

    public static int RecursiveBinarySearch(int [] values,int val,int left,int right)
    {
        int mid = left + (right-left) / 2;
        return (left>right) ? -1 :
                (values[mid] == val) ? mid:
                        (values[mid] > val) ? RecursiveBinarySearch(values,val,left,mid - 1) :
                                RecursiveBinarySearch(values,val,mid +1,right);
    }

    public static void selectionSort(int[] values) {
        for (int index = 0; index < values.length - 1; index++) {
            int minindex = index;
            for (int k = index + 1; k < values.length; k++) {
                if (values[k] < values[minindex]) {
                    minindex = k;
                }
            }
            if (minindex != index) {
                int temp = values[minindex];
                values[minindex] = values[index];
                values[index] = temp;
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    public static void bubbleSort(int[] array) {
        int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }






}
