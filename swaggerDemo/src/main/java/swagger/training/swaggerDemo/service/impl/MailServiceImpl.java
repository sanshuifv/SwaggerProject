package swagger.training.swaggerDemo.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swagger.training.swaggerDemo.service.IMailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Api(tags = "Send email")
@RestController
@RequestMapping("/mail")
/**
 * @Date 2019/12/16 9:58
 */
@Component
@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    public JavaMailSender mailSender;
    @Value("mpanxue@163.com")
    private String from;


    @GetMapping("/sendSimpleMail")
    @ApiOperation("发送简单文本")
  /*  @ApiImplicitParams({
            @ApiImplicitParam(name = "mail", value = "接收者邮箱", paramType = "query", required = true, defaultValue = "2567984251@qq.com"),
            @ApiImplicitParam(name = "theme", value = "邮箱主题", paramType = "query", required = true, defaultValue = "测试简单文本邮件通讯"),
            @ApiImplicitParam(name = "content", value = "简单文本内容", paramType = "query", required = true, defaultValue = "测试内容=>无bug通过")
    })*/
    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    @GetMapping("/sendHtmlMail")
    @ApiOperation("发送HTML邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mail", value = "接收者邮箱", paramType = "query", required = true, defaultValue = "1761437173@qq.com"),
            @ApiImplicitParam(name = "theme", value = "邮箱主题", paramType = "query", required = true, defaultValue = "测试HTML邮件通讯"),
            @ApiImplicitParam(name = "html", value = "html内容", paramType = "query", required = true, defaultValue = "测试内容<br/><hr><br/>无bug通过")
    })
    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }


    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath 附件路径
     */
    @GetMapping("/sendAttachmentsMail")
    @ApiOperation("发送带附件的邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "to", value = "接收者邮箱", paramType = "query", required = true, defaultValue = "2567984521@qq.com"),
            @ApiImplicitParam(name = "subject", value = "邮箱主题", paramType = "query", required = true, defaultValue = "测试带附件的邮件通讯"),
            @ApiImplicitParam(name = "content", value = "文本内容", paramType = "query", required = true, defaultValue = "测试内容=>无bug通过"),
            @ApiImplicitParam(name = "filePath", value = "附件路径", paramType = "query", required = true, defaultValue = "C:\\Users\\Administrator\\Desktop\\pic01.jpg")
    })
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf( File.separator));
        helper.addAttachment(fileName, file);

        mailSender.send(message);
    }


    /**
     * 发送正文中有静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath 资源路径
     * @param rscId 资源id
     */
    @GetMapping("/sendResourceMail")
    @ApiOperation("发送正文中有静态资源的邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "to", value = "接收者邮箱", paramType = "query", required = true, defaultValue = "2567984521@qq.com"),
            @ApiImplicitParam(name = "content", value = "邮箱主题", paramType = "query", required = true, defaultValue = "<html><body>这有是图片的邮件：<img src='cid:1' ></body></html>"),
            @ApiImplicitParam(name = "rscPath", value = "资源路径", paramType = "query", required = true, defaultValue = "C:\\Users\\admin\\Desktop\\aa.html"),
            @ApiImplicitParam(name = "rscId", value = "资源id ", paramType = "query", required = true, defaultValue = "1")
    })
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        content = "<html><body>这有是图片的邮件：<img src='cid:1' ></body></html>";
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, res);

        mailSender.send(message);
    }
}
