package Week2.Day2;



public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0;
		//String result = null;
		String[] ssplit = text.split("\\s");
		for (int i = 0; i < ssplit.length; i++) {
			System.out.println("MainString:"+ssplit[i]);
			for (int j = i + 1; j < ssplit.length; j++) {
				System.out.println(ssplit[j]);
				if (ssplit[i].equals(ssplit[j])) {
					count++;
					ssplit[j] = "";
				}
				if (count >= 1 ) {
					System.out.print(ssplit[j]);
					System.out.println("C:" + count);
					count = 0;
					 System.out.println("comparison:"+ssplit[i].replace(ssplit[j]," "));
				}	
			}
			
			if(count==0)
			{
				System.out.print(ssplit[i]+" ");
			}
		}

	}

}
