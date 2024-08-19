package controller;

import model.MergeSort;
import view.ConsoleView;
import view.IView;

import java.util.Random;

public class MergeSystem {

    IView view = new ConsoleView();

    public void runSystem(){
        doMergeWithRandomList();
    }

    private void doMergeWithRandomList(){

        Random random = new Random();
        int[] list = new int[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(1000);
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(list);

        view.showList(list, "Depois de classificar: ");
    }
}
