package cloud.autotests.po;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public abstract class BasePage extends WebPage {
    @UI("Header label") public Label headerLabel;
}
