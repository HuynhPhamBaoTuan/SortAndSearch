
package controller;


import View.Menu;
import common.Algorithm;
import common.Library;
import model.Element;

public class Program extends Menu<String> {

    static String[] mc = {"Sort", "Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public Program(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                sort();
                break;
            case 2:
                search();
                break;
            case 3:
                System.exit(0);
        }
    }
    
    public void search() {
        final String[] mcSearch = {"Binary Search", "Linear Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public void execute(int n) {
                System.out.println("------------------------------");
                System.out.println("Array after use sort: ");
                algorithm.bubbleSort(array);
                library.display(array);
                System.out.println("------------------------------");
                int value = library.getInt("Enter number: ", 1, 100);
                switch (n) {
                    case 1:
                        algorithm.bubbleSort(array);
                        library.display(array);
                        System.out.println("");
                        algorithm.binarySearch(array, value);
                        System.out.println("Found value at index: " + algorithm.binarySearch(array, value));
                        break;
                    case 2:
                        algorithm.quickSort(array, 0, size_array - 1);
                        library.display(array);
                        System.out.println("");
                        Algorithm.linearSearch(array, value);
                        int linearSearchResult = Algorithm.linearSearch(array, value);
                            if (linearSearchResult != -1) {
                                System.out.println("Found value at index: " + linearSearchResult);
                            } else {
                                System.out.println("Value not found in the array.");
                            }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
        }

    public void sort() {
        final String[] mcSort = {"Bubble Sort", "Quick Sort", "Exit"};
        class SortMenu extends Menu<String> {

            public SortMenu() {
                super("Sort Option", mcSort);
            }

            @Override
            public void execute(int n) {
                System.out.println("Unsorted array: ");
                library.display(array);
                switch (n) {
                    case 1:
                        algorithm.bubbleSort(array);
                        System.out.println("\nBubble Sort: ");
                        library.display(array);
                        System.out.println("");
                        break;
                    case 2:
                        algorithm.quickSort(array, 0, size_array - 1);
                        System.out.println("\nQuick Sort: ");
                        library.display(array);
                        System.out.println("");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SortMenu sm = new SortMenu();
        sm.run();
    }
}
