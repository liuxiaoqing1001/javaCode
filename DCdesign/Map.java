package Map;

public class Map {

    int vertex[][]={{},{510, 147},{538, 68},{586, 123},{657, 123},{623, 201},{702, 201},
            {733, 248},{733, 350},{861, 435},{861, 350},{861, 171},{793, 83},{804, 227}};
    int side[][]= {{},{1,2},{2,3},{3,4},{3,5},{4,5},{5,6},{6,7},{6,12},{7,8},{7,13},
            {8,9},{8,10},{8,13},{9,10},{10,13},{10,11},{11,13},{11,12},{12,13}};
    public int place[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    String placeName[]={"","老教楼","阶梯教学楼","第二教学楼","第三教学楼","教学主楼","共建桥",
            "第四餐厅","七号公寓","篮球场","镜湖","体育馆","操场","第五餐厅"};

    public int sideDistance[][]=new int[vertex.length][vertex.length];
    int pathArray[][]=new int[vertex.length][vertex.length];
    int distanceSum[][]=new int[vertex.length][vertex.length];


    void InitializeEdge(){
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
                    if (distanceSum[i][k]!=65535&&distanceSum[k][j]!=65535&&distanceSum[i][j] 
                    		> distanceSum[i][k] + distanceSum[k][j]) {
                        distanceSum[i][j] = distanceSum[i][k] + distanceSum[k][j];
                        pathArray[i][j] = pathArray[i][k];
                    }
                }
            }
        }
    }

    String shortP;
    void PrintShort1(int start,int end) {
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
    
    
    void PrintShort2(int start,int end,int through) {
        int k;
        for (int i = 1; i < vertex.length; ++i) {
            for (int j = 1; j < vertex.length; ++j) {
                if(i==start&&j==through){
                    shortP="所选路径:\n  "+placeName[i] + "->" + placeName[end] + "(经过点:"+placeName[through]+")\n路程:\n  " + distanceSum[i][end]+"米"+"\n"+"最短路径:\n  ";
                    k = pathArray[i][j];
                    shortP=shortP+placeName[i];
                    while (k != j) {
                        shortP=shortP+"->" + placeName[k];
                        k = pathArray[k][j];
                    }
                    shortP=shortP+"->" + placeName[j];
                }
            }
        }
        
        for (int i = 1; i < vertex.length; ++i) {
            for (int j = 1; j < vertex.length; ++j) {
                if(i==through&&j==end){
                    k = pathArray[i][j];
                    shortP=shortP+"\n  ";
                    while (k != j) {
                        shortP=shortP+"->" + placeName[k];
                        k = pathArray[k][j];
                    }
                    shortP=shortP+"->" + placeName[j];
                }
            }
        }
    }

    String Floyd(int start,int end,int through) {
        InitializeEdge();
        CountDistance();
        FloydShort(pathArray, distanceSum);
        if(through!=-1&&through!=0) {
        	PrintShort2(start,end,through);
        }else {
        	PrintShort1(start,end);
        }
        return shortP;
    }

    int x,y=1;
    String minT="最小生成树：\n";
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
                if(x==2*y) {
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