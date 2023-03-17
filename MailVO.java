package multi;

public class MailVO {
	
	private int no;
	private String send;
	private String title;
	private String content;
	private String date;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MailVO [no=" + no + ", send=" + send + ", title=" + title + ", content=" + content + ", date=" + date
				+ "]";
	}
	
	
	
}
