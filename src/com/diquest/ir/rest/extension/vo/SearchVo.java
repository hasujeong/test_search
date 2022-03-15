package com.diquest.ir.rest.extension.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.common.Pages;

public class SearchVo {
	
	private String searchTerm; 		// 검색어
	private String sort;			// 정렬
	private String currentPage	= Pages.CURRENT_PAGE;	// 현재페이지 ( 기본 1 ) 
	private String rowsperPage	= Pages.ROWS;			// 페이지당 출력 건수 ( 기본 10 )
	
	private String type;			// 타입 검색
	private String typenm;			// 타입명 검색
	private String gern;			// 장르 검색
	private String gernnm;			// 장르명 검색
	private String age;				// 연령대 검색
	private String agenm;				// 연령대코드명 검색
	private String product;			// 제품상태
	private String productnm;			// 제품상태명
	private String lng;				// 언어검색
	private String lngnm;				// 언어명 검색
	private String mfcode;		// 메인플랫폼검색
	private String mfcodenm;		// 메인플랫폼명 검색
	private String mfcodeurl;				// mf url 코드리스트
	
	private String pmaincode;		// 메인비지니스타입부모코드 검색
	private String maincode;		// 메인비지니스타입코드 검색
	private String seccode;			// seccen비지니스타입코드 검색
	private String thdcode;			// third비지니스타입코드 검색
	
	private String fstmeet;			// fst_meet_type 검색
	private String secmeet;			// sec_meet_type 검색
	private String thdmeet;			// thd_meet_type 검색
	private String futmeet;			// fut_meet_type 검색
	private String fitmeet;			// fit_meet_type 검색
	
	private String bbacode;			// bbacode 검색
	private String bbaval;			// bbaval 검색
	private String bbccode;			// bbccode 검색
	private String bbcval;			// bbcval 검색
	private String bbwcode;			// bbwcode 검색
	private String bbwval;			// bbwval 검색
	private String bbgcode;			// bbgcode 검색
	private String bbgval;			// bbgval 검색
	private String bbocode;			// bbocode 검색
	private String bboval;			// bboval 검색
	
	private String kwd1;			// 키워드1
	private String kwd2;			// 키워드2
	private String kwd3;			// 키워드3
	private String kwd4;			// 키워드4
	private String kwd5;			// 키워드5
	
	private String tgcode;			// 담당자 계정 타이틀명
	private String entgcode;		// 계정타이틀코드 영문명
	private String firstnm;			// 담당자 성
	private String lastnm;			// 담당자 이름
	private String email;			// 담당자 이메일
	private String telno;			// 담당자 전화번호
	
	private String catecode;			// 카테고리코드
	private String catecodenm;			// 카테고리코드명
	private String encatecode;			// 카테고리코드 영문명	
	private String cttypecode;			// 컨텍트타입코드
	private String cttypecodenm;			// 컨텍트타입코드명
	private String enproductnm;			// 제품상태명(영문)
	private String pntncode;				// 판매국가 코드
	private String pntncodenm;				// 판매국가명 코드
	
	private String ntncode;				// 회사권역 코드
	private String ntncodenm;			// 회사권역 코드명
	private String enntncode;			// 회사권역 코드 영문
	
	private String syear;				// start 년도
	private String eyear;				// end 년도
	private String uhdck;				// uhd 여부
	private String cdck;				// cd 여부
	private String hdck;				// hd 여부
	private String crossck;				// crossmedia 여부
	
	private String cityname;				// 도시명
	private String openyear;				// 설립일
	
	private String etidx;				// 행사 일련번호
	
	
	// 페이지 관련 
	private int start;
	private int end;
	
	// 로그 남길 키워드 
	private String logKeyword;
	
	public String[] getSearchTerms() {
		return searchTerm.split(Pages.DEL);
	}
	public String getSort() {
		return sort;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public String getRowsperPage() {
		return rowsperPage;
	}
	public String[] getTypes() {
		return type.split(Pages.DEL);
	}
	public String[] getTypenms() {
		return typenm.split(Pages.DEL);
	}
	public String[] getProducts() {
		return product.split(Pages.DEL);
	}
	public String[] getProductnms() {
		return productnm.split(Pages.DEL);
	}
	public String[] getGerns() {
		return gern.split(Pages.DEL);
	}
	public String[] getGernnms() {
		return gernnm.split(Pages.DEL);
	}
	public String[] getAges() {
		return age.split(Pages.DEL);
	}
	public String[] getAgenms() {
		return agenm.split(Pages.DEL);
	}
	public String[] getLngs() {
		return lng.split(Pages.DEL);
	}
	public String[] getLngnms() {
		return lngnm.split(Pages.DEL);
	}
	public String[] getPmaincodes() {
		return pmaincode.split(Pages.DEL);
	}
	public String[] getMaincodes() {
		return maincode.split(Pages.DEL);
	}
	public String[] getSeccodes() {
		return seccode.split(Pages.DEL);
	}
	public String[] getThdcodes() {
		return thdcode.split(Pages.DEL);
	}
	public String[] getFstmeets() {
		return fstmeet.split(Pages.DEL);
	}
	public String[] getSecmeets() {
		return secmeet.split(Pages.DEL);
	}
	public String[] getThdmeets() {
		return thdmeet.split(Pages.DEL);
	}
	public String[] getFutmeets() {
		return futmeet.split(Pages.DEL);
	}
	public String[] getFitmeets() {
		return fitmeet.split(Pages.DEL);
	}
	public String[] getBbacodes() {
		return bbacode.split(Pages.DEL);
	}
	public String[] getBbavals() {
		return bbaval.split(Pages.DEL);
	}
	public String[] getBbccodes() {
		return bbccode.split(Pages.DEL);
	}
	public String[] getBbcvals() {
		return bbcval.split(Pages.DEL);
	}
	public String[] getBbwcodes() {
		return bbwcode.split(Pages.DEL);
	}
	public String[] getBbwvals() {
		return bbwval.split(Pages.DEL);
	}
	public String[] getBbgcodes() {
		return bbgcode.split(Pages.DEL);
	}
	public String[] getBbgvals() {
		return bbgval.split(Pages.DEL);
	}
	public String[] getBbocodes() {
		return bbocode.split(Pages.DEL);
	}
	public String[] getBbovals() {
		return bboval.split(Pages.DEL);
	}
	
	public String[] getMfcodes() {
		return mfcode.split(Pages.DEL);
	}
	public String[] getMfcodenms() {
		return mfcodenm.split(Pages.DEL);
	}
	public String[] getMfcodeurls() {
		return mfcodeurl.split(Pages.DEL);
	}
	public String[] getCttypecodes() {
		return cttypecode.split(Pages.DEL);
	}
	public String[] getCttypenms() {
		return cttypecodenm.split(Pages.DEL);
	}
	public String[] getEnproductnms() {
		return enproductnm.split(Pages.DEL);
	}
	public String[] getPntncodes() {
		return pntncode.split(Pages.DEL);
	}
	public String[] getPntncodenms() {
		return pntncodenm.split(Pages.DEL);
	}

	
	public String getCityname() {
		return cityname;
	}
	public String getOpenyear() {
		return openyear;
	}
	public String getKwd1() {
		return kwd1;
	}
	public String getKwd2() {
		return kwd2;
	}
	public String getKwd3() {
		return kwd3;
	}
	public String getKwd4() {
		return kwd4;
	}
	public String getKwd5() {
		return kwd5;
	}
	public String getTgcode() {
		return tgcode;
	}
	public String getEntgcode() {
		return entgcode;
	}
	public String getFirstnm() {
		return firstnm;
	}
	public String getLastnm() {
		return lastnm;
	}
	public String getEmail() {
		return email;
	}
	public String getTelno() {
		return telno;
	}
	public String getCatecode() {
		return catecode;
	}
	public String getCatecodenm() {
		return catecodenm;
	}
	public String getEncatecode() {
		return encatecode;
	}
	public String getNtncode() {
		return ntncode;
	}
	public String getNtncodenm() {
		return ntncodenm;
	}
	public String getEnntncode() {
		return enntncode;
	}
	public String getSyear() {
		return syear;
	}
	public String getEyear() {
		return eyear;
	}
	public String getUhdck() {
		return uhdck;
	}
	public String getCdck() {
		return cdck;
	}
	public String getHdck() {
		return hdck;
	}
	public String getCrossck() {
		return crossck;
	}
	public String getMfcode() {
		return mfcode;
	}
	public String getMfcodeurl() {
		return mfcodeurl;
	}
	public String getMfcodenm() {
		return mfcodenm;
	}

	public String getTypenm() {
		return typenm;
	}
	public String getGernnm() {
		return gernnm;
	}
	public String getAgenm() {
		return agenm;
	}
	public String getLngnm() {
		return lngnm;
	}
	public String getSearchTerm() {
		return searchTerm;
	}
	public String getProduct() {
		return product;
	}
	public String getProductnm() {
		return productnm;
	}
	public String getType() {
		return type;
	}
	public String getGern() {
		return gern;
	}
	public String getAge() {
		return age;
	}
	public String getLng() {
		return lng;
	}
	public String getPmaincode() {
		return pmaincode;
	}
	public String getMaincode() {
		return maincode;
	}
	public String getSeccode() {
		return seccode;
	}
	public String getThdcode() {
		return thdcode;
	}
	public String getBbacode() {
		return bbacode;
	}
	public String getBbaval() {
		return bbaval;
	}
	public String getBbccode() {
		return bbccode;
	}
	public String getBbcval() {
		return bbcval;
	}
	public String getBbwcode() {
		return bbwcode;
	}
	public String getBbwval() {
		return bbwval;
	}
	public String getBbgcode() {
		return bbgcode;
	}
	public String getBbgval() {
		return bbgval;
	}
	public String getBbocode() {
		return bbocode;
	}
	public String getBboval() {
		return bboval;
	}
	public String getFstmeet() {
		return fstmeet;
	}
	public String getSecmeet() {
		return secmeet;
	}
	public String getThdmeet() {
		return thdmeet;
	}
	public String getFutmeet() {
		return futmeet;
	}
	public String getFitmeet() {
		return fitmeet;
	}

	public String getCttypecode() {
		return cttypecode;
	}
	public String getCttypecodenm() {
		return cttypecodenm;
	}
	public String getEnproductnm() {
		return enproductnm;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public String getLogKeyword() {
		return logKeyword;
	}
	public String getPntncode() {
		return pntncode;
	}
	public String getPntncodenm() {
		return pntncodenm;
	}
	public String getEtidx() {
		return etidx;
	}
	public SearchVo() {
	}
	
	public SearchVo(Map<String,String> params) {
		this.searchTerm = (params.get("searchTerm") == null ? "" : params.get("searchTerm"));		// 검색어 
		this.sort = (params.get("sort") == null ? "" : params.get("sort"));					// 정렬
		
		this.product		= (params.get("product") 	== null ? "" : params.get("product"));		// 제품상태
		this.type		= (params.get("type") 		== null ? "" : params.get("type"));				// 타입
		this.mfcode = (params.get("mfcode") == null ? "" : params.get("mfcode"));	
		this.mfcodeurl = (params.get("mfcodeurl") == null ? "" : params.get("mfcodeurl"));	
		this.mfcodenm = (params.get("mfcodenm") == null ? "" : params.get("mfcodenm"));
		this.age	= (params.get("age") 	== null ? "" : params.get("age"));						// 연령대
		this.lng	= (params.get("lng") 	== null ? "" : params.get("lng"));						// 언어
		this.gern		= (params.get("gern") 	== null ? "" : params.get("gern"));					// 장르
		
		this.productnm		= (params.get("productnm") 	== null ? "" : params.get("productnm"));		// 제품상태
		this.typenm		= (params.get("typenm") 		== null ? "" : params.get("typenm"));				// 타입
		this.agenm	= (params.get("agenm") 	== null ? "" : params.get("agenm"));						// 연령대
		this.lngnm	= (params.get("lngnm") 	== null ? "" : params.get("lngnm"));						// 언어
		this.gernnm		= (params.get("gernnm") 	== null ? "" : params.get("gernnm"));					// 장르
		
		this.kwd1		= (params.get("kwd1") 	== null ? "" : params.get("kwd1"));					// kwd1
		this.kwd2		= (params.get("kwd2") 	== null ? "" : params.get("kwd2"));					// kwd2
		this.kwd3		= (params.get("kwd3") 	== null ? "" : params.get("kwd3"));					// kwd3
		this.kwd4		= (params.get("kwd4") 	== null ? "" : params.get("kwd4"));					// kwd4
		this.kwd5		= (params.get("kwd5") 	== null ? "" : params.get("kwd5"));					// kwd5
		
		this.pmaincode		= (params.get("pmaincode") 	== null ? "" : params.get("pmaincode"));					// 메인비지니스타입부모코드
		this.maincode		= (params.get("maincode") 	== null ? "" : params.get("maincode"));					// 메인비지니스타입코드
		this.seccode		= (params.get("seccode") 	== null ? "" : params.get("seccode"));					// seccen비지니스타입코드
		this.thdcode		= (params.get("thdcode") 	== null ? "" : params.get("thdcode"));					// third비지니스타입코드
		
		this.fstmeet		= (params.get("fstmeet") 	== null ? "" : params.get("fstmeet"));					// fstmeet
		this.secmeet		= (params.get("secmeet") 	== null ? "" : params.get("secmeet"));					// secmeet
		this.thdmeet		= (params.get("thdmeet") 	== null ? "" : params.get("thdmeet"));					// thdmeet
		this.futmeet		= (params.get("futmeet") 	== null ? "" : params.get("futmeet"));					// futmeet
		this.fitmeet		= (params.get("fitmeet") 	== null ? "" : params.get("fitmeet"));					// fitmeet
		
		this.bbacode		= (params.get("bbacode") 	== null ? "" : params.get("bbacode"));	
		this.bbaval		= (params.get("bbaval") 	== null ? "" : params.get("bbaval"));					
		this.bbccode		= (params.get("bbccode") 	== null ? "" : params.get("bbccode"));					
		this.bbcval		= (params.get("bbcval") 	== null ? "" : params.get("bbcval"));					
		this.bbwcode		= (params.get("bbwcode") 	== null ? "" : params.get("bbwcode"));					
		this.bbwval		= (params.get("bbwval") 	== null ? "" : params.get("bbwval"));	
		this.bbgcode		= (params.get("bbgcode") 	== null ? "" : params.get("bbgcode"));	
		this.bbgval		= (params.get("bbgval") 	== null ? "" : params.get("bbgval"));	
		this.bbocode		= (params.get("bbocode") 	== null ? "" : params.get("bbocode"));	
		this.bboval		= (params.get("bboval") 	== null ? "" : params.get("bboval"));	
		
		this.tgcode		= (params.get("tgcode") 	== null ? "" : params.get("tgcode"));	
		this.entgcode		= (params.get("entgcode") 	== null ? "" : params.get("entgcode"));					
		this.firstnm		= (params.get("firstnm") 	== null ? "" : params.get("firstnm"));					
		this.lastnm		= (params.get("lastnm") 	== null ? "" : params.get("lastnm"));					
		this.email		= (params.get("email") 	== null ? "" : params.get("email"));					
		this.telno		= (params.get("telno") 	== null ? "" : params.get("telno"));	
		
		this.catecode		= (params.get("catecode") 	== null ? "" : params.get("catecode"));	
		this.catecodenm		= (params.get("catecodenm") 	== null ? "" : params.get("catecodenm"));	
		this.encatecode		= (params.get("encatecode") 	== null ? "" : params.get("encatecode"));	
		this.ntncode		= (params.get("ntncode") 	== null ? "" : params.get("ntncode"));	
		this.ntncodenm		= (params.get("ntncodenm") 	== null ? "" : params.get("ntncodenm"));	
		this.enntncode		= (params.get("enntncode") 	== null ? "" : params.get("enntncode"));	
		this.pntncode		= (params.get("pntncode") 	== null ? "" : params.get("pntncode"));
		this.pntncodenm		= (params.get("pntncodenm") 	== null ? "" : params.get("pntncodenm"));
		
		this.syear		= (params.get("syear") 	== null ? "" : params.get("syear"));	
		this.eyear		= (params.get("eyear") 	== null ? "" : params.get("eyear"));	
		this.uhdck		= (params.get("uhdck") 	== null ? "" : params.get("uhdck"));	
		this.cdck		= (params.get("cdck") 	== null ? "" : params.get("cdck"));	
		this.hdck		= (params.get("hdck") 	== null ? "" : params.get("hdck"));	
		this.crossck		= (params.get("crossck") 	== null ? "" : params.get("crossck"));	
		
		this.cttypecode		= (params.get("cttypecode") 	== null ? "" : params.get("cttypecode"));	
		this.cttypecodenm		= (params.get("cttypecodenm") 	== null ? "" : params.get("cttypecodenm"));	
		this.enproductnm		= (params.get("enproductnm") 	== null ? "" : params.get("enproductnm"));		
		
		this.cityname		= (params.get("cityname") 	== null ? "" : params.get("cityname"));	
		this.openyear		= (params.get("openyear") 	== null ? "" : params.get("openyear"));
		
		this.etidx		= (params.get("etidx") 	== null ? "" : params.get("etidx"));

		try {
			this.searchTerm = URLDecoder.decode(this.searchTerm, "UTF-8");
			this.type = URLDecoder.decode(this.type, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(params.get("currentPage") != null && !params.get("currentPage").equals("") && !params.get("currentPage").equals("0")) {
			this.currentPage = params.get("currentPage");
		}
		if(params.get("rowsperPage") != null && !params.get("rowsperPage").equals("") && !params.get("rowsperPage").equals("0")) {
			this.rowsperPage = params.get("rowsperPage");
		}
		this.start 	= CommonUtil.getPageStart(this.currentPage, this.rowsperPage);
		this.end	= CommonUtil.getPageEnd(this.currentPage, this.rowsperPage);
		
		if(!searchTerm.equals("")) {
			this.logKeyword = getSearchTerms()[0];
		}
	}
	
}
