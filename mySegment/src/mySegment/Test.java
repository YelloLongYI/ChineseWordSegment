package mySegment;

public class Test {

	public static void main(String[] args) throws Exception{
		
		MySegment test=new MySegment(5);
		
		/*
		 * ���ԣ�
		 * "�ҽ�������һ������������"
		 * ������/����/ҩ��    ����/�г�/��ҩ/��
		 * ��Ʒ�ͷ���Ա   �ڴʵ��м��롰�ͷ����������㷨������N���·����
		 */
		String s="��Ʒ�ͷ���Ա";
		System.out.println(test.segment_Maximum_Forward_Matching(s));
		System.out.println(test.segment_N_Minimum_Path(s));
		
	}
}
