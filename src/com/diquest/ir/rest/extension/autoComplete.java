package com.diquest.ir.rest.extension;

import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.rest.common.object.RestHttpRequest;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.common.Pages;
import com.diquest.ir.rest.extension.vo.SearchVo;
  
public class autoComplete implements QuerySetExtension{ 
	
	@Override 
	public void init() { 
		System.out.println("QueryExtension init");
	}
	
	@Override
	public QuerySet makeQuerySet(RestHttpRequest request) {

		request.getParams().put("currentPage", Pages.CURRENT_PAGE);
		
		SearchVo searchVo = new SearchVo(request.getParams());
        QuerySet querySet = new QuerySet(1);  						    	                                                                                
        
		Query query = new Query();            
		query.setSelect(CommonUtil.getSelectSet(Collections.AUTOCOMPLETE));				// 노출필드
		query.setWhere(CommonUtil.getWhereSet(searchVo, Collections.AUTOCOMPLETE));		// 검색조건
//		query.setOrderby(CommonUtil.getOrderBySet(searchVo, Collections.AUTOCOMPLETE));	// 정렬조건
		
		query.setLoggable(true);
    	query.setFrom(Collections.AUTOCOMPLETE);	// 대상 컬렉션 
    	query.setDebug(true);	
    	
    	query.setPrintQuery(true);
    	query.setResult(searchVo.getStart(), searchVo.getEnd());
		 		
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
   