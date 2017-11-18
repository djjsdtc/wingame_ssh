package org.wingame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.wingame.dao.TMeetingStatus;
import org.wingame.dao.TUser;

import jxl.JXLException;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelTableUtil {
	private static class Users{
		public String username;
		public String realname;
		public String company;
	}
	
	private List<Users> userlist = new ArrayList<Users>();
	private String meetingName = "";
	//���캯���а�userlist��meetingName��������д��
	public ExcelTableUtil(List<TMeetingStatus> ulist,String meetingName){
		this.meetingName = meetingName;
		for(TMeetingStatus status : ulist){
			TUser user = status.getId().getTUser();
			Users u = new Users();
			u.username = user.getUsername();
			u.realname = user.getRealname();
			u.company = user.getCompany();
			userlist.add(u);
		}
	}
	
	public void createTable(OutputStream os) throws IOException, JXLException{
		//�����������͹�����
		WritableWorkbook book = Workbook.createWorkbook(os);
		WritableSheet sheet = book.createSheet("�λ���Ա����", 0);
		//�����п�
		sheet.setColumnView(0, 16);
		sheet.setColumnView(1, 16);
		sheet.setColumnView(2, 40);
		sheet.setColumnView(3, 10);
		//�����ϲ���Ԫ��
		sheet.mergeCells(0, 0, 3, 0);
		sheet.mergeCells(0, 1, 3, 1);
		//��д���������
		WritableCellFormat titleformat = new WritableCellFormat();
		titleformat.setAlignment(Alignment.CENTRE);
		Label l00 = new Label(0,0,meetingName,titleformat);
		Label l01 = new Label(0,1,"�λ���Ա����",titleformat);
		sheet.addCell(l00);
		sheet.addCell(l01);
		//��д��ͷ
		WritableCellFormat format = new WritableCellFormat();
		format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		Label l03 = new Label(0,3,"�û���",format);
		Label l13 = new Label(1,3,"��ʵ����",format);
		Label l23 = new Label(2,3,"��λ",format);
		Label l33 = new Label(3,3,"�ɷ�",format);
		sheet.addCell(l03);
		sheet.addCell(l13);
		sheet.addCell(l23);
		sheet.addCell(l33);
		//��д����
		int row = 4;
		for(Users u : userlist){
			Label l0x = new Label(0,row,u.username,format);
			Label l1x = new Label(1,row,u.realname,format);
			Label l2x = new Label(2,row,u.company,format);
			Label l3x = new Label(3,row,"��",format);
			sheet.addCell(l0x);
			sheet.addCell(l1x);
			sheet.addCell(l2x);
			sheet.addCell(l3x);
			row ++;
		}
		book.write();
		book.close();
	}
	
	//����SSH�汾����Ҫ�а������OutputStream����ΪInputStream�ĺ���
	public InputStream getInputStream(ByteArrayOutputStream os){
		if(os == null) return null;
		byte[] b = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(b);
		return is;
	}
}
