package com.algorithm.devmatching;

import java.util.*;

public class Third {
    int[][] macaronMap = new int[8][8];
    boolean[][] visited = new boolean[8][8];

    public String[] solution(int[][] macaron) {
        for (int[] input : macaron) {
            macaronMap[1][input[0]] = input[1];
            gameSet();
            while (isExplode()) {
                gameSet();
            }
        }
        return getAnswer();
    }

    public String[] getAnswer() {
        String[] answer = new String[6];
        for (int i = 1; i <= 6; i++) {
            StringBuilder oneLine = new StringBuilder();
            for (int j = 1; j <= 6; j++) {
                oneLine.append(macaronMap[i][j]);
            }
            answer[i - 1] = oneLine.toString();
        }
        return answer;
    }

    public boolean isExplode() {
        boolean result = false;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (macaronMap[i][j] != 0) {
                    Queue<Node> queue = new LinkedList<>();
                    List<Node> sameList = new ArrayList<>();
                    visited = new boolean[8][8];
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node nowNode = queue.poll();
                        sameList.add(nowNode);
                        queue.addAll(nowNode.nextNode(macaronMap[i][j]));
                    }
                    if (sameList.size() >= 3) {
                        result = true;
                        for (Node node : sameList) {
                            macaronMap[node.getX()][node.getY()] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }

    public void gameSet() {
        for (int j = 1; j <= 6; j++) {
            List<Integer> macaronList = new ArrayList<>();
            for (int i = 6; i >= 1; i--) {
                if (macaronMap[i][j] != 0) {
                    macaronList.add(macaronMap[i][j]);
                }
            }
            while (macaronList.size() < 6) {
                macaronList.add(0);
            }
            Collections.reverse(macaronList);
            for (int i = 6; i >= 1; i--) {
                macaronMap[i][j] = macaronList.get(i - 1);
            }
        }
    }

    public class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Queue<Node> nextNode(int value) {
            int i = x;
            int j = y;
            int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<Node> result = new LinkedList<>();
            for (int[] move : moves) {
                int toI = i + move[0];
                int toJ = j + move[1];
                if (macaronMap[toI][toJ] == value && !visited[toI][toJ]) {
                    visited[toI][toJ] = true;
                    result.add(new Node(toI, toJ));
                }
            }
            return result;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


}
