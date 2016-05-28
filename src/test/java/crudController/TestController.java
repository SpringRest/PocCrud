package crudController;

import app.rs.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guelerauda on 28/05/2016.
 */
@RestController
@RequestMapping("/test")
public class TestController extends CrudController<TestEntity, Integer, TestRepository> {

}
