package locators;

public class LocatorsMainPage {

    public static final String POPULAR_CATEGORIES = "//div[1]/div[@data-zone-name='category-link']/div/a";
    public static final String PRODUCTS_CATALOG_BUTTON_V1 = "//span[.='Каталог товаров']/../parent::button";
    public static final String PRODUCTS_CATALOG_BUTTON_V2 = "//div[@data-apiary-widget-name='@MarketNode/HeaderCatalogEntrypoint']/button";
    public static final String PRODUCTS_CATEGORIES = "//div[@data-zone-name='category-link']/button/a/span";
    public static final String LOG_IN_BUTTON = "//span[.='Войти']";
    public static final String INPUT_FIELD_LOGIN = "#passp-field-login";
    public static final String INPUT_FIELD_PASSWORD = "#passp-field-passwd";
    public static final String LOG_IN_AUTORIZATION_BUTTON = "//span[.='Войти']/parent::button";
    public static final String USER_AVATAR = "//img[@alt='user-avatar']/../../../button";
    public static final String LOG_OUT_BUTTON_V1 = "//div[.='sheff-qa@yandex.ru']/../../div[3]";
    public static final String LOG_OUT_BUTTON_V2 = "//*[.='Выйти']";

}
