package lesson7;

public class Main7 {

    public static void main(String[] args) {

        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга" );
        graph.addEdges("Калуга", "Орел", "Москва" );
        graph.addEdges("Орел", "Калуга", "Курск" );
        graph.addEdges("Курск", "Орел", "Воронеж" );
        graph.addEdges("Рязань", "Москва", "Тамбов" );
        graph.addEdges("Тамбов", "Рязань", "Саратов" );
        graph.addEdges("Саратов", "Тамбов", "Воронеж" );
        graph.addEdges("Тула", "Москва", "Липецк" );
        graph.addEdges("Липецк", "Тула", "Воронеж" );

//        graph.bfs("Москва");
//        graph.dfs("Москва");
            graph.shortestPathBFS("Москва", "Воронеж");

       // graph.display();

    }
}
