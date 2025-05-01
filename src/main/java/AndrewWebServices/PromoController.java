package AndrewWebServices;

public class PromoController {
    private final PromoEmailSender emailSender;

    public PromoController(PromoEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void triggerPromo(String email) {
        emailSender.sendPromoEmail(email);
    }
}

