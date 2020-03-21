package Testing.TestLombok;

import lombok.Data;

public @Data class TestLambokExample {

	private int Age;
	private String Name;
	private String Address;
	
	public static void main(String arg[])
	{
		TestLambokExample tem = new TestLambokExample();
		tem.setAge(20);
		tem.setName("SomeName");
		tem.setAddress("Some Address");
		System.out.println(tem);
	}

}
