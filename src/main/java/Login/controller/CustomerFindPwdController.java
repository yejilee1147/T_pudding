package Login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Login.model.Customer;
import Login.model.CustomerDao;

@Controller
public class CustomerFindPwdController {

	final String command = "/findpwd.me";
	final String getPage = "FindPwdForm";
	final String gotoPage = "LoginForm";

	@Autowired
	CustomerDao customerDao;

	@RequestMapping(value=command , method=RequestMethod.GET)
	public String doAction() {
		return getPage; 
	}

	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doAction(Customer customer,HttpServletResponse response,
								@RequestParam(value="customer_name",required=true) String customer_name,
								@RequestParam(value="customer_id",required=true) String customer_id
								) throws IOException {
		
		
		Customer bean = customerDao.getPwdFind(customer_name,customer_id);
		
		ModelAndView mav = new ModelAndView(); 
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		if(bean == null) {	
			System.out.println("id, name �Ѵ�  ����");
			pw.println("<script type='text/javascript'>");
			pw.println("alert('ȸ�������� �����ϴ�.');");
			pw.println("</script>");
			pw.flush();   //��������
			return new ModelAndView(getPage);
		}																			
		else {
			System.out.println(bean.getCustomer_id());
			System.out.println(bean.getCustomer_name());
			
			if(bean.getCustomer_name().equals(customer_name)){//���̵�� �̸��̰����� 
				System.out.println("�̸��� ���̵� ����");
				pw.println("<script type='text/javascript'>");
				pw.println("alert('��й�ȣ�� "+bean.getCustomer_passwd()+"�Դϴ�.')");
		        pw.println("</script>");
		        pw.flush();   //��������
				mav.setViewName(gotoPage);
				return mav;
			}else {																		//�̸� ���� ��ȣ Ʋ�� �Ȱ��� length�� ���� ��
				System.out.println("���̵�� �̸��� Ʋ��");
				pw.println("<script type='text/javascript'>");
				pw.println("alert('�̸� Ʋ�Ƚ��ϴ�.');");
				pw.println("</script>");
				pw.flush();   //��������
				mav.setViewName(getPage);
				return mav;
			}
		}
		
		
	}
}










