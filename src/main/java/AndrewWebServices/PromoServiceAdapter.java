package AndrewWebServices;

public class PromoServiceAdapter implements PromoEmailSender {
    private final PromoService promoService;

    public PromoServiceAdapter(PromoService promoService) {
        this.promoService = promoService;
    }

    @Override
    public void sendPromoEmail(String email) {
        promoService.mailTo(email);
    }
}
