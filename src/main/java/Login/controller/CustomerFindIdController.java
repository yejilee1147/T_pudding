package Login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
public class CustomerFindIdController {

	final String command = "/findid.me";
	final String getPage = "FindIdForm";
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
			@RequestParam(value="customer_hpnumber",required=true) String customer_hpnumber   ) throws IOException {

		Customer customerbean = customerDao.getOneData(customer_name,customer_hpnumber);
		
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		if(customerbean == null) {	
			pw.println("<script type='text/javascript'>");
			pw.println("alert('ȸ�������� �����ϴ�.');");
			pw.println("</script>");
			pw.flush();   //��������
			return new ModelAndView(getPage);
		}																			
		else {			
			
			if(customerbean.getCustomer_hpnumber().equals(customer_hpnumber)){//�̸���  ��ȣ�� ������ 
				System.out.println("�̸��� �޴�����ȣ �Ѵ� ����");
				pw.println("<script type='text/javascript'>");
		        pw.println("alert('���̵�� "+customerbean.getCustomer_id()+"�Դϴ�.')");
		        pw.println("</script>");
		        pw.flush();   //��������
		        return new ModelAndView(gotoPage);
			}else {																		//�̸� ���� ��ȣ Ʋ�� �Ȱ��� length�� ���� ��
				System.out.println("�̸��� �޴�����ȣ �Ѵ� ����");
				pw.println("<script type='text/javascript'>");
				pw.println("alert('��ȣ Ʋ�Ƚ��ϴ�.');");
				pw.println("</script>");
				pw.flush();   //��������
				mav.setViewName(getPage);
				return mav;
			}
		}


	}
}
