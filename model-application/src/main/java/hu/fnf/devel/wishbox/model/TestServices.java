package hu.fnf.devel.wishbox.model;

import hu.fnf.devel.wishbox.ModelApplication;
import hu.fnf.devel.wishbox.model.entity.mongo.NotificationMongo;
import hu.fnf.devel.wishbox.model.entity.mongo.WishMongo;
import hu.fnf.devel.wishbox.model.repository.mongo.NotificationMongoRepository;
import hu.fnf.devel.wishbox.model.repository.mongo.WishMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping(ModelApplication.ROOT)
public class TestServices {
    @Autowired
    private WishMongoRepository wishMongoRepository;
    @Autowired
    private NotificationMongoRepository notificationMongoRepository;

    @PostConstruct
    public void init() {
        wishMongoRepository.deleteAll();
        WishMongo wish = new WishMongo();
        wish.setLabel("a");

        wishMongoRepository.save(wish);

        notificationMongoRepository.deleteAll();
        NotificationMongo notification = new NotificationMongo();
        notification.setText("b");

        notificationMongoRepository.save(notification);
    }

    @RequestMapping(value = "wish", method = RequestMethod.GET)
    @ResponseBody
    public List<WishMongo> getWishMongos() {
        return wishMongoRepository.findAll();
    }

    @RequestMapping(value = "notification", method = RequestMethod.GET)
    @ResponseBody
    public List<NotificationMongo> getNotificationMongos() {
        return notificationMongoRepository.findAll();
    }

    @RequestMapping(value = "wish", method = RequestMethod.POST)
    @ResponseBody
    public void postWishMongos(WishMongo wish) {
        WishMongo wishMongo = new WishMongo(wish);
        wishMongoRepository.save(wishMongo);
    }

    @RequestMapping(value = "notification", method = RequestMethod.POST)
    @ResponseBody
    public void postNotificationMongos(NotificationMongo notif) {
        notificationMongoRepository.save(notif);
    }


}
