package app.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guelerauda on 27/05/2016.
 */
public abstract class CrudController<Entity extends Serializable, EntityTypeId extends Serializable, Repository extends CrudRepository> {

    @Autowired
    private Repository repository;

    public CrudController() {}

    @RequestMapping(method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public Entity create(@RequestBody Entity entity)
    {
        return (Entity) repository.save(entity);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> findAll()
    {
        return (List<Entity>)repository.findAll();
    }

    @RequestMapping(value="/{entityId}", method = RequestMethod.GET)
    public Entity find(@PathVariable EntityTypeId entityId)
    {
        return (Entity)repository.findOne(entityId);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
    public Entity update(@RequestBody Entity entity)
    {
        return (Entity)repository.save(entity);
    }

    @RequestMapping(value="/{entityId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable EntityTypeId entityId)
    {
        repository.delete(entityId);
    }

}
