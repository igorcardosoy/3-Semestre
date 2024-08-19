package view;

import java.util.Arrays;

public class ConsoleView implements IView{

    public void showList(int[] list){
        System.out.println(Arrays.toString(list));
    }

    public void showList(int[] list, String title){
        System.out.println(title);
        showList(list);
    }
}
