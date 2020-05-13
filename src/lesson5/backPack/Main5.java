package lesson5.backPack;

import java.util.ArrayList;

public class Main5 {

    public static void main(String[] args) {

        BackPack backPack = new BackPack(9);

        ArrayList<Junk> junks = new ArrayList<>();
        junks.add(new Junk("Книга", 1, 600));
        junks.add(new Junk("Бинокль", 2, 5000));
        junks.add(new Junk("Аптечка", 4, 1500));
        junks.add(new Junk("Ноутбук", 2, 40000));
        junks.add(new Junk("Котелок", 1, 500));


        FindBestKit findBestKit = new FindBestKit(backPack, junks);
        System.out.println(findBestKit.bestKit());
    }

}
