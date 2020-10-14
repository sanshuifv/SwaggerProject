package swagger.training.swaggerDemo.service;

import javax.mail.MessagingException;

/**
 * @Date 2019/12/16 9:57
 */
public interface IMailService {
    /**
     * 发送文本邮件
     * @param to 接受方
     * @param subject 邮箱主题
     * @param content 文本内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     * @param to 接受方
     * @param subject 邮箱主题
     * @param content html内容
     * @throws MessagingException
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    /**
     * 发送带附件的邮件
     * @param to 接受方
     * @param subject 邮箱主题
     * @param content 文本内容
     * @param filePath 附件路径
     * @throws MessagingException
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException;

    /**
     * 发送正文中有静态资源的邮件
     * @param to 接受方
     * @param subject 邮箱主题
     * @param content 邮箱内容
     * @param rscPath 资源路径
     * @param rscId 资源id
     * @throws MessagingException
     */
    void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;
}
