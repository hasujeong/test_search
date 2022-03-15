package com.diquest.ir.rest.extension;

import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.rest.common.object.RestHttpRequest;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.common.Pages;
  
public class trendsKeyword implements QuerySetExtension{ 
	
	@Override 
	public void init() {  
		System.out.println("QueryExtension init");
	}
	
	/* 인기검색어 */
	@Override
	public QuerySet makeQuerySet(RestHttpRequest request) {
		
		String rowsperPage = request.getParams().get("rowsperPage");
		if(rowsperPage == null || rowsperPage.equals("") || rowsperPage.equals("0")) {
			rowsperPage = Pages.ROWS;
		}
		int start 	= CommonUtil.getPageStart(Pages.CURRENT_PAGE, rowsperPage);
		int end 	= CommonUtil.getPageEnd(Pages.CURRENT_PAGE, rowsperPage);
		
        QuerySet querySet = new QuerySet(1);  						    	                                                                                
        
		Query query = new Query();            
		query.setSelect(CommonUtil.getSelectSet(Collections.HOTKEY));
		query.setOrderby(CommonUtil.getOrderBySet(null, Collections.HOTKEY));
		query.setFrom(Collections.HOTKEY);
		
		query.setLoggable(false);
    	query.setDebug(true);
    	query.setPrintQuery(false);
    	query.setResult(start, end);
		 		
        querySet.addQuery(query);
		return querySet;
	}

	@SuppressWarnings("unused")
	private int getIntParam(String param, int defVal) {
		try {
			int val = Integer.parseInt(param);
			return val;
		} catch (Exception e) {
			return defVal;
		}
	}
	
	
}
   