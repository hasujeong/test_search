package com.diquest.ir.rest.extension;

import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.OrderBySet;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QueryParser;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.query.WhereSet;
import com.diquest.ir.rest.common.object.RestHttpRequest;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.vo.SearchVo;

public class serviceSearch implements QuerySetExtension {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("QueryExtension init");
		
	}

	@Override
	public QuerySet makeQuerySet(RestHttpRequest request) {

		SearchVo searchVo	= new SearchVo(request.getParams());
		
		QuerySet querySet = new QuerySet(1);
		
		QueryParser parser = new QueryParser();
		
		Query query = new Query();
					
		SelectSet[] selectSets 		= CommonUtil.getSelectSet(Collections.QNA);
		WhereSet[] whereSets 		= CommonUtil.getWhereSet(searchVo, Collections.QNA);		// 검색조건     
    	OrderBySet[] orderBySets 	= CommonUtil.getOrderBySet(searchVo, Collections.QNA);	// 정렬조건      
				
		query.setSelect(selectSets);
		query.setWhere(whereSets);
		query.setOrderby(orderBySets);
		query.setResult(searchVo.getStart(), searchVo.getEnd());
		
		query.setFrom(Collections.QNA);
		query.setDebug(true);
		query.setFaultless(true);
		query.setPrintQuery(true);			// 실제 반영시 제거
		
		/* 검색로그 관련 start */
    	// 검색 로그의 경우 현재 상품에 대한 로그만 수집하여 자동완성검색에서 사용 
    	// (아래의 설정에서 쌓인 데이터로 자동완성 검색 사용) 
    	query.setLoggable(true);	// 검색 로그 추가 여부 
    	query.setLogKeyword(searchVo.getSearchTerm().toCharArray());	// 검색 로그에 저장될 키워드 
    	/* 검색로그 관련 end */
    	
    	
		query.setSearchOption((byte)(Protocol.SearchOption.CACHE | Protocol.SearchOption.BANNED | Protocol.SearchOption.STOPWORD));	// 검색 캐시, 금지어, 불용어 사전 사용 설정 
 		query.setThesaurusOption((byte)(Protocol.ThesaurusOption.QUASI_SYNONYM | Protocol.ThesaurusOption.EQUIV_SYNONYM));			// 동의어, 유의어 사전 사용 설정 
		
		String queryStr = parser.queryToString(query);
		
		System.out.println("QNA_query :::: " + queryStr);
		
		querySet.addQuery(query);
		
		return querySet;
	}

}
