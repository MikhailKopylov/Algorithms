package lesson7;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public void addEdges(String start, String second, String... other) {
        addEdge(start, second);
        for (String another : other) {
            addEdge(start, another);
        }
    }

    private void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for edge");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())) {
                return i;
            }
        }

        return -1;
    }

    public int getSize() {
        return vertexList.size();
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        vertex.setPrevious(null);
        visitVertex(vertex, stack);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex, stack);
            } else {
                stack.pop();
            }
        }

        resetVertexState();

    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex, queue);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

//    Поиск в ширину кратчайшего пути
    public void shortestPathBFS(String startLabel, String finishLabel) {
        int indexStart = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (indexStart == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for edge");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(indexStart);
        visitVertexShortestPath(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertexShortestPath(vertex, queue);
            } else {
                queue.remove();
            }
            if (vertex == vertexList.get(finishIndex)) {
                assert vertex != null;
                displayShortestPath(vertex);
                return;
            }
        }
        visitVertex(vertex, queue);

    }
// Посещение вершины
    private void visitVertexShortestPath(Vertex vertex, Queue<Vertex> queue) {
        queue.add(vertex);
        vertex.setVisited(true);
    }
// Вывод на консоль вершин кратчайшего пути, начиная с последнего
    private void displayShortestPath(Vertex finishVertex) {
        while (!finishVertex.getPrevious().equals("")) {
            System.out.println(finishVertex);
            int previousIndex = indexOf(finishVertex.getPrevious());
            if(previousIndex == -1){
                return;
            }
            finishVertex = vertexList.get(previousIndex);
        }
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setPrevious("");
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                vertexList.get(i).setPrevious(peek.getLabel());
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }


}
