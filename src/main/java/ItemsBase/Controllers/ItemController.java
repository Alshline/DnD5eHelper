package ItemsBase.Controllers;

import ItemsBase.Repositories.ArmorRepository;
import ItemsBase.Repositories.ItemRepository;
import ItemsBase.Repositories.WeaponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    @Autowired
    private ArmorRepository armorRepository;

    @Autowired
    private WeaponsRepository weaponsRepository;

    @Autowired
    private ItemRepository itemRepository;
}
