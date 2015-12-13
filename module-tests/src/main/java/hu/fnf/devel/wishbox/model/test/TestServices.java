package hu.fnf.devel.wishbox.model.test;

import hu.fnf.devel.wishbox.model.entity.mongo.WishMongo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping(TestApp.ROOT)
public class TestServices {
//    @Autowired
//    private WishMongoRepository wishMongoRepository;
//    @Autowired
//    private NotificationMongoRepository notificationMongoRepository;

    @PostConstruct
    public void init() {
        WishMongo wish = new WishMongo();
        wish.setLabel("a");

//        wishMongoRepository.save(wish);

//        NotificationMongo notification = new NotificationMongo();
//        notification.setText("b");
//
//        notificationMongoRepository.save(notification);
    }

    @RequestMapping(value = "wish", method = RequestMethod.GET)
    @ResponseBody
    public List<WishMongo> getWishMongos() {
        return null; // wishMongoRepository.findAll();
    }

//    @RequestMapping(value = "notification", method = RequestMethod.GET)
//    @ResponseBody
//    public List<NotificationMongo> getNotificationMongos() {
//        return notificationMongoRepository.findAll();
//    }
}
