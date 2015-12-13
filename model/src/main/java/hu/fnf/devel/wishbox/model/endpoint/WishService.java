package hu.fnf.devel.wishbox.model.endpoint;

import hu.fnf.devel.wishbox.model.Model;
import hu.fnf.devel.wishbox.model.entity.Wish;
import hu.fnf.devel.wishbox.model.entity.mongo.WishMongo;
import hu.fnf.devel.wishbox.model.repository.mongo.WishMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(Model.ROOT + "wish")
public class WishService {
    @Autowired
    private WishMongoRepository wishRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Wish test() {
        wishRepository.save(new WishMongo());
        return wishRepository.findAll().get(0);
    }
}
