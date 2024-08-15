package adminUI;

public class AddNewPostPageUI {
    public static final String POST_IFRAME = "xpath=//iframe[contains(@class, 'is-loaded')]";
    public static final String TITLE_POST = "xpath=//div[contains(@class,'post-title-wrapper')]";
    public static final String TITLE_TEXTBOX = "xpath=//div[contains(@class,'post-title-wrapper')]/h1[@aria-label='Add title']";
    public static final String PUBLISH_BUTTON = "xpath=//button[text()='Publish']";
    public static final String VIEW_POST_AT_POPUP_LINK = "xpath=//a[contains(@class,'view-post-link')]";
    public static final String ADD_NEW_SUCCESS_MESSAGE = "xpath=//div[@class='wpcom-block-editor-post-published-sharing-modal__left']/h1";
}
