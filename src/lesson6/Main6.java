package lesson6;


import java.util.Random;

public class Main6 {

    public static final int COUNT_CREATE_TREE = 20;
    public static final int RANDOM_NUMBER_ORIGIN = -25;
    public static final int RANDOM_NUMBER_BOUND = 25;
    public static final int MAX_SIZE = (int) (Math.pow(2, TreeImpl.MAX_DEEP_TREE) - 1);

    public static void main(String[] args) {



        Random random = new Random();
        int countBalancedTree = 0;
        for (int i = 0; i < COUNT_CREATE_TREE; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            random.ints(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                    .limit(MAX_SIZE)
                    .forEach(tree::add);

            tree.display();
            if(isBalanced(tree.getRoot())) {
                System.out.println("Дерево сбалансировано");
                countBalancedTree++;
            } else {
                System.out.println("Дерево не сбалансировано");
            }
        }

        int percentBalancedTree = countBalancedTree * 100 / COUNT_CREATE_TREE;
        System.out.printf("Процент сбалансированных деревьев из %d созданных = %d%%",
                COUNT_CREATE_TREE, percentBalancedTree);
    }

    public  static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
