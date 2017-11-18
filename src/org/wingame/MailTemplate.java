package org.wingame;

public abstract class MailTemplate {
	private static final String resetPasswordTemplate = 
			"�𾴵��û���\n" +
			"����������վ�����һ����롣���¼����վΪ���������ɵ�������룺%{password}\n" +
			"��������ʹ�ô������¼��վ�����޸��������롣�޸�������뼰ʱɾ�����ʼ���\n" +
			"��л��ʹ�ñ���վ��ף��ʹ����졣\n" +
			"Windows С��Ϸ�о�ѧ��\n\n" +
			"ע�⣺���ʼ�Ϊϵͳ�Զ�����������ظ���";
	
	private static final String docTemplateHead = "�𾴵��û�%{username}��\n���ã�\n��Ϊ����%{meeting}�ϴ����ĵ�";
	
	private static final String docPassTemplate = 
			"�Ѿ�ͨ���˹���Ա����ˣ��������Ѿ�����˲μӱ��λ�����ʸ�\n"+
			"����ǰ�����λ����Ԥ����ϵͳ���л���Ԥ��������ַ���£�\n"+
			"http://localhost:8080/newj2eework2/application/home?id=%{mid}\n"+
			"���������Ҫ��¼�����ʺŲ��ܽ��л����Ԥ������\n"+
			"�������С��ɾ���˱��ʼ������������ĵ��ϴ�ϵͳ���ҵ�Ԥ����ϵͳ�����ӡ�\n"+
			"лл���Ĳ��룡\nWindows С��Ϸ�о�ѧ��\n\n" +
			"ע�⣺���ʼ�Ϊϵͳ�Զ�����������ظ���";
	
	private static final String docFailTemplate = 
			"û���ܹ�ͨ������Ա����ˡ����������ϴ��ĵ���ֹ����ǰ�ϴ��µ��ĵ��μ���ˡ�\n"+
			"лл���Ĳ��룡\nWindows С��Ϸ�о�ѧ��\n\n" +
			"ע�⣺���ʼ�Ϊϵͳ�Զ�����������ظ���";
	
	public static String getResetPasswordContext(String password){
		return resetPasswordTemplate.replace("%{password}", password);
	}
	
	public static String getDocPassContext(String username,String meeting,int mid){
		return docTemplateHead.replace("%{username}", username).replace("%{meeting}", meeting) + 
				docPassTemplate.replace("%{mid}", Integer.toString(mid));
	}
	
	public static String getDocFailContext(String username,String meeting){
		return docTemplateHead.replace("%{username}", username).replace("%{meeting}", meeting) + docFailTemplate;
	}
}
