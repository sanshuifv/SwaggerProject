package swagger.training.swaggerDemo;

import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import swagger.training.swaggerDemo.model.User;
import swagger.training.swaggerDemo.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExportSwagger {

	@Resource
	private UserService userService;

	@Test
	public void generateAsciiDocs() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.withOutputLanguage(Language.JA)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();
		
		Swagger2MarkupConverter.from(new URL("http://localhost:6688/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("src/main/resources/docs/asciidoc"));
	}


	@Test
	public void generateMarkdownDocs() throws Exception {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withSwaggerMarkupLanguage(MarkupLanguage.MARKDOWN)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();
		
		Swagger2MarkupConverter.from(new URL("http://localhost:6688/v2/api-docs"))
		.withConfig(config)
		.build()
		.toFile(Paths.get("src/main/resources/docs/markdown"));
	}
	@Test
	public void add(){
		User user= new User();
		user.setId(3);
		user.setName("liming");
		user.setNumber("12455");
		userService.addUser(user);
	}


}
