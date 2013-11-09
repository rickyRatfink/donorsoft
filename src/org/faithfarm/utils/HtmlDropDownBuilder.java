package org.faithfarm.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.faithfarm.domain.DropDownItem;
import org.faithfarm.domain.GiftType;
import org.faithfarm.domain.State;
import org.faithfarm.hibernate.dao.GiftTypeDao;
import org.faithfarm.hibernate.dao.StateDao;

public class HtmlDropDownBuilder {

	public void refresh(HttpSession session) {
	   	
        StateDao dao3 = new StateDao();
        List<State> list3 = new ArrayList<State>();
        list3=dao3.listStates();
        session.setAttribute("ddl_state", list3);

		GiftTypeDao dao4 = new GiftTypeDao();
		List<GiftType> list4 = new ArrayList<GiftType>();
		list4 = dao4.listGiftTypes();
	    session.setAttribute("ddl_giftType", list4);
      
	   List<DropDownItem> yesNo = new ArrayList<DropDownItem>();
	   yesNo.add(new DropDownItem("Yes","Yes"));
	   yesNo.add(new DropDownItem("No","No"));
	   session.setAttribute("ddl_yesNo", yesNo);
	 
	}
	

}
