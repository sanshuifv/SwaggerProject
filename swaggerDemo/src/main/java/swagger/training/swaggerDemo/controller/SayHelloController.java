package swagger.training.swaggerDemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/hello")
public class SayHelloController {

	@ApiOperation(value="Say hello.", notes="Say hello to world.")
	@RequestMapping(value="/world", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello World!";
	}
	
	@ApiOperation(value="Say hello.", notes="Say hello to input person.")
	@ApiImplicitParam(name="name", value="Person 名前", required=false)
	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	public String helloPerson(@PathVariable("name") String name) {
		return "Hello " + name + "!";
	}
}
