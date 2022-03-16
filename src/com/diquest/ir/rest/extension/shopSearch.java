package com.diquest.ir.rest.extension;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.diquest.ir.common.database.entity.feedback.FeedbackLog;
import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.FilterSet;
import com.diquest.ir.common.msg.protocol.query.GroupBySet;
import com.diquest.ir.common.msg.protocol.query.OrderBySet;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QueryParser;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.query.WhereSet;
import com.diquest.ir.common.msg.protocol.repository.CFRecommendReq;
import com.diquest.ir.rest.common.object.RestHttpRequest;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.vo.SearchVo;

public class shopSearch implements QuerySetExtension {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("QueryExtension init");
		
	}

	@Override
	public QuerySet makeQuerySet(RestHttpRequest request) {

		SearchVo searchVo	= new SearchVo(request.getParams());
		
		if (request.getParams().size() == 1) {
			String test	= request.getRequestBody();
			try {
				test = URLDecoder.decode(test, "utf-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Map<String, String> paramMap = request.getParams();
			
			String[] params = test.split("&");
	        for (String param : params) {
	        	if (param.split("=").length == 2) {
	        		String name = param.split("=")[0];
		            String value = param.split("=")[1];
		            paramMap.put(name, value);
	        	}
	        }
			
			searchVo = new SearchVo(paramMap);
		}
		
		QuerySet querySet = new QuerySet(1);
		
		QueryParser parser = new QueryParser();
		
		char[] startTag = "<b>".toCharArray(); // Highlight tag 설정 startTag
		char[] endTag = "</b>".toCharArray(); // Highlight tag 설정 endTag
		
		Query query = new Query(startTag, endTag);
		
		SelectSet[] selectSets 		= CommonUtil.getSelectSet(Collections.PRODUCT);
//		WhereSet[] whereSets 		= CommonUtil.getWhereSet(searchVo, Collections.PRODUCT);		// 검색조건     
//    	OrderBySet[] orderBySets 	= CommonUtil.getOrderBySet(searchVo, Collections.PRODUCT);	// 정렬조건      
//    	GroupBySet[] groupBySets	= CommonUtil.getGroupbySet(searchVo, Collections.PRODUCT);	// 그룹설정
//    	FilterSet[] filterSets		= CommonUtil.getFilterSet(searchVo);						// 필터조건 ( >> 가격 범위 검색 ) 
    			
		query.setSelect(selectSets);
//		if(whereSets != null) {
//			query.setWhere(whereSets);
//		}
//		query.setOrderby(orderBySets);
//		query.setGroupBy(groupBySets);	
//		if(filterSets != null) {
//			query.setFilter(filterSets); 
//		}
		
		/*FeedbackLog feedbackLog = new FeedbackLog(Collections.PRODUCT, searchVo.getSearchTerm(), "332006004420");
		try {
			CommandFeedbackLog.request("127.0.0.1", 5555, feedbackLog);
		} catch (IRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	query.setFrom(Collections.PRODUCT);
    	query.setResult(searchVo.getStart(), searchVo.getEnd());
    	
    	/* 검색로그 관련 start */
    	// 검색 로그의 경우 현재 상품에 대한 로그만 수집하여 자동완성검색에서 사용 
    	// (아래의 설정에서 쌓인 데이터로 자동완성 검색 사용) 
    	if(searchVo.getLogKeyword() != null && !searchVo.getLogKeyword().equals("")) {
	    	query.setLoggable(true);	// 검색 로그 추가 여부 
	    	query.setLogKeyword(searchVo.getLogKeyword().toCharArray());	// 검색 로그에 저장될 키워드 
    	}
    	/* 검색로그 관련 end */
    	
		query.setDebug(true);
		query.setFaultless(true);
		query.setPrintQuery(true);			// 실제 반영시 제거
//    	
//		query.setSearchOption((byte)(Protocol.SearchOption.CACHE | Protocol.SearchOption.BANNED | Protocol.SearchOption.STOPWORD));	// 검색 캐시, 금지어, 불용어 사전 사용 설정 
// 		query.setThesaurusOption((byte)(Protocol.ThesaurusOption.QUASI_SYNONYM | Protocol.ThesaurusOption.EQUIV_SYNONYM));			// 동의어, 유의어 사전 사용 설정 
// 		query.setRankingOption((byte) (Protocol.RankingOption.CATEGORY_RANKING | Protocol.RankingOption.DOCUMENT_RANKING));			// 카테고리 랭킹, 문서랭킹 사용 설정
// 		query.setCategoryRankingOption((byte)(Protocol.CategoryRankingOption.MULTI_TERM_KOREAN | Protocol.CategoryRankingOption.QUASI_SYNONYM | Protocol.CategoryRankingOption.EQUIV_SYNONYM));
// 		// 카테고리 랭킹 시 키워드 한국어 형태소로 분석하여 사용하겠다는 추가 설정 (korean)
 		
//		String queryStr = parser.queryToString(query);
		
		querySet.addQuery(query);
		
		return querySet;
	}

}
