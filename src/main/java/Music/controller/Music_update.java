package Music.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Music.model.Music;
import Music.model.MusicDao;


@Controller
public class Music_update {
	final String command = "update.ms";
	final String getPage = "update_music";
	final String gotoPage = "redirect:/list.ms";
	@Autowired
	MusicDao dao;
	@Autowired
	ServletContext servletcontext;
@RequestMapping(value = command,method = RequestMethod.GET)
public ModelAndView doAction(@RequestParam("mno") int mno) {
	ModelAndView mav = new ModelAndView();
	Music music = dao.getOneData(mno);
	mav.addObject("music", music);
	mav.setViewName(getPage);
	return mav;
	}
@RequestMapping(value = command,method = RequestMethod.POST)
public ModelAndView doAction(Music music) throws IllegalStateException, IOException {
	ModelAndView mav = new ModelAndView();
	mav.setViewName(gotoPage);
	String uploadimg = servletcontext.getRealPath("/resources/imgs/");
	String uploadsong = servletcontext.getRealPath("/resources/song/");
	String uploadtxt = servletcontext.getRealPath("/resources/txt/");
	MultipartFile multii = music.getImg_upload();
	MultipartFile multis = music.getSong_upload();
	MultipartFile multit = music.getLyics_upload();
	File filei = new File(uploadimg+music.getMusic_image());
	File files = new File(uploadsong+music.getMusic_song());
	File filet = new File(uploadtxt+music.getMusic_lyics());
	File dfilei = new File(uploadimg+music.getOld_img());
	File dfiles = new File(uploadsong+music.getOld_song());
	File dfilet = new File(uploadtxt+music.getOld_lyics());
	dfilei.delete();
	dfiles.delete();
	dfilet.delete();
	multii.transferTo(filei);
	multis.transferTo(files);
	multit.transferTo(filet);
	dao.update(music);
	mav.setViewName(gotoPage);
	return mav;
}

}
