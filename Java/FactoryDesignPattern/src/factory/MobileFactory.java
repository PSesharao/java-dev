package factory;

import entity.Mobile;
import entity.impl.Nokia;
import entity.impl.RealMe;
import entity.impl.Redmi;
import entity.impl.Samsung;

public class MobileFactory {
	public Mobile getMobile(String mobileType )
	{
		if(mobileType.equals("mi"))
			return new Redmi();
		else if(mobileType.equals("sam"))
			return new Samsung();
		else if(mobileType.equals("nokia"))
			return new Nokia();
		else if(mobileType.equals("realme"))
			return new RealMe();
		return null;
	}
}
