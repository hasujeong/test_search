package com.diquest.ir.rest.extension.common;

import java.util.ArrayList;

import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.GroupBySet;
import com.diquest.ir.common.msg.protocol.query.OrderBySet;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.query.WhereSet;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.vo.SearchVo;

public class CommonUtil {

	public static SelectSet[] getSelectSet(String collection) {
    	
		SelectSet[] selectSets = null;
		
		/* 자동완성 노출 필드 설정 start */
		if(collection.equals(Collections.AUTOCOMPLETE)) {
			selectSets = new SelectSet[]{ 
					new SelectSet("KEYWORD", Protocol.SelectSet.NONE),		// 키워드 
					new SelectSet("CNT", Protocol.SelectSet.NONE)			// 검색 건수 
			};
			return selectSets;
		}
		/* 자동완성 노출 필드 설정 end */
		
		/* 인기검색어 노출 필드 설정 start */
		if(collection.equals(Collections.HOTKEY)) {
			selectSets = new SelectSet[]{ 
					new SelectSet("KEYWORD", Protocol.SelectSet.NONE),	// 검색어
					new SelectSet("RANKING", Protocol.SelectSet.NONE),	// 순위 
					new SelectSet("COUNT", Protocol.SelectSet.NONE),	// 
					new SelectSet("PREV_RANK", Protocol.SelectSet.NONE)	// 이전 순위 
			};
			return selectSets;
		}
		/* 인기검색어 노출 필드 설정 end */
		
		/* 제품 노출 필드 설정 start */
		if(collection.equals(Collections.PRODUCT)) {
			selectSets = new SelectSet[]{ 
//					new SelectSet("DQ_ID", Protocol.SelectSet.NONE),
					new SelectSet("MAKR_NM", Protocol.SelectSet.NONE),
					new SelectSet("PRDUCT_NM", Protocol.SelectSet.NONE),
					new SelectSet("SLE_AMOUNT", Protocol.SelectSet.NONE),
					new SelectSet("SPUSE_DSCSS_AT", Protocol.SelectSet.NONE),
					new SelectSet("REPRSNT_PRDUCT_IMAGE_ATCHMNFL", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE)
			};
			return selectSets;
		}
		/* 제품 노출 필드 설정 end */
    	
		/* 기술 노출 필드 설정 start */
		if(collection.equals(Collections.TECH)) {
			selectSets = new SelectSet[]{ 
//					new SelectSet("DQ_ID", Protocol.SelectSet.NONE),
					new SelectSet("MAKR_NM", Protocol.SelectSet.NONE),
					new SelectSet("TCHNLGY_NM", Protocol.SelectSet.NONE),
					new SelectSet("SLE_AMOUNT", Protocol.SelectSet.NONE),
					new SelectSet("SPUSE_DSCSS_AT", Protocol.SelectSet.NONE),
					new SelectSet("REPRSNT_TCHNLGY_IMAGE_ATCHMNFL", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("TCHNLGY_CTGRY_LCLAS_NM", Protocol.SelectSet.NONE),
					new SelectSet("TCHNLGY_CTGRY_SCLAS_NM", Protocol.SelectSet.NONE)
			};
			return selectSets;
		}
		/* 기술 노출 필드 설정 end */
		
		/* 튜닝작업 검색 노출필드 start */    	
		if(collection.equals(Collections.TUNING)) {
			selectSets = new SelectSet[]{
					new SelectSet("ESTMT_NM", Protocol.SelectSet.NONE),
					new SelectSet("RESULT_SCORE", Protocol.SelectSet.NONE),
					new SelectSet("RDCNT", Protocol.SelectSet.NONE),
					new SelectSet("RQESTER_NM", Protocol.SelectSet.NONE),
					new SelectSet("ENTRPS_NM", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("TOTAL_AMOUNT", Protocol.SelectSet.NONE),
					new SelectSet("TCHNLGY_CTGRY_LCLAS_NM", Protocol.SelectSet.NONE),
					new SelectSet("TCHNLGY_CTGRY_SCLAS_NM", Protocol.SelectSet.NONE),
					new SelectSet("HASHTAG", Protocol.SelectSet.NONE)
			};
		}
		/* 튜닝작업 검색 노출필드 end */
		
		/* 브랜드관 검색 노출필드 start */    	
		if(collection.equals(Collections.BRAND)) {
			selectSets = new SelectSet[]{
					new SelectSet("ENTRPS_NM", Protocol.SelectSet.NONE),
					new SelectSet("INDUTY", Protocol.SelectSet.NONE),
					new SelectSet("ENTRPS_LOGO", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("RDCNT", Protocol.SelectSet.NONE)
			};
		}
		/* 브랜드관 검색 노출필드 end */
		
		/* 우수업체 검색 노출필드 start */    	
		if(collection.equals(Collections.GOOD)) {
			selectSets = new SelectSet[]{
					new SelectSet("NOTICE_SJ", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("UPDT_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("RDCNT", Protocol.SelectSet.NONE)
			};
		}
		/* 우수업체 검색 노출필드 end */
		
		/* 뉴스 검색 노출필드 start */    	
		if(collection.equals(Collections.NEWS)) {
			selectSets = new SelectSet[]{
					new SelectSet("NEWS_SJ", Protocol.SelectSet.NONE),
					new SelectSet("NEWS_LINK", Protocol.SelectSet.NONE),
					new SelectSet("NEWS_RDCNT", Protocol.SelectSet.NONE),
					new SelectSet("NEWS_PBLCATE_PNTTM", Protocol.SelectSet.NONE)
			};
		}
		/* 뉴스 검색 노출필드 end */
		
		/* 구인 검색 노출필드 start */    	
		if(collection.equals(Collections.JOB)) {
			selectSets = new SelectSet[]{
					new SelectSet("JO_SJ,", Protocol.SelectSet.NONE),
					new SelectSet("CHRG_DTY,", Protocol.SelectSet.NONE),
					new SelectSet("ETC_MATTER,", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM,", Protocol.SelectSet.NONE),
					new SelectSet("CLOS_DE", Protocol.SelectSet.NONE)
			};
		}
		/* 구인 검색 노출필드 end */
		
		/* QnA 검색 노출필드 start */    	
		if(collection.equals(Collections.QNA)) {
			selectSets = new SelectSet[]{
					new SelectSet("INQRY_SJ", Protocol.SelectSet.NONE),
					new SelectSet("INQRY_CN", Protocol.SelectSet.NONE),
					new SelectSet("ANSWER_CN", Protocol.SelectSet.NONE),
					new SelectSet("LCLAS_CODE_NM", Protocol.SelectSet.NONE),
					new SelectSet("SCLAS_CODE_NM", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE)
			};
		}
		/* QnA 검색 노출필드 end */
		
		/* FAQ 검색 노출필드 start */    	
		if(collection.equals(Collections.FAQ)) {
			selectSets = new SelectSet[]{
					new SelectSet("FAQ_SJ", Protocol.SelectSet.NONE),
					new SelectSet("FAQ_CN", Protocol.SelectSet.NONE),
					new SelectSet("REGIST_PNTTM", Protocol.SelectSet.NONE)
			};
		}
		/* FAQ 검색 노출필드 end */
		
		/* 게시판 검색 노출필드 start */    	
		if(collection.equals(Collections.BOARD)) {
			selectSets = new SelectSet[]{
					new SelectSet("NTT_SJ", Protocol.SelectSet.NONE),
					new SelectSet("NTT_CN", Protocol.SelectSet.NONE),
					new SelectSet("RDCNT", Protocol.SelectSet.NONE),
					new SelectSet("FRST_REGIST_PNTTM", Protocol.SelectSet.NONE),
					new SelectSet("BBS_NM", Protocol.SelectSet.NONE)
			};
		}
		/* 게시판 검색 노출필드 end */
		
		
    	/* 통합검색 노출필드 start */    	
    	selectSets = new SelectSet[]{
    			
		};
    	/* 통합검색 노출필드 end */

    	return selectSets;
    	
    }
	
	
	public static WhereSet[] getWhereSet(SearchVo searchVo, String collection) {

        ArrayList<WhereSet> whereSetList = new ArrayList<WhereSet>();
        WhereSet[] whereSets = null;
        
        /* 자동완성 검색 조건 설정 start */
        if(collection.equals(Collections.AUTOCOMPLETE)) {
        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));    
			whereSetList.add(new WhereSet ("IDX_FKEY", Protocol.WhereSet.OP_HASALL, searchVo.getSearchTerm(), 100));		 	
			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_OR));
			whereSetList.add(new WhereSet ("IDX_BKEY", Protocol.WhereSet.OP_HASALL, searchVo.getSearchTerm(), 10));		 
			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
			
			whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 자동완성 검색 조건 설정 end */
        
        /* 제품 검색 조건 설정 start */
        if(collection.equals(Collections.PRODUCT)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_MAKR_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_PRDUCT_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_PRDUCT_DC", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_HASHTAG", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
		        	
		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 제품 검색 조건 설정 end */
        
        /* 기술 검색 조건 설정 start */
        if(collection.equals(Collections.TECH)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_MAKR_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_TCHNLGY_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_TCHNLGY_DC", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_HASHTAG", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
		        	
		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 기술 검색 조건 설정 end */
        
        /* 튜닝작업 검색 조건 설정 start */
        if(collection.equals(Collections.TUNING)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_ESTMT_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_RESULT_CN", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_HASHTAG", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
		        	
		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 튜닝작업 검색 조건 설정 end */
        
        /* 브랜드관 검색 조건 설정 start */
        if(collection.equals(Collections.BRAND)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_ENTRPS_NM", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_INDUTY", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_ENTRPS_ETC_INFO", Protocol.WhereSet.OP_HASALL, searchTerms[i]));

		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 브랜드관 검색 조건 설정 end */
        
        /* 우수업체 검색 조건 설정 start */
        if(collection.equals(Collections.GOOD)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_NOTICE_SJ", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_NOTICE_CN", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		
		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 우수업체 검색 조건 설정 end */
        
        /* 뉴스 검색 조건 설정 start */
        if(collection.equals(Collections.NEWS)) {
        	
        	if(!searchVo.getSearchTerm().equals("")) {
	        	String[] searchTerms = searchVo.getSearchTerms();
	        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_OPEN));
	        	for(int i = 0; i < searchTerms.length; i++) {
	        		if(i > 0) {
	        			whereSetList.add(new WhereSet(Protocol.WhereSet.OP_AND));
	        		}
	        		
	        		whereSetList.add(new WhereSet ("IDX_NEWS_SJ", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		whereSetList.add(new WhereSet (Protocol.WhereSet.OP_OR));
	        		whereSetList.add(new WhereSet ("IDX_NEWS_CN", Protocol.WhereSet.OP_HASALL, searchTerms[i]));
	        		
		        	whereSetList.add(new WhereSet(Protocol.WhereSet.OP_BRACE_CLOSE));
	        	}
        	}
        	
        	whereSets = new WhereSet[whereSetList.size()];            
            for(int i = 0; i < whereSetList.size(); i++){
                   whereSets[i] = whereSetList.get(i);
            }
            
            return whereSets;
        }
        /* 뉴스 검색 조건 설정 end */
        
        
		whereSets = new WhereSet[whereSetList.size()];            
        for(int i = 0; i < whereSetList.size(); i++){
               whereSets[i] = whereSetList.get(i);
        }
        
//        WhereSet[] whereSets = whereSetList.toArray(new WhereSet[whereSetList.size()]);
        
        return whereSets;
    }
	
	
	public static GroupBySet[] getGroupbySet(SearchVo searchVo, String collection) {
		
		GroupBySet[] groupBySets = null;
		
		
		if(collection.equals(Collections.TOTAL)) {
			groupBySets = new GroupBySet[] {
	  			new GroupBySet("GROUP_PC_CD",(byte) (Protocol.GroupBySet.OP_COUNT | Protocol.GroupBySet.ORDER_COUNT), "DESC", "")  // 카테고리 그룹필드 설정 (2depth)
	  		};
			
			return groupBySets;
		}
		
		if(collection.equals(Collections.BOARD)) {
			groupBySets = new GroupBySet[] {
	  			new GroupBySet("GROUP_PC_CD",(byte) (Protocol.GroupBySet.OP_COUNT | Protocol.GroupBySet.ORDER_COUNT), "DESC", "")  // 카테고리 그룹필드 설정 (2depth)
	  		};
			
			return groupBySets;
		}
				
		return groupBySets;
	}
	
	
	public static OrderBySet[] getOrderBySet(SearchVo searchVo, String collection) {
		
		OrderBySet[] orderBySet = null;
				
		/* 자동완성 정렬 start
		if(collection.equals(Collections.AUTOCOMPLETE)) {
			orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_CNT", Protocol.OrderBySet.OP_POSTWEIGHT)};
			return orderBySet;
		}
		/* 자동완성 정렬 end */
		
		/* 인기검색어 정렬 start */
		if(collection.equals(Collections.HOTKEY)) {
			orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_RANKING", Protocol.OrderBySet.OP_POSTWEIGHT)};
			return orderBySet;
		}
		/* 인기검색어 정렬 end */
		
		
		/* JOB 정렬 start */
		if(collection.equals(Collections.JOB)) {
			
			if (searchVo.getSort().equals("reg")) { 					// 등록일시순 (최신순)
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("view")) { 					// 조회수순
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_VIEW_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else {
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_PREWEIGHT) };
			}
			
			return orderBySet;
		}
		/* JOB 정렬 end */
		
				
		/* buyer 정렬 start */
		if(collection.equals(Collections.JOB)) {
			
			if (searchVo.getSort().equals("reg")) { 					// 등록일시순 (최신순)
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("view")) { 					// 조회수순
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_VIEW_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else {
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_PREWEIGHT) };
			}
			
			return orderBySet;
		}
		/* buyer 정렬 end */
		
		/* total 정렬 start */
		if(collection.equals(Collections.TOTAL)) {
			
			if (searchVo.getSort().equals("scr")) { 					// 스크리닝수 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_SCR_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("play")) { 					// playlist 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_PLY_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("mat")) { 					// 매칭수 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_MAT_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("reg")) { 					// 등록일시순 (최신순)
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("modify")) { 					// 수정일시 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_MDFCN_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else {
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_PREWEIGHT) };
			}
		}
		
		/* event 정렬 start */
		if(collection.equals(Collections.BOARD)) {
			if (searchVo.getSort().equals("scr")) { 					// 스크리닝수 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_SCR_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("play")) { 					// playlist 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_PLY_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("mat")) { 					// 매칭수 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_PIT_MAT_CNT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("reg")) { 					// 등록일시순 (최신순)
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else if (searchVo.getSort().equals("modify")) { 					// 수정일시 정렬
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_MDFCN_DT", Protocol.OrderBySet.OP_POSTWEIGHT) };
			} else {
				orderBySet = new OrderBySet[] { new OrderBySet(true, "SORT_REG_DT", Protocol.OrderBySet.OP_PREWEIGHT) };
			}
		}
		
		return orderBySet;
	}
		
	
	public static int getPageStart(String currentPage, String rowsperPage) {
		return Integer.parseInt(rowsperPage)*(Integer.parseInt(currentPage)-1);
	}
	
	public static int getPageEnd(String currentPage, String rowsperPage) {
		return (Integer.parseInt(rowsperPage)*Integer.parseInt(currentPage))-1;
	}
	
}
