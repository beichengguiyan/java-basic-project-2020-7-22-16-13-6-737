package creditcard;

public enum PaymentType {
    POS("POS机"),
    WECHAT("绑定微信支付"),
    CREDITCARDEXPRESS("信用卡快捷支付");


    PaymentType(String type) {
    }
}
