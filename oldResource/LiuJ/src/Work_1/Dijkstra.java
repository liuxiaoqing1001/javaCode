package Work_1;

//import graph.model.Point;

import java.util.*;
import java.util.Map;

class Point {
    private int x;
    private int y;
    private int value;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point vertex = (Point) o;

        if (x != vertex.x) return false;
        return y == vertex.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

/**
 * Created by MHX on 2017/9/13.
 */
public class Dijkstra {
    private int[][] map; // 地图结构保存
    private int[][] edges; // 邻接矩阵
    private int[] prev; // 前驱节点标号
    private boolean[] s; // S集合中存放到起点已经算出最短路径的点
    private int[] dist; // dist[i]表示起点到第i个节点的最短路径
    private int pointNum; // 点的个数
    private java.util.Map<Integer, Point> indexPointMap; // 标号和点的对应关系
    private java.util.Map<Point, Integer> pointIndexMap; // 点和标号的对应关系
    private int v0; // 起点标号
    private Point startPoint; // 起点
    private Point endPoint; // 终点
    private Map<Point, Point> pointPointMap; // 保存点和权重的映射关系
    private List<Point> allPoints; // 保存所有点
    private int maxX; // x坐标的最大值
    private int maxY; // y坐标的最大值

    public Dijkstra(int map[][], Point startPoint, Point endPoint) {
        this.maxX = map.length;
        this.maxY = map[0].length;
        this.pointNum = maxX * maxY;
        this.map = map;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        init();
        dijkstra();
    }

    /**
     * 打印指定起点到终点的最短路径
     */
    public void printShortestPath() {
        printDijkstra(pointIndexMap.get(endPoint));
    }

    /**
     * 初始化dijkstra
     */
    private void init() {
        // 初始化所有变量
        edges = new int[pointNum][pointNum];
        prev = new int[pointNum];
        s = new boolean[pointNum];
        dist = new int[pointNum];
        indexPointMap = new HashMap<>();
        pointIndexMap = new HashMap<>();
        pointPointMap = new HashMap<>();
        allPoints = new ArrayList<>();

        // 将map二维数组中的所有点转换成自己的结构
        int count = 0;
        for (int x = 0; x < maxX; ++x) {
            for (int y = 0; y < maxY; ++y) {
                indexPointMap.put(count, new Point(x, y));
                pointIndexMap.put(new Point(x, y), count);
                count++;
                allPoints.add(new Point(x, y));
                pointPointMap.put(new Point(x, y), new Point(x, y, map[x][y]));
            }
        }

        // 初始化邻接矩阵
        for (int i = 0; i < pointNum; ++i) {
            for (int j = 0; j < pointNum; ++j) {
                if (i == j) {
                    edges[i][j] = 0;
                } else {
                    edges[i][j] = 9999;
                }
            }
        }

        // 根据map上的权重初始化edges，当然这种算法是没有单独加起点的权重的
        for (Point vertex : allPoints) {
            for (Point aroundPoint : getAroundPoints(vertex)) {
                edges[pointIndexMap.get(vertex)][pointIndexMap.get(aroundPoint)] = aroundPoint.getValue();
            }
        }

        v0 = pointIndexMap.get(startPoint);

        for (int i = 0; i < pointNum; ++i) {
            dist[i] = edges[v0][i];
            if (dist[i] == 9999) {
                // 如果从0点（起点）到i点最短路径是9999，即不可达
                // 则i节点的前驱节点不存在
                prev[i] = -1;
            } else {
                // 初始化i节点的前驱节点为起点，因为这个时候有最短路径的都是与起点直接相连的点
                prev[i] = v0;
            }
        }

        dist[v0] = 0;
        s[v0] = true;
    }

    /**
     * dijkstra核心算法
     */
    private void dijkstra() {
        for (int i = 1; i < pointNum; ++i) { // 此时有pointNum - 1个点在U集合中，需要循环pointNum - 1次
            int minDist = 9999;
            int u = v0;

            for (int j = 1; j < pointNum; ++j) { // 在U集合中，找到到起点最短距离的点
                if (!s[j] && dist[j] < minDist) { // 不在S集合，就是在U集合
                    u = j;
                    minDist = dist[j];
                }
            }
            s[u] = true; // 将这个点放入S集合

            for (int j = 1; j < pointNum; ++j) { // 以当前刚从U集合放入S集合的点u为基础，循环其可以到达的点
                if (!s[j] && edges[u][j] < 9999) {
                    if (dist[u] + edges[u][j] < dist[j]) {
                        dist[j] = dist[u] + edges[u][j];
                        prev[j] = u;
                    }
                }
            }
        }
    }

    private void printDijkstra(int endPointIndex) {
        if (endPointIndex == v0) {
            System.out.print(indexPointMap.get(v0) + ",");
            return;
        }
        printDijkstra(prev[endPointIndex]);
        System.out.print(indexPointMap.get(endPointIndex) + ",");
    }

    private List<Point> getAroundPoints(Point vertex) {
        List<Point> aroundPoints = new ArrayList<>();
        int x = vertex.getX();
        int y = vertex.getY();
        aroundPoints.add(pointPointMap.get(new Point(x - 1, y)));
        aroundPoints.add(pointPointMap.get(new Point(x, y + 1)));
        aroundPoints.add(pointPointMap.get(new Point(x + 1, y)));
        aroundPoints.add(pointPointMap.get(new Point(x, y - 1)));
        aroundPoints.removeAll(Collections.singleton(null)); // 剔除不在地图范围内的null点
        return aroundPoints;
    }

    public static void main(String[] args) {
        int map[][] = {
                {1, 2, 2, 2, 2, 2, 2},
                {1, 0, 2, 2, 0, 2, 2},
                {1, 2, 0, 2, 0, 2, 2},
                {1, 2, 2, 0, 2, 0, 2},
                {1, 2, 2, 2, 2, 2, 2},
                {1, 1, 1, 1, 1, 1, 1}
        }; // 每个点都代表权重，没有方向限制
        Point startPoint = new Point(0, 3); // 起点
        Point endPoint = new Point(5, 6); // 终点
        Dijkstra dijkstra = new Dijkstra(map, startPoint, endPoint);
        dijkstra.printShortestPath();
    }
}




//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Map.Entry;
//
///**
// * @author wyhong
// *
// */
//public class Dijkstra {
//
//    public class Node{
//        /**
//         * 节点的标识符
//         */
//        private Integer identifier;
//        /**
//         * 该节点是否被访问过
//         */
//        private boolean visited = false;
//        /**
//         * 该节点与其他节点的映射关系
//         */
//        private Map<Node,Integer> mapping = new HashMap<Node,Integer>();
//
//        public Integer getIdentifier() {
//            return identifier;
//        }
//        public void setIdentifier(Integer identifier) {
//            this.identifier = identifier;
//        }
//        public boolean isVisited() {
//            return visited;
//        }
//        public void setVisited(boolean visited) {
//            this.visited = visited;
//        }
//        public Map<Node, Integer> getMapping() {
//            return mapping;
//        }
//    }
//
//    /**
//     * Getting optimal path by Dijkstra algorithm
//     * @param src
//     * @param dest
//     * @return
//     */
//    public static LinkedList<Node> getOptimalPath(Node src, Node dest){
//        return dijkstra(src, dest, 0, 0, new LinkedList<Node>());
//    }
//
//    /**
//     * Dijkstra algorithm
//     * @param src 起始节点
//     * @param dest 目标节点
//     * @param adjacentDist 起始节点与目标节点相邻时的距离
//     * @param optimalDist 最短路径权值之和
//     * @param optimalPath 最短路径
//     * @return
//     */
//    private static LinkedList<Node> dijkstra(Node src, Node dest, int adjacentDist, int optimalDist,
//                                             LinkedList<Node> optimalPath){
//        if(optimalPath.size()==0){
//            optimalPath.add(src);
//        }
//        //当前节点与其他节点的映射关系
//        Map<Node,Integer> mapping = src.getMapping();
//        //当前节点与其相邻节点的最小距离
//        int partialMinDist = 0;
//        //当前预选的下一最优节点
//        Node partialOptimalNode = null;
//        Iterator<Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
//        while (entryIterator.hasNext()) {
//            Entry<Node, Integer> entry = (Entry<Node, Integer>) entryIterator.next();
//            Node nextNode = entry.getKey();
//            //判断该相邻节点是否被访问过
//            if (nextNode.isVisited()) continue;
//            int dist = entry.getValue();
//            //终点与起点相邻，但未必路径最短
//            if(nextNode.getIdentifier() == dest.getIdentifier() && optimalPath.size() == 1) adjacentDist = dist;
//            if (partialMinDist != 0) {
//                boolean currentIsOptimal = partialMinDist > dist ? false : true;
//                if(!currentIsOptimal){
//                    partialMinDist = dist;
//                    partialOptimalNode = nextNode;
//                }
//            }else{
//                partialMinDist = dist;
//                partialOptimalNode = nextNode;
//            }
//        }
//        //设置当前节点已被访问
//        src.setVisited(true);
//        //加入链表
//        optimalPath.add(partialOptimalNode);
//        optimalDist += partialMinDist;
//        if(partialOptimalNode.getIdentifier()!=dest.getIdentifier()){
//            //若未到终点时当前最优路径长度已大于终点与起点相邻的距离，则最短路径为起点--->终点
//            if(adjacentDist != 0 && optimalDist > adjacentDist) {
//                src = optimalPath.removeFirst();
//                optimalPath.clear();
//                optimalPath.add(src);
//                optimalPath.add(dest);
//                optimalDist = adjacentDist;
//                return optimalPath;
//            }
//            //否则以当前节点递归
//            return dijkstra(partialOptimalNode, dest, adjacentDist, optimalDist, optimalPath);
//        }else{
//            return optimalPath;
//        }
//    }
//
//
//        /**
//         * @param args
//         */
//        public static void main(String[] args) {
//            // TODO Auto-generated method stub
//            Dijkstra dijkstra = new Dijkstra();
//            Dijkstra.Node node_1 = dijkstra.new Node();
//            Dijkstra.Node node_2 = dijkstra.new Node();
//            Dijkstra.Node node_3 = dijkstra.new Node();
//            Dijkstra.Node node_4 = dijkstra.new Node();
//            Dijkstra.Node node_5 = dijkstra.new Node();
//            Dijkstra.Node node_6 = dijkstra.new Node();
//
//            node_1.setIdentifier(1);
//            node_1.getMapping().put(node_2, 7);
//            node_1.getMapping().put(node_3, 9);
//            node_1.getMapping().put(node_6, 14);
//
//            node_2.setIdentifier(2);
//            node_2.getMapping().put(node_1, 7);
//            node_2.getMapping().put(node_3, 10);
//            node_2.getMapping().put(node_4, 15);
//
//            node_3.setIdentifier(3);
//            node_3.getMapping().put(node_1,9);
//            node_3.getMapping().put(node_2,10);
//            node_3.getMapping().put(node_4,11);
//            node_3.getMapping().put(node_6,2);
//
//            node_4.setIdentifier(4);
//            node_4.getMapping().put(node_3, 11);
//            node_4.getMapping().put(node_2, 15);
//            node_4.getMapping().put(node_5, 6);
//
//            node_5.setIdentifier(5);
//            node_5.getMapping().put(node_4, 6);
//            node_5.getMapping().put(node_6, 9);
//
//            node_6.setIdentifier(6);
//            node_6.getMapping().put(node_5, 9);
//            node_6.getMapping().put(node_3, 2);
//            node_6.getMapping().put(node_1, 14);
//
//            LinkedList<Node> optimalPath = Dijkstra.getOptimalPath(node_1, node_4);
//            System.out.println("-------The optimal path--------");
//            for (Iterator<Node> iterator = optimalPath.iterator(); iterator.hasNext();) {
//                Node node = (Node) iterator.next();
//                if (iterator.hasNext()) {
//                    System.out.print(node.getIdentifier()+"-->");
//                }else{
//                    System.out.print(node.getIdentifier());
//                }
//            }
//        }
//
//}