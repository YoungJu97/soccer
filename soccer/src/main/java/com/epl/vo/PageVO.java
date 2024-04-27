package com.epl.vo;


public class PageVO {
	private int startNo; 
	private int endNo; 
	private int perPageNum=10;
	private Integer page; 
	private int totalCount; 
	private int endPage;
	private int startPage;
	private boolean prev;
	private boolean next;
	
	private String searchType;
	private String searchKeyword;
	

	public void prt() {
		System.out.println("StartNo : "+startNo);
		System.out.println("endNo : "+endNo);
		System.out.println("startPage : "+startPage);
		System.out.println("endPage : "+endPage);
	}	
	
	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	private void calcPage() {
	    // ���� ��ȣ ���
	    startNo = (this.page - 1) * perPageNum + 1;
	    
	    // �ӽ� �� ������ ���
	    int tempEnd = (int) (Math.ceil(page / (double) this.perPageNum) * this.perPageNum);
	    
	    // ���� ������ ���
	    this.startPage = (tempEnd - this.perPageNum) + 1;
	    
	    // �������� ���� �� �׸� ���� �Ѿ���� Ȯ���Ͽ� �� ������ �� �� ��ȣ ���
	    if (tempEnd * this.perPageNum > this.totalCount) {
	        // �������� ���� �� �׸� ���� �Ѿ ��
	        this.endPage = (int) Math.ceil(this.totalCount / (double) this.perPageNum);
	        if (endPage != page) {
	            // ���� �������� �� �������� �ƴ� ��
	            this.endNo = startNo + this.perPageNum - 1;  
	        } else {
	            // ���� �������� �� �������� ��
	            this.endNo = this.totalCount;
	        }
	    } else {
	        // �������� ���� �� �׸� ���� �Ѿ�� ���� ��
	        this.endPage = tempEnd;
	        this.endNo = startNo + this.perPageNum - 1;
	    }
	    
	    // ���� ������ �� ���� �������� ���� ���� ����
	    this.prev = this.startPage != 1;
	    this.next = this.endPage * this.perPageNum < this.totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcPage();
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getStartNo() {

		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
}
