package mySegment;

public class Test {

	public static void main(String[] args) throws Exception{
		
		MySegment test=new MySegment(5);
		
		/*
		 * 测试：
		 * "我今天买了一张三角形桌子"
		 * 长春市/长春/药店    长春/市长/春药/店
		 * 商品和服务员   在词典中加入“和服”，两种算法有区别，N最短路径好
		 */
		String s="商品和服务员";
		System.out.println(test.segment_Maximum_Forward_Matching(s));
		System.out.println(test.segment_N_Minimum_Path(s));
		
	}
}
