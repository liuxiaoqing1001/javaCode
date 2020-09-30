package Work_1;

public class Map {

    int vertex[][]={{},{510, 147},{538, 68},{586, 123},{657, 123},{623, 201},{702, 201},
            {733, 248},{733, 350},{861, 435},{861, 350},{861, 171},{793, 83},{804, 227}};
    int side[][]= {{},{1,2},{2,3},{3,4},{3,5},{4,5},{5,6},{6,7},{6,12},{7,8},{7,13},
            {8,9},{8,10},{8,13},{9,10},{10,13},{10,11},{11,13},{11,12},{12,13}};
    public int place[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    String placeName[]={"","老教楼","阶梯教学楼","第二教学楼","第三教学楼","教学主楼","共建桥",
            "第四餐厅","七号公寓","篮球场","镜湖","体育馆","操场","第五餐厅"};

    //每条边的长度
    public int sideDistance[][]=new int[vertex.length][vertex.length];
    //存最短路径下标的数组
    int pathArray[][]=new int[vertex.length][vertex.length];
    //存到各点最短路径的权值和
    int distanceSum[][]=new int[vertex.length][vertex.length];


    void InitializeEdge(){
        //初始化sidedistance
        for(int i = 1; i< vertex.length; i++){
            for(int j = 1; j< vertex.length; j++){
                if(i!=j) {
                    sideDistance[i][j]=65535;
                }
//	                System.out.printf(sideDistance[i][j]+"\t");
            }
//	            System.out.println();
        }

    }

    void CountDistance() {
        //计算边
        for(int i=1;i<side.length;i++){
            sideDistance[side[i][0]][side[i][1]]= sideDistance[side[i][1]][side[i][0]]=
                    (int) Math.sqrt(
                            Math.pow(vertex[side[i][1]][0]- vertex[side[i][0]][0],2)
                                    +Math.pow(vertex[side[i][1]][1]- vertex[side[i][0]][1],2)
                    );
//	            System.out.printf(sideDistance[side[i][0]][side[i][1]]+" ");
        }
//	        System.out.println();

//	        for(int i = 1; i< vertex.length; i++){
//	            for(int j = 1; j< vertex.length; j++){
//	                System.out.printf(sideDistance[i][j]+"\t");
//	            }
//	            System.out.println();
//	        }
    }

    void FloydShort(int pathArray[][], int distanceSum[][]) {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                distanceSum[i][j] = sideDistance[i][j];
                pathArray[i][j] = j;
            }
        }

        for (int k = 1; k < vertex.length; k++) {
            for (int i = 1; i < vertex.length; i++) {
                for (int j = 1; j < vertex.length; j++) {
                    if (distanceSum[i][k]!=999&&distanceSum[k][j]!=999&&distanceSum[i][j] > distanceSum[i][k] + distanceSum[k][j]) {
                        distanceSum[i][j] = distanceSum[i][k] + distanceSum[k][j];
                        pathArray[i][j] = pathArray[i][k];
                    }
                }
            }
        }

//        for (int k = 0; k < vertex.length; k++) {
//            for (int i = 0; i < vertex.length; i++) {
//                System.out.printf(pathArray[k][i] + "\t");
//            }
//            System.out.println();
//        }

//	        for (int k = 1; k < vertex.length; k++) {
//	            for (int i = 1; i < vertex.length; i++) {
//	                System.out.printf(distanceSum[k][i] + "\t");
//	            }
//	            System.out.println();
//	        }

    }

    String shortP;
    void PrintShort(int start,int end) {
        int k;
        for (int i = 1; i < vertex.length; ++i) {
            for (int j = 1; j < vertex.length; ++j) {
                if(i==start&&j==end){
                    shortP="所选路径:\n  "+placeName[i] + "->" + placeName[j] + "\n路程:\n  " + distanceSum[i][j]+"米"+"\n"+"最短路径:\n  ";
//	                  System.out.printf( "最短路径：\n"+placeName[i] + "->" + placeName[j] + "\n路程: " + distanceSum[i][j]+"米");
                    k = pathArray[i][j];
//	                  System.out.printf("\n路径:" + placeName[i]);
                    shortP=shortP+placeName[i];
                    while (k != j) {
                        shortP=shortP+"->" + placeName[k];
//	                      System.out.printf("->" + placeName[k]);
                        k = pathArray[k][j];
                    }
                    shortP=shortP+"->" + placeName[j];
//	                  System.out.printf("->" + placeName[j]);
                }
            }
        }
//	      System.out.println(x);
    }

    String shortPath(int start,int end) {
        InitializeEdge();
        CountDistance();
        FloydShort(pathArray, distanceSum);
        PrintShort(start,end);
        return shortP;
    }

    int x,y=1;
    String minT="";
    String Prim() {
        InitializeEdge();
        CountDistance();
        int adjVertex[]=new int[vertex.length];
        int valueBVex[]=new int[vertex.length];
        valueBVex[0]=0;
        adjVertex[0]=1;
        for(int i=1;i<vertex.length;i++) {
            valueBVex[i]=sideDistance[1][i];
            adjVertex[i]=1;
        }
        for(int i=1;i<vertex.length;i++) {
            int min=65535;
            int j=1;
            int k=1;
            while(j<vertex.length) {
                if(valueBVex[j]!=0&&valueBVex[j]<min) {
                    min=valueBVex[j];
                    k=j;
                }
                j++;
            }
            if(k!=1) {
                minT=minT+"("+placeName[adjVertex[k]]+","+placeName[k]+")";
                x++;
//					System.out.printf("("+placeName[k-1]+","+placeName[k]+")");
                if(x==3*y) {
                    minT=minT+"\n";
                    y++;
                }
            }
            valueBVex[k]=0;
            for(j=1;j<vertex.length;j++) {
                if(valueBVex[j]!=0&&sideDistance[k][j]<valueBVex[j]) {
                    valueBVex[j]=sideDistance[k][j];
                    adjVertex[j]=k;
                }
            }
        }
        return minT;
//			System.out.println();
    }

//    public static void main(String[] args) {
//        Map map=new Map();
//
//	        map.shortPath(1, 11);
//	        System.out.println( map.shortPath(1,13));
//
//	        map.Prim();
//        System.out.println( map.Prim());
//	        System.out.println( map.Kruskal());

//    }

}





//private boolean[] s=new boolean[vertex.length];; // S集合中存放到起点已经算出最短路径的点
//private int[] dist= new int[vertex.length]; // dist[i]表示起点到第i个节点的最短路径
//private int[][] edges= new int[vertex.length][vertex.length]; // 邻接矩阵
//private int[] prev=new int[vertex.length]; // 前驱节点标号
//void dijkstra(int start,int end) {
//  for (int i = 1; i < vertex.length; ++i) { // 此时有pointNum - 1个点在U集合中，需要循环pointNum - 1次
//      int minDist = 65535;
//      int u = start;
//
//      for (int j = 1; j <vertex.length; ++j) { // 在U集合中，找到到起点最短距离的点
//          if (!s[j] && dist[j] < minDist) { // 不在S集合，就是在U集合
//              u = j;
//              minDist = dist[j];
//          }
//      }
//      s[u] = true; // 将这个点放入S集合
//
//      for (int j = 1; j <vertex.length; ++j) { // 以当前刚从U集合放入S集合的点u为基础，循环其可以到达的点
//          if (!s[j] && edges[u][j] < 65535) {
//              if (dist[u] + edges[u][j] < dist[j]) {
//                  dist[j] = dist[u] + edges[u][j];
//                  prev[j] = u;
//              }
//          }
//      }
//  }
//}
//
//void printDijkstra(int start,int end) {
//  if (end == start) {
////      System.out.print(indexPointMap.get(start) + ",");
//      return;
//  }
//  printDijkstra(prev[start],prev[end]);
////  System.out.print(indexPointMap.get(end) + ",");
//}
//int Find(int parent[],int f) {
//while (parent[f] > 0) {
//	f = parent[f];
//}
//return f;
//}
//
//String mi="";
//String Kruskal() {
//InitializeEdge();
//CountDistance();
//int edge[]=new int[side.length];
//for(int i=1;i<vertex.length;i++) {
//    for(int j=1;j<vertex.length;j++) {
////    		if(sideDistance[i][j]!=999&&sideDistance[]) {
////
////    		}
//    }
//}
//    int edges[][]=new int[side.length][2];
//    int parent[]=new int[side.length];
//
//    for(int i=1;i<vertex.length;i++) {
//    	parent[i]=0;
//    }
//    for(int i=1;i<side.length;i++){
//        for(int j=0;j<2;j++){
//            edges[i][j]=side[i][j];
//        }
//    }
//
//    for(int i=1;i<side.length;i++) {
//    	int n=Find(parent,edges[i][0]);
//    	int m=Find(parent,edges[i][1]);
//    	if(n!=m) {
//    		parent[n]=m;
//    		mi=mi+"("+placeName[edges[i][0]]+","+placeName[edges[i][1]]+")";
//    	}
//    }
//
//return mi;
//}
