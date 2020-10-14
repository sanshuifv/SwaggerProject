package swagger.training.swaggerDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import swagger.training.swaggerDemo.model.Person;

@Api
@RestController
@RequestMapping("/person")
public class PersonController {

	@ApiOperation(value="Add person.", notes="Add person info.")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Person addPerson(@RequestBody Person p) {
		return p;
	}
	
	@ApiOperation(value="Get person list.", notes="Get persons info.")
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<Person> getPersonList(@RequestParam String first) {
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setFirstName(first);
		p1.setLastName("last1");
		list.add(p1);
		
		Person p2 = new Person();
		p2.setFirstName(first);
		p2.setLastName("last2");
		list.add(p2);
		return list;
	}
	
	@ApiOperation(value="Update person.", notes="Update person info.")
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person p) {
		return p;
	}
	
	@ApiOperation(value="Delete person list.", notes="Delete persons info.")
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String deletePerson(@RequestParam String first) {
		return first + " is deleted.";
	}
}
