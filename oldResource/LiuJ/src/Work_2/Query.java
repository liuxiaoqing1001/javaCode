package Work_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class Node{

    private Integer vertex;
    private boolean visited = false;
    private Map<Node,Integer> map = new HashMap<Node,Integer>();

    public Integer getVertex() {
        return vertex;
    }

    public void setVertex(Integer vertex) {
        this.vertex = vertex;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Map<Node, Integer> getMap() {
        return map;
    }
}

public class Query {

    public static LinkedList<Node> getOptimalPath(Node src, Node dest){
        return dijkstra(src, dest, 0, 0, new LinkedList<Node>());
    }

    private static LinkedList<Node> dijkstra(Node src, Node dest, int adjacentDist, int optimalDist,
                                                      LinkedList<Node> optimalPath){

        System.out.println(optimalPath.size());
        if(optimalPath.size()==0){
            optimalPath.add(src);
        }
        //当前节点与其他节点的映射关系
        Map<Node,Integer> mapping = src.getMap();
        //当前节点与其相邻节点的最小距离
        int partialMinDist = 0;
        //当前预选的下一最优节点
        Node partialOptimalNode = null;
        Iterator<Map.Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Node, Integer> entry = (Map.Entry<Node, Integer>) entryIterator.next();
            Node nextNode = entry.getKey();
            //判断该相邻节点是否被访问过
            if (nextNode.isVisited()) continue;
            int dist = entry.getValue();
            //终点与起点相邻，但未必路径最短
            if(nextNode.getVertex() == dest.getVertex() && optimalPath.size() == 1) adjacentDist = dist;
            if (partialMinDist != 0) {
                boolean currentIsOptimal = partialMinDist > dist ? false : true;
                if(!currentIsOptimal){
                    partialMinDist = dist;
                    partialOptimalNode = nextNode;
                }
            }else{
                partialMinDist = dist;
                partialOptimalNode = nextNode;
            }
        }
        //设置当前节点已被访问
        src.setVisited(true);
        //加入链表
        optimalPath.add(partialOptimalNode);
        optimalDist += partialMinDist;
        if(partialOptimalNode.getVertex()!=dest.getVertex()){
            //若未到终点时当前最优路径长度已大于终点与起点相邻的距离，则最短路径为起点--->终点
            if(adjacentDist != 0 && optimalDist > adjacentDist) {
                src = optimalPath.removeFirst();
                optimalPath.clear();
                optimalPath.add(src);
                optimalPath.add(dest);
                optimalDist = adjacentDist;
                return optimalPath;
            }
            //否则以当前节点递归
            return dijkstra(partialOptimalNode, dest, adjacentDist, optimalDist, optimalPath);
        }else{
            return optimalPath;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Query query = new Query();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();

        node1.setVertex(1);
        node1.getMap().put(node2, 7);
        node1.getMap().put(node3, 9);
        node1.getMap().put(node6, 14);

        node2.setVertex(2);
        node2.getMap().put(node1, 7);
        node2.getMap().put(node3, 10);
        node2.getMap().put(node4, 15);

        node3.setVertex(3);
        node3.getMap().put(node1, 9);
        node3.getMap().put(node2, 10);
        node3.getMap().put(node4, 11);
        node3.getMap().put(node6, 2);

        node4.setVertex(4);
        node4.getMap().put(node3, 11);
        node4.getMap().put(node2, 15);
        node4.getMap().put(node5, 6);

        node5.setVertex(5);
        node5.getMap().put(node4, 6);
        node5.getMap().put(node6, 9);

        node6.setVertex(6);
        node6.getMap().put(node5, 9);
        node6.getMap().put(node3, 2);
        node6.getMap().put(node1, 14);

        LinkedList<Node> optimalPath = getOptimalPath(node1, node4);
            System.out.println("-------The optimal path--------");
            for (Iterator<Node> iterator = optimalPath.iterator(); iterator.hasNext();) {
                Node node = (Node) iterator.next();
                if (iterator.hasNext()) {
                    System.out.print(node.getVertex()+"-->");
                }else{
                    System.out.print(node.getVertex());
                }
            }
    }

}




//import java.awt.Color;
//import java.awt.Graphics;
//
//public class Query {
//
//    int point[][]={{},{290,150},{530,180},{750,110},{720,200},{800,240},{770,400},
//            {700,500},{650,450},{660,380},{300,350},{250,480},{125,470},
//            {60,370},{135,360}};
//    int side[][]={{},{1,2},{1,3},{1,10},{1,14},{2,4},{2,9},{3,4},
//            {3,5},{4,5},{4,6},{4,9},{5,6},{6,7},{7,8},
//            {8,9},{8,10},{10,11},{11,12},{11,14},{12,13},
//            {13,14}};
//
//    public int place[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//    String placename[]={"","小东湖","第二行政楼","广商田径场","广商教学楼A","同乐园",
//            "图书馆","广商正门","康大超市","三栋宿舍","同德园","第一行政楼","校医室",
//            "实训楼s栋","金贝子"};
//
//    //创建一个储存两点间的距离的二维数组
//    public int  sidedistance[][]=new int[point.length][point.length];
//
//    /*构造方法内部可以作一些变量的初始化或在创建这个类时必须调用的一些方法和运算，
//     他是不用特意去调用的方法，会随着类的创建而自动去调用*/
//    void point(){
//        //边距离的初始化
//        for(int i=1;i<point.length;i++){
//            for(int j=1;j<point.length;j++){
//                if(i==j)  sidedistance[i][j]=0;
//                else  sidedistance[i][j]=0x7fffffff;
//            }
//        }
//        for(int i=1;i<side.length;i++){
//            sidedistance[side[i][0]][side[i][1]]= sidedistance[side[i][1]][side[i][0]]=
//                    (int) Math.sqrt(
//                            Math.pow(point[side[i][1]][0]-point[side[i][0]][0],2)
//                                    +Math.pow(point[side[i][1]][1]-point[side[i][0]][1],2)
//                    );
//			 System.out.println(sidedistance[side[1][0]][side[1][1]]);
//
//        }
//
//
//        Shortest();
//
//    }
//
//    void draw(Graphics g)
//    {
//        g.setColor(Color.black);
//        for(int i=1;i<point.length;i++){
//            //在相应的结点位置画出圆，并写出名称
//            g.drawString(placename[i],point[i][0], point[i][1]);
//            g.fillOval(point[i][0], point[i][1], 20,20);
//        }
//        //画出两点间可行走的路径
//        for(int i=1;i<side.length;i++){
//            g.drawLine(point[side[i][0]][0]+10, point[side[i][0]][1]+10,
//                    point[side[i][1]][0]+10, point[side[i][1]][1]+10);
//        }
//    }
//
//
//
//    boolean isShortestPath=false;
//    //创建一个数组储存达到中间结点的距离
//    int between[][]=new int[point.length][point.length];
//
//    void Shortest(){
//        if(isShortestPath) return;
//        //创建一个数组储存最短路径
//        int ShortestPath[][]=new int[point.length][point.length];
//        //初始化中间结点，如果两结点间没有经过任何结点，则中间把中间节点设为开始结点的下标
//        for(int i=1;i<point.length;i++){
//            for(int j=0;j<point.length;j++){
//                //最短路径的距离等于两点边的直接距离
//                ShortestPath[i][j]= sidedistance [i][j];
//                between[i][j]=i;
//            }
//        }
//        //嵌套循环
//        for(int k=1;k<point.length;k++){
//            //下面两个for语句依次扫描出二维数组中储存的数据
//            for(int i=1;i<point.length;i++){
//                for(int j=1;j<point.length;j++){
//                    //如果始点与终点的直接距离大于始点与中点和中点与终点的和距离
//                    if(ShortestPath[i][k]!=0x7fffffff&&ShortestPath[k][j]!=0x7fffffff&&
//                            ShortestPath[i][j]>ShortestPath[i][k]+ShortestPath[k][j]){
//                        //则把始点与中点和中点与终点的和距离赋予最短距离
//                        ShortestPath[i][j]=ShortestPath[i][k]+ShortestPath[k][j];
//                        between[i][j]=k;//把中点中间连结点加入到数组里
//                    }
//                }
//            }
//        }
//        isShortestPath=true;
//    }
//
//
//    //弗洛伊德算法
//    void drawShortestPath(int start,int end,Graphics g){
//        //如果中间没经过任何结点，则直接画出最短路径
//        if(between[start][end]==start){
//            g.setColor(Color.red);
//            g.drawLine(point[start][0]+10,point[start][1]+10,point[end][0]+10,point[end][1]+10);
//        }
//        else{//递归调用算法进行计算
//            drawShortestPath(start,between[start][end],g);
//            drawShortestPath(between[start][end],end,g);
//        }
//    }
//
////	public static void main(String[] args) {
////		Point p=new Point();
////		p.point();
////	}
//
//}