package Interview;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Saroye
 *
 */
public class box_cutting {


	public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
//		c.maxProfit(1,10,w)

		if(lengths.size()==0) return 0;
		int left=1;
		int right=0;
		for(int i:lengths) {
			right=Math.max(i,right);
		}
		return BST(lengths,salePrice,costPerCut,left,right);
	}

	static int BST(List<Integer> lengths,int salePrice,int costPerCut,int Left,int Right){
		if(Left>Right) {
			return 0;
		}
		int mid=Left+(Right-Left)/2;
		
		int Cutleft=helper(lengths,salePrice,costPerCut,Left);
		int Cutright=helper(lengths,salePrice,costPerCut,Right);
		int Cutmid=helper(lengths,salePrice,costPerCut,mid);
		
		int Rec_left=BST(lengths,salePrice,costPerCut,Left,mid-1);
		int Rec_right=BST(lengths,salePrice,costPerCut,mid+1,Right);
		
		int surplus=Math.max(Rec_left,Rec_right);
		surplus=Math.max(surplus,Math.max(Cutleft,Math.max(Cutright,Cutmid)));
		
		return surplus;
	}

	static int helper(List<Integer> lengths,int salePrice,int costPerCut,int totalUniformRods){
		int saleLength=0;
		int totalCuts=0;
		for(int i=0;i<lengths.size();i++)
		{
			saleLength+=lengths.get(i)/totalUniformRods;
			if(lengths.get(i)%totalUniformRods==0){
				totalCuts+=(lengths.get(i)/totalUniformRods)-1;
			}
			else {
				totalCuts+=(lengths.get(i)/totalUniformRods);
			}
		}
		return (totalUniformRods*saleLength*salePrice)-(totalCuts*costPerCut);
	}

	public static void main(String[] args) {
		box_cutting c = new box_cutting();
		List<Integer> w = new ArrayList<Integer>();
		w.add(30);
		w.add(15);
		w.add(10);
		w.add(6);
		w.add(5);
		w.add(3);
		System.out.println(c.maxProfit(1,10,w));
		
		
	}
}


