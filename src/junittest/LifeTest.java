package junittest;

import org.junit.Test;
import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class LifeTest {
	@SuppressWarnings("unused")
	@Test
    public void testlife(){
		Life life=new Life();
		Life.Read();
		for(int i=0;i<10;i++)
			Life.Next();
		int[][] currentGeneration=Life.currentGeneration;
		int[][] finalGeneration={
				{0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
				{0, 0, 1, 1, 0, 0, 0, 0, 1, 0}, 
				{0, 1, 1, 1, 0, 0, 0, 0, 1, 0}, 
				{0, 1, 0, 1, 1, 1, 0, 1, 1, 0}, 
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
				{0, 1, 1, 0, 1, 1, 1, 0, 1, 0}, 
				{0, 1, 0, 0, 0, 0, 1, 1, 1, 0}, 
				{0, 1, 0, 0, 0, 0, 1, 1, 0, 0}, 
				{0, 1, 0, 0, 0, 0, 1, 1, 0, 0}};
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				Assert.assertEquals(currentGeneration[i][j],finalGeneration[i][j]);
    }
}