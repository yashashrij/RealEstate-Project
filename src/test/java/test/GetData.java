package test;

import com.clearcode.utils.DBUtils;

public class GetData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[][] a = DBUtils.getDBTable("select * from sys.sys_config;", 3);
		for(Object[] b:a)
		{
			for(Object c:b)
			{
				System.out.print(c+"\t\t");
			}
			System.out.println();
		}
		Object[][] b = {{"admin"}};
		System.out.println(a.equals(b));
	}

}
