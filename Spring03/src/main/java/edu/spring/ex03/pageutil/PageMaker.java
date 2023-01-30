package edu.spring.ex03.pageutil;

//페이지 번호들의 링크를 만들기 위한 유틸리티 클래스
public class PageMaker {
	private PageCriteria criteria;
	private int totalCount; // 전체 게시글 개수
	private int numsOfPageLinks; // 페이지 번호 링크의 개수
	private int startPageNo; // 시작 페이지 링크 번호
	private int endPageNo; // 끝 페이지 링크 번호
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는 지
	private boolean hasNext; // 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	
	public PageMaker() {
		this.numsOfPageLinks = 5;
	}
	
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 및 세팅
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
		
		// page = 1
		// numsOfPageLinks = 5
		// (1/5 = 0.2 =>1 ) * 5 = 5
		// (2/5 = 0.4 =>1 ) * 5 = 5
		// (3/5 = 0.6 =>1 ) * 5 = 5
		// (4/5 = 0.8 =>1 ) * 5 = 5
		// (5/5 = 1.0 =>1 ) * 5 = 5
		// (6/5 = 1.2 =>2 ) * 5 = 10
		// ...
		// (11/5 = 2.2 => 3 ) * 5 = 15
		
		
		
		if (temp > totalLinkNo) {
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		// ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		// ((5 - 1) / 5) * 5 + 1 = 1
		// double이 아니므로 소수점 아래를 버려서 4 / 5 = 0이 되버림
		// ((10 - 1) / 5) * 5 + 1 = 6
		
		
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// Math.ceil (올림)
		// Math.floor (버림
		
	}
	
} // end PageMaker













