package client;

import entity.Mobile;
import factory.MobileFactory;

public class AppFactory {
	public static void main(String[] args) {
		MobileFactory mf = new MobileFactory();
		Mobile mobile = mf.getMobile("nokia");
		if(mobile!=null)
			mobile.show();
		else
			System.out.println("Choose correct type!");
	}
}
