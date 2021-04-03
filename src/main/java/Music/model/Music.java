package Music.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Music {
private   int mno;
@NotEmpty(message = "�뷡������ �����ϼ���")
private    String music_title;
private   String  music_dj;
@NotEmpty(message = "�帣�� �����ϼ���")
private   String  music_ganre; 
private    int music_recount; 
@NotEmpty(message = "�뷡 �̹����� �����ϼ���")
private    String  music_image;
@NotEmpty(message = "�뷡 ���������� �����ϼ���")
private    String music_song;
@NotEmpty(message = "�������� �����ϼ���")
private    String  music_singer;
@NotEmpty(message = "�뷡 ���������� �����ϼ���")
private    String  music_lyics;
@NotEmpty(message = "�߸����� �����ϼ���")
private  Date  music_date;

private int music_price;

public int getMusic_price() {
	return music_price;
}
public void setMusic_price(int music_price) {
	this.music_price = music_price;
}
private int music_heart;
private    MultipartFile  img_upload;
private    MultipartFile  song_upload;
private    MultipartFile  lyics_upload;
private String old_img;
private String old_song;
private String old_lyics;
private String user;


public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public int getMusic_heart() {
   return music_heart;
}
public void setMusic_heart(int music_heart) {
   this.music_heart = music_heart;
}
public String getOld_img() {
   return old_img;
}
public void setOld_img(String old_img) {
   this.old_img = old_img;
}
public String getOld_song() {
   return old_song;
}
public void setOld_song(String old_song) {
   this.old_song = old_song;
}
public String getOld_lyics() {
   return old_lyics;
}
public void setOld_lyics(String old_lyics) {
   this.old_lyics = old_lyics;
}
public MultipartFile getImg_upload() {
   return img_upload;
}
public void setImg_upload(MultipartFile img_upload) {
   this.img_upload = img_upload;
   if (img_upload !=null) {
      System.out.println("img_name:"+img_upload.getName());
      System.out.println("upload_originalFilename:"+img_upload.getOriginalFilename());
      this.music_image = img_upload.getOriginalFilename();
   }
}
public MultipartFile getSong_upload() {
   return song_upload;
}
public void setSong_upload(MultipartFile song_upload) {
   this.song_upload = song_upload;
   if (song_upload !=null) {
      this.music_song = song_upload.getOriginalFilename();
   }
}
public MultipartFile getLyics_upload() {
   return lyics_upload;
}
public void setLyics_upload(MultipartFile lyics_upload) {
   this.lyics_upload = lyics_upload;
   if (lyics_upload !=null) {
      this.music_lyics = lyics_upload.getOriginalFilename();
      System.out.println(music_lyics);
   }
}
public int getMno() {
   return mno;
}
public void setMno(int mno) {
   this.mno = mno;
}
public String getMusic_title() {
   return music_title;
}
public void setMusic_title(String music_title) {
   this.music_title = music_title;
}
public String getMusic_ganre() {
   return music_ganre;
}
public void setMusic_ganre(String music_ganre) {
   this.music_ganre = music_ganre;
}
public int getMusic_recount() {
   return music_recount;
}
public void setMusic_recount(int music_recount) {
   this.music_recount = music_recount;
}
public String getMusic_image() {
   return music_image;
}
public void setMusic_image(String music_image) {
   this.music_image = music_image;
}
public String getMusic_song() {
   return music_song;
}
public void setMusic_song(String music_song) {
   this.music_song = music_song;
}
public String getMusic_singer() {
   return music_singer;
}
public void setMusic_singer(String music_singer) {
   this.music_singer = music_singer;
}
public String getMusic_lyics() {
   return music_lyics;
}
public void setMusic_lyics(String music_lyics) {
   this.music_lyics = music_lyics;
}
public Date getMusic_date() {
   return music_date;
}
public void setMusic_date(Date music_date) {
   this.music_date = music_date;
}
public Music() {
   super();
}
public String getMusic_dj() {
   return music_dj;
}
public void setMusic_dj(String music_dj) {
   this.music_dj = music_dj;
}
public Music(int mno, String music_title, String music_dj, String music_ganre, int music_recount, String music_image,
      String music_song, String music_singer, String music_lyics, Date music_date, MultipartFile img_upload,
      MultipartFile song_upload, MultipartFile lyics_upload, String old_img, String old_song, String old_lyics) {
   super();
   this.mno = mno;
   this.music_title = music_title;
   this.music_dj = music_dj;
   this.music_ganre = music_ganre;
   this.music_recount = music_recount;
   this.music_image = music_image;
   this.music_song = music_song;
   this.music_singer = music_singer;
   this.music_lyics = music_lyics;
   this.music_date = music_date;
   this.img_upload = img_upload;
   this.song_upload = song_upload;
   this.lyics_upload = lyics_upload;
   this.old_img = old_img;
   this.old_song = old_song;
   this.old_lyics = old_lyics;
}



}