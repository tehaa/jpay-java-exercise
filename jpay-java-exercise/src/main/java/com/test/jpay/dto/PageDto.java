package com.test.jpay.dto;

public class PageDto {

	private int pageNumber;

	private int pageSize;

	private Long totalNumberOfElements;

	public PageDto(int pageNumber, int pageSize, Long totalNumberOfElements) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalNumberOfElements = totalNumberOfElements;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalNumberOfElements() {
		return totalNumberOfElements;
	}

	public void setTotalNumberOfElements(Long totalNumberOfElements) {
		this.totalNumberOfElements = totalNumberOfElements;
	}

	@Override
	public String toString() {
		return "PageDto [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalNumberOfElements="
				+ totalNumberOfElements + "]";
	}


}
