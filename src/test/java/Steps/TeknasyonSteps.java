package Steps;

import Base.TemelSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


import java.io.File;

public class TeknasyonSteps extends TemelSteps {
    private static final File CVDOC = new File("src/main/resources/MEriçBacak.pdf");
    String GoogleSearchBox="q";
    String GoogleAraBtn="btnK";
    String teknasyonlinkXpath="(//cite[@class='iUh30 Zu0yb tjvcx' and text()='https://teknasyon.com'])[1]";
    String KariyerBtn="(//a[text()='Kariyer'])[2]";
    String SeniTanimakisteriz="//h2[text()='Seni tanımak isteriz!']";
    String KariyerPageDescription="//p[text()='Kodluyoruz ve dünyaya sunuyoruz! Bizimle birlikte bu dünyayı keşfetmek istersen başvurunu bekliyoruz. Hemen tanışalım ve sana Teknasyon’un ayrıcalıklarından bahsedelim.']";
    String titleTestOtoMuhendisi="//a[@title='Test Otomasyon Mühendisi']";
    String TestotomasyonMuhendisiPageTitle="Test Otomasyon Mühendisi - Teknasyon";
    String GenelNiteliklereGozAtin="//p[text()='Genel niteliklere göz atın.']";
    String BasvurButtonInPositionDetailPage="//i[@class='icon-arrow-right-link']";
    String BasvurButtonInJobApplicationPage="//i[@class='icon-arrow-right-link']";
    String TitleJobApplicationPage="İş Başvuru Formu - Teknasyon";
    String NameSurnameWarning="//span[@id='jobNameSurname-error']";
    String EmailWarning="//span[@id='jobEmail-error']";
    String CVUploadWarning="//span[@id='jobFile-error']";
    String InformationWarning="//span[@id='jobLet-error']";
    String RecaptchaWarning="//span[@id='recaptchaControl-error']";
    String CVYukleButton="//input[@type='file']";
    String AdSoyadAlani ="//input[@id='jobNameSurname']";
    String EmailAlani="//input[@id='jobEmail']";
    String AydinlatmaMetniCheckBox="(//span[@class='ci-effect'])[1]";
    String SecondCheckbox="(//span[@class='ci-effect'])[2]";
    String ThirdCheckbox="(//span[@class='ci-effect'])[3]";
    String Recaptcha="//iframe[@title='reCAPTCHA']";
    String BasvurunuzAlindi="//h2[text()='Başvurunuz alınmıştır.']";

    @Given("^Google sayfasina gidilmistir.$")

    public void OpenGooglePage() {
        sayfayiAC();
    }

    @Then("^Google olduğunu doğrulayın.$")
    public void VerifyGoogle(){
        VerifyPageTitle("Google");
    }

    @When ("^Google search box görüntülediğinde teknasyon aratılır.$")

    public void TeknasyonSearchInGoogle(){
        findElement(GoogleSearchBox, Selectors.name,"Google SearchBox name attribute").sendKeys("Teknasyon");
    }

    @Then("^Google Ara butonuna tıklanır.$")

    public void GoogleAraButonunaTikla(){

        findElementClick(GoogleAraBtn, Selectors.name);
    }

    @Then("^Teknasyon.com'u listelendiğini doğrulayın.$")

    public void VerifyTeknasyonLink(){

        findElement(teknasyonlinkXpath, Selectors.xPath,"teknasyon.com linki").isDisplayed();
        System.out.println(findElement(teknasyonlinkXpath, Selectors.xPath,"teknasyon.com linki").getText());
        String actualLink=findElement(teknasyonlinkXpath, Selectors.xPath,"teknasyon.com linki").getText();
        Assert.assertEquals("https://teknasyon.com",actualLink);
    }

    @Then("^web sitesini açın ve web sitesi başlığını kontrol edin.$")

    public void clicklinkandverifypage(){

        findElementClick(teknasyonlinkXpath, Selectors.xPath);
        VerifyPageTitle("Teknasyon");
    }

    @When("^En aşağıdaki teknasyon başlğı altına scroll yapıp 'Kariyer' butonunun var olduğunu doğrulayın ve tıklayın.$")
    public void ScrollUntilFindKariyerButtonandClick(){
        ScrollUntilElementVisible(KariyerBtn);
        findElementClick(KariyerBtn, Selectors.xPath);
    }

    @Then("^Kariyer sayfadaki açıklama kısmını kontrol edin.$")
    public void VerifyDescriptionPart(){
        findElement(SeniTanimakisteriz, Selectors.xPath,"Kariyer sayfasındaki seni tanımak isteriz başlığı").isDisplayed();
        boolean contains = findElement(SeniTanimakisteriz, Selectors.xPath, "Kariyer sayfasındaki seni tanımak isteriz başlığı").getText().contains("Seni tanımak isteriz!");
        if(contains== false){
            System.out.println("Sayfada Seni Tanımak isteriz alanı görüntülenememiştir.");
        }
        findElement(KariyerPageDescription, Selectors.xPath,"Kariyer sayfasındaki uzun açıklama").isDisplayed();
        boolean contains2 = findElement(KariyerPageDescription, Selectors.xPath, "Kariyer sayfasındaki seni tanımak isteriz başlığı").getText().contains("Kodluyoruz ve dünyaya sunuyoruz! Bizimle birlikte");
        if(contains2== false){
            System.out.println("Sayfada Kodluyoruz ve dünyaya sunuyoruz! Bizimle birlikte görüntülenememiştir.");
        }
    }

    @Then("^'Test Otomasyon Mühendisi' pozisyonunun bulunduğunu doğrulayın.$")
    public void verifyRelatedpositionInCurrentPage(){
        findElement(titleTestOtoMuhendisi,Selectors.xPath,"Test otomasyon Mühendisi xpath").isEnabled();
    }

    @Then("^'Test Otomasyon Mühendisi' pozisyonuna tıklayın ve başlığı kontol edin.$")
    public void verifypositionDetailPage(){
        findElementClick(titleTestOtoMuhendisi,Selectors.xPath);
        VerifyPageTitle(TestotomasyonMuhendisiPageTitle);
    }

    @Then("^İş başvuru formu sayfası görüntülenir.$")
    public void verifyJobApplicationPage(){

        findElementClick(GenelNiteliklereGozAtin,Selectors.xPath);
        findElementClick(BasvurButtonInPositionDetailPage,Selectors.xPath);
        VerifyPageTitle(TitleJobApplicationPage);
    }

    @When("^Başvuru formunda herhangi bir işlem yapmadan uyarı mesajlarının gelip gelmediğini kontrol ettirin.$")
    public void verifymandatoryfieldsinjobApplicationPage(){
        findElementClick(AdSoyadAlani,Selectors.xPath);
        findElementClick(BasvurButtonInJobApplicationPage,Selectors.xPath);
        findElement(NameSurnameWarning,Selectors.xPath,"Ad-Soyad zrounlu alanı uyarısı").isEnabled();
        findElement(EmailWarning,Selectors.xPath,"Email zorunlu alanı uyarısı").isEnabled();
        findElement(CVUploadWarning,Selectors.xPath,"CV yükleme zorunlu alanı uyarısı").isEnabled();
        findElement(RecaptchaWarning,Selectors.xPath,"Recaptcha ben robot değilim kontrolü uyarısı").isEnabled();
        findElement(InformationWarning,Selectors.xPath,"Aydınlatma Metni zorunlu alanı kontrolü").isEnabled();
    }

    @Then("^Başvuru butonun var olduğunu doğrulayın ve tıklayın.$")
    public void VerifyBasvurbuttonandClick(){
        findElement(BasvurButtonInJobApplicationPage,Selectors.xPath,"İş başvuru sayfasındaki Başvur butonu").isEnabled();
        findElementClick(BasvurButtonInJobApplicationPage,Selectors.xPath);
    }

    @Then("^CV ekle butonunun olduğunu kontrol ettirin.$")
    public void veriyfCVAddButton(){
        findElement(CVYukleButton,Selectors.xPath,"İş başvuru sayfasındaki CV yükle butonu").isEnabled();

    }


    @Then("^Başvuru formunu doldurun ve özgeçmişinizi yükleyin.$")
    public void FillApplicationForm(){
        findElement(AdSoyadAlani,Selectors.xPath,"İş başvurusu sayfasında ad soyad alanı").sendKeys("Meriç Bacak");
        findElement(EmailAlani,Selectors.xPath,"İş başvuru sayfasunda email alanı").sendKeys("mericbacak@gmail.com");
        //findElementClick(CVYukleButton,Selectors.xPath);
        findElement(CVYukleButton,Selectors.xPath,"CV yükle butonu").sendKeys(CVDOC.getAbsolutePath());
    }

    @Then("^Recapthanın olduğunu doğrulayın.$")
    public void VerifyRecaptcha(){
        findElement(Recaptcha,Selectors.xPath,"Recaptcha checbox").isEnabled();
    }

    @When("^Onay kutularını doldurun ve onay kutusuna tıklayınca uyarı metinlerinin gittiğini doğrulayın.$")
    public void clickconfirmationboxesandverifywarningsDisappear() {
        findElementClick(AydinlatmaMetniCheckBox,Selectors.xPath);
        findElementClick(SecondCheckbox,Selectors.xPath);
        findElementClick(ThirdCheckbox,Selectors.xPath);
        Assert.assertFalse( findElement(NameSurnameWarning,Selectors.xPath,"Ad-Soyad zrounlu alanı uyarısı").isDisplayed());
        Assert.assertFalse( findElement(EmailWarning,Selectors.xPath,"Email zorunlu alanı uyarısı").isDisplayed());
        findElementClick(BasvurButtonInJobApplicationPage,Selectors.xPath);
        Assert.assertFalse( findElement(CVUploadWarning,Selectors.xPath,"CV yükleme zorunlu alanı uyarısı").isDisplayed());
        Assert.assertFalse(findElement(InformationWarning,Selectors.xPath,"Aydınlatma Metni zorunlu alanı kontrolü").isDisplayed());

    }
    @Then("^Başvur butonuna tıklayın.$")
    public void clickBasvurButton()  {
        findElement(Recaptcha,Selectors.xPath,"Recaptcha checbox").click();
        System.out.println("Recapthaya tıklandı");
        findElementClick(BasvurButtonInJobApplicationPage,Selectors.xPath);
        //Assert.assertFalse(findElement(RecaptchaWarning,Selectors.xPath,"Recaptcha ben robot değilim kontrolü uyarısı").isDisplayed());
    }

    @And("^sayfada Başvurunuz alınmıştır mesajını kontrol ediniz.$")
    public void BasvuruKontrol(){
        System.out.println((findElement(BasvurunuzAlindi,Selectors.xPath,"Başvuru alındı mesajı texti").getText()));
        String actual=(findElement(BasvurunuzAlindi,Selectors.xPath,"Başvuru alındı mesajı texti").getText());
        String expected="Başvurunuz alınmıştır.";
        Assert.assertEquals(expected,actual);
    }

    @Then("^sayfa kapatılır.$")
    public void driverKapatilir(){
        DriverQuit();
    }
}
