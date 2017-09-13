import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Tapan on 9/3/2017.
 */
public class AlienDictionary {

    HashMap<Character,Vertex> verticesMap = new HashMap<Character,Vertex>();

    class Vertex {
        public Vertex(char vertexValue) {
            this.vertexValue = vertexValue;
            this.adjecentVertices = new ArrayList<Vertex>();
        }

        void addAdjecentVertex(Vertex vertex) {
            this.adjecentVertices.add(vertex);
        }

        char vertexValue;
        ArrayList<Vertex> adjecentVertices;
    }

    class Tuple {
        char first;
        char second;

        public Tuple(char first, char second) {
            this.first = first;
            this.second = second;
        }
    }

    class Stack<T> {
        private ArrayList<T> elements = new ArrayList<T>();

        public ArrayList<T> getElements() {
            ArrayList<T> newElements = (ArrayList<T>) elements.clone();
            Collections.reverse(newElements);
            return newElements;
        }

        void push(T element) {
            elements.add(element);
        }

        T pop() {
            if (elements.size() == 0) {
                return null;
            }
            return elements.remove(elements.size() - 1);
        }

        int size() {
            return elements.size();
        }


    }

    char[] getCharactersSortingOrder(String[] words) {
        for (int i = 1; i < words.length; i++) {
            Tuple tuple = getDiff(words[i -1], words[i]);
            createEdge(tuple);
        }

        HashMap<Vertex, Boolean> visitedVertices = new HashMap<Vertex, Boolean>();
        Stack<Vertex> stack = new Stack<Vertex>();
        for (Character character : verticesMap.keySet()) {
            Vertex vertex = verticesMap.get(character);
            if (visitedVertices.get(vertex) == null) {
                topologicalSort(vertex, visitedVertices, stack);
            }
        }

        ArrayList<Vertex> topologicalSorted = stack.getElements();
        char[] alphabets = new char[topologicalSorted.size()];
        for (int i = 0; i<topologicalSorted.size(); i++) {
            alphabets[i] = topologicalSorted.get(i).vertexValue;
        }
        return alphabets;
    }

    private void createEdge(Tuple tuple) {
        Vertex firstVertex = getOrCreateVertex(tuple.first);
        Vertex secondVertex = getOrCreateVertex(tuple.second);
        firstVertex.addAdjecentVertex(secondVertex);
    }

    private void topologicalSort(Vertex vertex, HashMap<Vertex, Boolean> visitedVertices, Stack<Vertex> stack) {
          visitedVertices.put(vertex, true);
        for (Vertex adjecentVertex: vertex.adjecentVertices) {
            if (visitedVertices.get(adjecentVertex) == null) {
                topologicalSort(adjecentVertex, visitedVertices, stack);
            }
        }
        stack.push(vertex);
    }


    private Vertex getOrCreateVertex(Character c) {
        Vertex vertex = verticesMap.get(c);
        if (vertex == null) {
            vertex = new Vertex(c);
            verticesMap.put(c,vertex);
        }
        return vertex;
    }

    private Tuple getDiff(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                continue;
            } else {
                return new Tuple(word1.charAt(i), word2.charAt(i));
            }
        }
        return null;
    }

}
