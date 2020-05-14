package lesson5.backPack;

import java.util.*;

public class FindBestKit {

    private final BackPack backPack;
    private final List<Junk> junks;
    private Set<Junk> bestKit;
    private final List<Junk> kit;
    private int maxPrice;

    public FindBestKit(BackPack backPack, ArrayList<Junk> junks) {
        this.backPack = backPack;
        this.junks = junks;
        bestKit = new HashSet<>();
        kit = new ArrayList<>();
        maxPrice = 0;
    }

    public Set<Junk> bestKit() {
        findBestKit(junks.size());
        return bestKit;
    }

    private void findBestKit(int length) {
        if (length == 1) {
            fillKit(length);
            maxPriceInBackPack(length);//Влезает ли набор предметов в рюкзак и сранение с максимальной ценой
            return;
        }

        for (int i = 0; i < length; i++) {
            findBestKit(length - 1);
            fillKit(length);//заполняем новым набором предметов
            maxPriceInBackPack(length);
            rotate(length);
        }
    }

    private void maxPriceInBackPack(int length) {
        int weightKit = sumWeightJunks(length);
        int priceKit = sumPriceJunks(length);
        if (weightKit <= backPack.getCapacityPack() && priceKit > maxPrice) {
            bestKit = new HashSet<>(kit);
            maxPrice = priceKit;
        }
    }

    private void fillKit(int length) {
        kit.clear();
        for (int i = length - 1; i >= 0; i--) {
            kit.add(junks.get(i));
        }
    }

    private void rotate(int length) {
        Junk temp = junks.get(0);
        for (int i = 0; i < length - 1; i++) {
            junks.set(i, junks.get(i + 1));
        }
        junks.set(length - 1, temp);
    }


    private int sumPriceJunks(int length) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += junks.get(i).getPrice();
        }
        return result;
    }

    private int sumWeightJunks(int length) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += junks.get(i).getWeight();
        }
        return result;
    }
}
