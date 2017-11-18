package org.wingame;

public abstract class MailTemplate {
	private static final String resetPasswordTemplate = 
			"尊敬的用户：\n" +
			"您已在我网站申请找回密码。请记录本网站为您重新生成的随机密码：%{password}\n" +
			"请您尽快使用此密码登录本站，并修改您的密码。修改密码后，请及时删除此邮件。\n" +
			"感谢您使用本网站，祝您使用愉快。\n" +
			"Windows 小游戏研究学会\n\n" +
			"注意：该邮件为系统自动发出，请勿回复。";
	
	private static final String docTemplateHead = "尊敬的用户%{username}：\n您好！\n您为会议%{meeting}上传的文档";
	
	private static final String docPassTemplate = 
			"已经通过了管理员的审核，您现在已经获得了参加本次会议的资格。\n"+
			"请您前往本次会议的预报名系统进行会议预报名，地址如下：\n"+
			"http://localhost:8080/newj2eework2/application/home?id=%{mid}\n"+
			"进入后您需要登录您的帐号才能进行会议的预报名。\n"+
			"如果您不小心删除了本邮件，您可以在文档上传系统中找到预报名系统的链接。\n"+
			"谢谢您的参与！\nWindows 小游戏研究学会\n\n" +
			"注意：该邮件为系统自动发出，请勿回复。";
	
	private static final String docFailTemplate = 
			"没有能够通过管理员的审核。您可以在上传文档截止日期前上传新的文档参加审核。\n"+
			"谢谢您的参与！\nWindows 小游戏研究学会\n\n" +
			"注意：该邮件为系统自动发出，请勿回复。";
	
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
