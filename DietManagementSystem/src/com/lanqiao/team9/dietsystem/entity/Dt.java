package com.lanqiao.team9.dietsystem.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**动态表*/
public class Dt implements Serializable{
	/**动态编号（32位）*/
	private String dtno;
	
	/**用户图片（32位）*/
	private String photo;
	/**用户姓名（32位）*/
	private String uname;
	
	/**内容（2550位）*/
	private String content;
	
	/**图片（255位）*/
	private String dtpictureo;
	private String dtpicturet;
	private String dtpictures;
	private String dtpicturef;
	private String dtpictureff;
	private String dtpicturess;
	
	/**点赞数（8位）*/
	private int likes;
	/**用户是否点赞（8位）*/
	private boolean like;
	/**收藏数（8位）*/
	private int collects;
	/**用户是否收藏（8位）*/
	private boolean collect;
	
	/**评论数（8位）*/
	private int comments;
	
	
	/**日期（20位）*/
	private String dtdate;

	
	
	public Dt() {}

		


	public Dt(String dtno, String photo, String uname, String content, String dtpictureo, String dtpicturet, String dtpictures, String dtpicturef, String dtpictureff, String dtpicturess, int likes,
			boolean like, int comments, int collects, boolean collect, String dtdate) {
		super();
		this.dtno = dtno;
		this.photo = photo;
		this.uname = uname;
		this.content = content;
		this.dtpictureo = dtpictureo;
		this.dtpicturet = dtpicturet;
		this.dtpictures = dtpictures;
		this.dtpicturef = dtpicturef;
		this.dtpictureff = dtpictureff;
		this.dtpicturess = dtpicturess;
		this.likes = likes;
		this.like = like;
		this.collects = collects;
		this.collect = collect;
		this.comments = comments;
		this.dtdate = dtdate;
	}


	

	public int getCollects() {
		return collects;
	}




	public void setCollects(int collects) {
		this.collects = collects;
	}




	public boolean isCollect() {
		return collect;
	}




	public void setCollect(boolean collect) {
		this.collect = collect;
	}




	public boolean getLike() {
		return like;
	}




	public void setLike(boolean like) {
		this.like = like;
	}




	public String getDtno() {
		return dtno;
	}



	public void setDtno(String dtno) {
		this.dtno = dtno;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getdtpictureo() {
		return dtpictureo;
	}



	public void setdtpictureo(String dtpictureo) {
		this.dtpictureo = dtpictureo;
	}



	public String getdtpicturet() {
		return dtpicturet;
	}



	public void setdtpicturet(String dtpicturet) {
		this.dtpicturet = dtpicturet;
	}



	public String getdtpictures() {
		return dtpictures;
	}



	public void setdtpictures(String dtpictures) {
		this.dtpictures = dtpictures;
	}



	public String getdtpicturef() {
		return dtpicturef;
	}



	public void setdtpicturef(String dtpicturef) {
		this.dtpicturef = dtpicturef;
	}



	public String getdtpictureff() {
		return dtpictureff;
	}



	public void setdtpictureff(String dtpictureff) {
		this.dtpictureff = dtpictureff;
	}



	public String getdtpicturess() {
		return dtpicturess;
	}



	public void setdtpicturess(String dtpicturess) {
		this.dtpicturess = dtpicturess;
	}



	public int getLikes() {
		return likes;
	}



	public void setLikes(int likes) {
		this.likes = likes;
	}



	public int getComments() {
		return comments;
	}



	public void setComments(int comments) {
		this.comments = comments;
	}



	public String getDtdate() {
		return dtdate;
	}



	public void setDtdate(String dtdate) {
		this.dtdate = dtdate;
	}




	@Override
	public String toString() {
		return "Dt [dtno=" + dtno + ", photo=" + photo + ", uname=" + uname + ", content=" + content + ", dtpictureo=" + dtpictureo + ", dtpicturet=" + dtpicturet + ", dtpictures=" + dtpictures
				+ ", dtpicturef=" + dtpicturef + ", dtpictureff=" + dtpictureff + ", dtpicturess=" + dtpicturess + ", likes=" + likes + ", like=" + like + ", collects=" + collects + ", collect="
				+ collect + ", comments=" + comments + ", dtdate=" + dtdate + ", getCollects()=" + getCollects() + ", isCollect()=" + isCollect() + ", getLike()=" + getLike() + ", getDtno()="
				+ getDtno() + ", getPhoto()=" + getPhoto() + ", getUname()=" + getUname() + ", getContent()=" + getContent() + ", getdtpictureo()=" + getdtpictureo() + ", getdtpicturet()="
				+ getdtpicturet() + ", getdtpictures()=" + getdtpictures() + ", getdtpicturef()=" + getdtpicturef() + ", getdtpictureff()=" + getdtpictureff() + ", getdtpicturess()="
				+ getdtpicturess() + ", getLikes()=" + getLikes() + ", getComments()=" + getComments() + ", getDtdate()=" + getDtdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	
}
