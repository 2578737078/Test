package junittest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Life {
	static final int max=10;
    static int rows;
    static int columns;
    static int[][] currentGeneration=new int[max][max];
    static int[][] nextGeneration=new int[max][max];
    public static void main(String[] args) throws InterruptedException 
    {
    	Read();
    	Output(0);
    	for(int i=0;i<max;i++){
    		Next();
    		Output(i+1);
    	}
    }
    public static void Read() 
    {
		File file = new File("D:\\Program Files(x86)\\Java\\workspace\\JunitTest\\firstgeneration.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            String StrArray[]=null;
            int[] line=new int[max];
            int count=0;
            while ((tempString = reader.readLine()) != null) {
                StrArray = tempString.split(",");
                for(int i=0;i<max;i++){
                	line[i]=Integer.valueOf(StrArray[i]);
                	currentGeneration[count][i]=line[i];
                }
                count++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
    public static void Next()
    {
    	for(rows=0;rows<max;rows++){
    		for(columns=0;columns<max;columns++){
    			nextGeneration[rows][columns]=getNewState(rows,columns);
    		}
    	}
    	for(rows=0;rows<max;rows++){
    		for(columns=0;columns<max;columns++){
    			currentGeneration[rows][columns]=nextGeneration[rows][columns];
    		}
    	}
    }
	private static int getNewState(int i, int j) 
	{
		int sum=0;
		if (i==0 && j==0){//左上角
			sum=currentGeneration[i][j+1]
				+currentGeneration[i+1][j]
				+currentGeneration[i+1][j+1];
		}
		else if(i==0 && j==max-1){//右上角
			sum=currentGeneration[i][j-1]
				+currentGeneration[i+1][j]
				+currentGeneration[i+1][j-1];
		}
		else if(i==max-1 && j==0){//左下角
			sum=currentGeneration[i][j+1]
				+currentGeneration[i-1][j]
				+currentGeneration[i-1][j+1];
		}
		else if(i==max-1 && j==max-1){//右下角
			sum=currentGeneration[i][j-1]
				+currentGeneration[i-1][j]
				+currentGeneration[i-1][j-1];
		}
		else if(i==0){//上边界
			sum=currentGeneration[i][j-1]
				+currentGeneration[i][j+1]
				+currentGeneration[i+1][j-1]
				+currentGeneration[i+1][j]
				+currentGeneration[i+1][j+1];
		}
		else if(i==max-1){//下边界
			sum=currentGeneration[i][j-1]
				+currentGeneration[i][j+1]
				+currentGeneration[i-1][j-1]
				+currentGeneration[i-1][j]
				+currentGeneration[i-1][j+1];
		}
		else if(j==0){//左边界
			sum=currentGeneration[i-1][j]
				+currentGeneration[i+1][j]
				+currentGeneration[i-1][j+1]
				+currentGeneration[i][j+1]
				+currentGeneration[i+1][j+1];
		}
		else if(j==max-1){//右边界
			sum=currentGeneration[i-1][j]
				+currentGeneration[i+1][j]
				+currentGeneration[i-1][j-1]
				+currentGeneration[i][j-1]
				+currentGeneration[i+1][j-1];
		}
		else {//中间
			sum=currentGeneration[i-1][j+1]
				+currentGeneration[i][j+1]
				+currentGeneration[i+1][j+1]
				+currentGeneration[i-1][j]
				+currentGeneration[i+1][j]
				+currentGeneration[i-1][j-1]
				+currentGeneration[i][j-1]
				+currentGeneration[i+1][j-1];
		}
		if (currentGeneration[i][j]==1){
			if (sum==2 || sum==3)
				return 1;
			else return 0;
		}
		else {
			if (sum==3)
				return 1;
			else return 0;
		}
	}
	public static void Output(int i) throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("第"+i+"次：");
		for(rows=0;rows<max;rows++){
    		for(columns=0;columns<max;columns++){
    			System.out.print(currentGeneration[rows][columns]+" ");
    		}
    		System.out.println();
    	}
	}
}
