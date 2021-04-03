package Admin.model;

import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;

public class Notice {
	private	  int noticeno;
	@NotEmpty(message="���� �Է� ����")
	private	String notice_title;
	@NotEmpty(message = "���� �Է� ����")
	private	 String notice_content;
	private	 int notice_recount;
	private Date notice_date;
	private int rownum;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public int getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_recount() {
		return notice_recount;
	}
	public void setNotice_recount(int notice_recount) {
		this.notice_recount = notice_recount;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public Notice() {
		super();
	}
	public Notice(int noticeno, String notice_title, String notice_content, int notice_recount, Date notice_date) {
		super();
		this.noticeno = noticeno;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_recount = notice_recount;
		this.notice_date = notice_date;
	}
	
	
}
